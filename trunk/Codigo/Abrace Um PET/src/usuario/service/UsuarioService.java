package usuario.service;

import usuario.dao.UsuarioDAO;
import usuario.dominio.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDao = new UsuarioDAO();

	public boolean consultarUsuarioService(String login, String senha) {
		return usuarioDao.consultarUsuario(login, senha);
	}

	public boolean adicionarUsuarioService(Usuario usuario) {
		return usuarioDao.adicionarUsuario(usuario);
	}
}
