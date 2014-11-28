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
	
	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			
			int idEndereco = inserirEndereco(pessoaFisica, con);
			int idAdotante = inserirAdotante( pessoaFisica,  con,  idEndereco);
			inserirPessoaFisica( pessoaFisica,  con,  idAdotante);

			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean consultar(String query) {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean usuario = false;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
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

	public boolean consultarPessoaFisica(String cpf) {
		String resultSet = ("select cpf from pessoafisica where cpf='"
				+ cpf + "'");
		return consultar(resultSet);
	}

	public int inserirEndereco(PessoaFisica pessoaFisica, Connection con) {
		int id;
		String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con
					.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getAdotante()
					.getEndereco().getEstado());
			preparedStatement.setString(2, pessoaFisica.getAdotante()
					.getEndereco().getCidade());
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getEndereco().getBairro());
			preparedStatement.setString(4, pessoaFisica.getAdotante()
					.getEndereco().getRua());
			preparedStatement.setString(5, pessoaFisica.getAdotante()
					.getEndereco().getNumero());
			preparedStatement.setString(6, pessoaFisica.getAdotante()
					.getEndereco().getCep());
			preparedStatement.setString(7, pessoaFisica.getAdotante()
					.getEndereco().getComplemento());

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();
		} catch (Exception ex) {
			return -1;
		}
		return id;
	}

	public int inserirAdotante(PessoaFisica pessoaFisica, Connection con, int idEndereco) {
		int id;
		String query = "insert into adotante (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
		try {

			PreparedStatement preparedStatement = (PreparedStatement) con
					.prepareStatement(query);

			preparedStatement
					.setString(1, pessoaFisica.getAdotante().getNome());
			preparedStatement.setInt(2, idEndereco);
			preparedStatement.setString(3, pessoaFisica.getAdotante()
					.getTelefoneFixo());
			preparedStatement.setString(4, pessoaFisica.getAdotante()
					.getTelefoneCelular());
			preparedStatement.setString(5, pessoaFisica.getAdotante()
					.getEmail());

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();
		} catch (Exception ex) {
			return -1;
		}
		return id;
	}
	
	public int inserirPessoaFisica(PessoaFisica pessoaFisica, Connection con, int idAdotante){
		int id;
		String query = "insert into pessoafisica (rg, cpf, genero, idAdotante) values (?, ?, ?, ?)";
		try{
			
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getRg());
			preparedStatement.setString(2, pessoaFisica.getCpf());
			preparedStatement.setString(3, pessoaFisica.getGenero());
			preparedStatement.setInt(4, idAdotante);

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();
			
		}catch (Exception ex) {
			return -1;
		}
		return id;
	}

}
