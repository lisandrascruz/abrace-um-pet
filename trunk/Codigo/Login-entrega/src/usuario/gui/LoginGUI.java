package usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import usuario.negocio.UsuarioService;
import usuario.usuario.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setTitle("Login - Abrace Um PET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblLogin.setBounds(279, 88, 63, 17);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(379, 88, 199, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblSenha.setBounds(279, 165, 63, 17);
		contentPane.add(lblSenha);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Lisandra Cruz\\Desktop\\abrace-um-pet\\Codigo\\Login-entrega\\imagens\\logn1.png"));
		label.setBounds(10, 116, 332, 265);
		contentPane.add(label);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setLogin(textLogin.getText());
				usuario.setSenha((textSenha.getPassword()).toString());
				
				UsuarioService usuarioService = new UsuarioService();
				if(usuarioService.consultarUsuarioService(usuario)){
					JOptionPane.showMessageDialog(null, "Usuario e senha corretos");
					TelaInicialGUI tl = new TelaInicialGUI();
					tl.setVisible(true);
					tl.setExtendedState(new TelaInicialGUI().MAXIMIZED_BOTH);
					dispose();//sair da tela de login
					
				}
				if(!usuarioService.consultarUsuarioService(usuario)){
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
					textLogin.setText("");
					textSenha.setText("");
					textLogin.requestFocus();//volta o cursor pra caixa de login
				}
			}
		});
		btnAcessar.setBounds(489, 216, 89, 23);
		contentPane.add(btnAcessar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(489, 382, 89, 23);
		contentPane.add(btnFechar);
		
		JButton btnFaaSeuCadastro = new JButton("Fa\u00E7a seu cadastro");
		btnFaaSeuCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFaaSeuCadastro.setBounds(335, 382, 144, 23);
		contentPane.add(btnFaaSeuCadastro);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(379, 165, 199, 20);
		contentPane.add(textSenha);
	}
}
