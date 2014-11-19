package usuario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import usuario.usuario.Usuario;

import com.mysql.jdbc.Statement;

import dao.Conexao;

public class UsuarioDAO {

	public boolean adicionarUsuario(Usuario usuario){
    	Conexao.abrirConceccaoMySQL();
    	String login = usuario.getLogin();
    	String senha = usuario.getSenha();
    	String query ="INSERT INTO tbl_usuario (login, senha) VALUES ('" + login + "','" + senha +"')";
    	System.out.println(query);
    	Conexao.comandoMySQL(query);
    	Conexao.fecharConecaoMySQL();
    	return true;
    }
	
   
    /**
     * Consultar no bd 
     */
	@SuppressWarnings("null")
	public boolean consultarUsuario(Usuario usuario){
		String login = usuario.getLogin().toString();
		String senha = usuario.getSenha().toString();
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		//System.out.println(login +", " + senha);
		boolean acesso = false;
		try {
			Conexao.abrirConceccaoMySQL();
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery("select login, senha from tbl_usuario where login='"
					+ login + "'and senha='" + senha + "'");
			if (resultSet.next()) {
				acesso = true;
			} else {
				acesso = false;
			}
			Conexao.fecharConecaoMySQL();
		}catch (SQLException e) {
			
		}
		return acesso;
		
	}
    
}
