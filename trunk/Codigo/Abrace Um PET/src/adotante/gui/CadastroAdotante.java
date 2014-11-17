package adotante.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuario.gui.LoginGUI;

public class CadastroAdotante extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAdotante frame = new CadastroAdotante();
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
	public CadastroAdotante() {
		setTitle("Abrace um PET - Cadastro de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnPessoaFsica = new JButton("Pessoa F\u00EDsica");
		btnPessoaFsica.setBounds(95, 198, 279, 39);
		btnPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnPessoaJurdica = new JButton("Pessoa Jur\u00EDdica");
		btnPessoaJurdica.setBounds(95, 124, 279, 39);
		btnPessoaJurdica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAdotanteJuridicoGui cadastroPessoaJuridica = new CadastroAdotanteJuridicoGui();
				cadastroPessoaJuridica.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnPessoaJurdica);
		contentPane.add(btnPessoaFsica);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(285, 382, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblCadastroDeUsurio = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeUsurio.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeUsurio.setBounds(44, 37, 151, 39);
		contentPane.add(lblCadastroDeUsurio);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Lisandra Cruz\\Desktop\\abrace-um-pet\\Codigo\\Abrace Um PET\\imagens\\Sem T\u00EDtulo-1.png"));
		label.setBounds(385, 180, 244, 236);
		contentPane.add(label);
	}

}
