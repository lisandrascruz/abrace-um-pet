package usuario.gui;

import infraestrutura.gui.ImagensGUI;

import java.awt.Color;
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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import usuario.dominio.Usuario;
import usuario.service.CriptografiaService;
import usuario.service.SessaoUsuario;
import usuario.service.UsuarioService;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JLabel lblStatus;
	private JTextPane panelStatus;

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("Login - Abrace Um PET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblLogin.setBounds(37, 124, 63, 17);
		contentPane.add(lblLogin);

		textLogin = new JTextField();
		textLogin.setBounds(110, 124, 199, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblSenha.setBounds(37, 228, 63, 17);
		contentPane.add(lblSenha);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1, "ERROR", 0);
				}
			}
		});
		btnAcessar.setBounds(220, 296, 89, 23);
		contentPane.add(btnAcessar);

		JButton btnFaaSeuCadastro = new JButton("Fa\u00E7a seu cadastro");
		btnFaaSeuCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroUsuarioGUI cadastroUsuario = new CadastroUsuarioGUI();
				cadastroUsuario.setVisible(true);
				dispose();
			}
		});
		btnFaaSeuCadastro.setBounds(376, 382, 144, 23);
		contentPane.add(btnFaaSeuCadastro);

		textSenha = new JPasswordField();
		textSenha.setBounds(110, 228, 199, 20);
		contentPane.add(textSenha);
		
		JButton button = new JButton("Sobre");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SobreGUI sobre = new SobreGUI();
				sobre.setVisible(true);
				dispose();
			}
		});
		button.setBounds(530, 382, 89, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		ImagensGUI.imagemLogin(lblNewLabel);
		lblNewLabel.setBounds(353, 73, 266, 271);
		contentPane.add(lblNewLabel);
        panelStatus= new JTextPane();
		panelStatus.setEditable(false);
		panelStatus.setBounds(0, 416, 629, 20);
		contentPane.add(panelStatus);
		criarStatus();
		}
	private void criarStatus(){
		lblStatus = new JLabel("");
		lblStatus.setBounds(10,416,609, 20);
		panelStatus.add(lblStatus);
		
	}
	public void login() throws Exception {
		Usuario usuario = new Usuario();
		UsuarioService usuarioService = new UsuarioService();

		usuario.setLogin(textLogin.getText());
		usuario.setSenha(new String(textSenha.getPassword()));

		String login = usuario.getLogin();
		String senha = usuario.getSenha();

		CriptografiaService criptografia = new CriptografiaService();
		senha = criptografia.criptografar(senha);

		if (usuarioService.consultarUsuarioService(login, senha)) {
			usuario.setSenha(senha);
			int id = usuarioService.getIdUsuario(usuario);
			usuario.setId(id);
			SessaoUsuario sessao = SessaoUsuario.getInstancia();
			sessao.setUsuarioLogado(usuario);
			TelaInicialGUI tl = new TelaInicialGUI();
			tl.setVisible(true);
			dispose();
			
		}
		if (!(usuarioService.consultarUsuarioService(login, senha))) {
			panelStatus.setText("Dados inválidos");
			panelStatus.setForeground(Color.RED);
			textLogin.setText("");
			textSenha.setText("");
			textLogin.requestFocus();
		}
	}
}
