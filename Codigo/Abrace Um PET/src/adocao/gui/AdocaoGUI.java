package adocao.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdocaoGUI {

	private JFrame frmAdoo;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdocaoGUI window = new AdocaoGUI();
					window.frmAdoo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdocaoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdoo = new JFrame();
		frmAdoo.setTitle("Ado\u00E7\u00E3o");
		frmAdoo.setBounds(100, 100, 450, 300);
		frmAdoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdoo.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 41, 46, 14);
		frmAdoo.getContentPane().add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(64, 38, 153, 20);
		frmAdoo.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblRga = new JLabel("RGA");
		lblRga.setBounds(10, 83, 46, 14);
		frmAdoo.getContentPane().add(lblRga);
		
		textField_1 = new JTextField();
		textField_1.setBounds(64, 80, 153, 20);
		frmAdoo.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(331, 41, 46, 14);
		frmAdoo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(331, 83, 46, 14);
		frmAdoo.getContentPane().add(lblNewLabel_1);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.setBounds(128, 124, 89, 23);
		frmAdoo.getContentPane().add(btnAdotar);
		
		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.setBounds(227, 37, 80, 23);
		frmAdoo.getContentPane().add(btnConsultarCpf);
		
		JButton btnConsultarRga = new JButton("Consultar");
		btnConsultarRga.setBounds(227, 79, 80, 23);
		frmAdoo.getContentPane().add(btnConsultarRga);
	}
}
