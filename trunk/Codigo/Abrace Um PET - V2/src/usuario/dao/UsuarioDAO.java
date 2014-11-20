package usuario.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import md5.Criptografia;
import usuario.dominio.Usuario;
import dao.Conexao;

public class UsuarioDAO {

	public boolean adicionarUsuario(Usuario usuario) {
		Conexao.abrirConceccaoMySQL();
		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		String email = usuario.getEmail();

		Criptografia criptografia = new Criptografia();
		senha = criptografia.criptografar(senha);

		String query = "INSERT INTO tbl_usuario (login, senha, email) VALUES ('"
				+ login + "','" + senha + "','" + email + "')";
		System.out.println(query);
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}

	/**
	 * Consultar no bd
	 */
	public boolean consultarUsuario(String login, String senha) {
		boolean acesso = false;

		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// System.out.println(login + ", " + senha);

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
