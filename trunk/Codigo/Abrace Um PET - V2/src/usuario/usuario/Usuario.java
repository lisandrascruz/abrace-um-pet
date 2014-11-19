package usuario.usuario;

public class Usuario {

	// Atributos
	private int id_usuario;
	private String login;
	private String senha;

	// Getters e Setters
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
}
