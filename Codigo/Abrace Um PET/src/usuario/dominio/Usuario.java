package usuario.dominio;

public class Usuario {

	private int id_usuario;
	private String login;
	private String senha;
//	private String confirmarSenha;
	private String email;
	
	
	public int getId_Usuario() {
		return id_usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

		public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getConfirmarSenha() {
//		return confirmarSenha;
//	}
//
//	public void setConfirmarSenha(String confirmarSenha) {
//		this.confirmarSenha = confirmarSenha;
//	}
}
