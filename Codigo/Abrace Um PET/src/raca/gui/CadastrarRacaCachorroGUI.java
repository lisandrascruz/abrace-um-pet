package raca.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import raca.service.RacaService;
import usuario.gui.TelaInicialGUI;
import animal.dao.RacaDAO;
import animal.dominio.Raca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarRacaCachorroGUI extends JFrame {
	
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
					CadastrarRacaCachorroGUI frame = new CadastrarRacaCachorroGUI();
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
	public CadastrarRacaCachorroGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroRacaCachorro = new JLabel("Cadastro - Ra\u00E7a de Cachorro");
		lblCadastroRacaCachorro.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroRacaCachorro.setBounds(10, 28, 327, 14);
		contentPane.add(lblCadastroRacaCachorro);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(10, 108, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblOrigem.setBounds(10, 197, 62, 17);
		contentPane.add(lblOrigem);
		
		JLabel lblTamanhoMaximo = new JLabel("Tamanho Maximo: ");
		lblTamanhoMaximo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMaximo.setBounds(358, 106, 119, 14);
		contentPane.add(lblTamanhoMaximo);
		
		JLabel lblTamanhoMinimo = new JLabel("Tamanho Minimo: ");
		lblTamanhoMinimo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMinimo.setBounds(358, 150, 109, 14);
		contentPane.add(lblTamanhoMinimo);
		
		JLabel lblExpectativaDeVida = new JLabel("Expectativa de vida: ");
		lblExpectativaDeVida.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblExpectativaDeVida.setBounds(358, 196, 130, 14);
		contentPane.add(lblExpectativaDeVida);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(76, 106, 239, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldOrigem = new JTextField();
		textFieldOrigem.setBounds(76, 194, 239, 20);
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
		formattedTextFieldTamanhoMaximo.setBounds(489, 104, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMaximo);
		
		JFormattedTextField formattedTextFieldTamanhoMinimo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMinimo.setBounds(489, 148, 62, 20);
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
		formattedTextFieldExpectativaDeVida.setBounds(489, 194, 62, 20);
		contentPane.add(formattedTextFieldExpectativaDeVida);
		
		JLabel lblTemoeramento = new JLabel("Temperamento: ");
		lblTemoeramento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTemoeramento.setBounds(10, 261, 101, 20);
		contentPane.add(lblTemoeramento);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(76, 292, 475, 75);
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
				
				
				if(racaService.adicionarRacaCachorro(raca)){
					JOptionPane.showMessageDialog(null, "Raça de Cachorros adicionada com sucesso!");
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
		btnCadastrar.setBounds(445, 382, 101, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacaGUI racaGUI = new RacaGUI();
				racaGUI.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(335, 382, 89, 23);
		contentPane.add(btnCancelar);
	}
}
