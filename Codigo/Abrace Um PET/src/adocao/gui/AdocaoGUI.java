package adocao.gui;

import infraestrutura.gui.ImagensGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class AdocaoGUI {

	private JFrame frmAdoo;
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
		frmAdoo.setBounds(100, 100, 647, 455);
		frmAdoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdoo.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCpf.setBounds(29, 124, 46, 14);
		frmAdoo.getContentPane().add(lblCpf);
		
		JLabel lblRga = new JLabel("RGA");
		lblRga.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRga.setBounds(29, 245, 46, 14);
		frmAdoo.getContentPane().add(lblRga);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 243, 162, 20);
		frmAdoo.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.setBounds(179, 382, 125, 23);
		frmAdoo.getContentPane().add(btnAdotar);
		
		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.setBounds(257, 121, 89, 23);
		frmAdoo.getContentPane().add(btnConsultarCpf);
		
		JButton btnConsultarRga = new JButton("Consultar");
		btnConsultarRga.setBounds(257, 242, 89, 23);
		frmAdoo.getContentPane().add(btnConsultarRga);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(314, 382, 89, 23);
		frmAdoo.getContentPane().add(btnCancelar);
		
		JLabel lblAdooPessoa = new JLabel("Ado\u00E7\u00E3o - Pessoa Fisica");
		lblAdooPessoa.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdooPessoa.setBounds(83, 50, 209, 14);
		frmAdoo.getContentPane().add(lblAdooPessoa);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.setBounds(29, 382, 140, 23);
		frmAdoo.getContentPane().add(btnLimparCampos);
		
		JLabel label = new JLabel("");
		//ImagensGUI.imagemAdocaoFisico(label);
		
		label.setIcon(new ImageIcon("C:\\Users\\Lisandra Cruz\\Desktop\\Nova pasta\\imagens\\gatoeducado.png"));
		label.setBounds(363, 95, 258, 321);
		frmAdoo.getContentPane().add(label);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setBounds(76, 122, 171, 20);
		frmAdoo.getContentPane().add(jFormattedTextCpf);
	}
}
