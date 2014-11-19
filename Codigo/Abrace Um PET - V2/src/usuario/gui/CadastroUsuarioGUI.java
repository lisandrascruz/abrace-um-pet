package usuario.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import usuario.negocio.UsuarioService;
import usuario.usuario.Usuario;

import javax.swing.JPasswordField;

public class CadastroUsuarioGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textEmail;
	private JPasswordField textSenha;
	private JPasswordField textConfirmarSenha;
	/**
	 * Create the frame.
	 */
	public CadastroUsuarioGUI() {
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroUsuario = new JLabel("Cadastro de Usuario");
		lblCadastroUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroUsuario.setBounds(52, 57, 194, 19);
		contentPane.add(lblCadastroUsuario);
		
		JLabel lblLogin = new JLabel("Login: ");
		lblLogin.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblLogin.setBounds(68, 141, 46, 19);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(197, 141, 345, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblSenha.setBounds(68, 224, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(68, 182, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(197, 181, 345, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblConfirmarSenha.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblConfirmarSenha.setBounds(68, 263, 115, 14);
		contentPane.add(lblConfirmarSenha);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEmail.setText("");
				textLogin.setText("");
				textSenha.setText("");
				textConfirmarSenha.setText("");
			}
		});
		btnLimparCampos.setBounds(197, 349, 345, 23);
		contentPane.add(btnLimparCampos);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Usuario usuario = new Usuario();
				usuario.setLogin(textLogin.getText());
				usuario.setSenha(textSenha.getText());
				
				UsuarioService usuarioService = new UsuarioService();
				if(usuarioService.adicionarUsuarioService(usuario)){
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
					LoginGUI login = new LoginGUI();
					login.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "O cadastro n�o pode ser realizado", "ERROR", 0);
					textLogin.setText("");
					textSenha.setText("");
					textConfirmarSenha.setText("");
					textEmail.setText("");
				}
			}
		});
		btnCadastrar.setBounds(197, 315, 117, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(324, 315, 106, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(440, 315, 102, 23);
		contentPane.add(btnSair);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(197, 221, 345, 23);
		contentPane.add(textSenha);
		
		textConfirmarSenha = new JPasswordField();
		textConfirmarSenha.setBounds(197, 259, 345, 23);
		contentPane.add(textConfirmarSenha);
	}
}
