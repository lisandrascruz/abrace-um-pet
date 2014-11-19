package usuario.negocio;

import usuario.dao.UsuarioDAO;
import usuario.usuario.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	
	public boolean consultarUsuarioService(Usuario usuario){
		return usuarioDao.consultarUsuario(usuario);
	}
	
	public boolean adicionarUsuarioService(Usuario usuario){
		return usuarioDao.adicionarUsuario(usuario);
	}
	
//	public boolean serviceLoginUsuario(String login, String senha){
//		return daoUsuario.loginUsuario(login, senha);
//		
//	}
	
}
