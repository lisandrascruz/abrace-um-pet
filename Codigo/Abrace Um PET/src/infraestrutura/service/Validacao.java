package infraestrutura.service;

import javax.swing.JOptionPane;

import usuario.dao.UsuarioDAO;
import usuario.dominio.Usuario;
import usuario.gui.CadastroUsuarioGUI;

public class Validacao {
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDao = new UsuarioDAO();
	CadastroUsuarioGUI cadastroUsuario = new CadastroUsuarioGUI();

	/**
	 * VALIDAR CAMPO LOGIN (MINIMO 3 CARACTERES)
	 * 
	 * @param login
	 * @return
	 */
	public boolean validarLogin(String login) {
		boolean valido = true;
		int tamanhoLogin = login.length();

		if (tamanhoLogin < 3) {
			JOptionPane.showMessageDialog(null,
					"O login deve conter pelo menos 3 digitos", "ERROR", 0);
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	/**
	 * VALIDAR CAMPO SENHA (MINIMO 3 CARACTERES)
	 * @param senha
	 * @return
	 */
	public boolean validarSenha(String senha) {
		boolean valido = false;
		int tamanhoSenha = senha.length();

		if (tamanhoSenha < 3) {
			JOptionPane.showMessageDialog(null,
					"A senha deve conter pelo menos 3 digitos", "ERROR", 0);
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	/**
	 * VALIDAR SE SENHA E CONFIRMAR SENHA CONFEREM
	 * 
	 * @param senha
	 * @param confirmacaoSenha
	 * @return
	 */
	public boolean validarConfirmacaoSenha(String senha, String confirmacaoSenha) {
		boolean valido = false;

		cadastroUsuario.setConfirmarSenha(confirmacaoSenha);
		usuario.setSenha(senha);

		if (!(cadastroUsuario.getConfirmarSenha().equals(usuario.getSenha()))) {
			JOptionPane.showMessageDialog(null, "Senhas não conferem", "ERROR",
					0);
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	/**
	 * VALIDAR EMAIL DO USUARIO
	 * 
	 * @param email
	 * @return
	 */
	public boolean validarEmail(String email) {
		boolean valido = false;
		usuario.setEmail(email);

		if (email != "") {
			if ((usuario.getEmail().contains("@"))
					&& (usuario.getEmail().contains(".com"))
					&& (!(usuario.getEmail()).contains(" "))) {

				String nomeEmail = new String(email.substring(0,
						email.lastIndexOf('@')));
				String dominio = new String(email.substring(
						email.lastIndexOf('@') + 1, email.length()));

				if (!(nomeEmail.length() >= 1) && (!nomeEmail.contains("@"))
						&& (dominio.contains(".com"))
						&& (!dominio.contains("@"))
						&& (dominio.indexOf(".com") >= 1)
						&& (dominio.lastIndexOf(".com") < dominio.length() - 1)) {
					JOptionPane.showMessageDialog(null, "Email Iválido",
							"ERROR", 0);
					valido = false;
				} else {
					valido = true;
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Email errado, usar formato - exemplo@exemplo.com",
						"ERROR", 0);
				valido = false;
			}

		} else {
			JOptionPane.showMessageDialog(null, "Digite um email.", "ERROR", 0);
			valido = false;
		}
		return valido;
	}
	/**
	 * VALIDAR SE LOGIN JA EXISTE NO BANCO DE DADOS
	 * @param login
	 * @return
	 */

	public boolean validarCadastro(String login) {
		boolean valido = false;
		usuario.setLogin(login);

		if (usuarioDao.consultarUsuario(login)) {
			JOptionPane.showMessageDialog(null,"Login já cadastrado! Tente outro.", "ERROR", 0);
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

}
