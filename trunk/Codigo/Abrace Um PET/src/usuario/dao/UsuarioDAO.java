package usuario.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import usuario.dominio.Usuario;
import usuario.service.CriptografiaService;

public class UsuarioDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean adicionarUsuario(Usuario usuario) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			String login = usuario.getLogin();
			String senha = usuario.getSenha();
			String email = usuario.getEmail();

			CriptografiaService criptografia = new CriptografiaService();
			senha = criptografia.criptografar(senha);

			String query = "INSERT INTO usuario (login, senha, email) values (?, ?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, login);
			preparedStatement.setString(2, senha);
			preparedStatement.setString(3, email);
			// preparedStatement.execute();
			// preparedStatement.close();

			int id;
			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();

			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * DELETAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	/*
	 * public boolean excluirUsuario(Usuario usuario) { Connection con =
	 * Conexao.abrirConceccaoMySQL(); Criptografia criptografia = new
	 * Criptografia();
	 * 
	 * String login = usuario.getLogin(); String senha = usuario.getSenha();
	 * String email = usuario.getEmail(); senha =
	 * criptografia.criptografar(senha);
	 * 
	 * String query = "DELETE INTO tbl_usuario (login, senha, email) VALUES ('"
	 * + login + "','" + senha + "','" + email + "')";
	 * Conexao.comandoMySQL(query); Conexao.fecharConecaoMySQL(); return true; }
	 */

	/**
	 * 
	 * @param query
	 * @return
	 */
	public boolean consultar(String query) {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean usuario = false;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery(query);
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

	/**
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * 
	 * @param login
	 * @param senha
	 * @return
	 */
	public boolean consultarLogin(String login, String senha) {
		String resultSet = ("select login, senha from usuario where login='" + login + "'and senha='" + senha + "'");

		return consultar(resultSet);
	}

	/**
	 * @param login
	 * @return
	 */
	public boolean consultarUsuario(String login) {
		String resultSet = ("select login from usuario where login='" + login + "'");
		return consultar(resultSet);
	}

}
