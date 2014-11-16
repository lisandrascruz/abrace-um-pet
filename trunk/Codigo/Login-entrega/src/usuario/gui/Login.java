package usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JButton;







import usuario.dao.UsuarioDAO;
import usuario.negocio.UsuarioService;
import usuario.usuario.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(180, 27, 106, 20);
		contentPane.add(lblLogin);
		
		JLabel lblLogin_1 = new JLabel("LOGIN");
		lblLogin_1.setBounds(124, 81, 46, 14);
		contentPane.add(lblLogin_1);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(124, 141, 46, 14);
		contentPane.add(lblSenha);
		
		textLogin = new JTextField();
		textLogin.setBounds(201, 78, 86, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(201, 138, 86, 20);
		contentPane.add(textSenha);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Usuario usuario = new Usuario();
				usuario.setLogin(textLogin.getText());
				usuario.setSenha((textSenha.getPassword()).toString());
				
				UsuarioService usuarioService = new UsuarioService();
				if(usuarioService.consultarUsuarioService(usuario)){
					JOptionPane.showMessageDialog(null, "Usuario e senha corretos");
					TelaInicial tl = new TelaInicial();
					tl.setVisible(true);
					//tl.setExtendedState(new TelaInicial().MAXIMIZED_BOTH);
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
		btnAcessar.setBounds(146, 227, 89, 23);
		contentPane.add(btnAcessar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(245, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
