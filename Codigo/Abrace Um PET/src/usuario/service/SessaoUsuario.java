package usuario.service;

import usuario.dominio.Usuario;


public class SessaoUsuario {
	private Usuario usuarioLogado;
	private static SessaoUsuario instancia = new SessaoUsuario();
	private SessaoUsuario(){}
	public static SessaoUsuario getInstancia() {
		return instancia;
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
}
