package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import adotante.dominio.PessoaFisica;

public class PessoaFisicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean adicionarPessoFisica(PessoaFisica pessoaFisica) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();

			String query = "INSERT INTO endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con
					.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getAdotante()
					.getEndereco().getEstado());
			preparedStatement.setString(2, pessoaFisica.getAdotante()
					.getEndereco().getCidade());
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getEndereco().getBairro());
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getEndereco().getRua());
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getEndereco().getNumero());
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getEndereco().getCep());
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getEndereco().getComplemento());
			preparedStatement.execute();  
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
	 * public boolean excluirUsuario(Usuario usuario) {
	 * Conexao.abrirConceccaoMySQL();
	 * 
	 * 
	 * String login = usuario.getLogin(); String senha = usuario.getSenha();
	 * String email = usuario.getEmail();
	 * 
	 * 
	 * String query = "DELETE INTO tbl_usuario (login, senha, email) VALUES ('"
	 * + login + "','" + senha + "','" + email + "')";
	 * System.out.println(query); Conexao.comandoMySQL(query);
	 * Conexao.fecharConecaoMySQL(); return true; }
	 */

	/**
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * 
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
