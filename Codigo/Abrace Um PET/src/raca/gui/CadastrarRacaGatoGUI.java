package raca.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import raca.service.RacaService;
import usuario.gui.TelaInicialGUI;
import animal.dominio.Raca;

public class CadastrarRacaGatoGUI extends JFrame {
	
	private JPanel	contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldOrigem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarRacaGatoGUI frame = new CadastrarRacaGatoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public CadastrarRacaGatoGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroRaa = new JLabel("Cadastro - Ra\u00E7a de Gato");
		lblCadastroRaa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroRaa.setBounds(10, 39, 327, 19);
		contentPane.add(lblCadastroRaa);
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(10, 112, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblOrigem.setBounds(10, 193, 70, 18);
		contentPane.add(lblOrigem);
		
		JLabel lblTamanhoMaximo = new JLabel("Tamanho Maximo: ");
		lblTamanhoMaximo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMaximo.setBounds(344, 109, 125, 14);
		contentPane.add(lblTamanhoMaximo);
		
		JLabel lblTamanhoMinimo = new JLabel("Tamanho Minimo: ");
		lblTamanhoMinimo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMinimo.setBounds(344, 153, 125, 14);
		contentPane.add(lblTamanhoMinimo);
		
		JLabel lblExpectativaDeVida = new JLabel("Expectativa de vida: ");
		lblExpectativaDeVida.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblExpectativaDeVida.setBounds(344, 193, 138, 23);
		contentPane.add(lblExpectativaDeVida);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(90, 109, 231, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldOrigem = new JTextField();
		textFieldOrigem.setBounds(90, 194, 231, 20);
		contentPane.add(textFieldOrigem);
		textFieldOrigem.setColumns(10);		
		
		MaskFormatter mascaraTamanho = null;
		try{
			mascaraTamanho =  new MaskFormatter("#.##");
			mascaraTamanho.setPlaceholderCharacter('_');
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Tamanho inválido!", "ERROR", 0);
			e.printStackTrace();
		}
		
		JFormattedTextField formattedTextFieldTamanhoMaximo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMaximo.setBounds(479, 110, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMaximo);
		
		JFormattedTextField formattedTextFieldTamanhoMinimo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMinimo.setBounds(479, 150, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMinimo);
		
		MaskFormatter mascaraExpectativaVida = null;
		try{
			mascaraExpectativaVida =  new MaskFormatter("##");
			mascaraExpectativaVida.setPlaceholderCharacter('_');
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Tamanho inválido!", "ERROR", 0);
			e.printStackTrace();
		}
		
		JFormattedTextField formattedTextFieldExpectativaDeVida = new JFormattedTextField(mascaraExpectativaVida);
		formattedTextFieldExpectativaDeVida.setBounds(479, 195, 62, 20);
		contentPane.add(formattedTextFieldExpectativaDeVida);
		
		JLabel lblTemoeramento = new JLabel("Temperamento: ");
		lblTemoeramento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTemoeramento.setBounds(10, 241, 110, 19);
		contentPane.add(lblTemoeramento);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(90, 269, 451, 75);
		contentPane.add(editorPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacaService racaService = new RacaService();
				Raca raca = new Raca();
				
				raca.setNome(textFieldNome.getText());
				raca.setOrigem(textFieldOrigem.getText());
				raca.setTamanhoMax(Double.parseDouble(formattedTextFieldTamanhoMaximo.getText()));
				raca.setTamanhoMin(Double.parseDouble(formattedTextFieldTamanhoMinimo.getText()));
				raca.setExpectativaVida(Integer.parseInt(formattedTextFieldExpectativaDeVida.getText()));
				raca.setTemperamento(editorPane.getText());
				
				if(racaService.adicionarRacaGato(raca)){
					JOptionPane.showMessageDialog(null, "Raça de Gato adicionada com sucesso!");
					TelaInicialGUI telaInicialGUI = new TelaInicialGUI();
					telaInicialGUI.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Raça não cadastrada! Tente Novamente");
					raca.setNome("");
					raca.setOrigem(textFieldOrigem.getText());
					raca.setTamanhoMax(0);
					raca.setTamanhoMin(0);
					raca.setExpectativaVida(0);
					raca.setTemperamento("");
					textFieldNome.requestFocus();
				}
				
			}
		});
		btnCadastrar.setBounds(436, 382, 110, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacaGUI racaGUI = new RacaGUI();
				racaGUI.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(329, 382, 97, 23);
		contentPane.add(btnCancelar);
		
	}
	
}
