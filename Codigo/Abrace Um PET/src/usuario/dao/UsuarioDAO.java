package usuario.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usuario.dominio.Usuario;
import usuario.service.Criptografia;

public class UsuarioDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean adicionarUsuario(Usuario usuario) {
		Conexao.abrirConceccaoMySQL();
		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		String email = usuario.getEmail();

		Criptografia criptografia = new Criptografia();
		senha = criptografia.criptografar(senha);

		String query = "INSERT INTO tbl_usuario (login, senha, email) VALUES ('"+ login + "','" + senha + "','" + email + "')";
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}

	/**
	 * DELETAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean excluirUsuario(Usuario usuario) {
		Conexao.abrirConceccaoMySQL();
		Criptografia criptografia = new Criptografia();

		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		String email = usuario.getEmail();
		senha = criptografia.criptografar(senha);

		String query = "DELETE INTO tbl_usuario (login, senha, email) VALUES ('"
				+ login + "','" + senha + "','" + email + "')";
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}

	/**
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * @param login
	 * @param senha
	 * @return
	 */
	public boolean consultarLogin(String login, String senha) {
		String resultSet1 = ("select login, senha from tbl_usuario where login='"
				+ login + "'and senha='" + senha + "'");
		
		return consultar(resultSet1);
	}
	/**
	 * 
	 * @param login
	 * @return
	 */

	public boolean consultarUsuario(String login) {
		String resultSet1 = ("select login from tbl_usuario where login='"
				+ login + "'");
		return consultar(resultSet1);
	}
	/**
	 * 
	 * @param resultSet1
	 * @return
	 */
	public boolean consultar(String resultSet1) {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean usuario = false;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery(resultSet1);
			if (resultSet.next()) {
				usuario = true;
			} else {
				usuario = false;
			}
			Conexao.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
