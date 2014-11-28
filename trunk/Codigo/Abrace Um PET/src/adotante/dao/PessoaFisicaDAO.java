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
	Conexao conexao = new Conexao();
	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) {
		try {
			int id;
			Connection con = Conexao.abrirConceccaoMySQL();

			String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getAdotante().getEndereco().getEstado());
			preparedStatement.setString(2, pessoaFisica.getAdotante().getEndereco().getCidade());
			preparedStatement.setString(3, pessoaFisica.getAdotante().getEndereco().getBairro());
			preparedStatement.setString(4, pessoaFisica.getAdotante().getEndereco().getRua());
			preparedStatement.setString(5, pessoaFisica.getAdotante().getEndereco().getNumero());
			preparedStatement.setString(6, pessoaFisica.getAdotante().getEndereco().getCep());
			preparedStatement.setString(7, pessoaFisica.getAdotante().getEndereco().getComplemento());

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

			query = "insert into adotante (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getAdotante().getNome());
			preparedStatement.setInt(2, id);
			preparedStatement.setString(3, pessoaFisica.getAdotante().getTelefoneFixo());
			preparedStatement.setString(4, pessoaFisica.getAdotante().getTelefoneCelular());
			preparedStatement.setString(5, pessoaFisica.getAdotante().getEmail());

			affectedRows = preparedStatement.executeUpdate();

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

			query = "insert into pessoafisica (rg, cpf, genero, idAdotante) values (?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getRg());
			preparedStatement.setString(2, pessoaFisica.getCpf());
			preparedStatement.setString(3, pessoaFisica.getGenero());
			preparedStatement.setInt(4, id);

			affectedRows = preparedStatement.executeUpdate();

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
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * 
	 * @param login
	 * @param senha
	 * @return
	 */
	public boolean consultarUsuario(String login, String senha) {

		String resultSet = (("select login, senha from tbl_usuario where login='" + login + "'and senha='" + senha + "'"));
		return conexao.consultar(resultSet);
	}

	/**
	 * CONSULTA SE A PESSOA FISICA EXISTE NO BANCO ATRAVES DO CPF
	 * @param cpf
	 * @return
	 */
	public boolean consultarPessoaFisica(String cpf) {
		String resultSet = ("select cpf from pessoafisica where cpf='" + cpf + "'");
		return conexao.consultar(resultSet);
	}

}
