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
	 * VALIDAR SE LOGIN JA EXISTE NO BANCO DE DADOS
	 * 
	 * @param login
	 * @return
	 */
	public boolean validarCadastro(String login) {
		boolean valido;
		usuario.setLogin(login);

		if (usuarioDao.consultarUsuario(login)) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}
	/**
	 * VALIDAR CAMPO LOGIN (MINIMO 3 CARACTERES)
	 * 
	 * @param login
	 * @return
	 */
	public boolean validarLogin(String login) {
		boolean valido;
		int tamanhoLogin = login.length();

		if (tamanhoLogin > 3) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	/**
	 * VALIDAR CAMPO SENHA (MINIMO 6 CARACTERES E PELO MENOS UM CARACTER ESPECIAL)
	 * 
	 * @param senha
	 * @return
	 */
	public boolean validarSenha(String senha) {
		boolean valido;
		int tamanhoSenha = senha.length();
		usuario.setSenha(senha);

		if (senha != "") {
			if (tamanhoSenha < 6 && (!(senha.contains("!") || senha.contains("@")
					|| senha.contains("#") || senha.contains("%")
					|| senha.contains("&") || senha.contains("$")))) {
				valido = false;
			} else {
				valido = true;
			}

		}else{
			valido = false;
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
		boolean valido;

		cadastroUsuario.setConfirmarSenha(confirmacaoSenha);
		usuario.setSenha(senha);

		if ((cadastroUsuario.getConfirmarSenha().equals(usuario.getSenha()))) {
			valido = true;
		} else {
			valido = false;
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
		boolean valido;
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
					valido = false;
				} else {
					valido = true;
				}
			} else {
				valido = false;
			}

		} else {
			valido = false;
		}
		return valido;
	}
}
