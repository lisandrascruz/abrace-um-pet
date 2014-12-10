package adocao.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdocaoPessoaJuridicaGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	private JTextField textRga;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdocaoPessoaJuridicaGUI frame = new AdocaoPessoaJuridicaGUI();
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
	public AdocaoPessoaJuridicaGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdooDePessoa = new JLabel("Ado\u00E7\u00E3o de Pessoa Juridica");
		lblAdooDePessoa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdooDePessoa.setBounds(27, 50, 193, 14);
		contentPane.add(lblAdooDePessoa);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCnpj.setBounds(27, 133, 46, 14);
		contentPane.add(lblCnpj);
		
		JFormattedTextField formattedTextFieldCNPJ = new JFormattedTextField();
		formattedTextFieldCNPJ.setBounds(83, 131, 188, 20);
		contentPane.add(formattedTextFieldCNPJ);
		
		JButton buttonConsultarCNPJ = new JButton("Consultar");
		buttonConsultarCNPJ.setBounds(281, 130, 89, 23);
		contentPane.add(buttonConsultarCNPJ);
		
		JLabel label = new JLabel("RGA:");
		label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		label.setBounds(27, 255, 46, 14);
		contentPane.add(label);
		
		textRga = new JTextField();
		textRga.setColumns(10);
		textRga.setBounds(83, 253, 191, 20);
		contentPane.add(textRga);
		
		JButton buttonConsultarRGA = new JButton("Consultar");
		buttonConsultarRGA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonConsultarRGA.setBounds(281, 252, 89, 23);
		contentPane.add(buttonConsultarRGA);
		
		JLabel lblMostrarAnimal = new JLabel("");
		lblMostrarAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarAnimal.setBounds(83, 284, 193, 36);
		contentPane.add(lblMostrarAnimal);
		
		JButton button_1 = new JButton("Adotar");
		button_1.setBounds(182, 382, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Voltar");
		button_2.setBounds(281, 382, 89, 23);
		contentPane.add(button_2);
		
		JLabel lblMostrarNome = new JLabel("");
		lblMostrarNome.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblMostrarNome.setBounds(83, 167, 193, 23);
		contentPane.add(lblMostrarNome);
	}
}
