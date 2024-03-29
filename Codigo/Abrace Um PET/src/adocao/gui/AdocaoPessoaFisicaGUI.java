package adocao.gui;

import infraestrutura.gui.ImagensGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import usuario.gui.TelaInicialGUI;
import usuario.service.SessaoUsuario;
import adocao.dominio.Adocao;
import adocao.service.AdocaoService;
import adotante.dominio.Adotante;
import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;
import animal.dominio.Animal;
import animal.service.AnimalService;

public class AdocaoPessoaFisicaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel contentPane;
	private JLabel lblMostrarNome;
	private JLabel lblMostrarAnimal;
	private JTextField textRga;
	private Animal animal;
	private PessoaFisica pessoaFisica;

	/**
	 * Create the frame.
	 */
	public AdocaoPessoaFisicaGUI() {
		setTitle("Ado\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel.setBounds(118, 170, 46, 14);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF v�lido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setBounds(174, 168, 188, 20);
		contentPane.add(jFormattedTextCpf);
		
		JLabel lblNewLabel_1 = new JLabel("RGA:");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(118, 234, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textRga = new JTextField();
		textRga.setBounds(174, 232, 191, 20);
		contentPane.add(textRga);
		textRga.setColumns(10);
		
		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaFisica = new PessoaFisica();
				PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
				try{
					pessoaFisica = pessoaFisicaService.consultarRepresentante(jFormattedTextCpf.getText());
					lblMostrarNome.setText(pessoaFisica.getPessoa().getNome());
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Representante n�o encontrado.");
				}
			}
		});
		btnConsultarCpf.setBounds(372, 167, 89, 23);
		contentPane.add(btnConsultarCpf);
		
		JButton btnConsultarRga = new JButton("Consultar");
		btnConsultarRga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animal = new Animal();
				AnimalService animalService = new AnimalService();
				try {
					animal = animalService.consultarAnimal(textRga.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Animal n�o encontrado.");
				}
				lblMostrarAnimal.setText(animal.getNome());
			}
		});
		btnConsultarRga.setBounds(372, 231, 89, 23);
		contentPane.add(btnConsultarRga);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar calobj = Calendar.getInstance();
				String dataAdocao = df.format(calobj.getTime());
				
				Adocao adocao = null;
				AdocaoService adocaoService = new AdocaoService();
				try {
					adocao = adocaoService.consultarAdocao(jFormattedTextCpf.getText(), textRga.getText());
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null, "Ado��o n�o pode ser realizada.");
			
				}
				
				if (adocao.getId() == 0){
					adocao = new Adocao();
					Adotante adotante = new Adotante();
					try {
						adotante = adocaoService.consultarAdotante(pessoaFisica.getPessoa());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Adotante n�o encontrado!");
					}
					try{
						adocao.setAnimal(animal);
						adocao.setAdotante(adotante);
						adocao.setDataAdocao(dataAdocao);
						adocaoService.adicionarAdocaoService(adocao);
						SessaoUsuario sessao = SessaoUsuario.getInstancia();
						sessao.setAdocao(adocao);
						JOptionPane.showMessageDialog(null, "Ado��o realizada com sucesso!!");
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
					}
				}
				else if (adocao.getDataDevolucao() == null)
				{
					adocao.setDataDevolucao(dataAdocao);
					try{
					adocaoService.editarAdocao(adocao);
					JOptionPane.showMessageDialog(null, "Devolu��o realizada com sucesso!!");
					} catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
					}
				}
				else if (adocao.getDataDevolucao() != null) {
					JOptionPane.showMessageDialog(null, "O animal n�o pode mais ser adotado por esta pessoa!!");
				}

				TelaInicialGUI ti = new TelaInicialGUI();
				ti.setVisible(true);
				dispose();
			}
		});
		btnAdotar.setBounds(372, 290, 89, 23);
		contentPane.add(btnAdotar);
		
		lblMostrarNome = new JLabel("");
		lblMostrarNome.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarNome.setBounds(174, 198, 193, 23);
		contentPane.add(lblMostrarNome);
		
		lblMostrarAnimal = new JLabel("");
		lblMostrarAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarAnimal.setBounds(174, 263, 193, 23);
		contentPane.add(lblMostrarAnimal);
		
		JLabel lblAdooDePessoa = new JLabel("Ado\u00E7\u00E3o de Pessoa Fisica");
		lblAdooDePessoa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdooDePessoa.setBounds(28, 62, 193, 14);
		contentPane.add(lblAdooDePessoa);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI tig = new TelaInicialGUI();
				tig.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(530, 382, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
