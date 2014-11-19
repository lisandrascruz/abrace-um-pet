package usuario.usuario;

public class Usuario {

		//Atributos
		private int idUsuario;
		private String login;
		private String senha;
		//Costrutores
		public Usuario(){
			
		}
		public Usuario(String login,String senha){
			this.login = login;
			this.senha = senha;	
		}
		//Getters e Setters
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int id) {
			this.idUsuario = id;
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
