package usuario.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usuario.dominio.Usuario;
import usuario.md5.Criptografia;

public class UsuarioDAO {

	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
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

		String query = "INSERT INTO tbl_usuario (login, senha, email) VALUES ('"
				+ login + "','" + senha + "','" + email + "')";
		System.out.println(query);
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}
	/**
	 * DELETAR USUARIO NO BANCO DE DADOS
	 * @param usuario
	 * @return
	 */
	public boolean excluirUsuario(Usuario usuario) {
		Conexao.abrirConceccaoMySQL();
		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		String email = usuario.getEmail();

		Criptografia criptografia = new Criptografia();
		senha = criptografia.criptografar(senha);

		String query = "DELETE INTO tbl_usuario (login, senha, email) VALUES ('"
				+ login + "','" + senha + "','" + email + "')";
		System.out.println(query);
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
	public boolean consultarUsuario(String login, String senha) {
		boolean acesso = false;

		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;

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
			e.printStackTrace();
		}
		return acesso;
	}

}
