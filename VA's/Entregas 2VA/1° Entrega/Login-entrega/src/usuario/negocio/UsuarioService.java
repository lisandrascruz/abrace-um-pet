package usuario.negocio;

import usuario.dao.UsuarioDAO;
import usuario.usuario.Usuario;

public class UsuarioService {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public boolean consultarUsuarioService(Usuario usuario){
		return usuarioDAO.consultarUsuario(usuario);
	}
	
}
