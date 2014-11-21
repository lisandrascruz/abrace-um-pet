package usuario.gui;

import infraestrutura.gui.Imagens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import usuario.dominio.Usuario;
import usuario.service.Criptografia;
import usuario.service.UsuarioService;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;

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
		Imagens.imagemLogin(label);

		label.setBounds(10, 116, 332, 265);
		contentPane.add(label);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				login();
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
				CadastroUsuarioGUI cu = new CadastroUsuarioGUI();
				cu.setVisible(true);
				dispose();
			}
		});
		btnFaaSeuCadastro.setBounds(335, 382, 144, 23);
		contentPane.add(btnFaaSeuCadastro);

		textSenha = new JPasswordField();
		textSenha.setBounds(379, 165, 199, 20);
		contentPane.add(textSenha);
	}

	public void login() {
		Usuario usuario = new Usuario();
		UsuarioService usuarioService = new UsuarioService();

		usuario.setLogin(textLogin.getText().toString());
		usuario.setSenha(new String(textSenha.getPassword()));

		String login = usuario.getLogin().toString();
		String senha = usuario.getSenha().toString();

		Criptografia criptografia = new Criptografia();
		senha = criptografia.criptografar(senha);

		if (usuarioService.consultarUsuarioService(login, senha)) {
			TelaInicialGUI tl = new TelaInicialGUI();
			tl.setVisible(true);
			dispose();
		}
		if (!(usuarioService.consultarUsuarioService(login, senha))) {
			JOptionPane.showMessageDialog(null, "Dados inválidos", "ERRO", 0);
			textLogin.setText("");
			textSenha.setText("");
			textLogin.requestFocus();
		}
	}
}
