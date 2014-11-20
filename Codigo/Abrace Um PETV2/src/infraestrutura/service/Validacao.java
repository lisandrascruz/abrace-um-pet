package infraestrutura.service;

import javax.swing.JOptionPane;

import usuario.dominio.Usuario;

public class Validacao {
	Usuario usuario = new Usuario();
	/**
	 * Valida o login do usuario. Deve ter pelo menos 3 caracteres
	 * @param login
	 * @return
	 */
	public boolean validarLogin(String login){
		boolean valido = true;
		int tamanhoLogin = login.length();
		
		if(tamanhoLogin<3){
			JOptionPane.showMessageDialog(null, "O login deve conter pelo menos 3 digitos", "ERROR", 0);
			valido = false;
		}
		else{
			valido = true;
		}
		return valido;
	}
	/**
	 * valida a senha do usuario. Dever ter pelo menos 3 caracteres
	 * @param senha
	 * @return
	 */
	public boolean validarSenha(String senha){
		boolean valido = false;
		int tamanhoSenha = senha.length();
		
		if(tamanhoSenha < 3){
			JOptionPane.showMessageDialog(null, "A senha deve conter pelo menos 3 digitos", "ERROR", 0);
			valido = false;
		}
		else {
			valido = true;
		}
		return valido;
	}
	/**
	 * faz a confirmação da senha
	 * @param senha
	 * @param confirmacaoSenha
	 * @return
	 */
	public boolean validarConfirmacaoSenha(String senha, String confirmacaoSenha){
		boolean valido = false;
		
		usuario.setConfirmarSenha(confirmacaoSenha);
		usuario.setSenha(senha);
		
		if(!(usuario.getConfirmarSenha().equals(usuario.getSenha()))){
			JOptionPane.showMessageDialog(null, "Senhas não conferem", "ERROR", 0);
			valido = false;
		}
		else {
			valido = true;
		}
		return valido;
	}
	
	public boolean validarEmail(String email){
		boolean valido = false;
		usuario.setEmail(email);
		
		if(email != ""){
			if((usuario.getEmail().contains("@")) && (usuario.getEmail().contains(".com")) && (!(usuario.getEmail()).contains(" "))){
				String nomeEmail = new String(email.substring(0,email.lastIndexOf('@')));
				String dominio = new String(email.substring(email.lastIndexOf('@') + 1, email.length()));
				
				if (!(nomeEmail.length() >=1) && (!nomeEmail.contains("@")) && (dominio.contains(".com")) && (!dominio.contains("@")) && 
						(dominio.indexOf(".com") >=1) && (dominio.lastIndexOf(".com") < dominio.length() - 1)){
					JOptionPane.showMessageDialog(null, "Email Iválido", "ERROR", 0);
					valido = false;
				}
				else {
					valido = true;
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Email errado, usar formato - exemplo@exemplo.com", "ERROR", 0);
				valido = false;
			}
		
	}else{
		JOptionPane.showMessageDialog(null, "Digite um email.", "ERROR", 0);
		valido = false;
		}
		return valido;
	}
	
	public boolean validarCadastro(String login){
		
		return false;
	}

}
