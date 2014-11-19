package usuario.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usuario.usuario.Usuario;
import dao.Conexao;

public class UsuarioDAO {

	public boolean adicionarUsuario(Usuario usuario) {
		Conexao.abrirConceccaoMySQL();
		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes(), 0, senha.length());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "INSERT INTO tbl_usuario (login, senha) VALUES ('"
				+ login + "','" + senha + "')";
		System.out.println(query);
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}

	/**
	 * Consultar no bd
	 */
	@SuppressWarnings("null")
	public boolean consultarUsuario(String login, String senha) {

		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		System.out.println(login + ", " + senha);
		boolean acesso = false;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement
					.executeQuery("select login, senha from tbl_usuario where login='"
							+ login + "'and senha='" + senha + "'");
			if (resultSet.next()) {
				acesso = true;
			} else {
				acesso = false;
			}
			Conexao.fecharConecaoMySQL();
		} catch (SQLException e) {

		}
		return acesso;

	}

}
