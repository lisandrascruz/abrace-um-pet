package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import adotante.dominio.PessoaJuridica;

import com.mysql.jdbc.PreparedStatement;

public class PessoaJuridicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		try {
			int id;
			Connection con = Conexao.abrirConceccaoMySQL();

			String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getAdotante()
					.getEndereco().getEstado());
			preparedStatement.setString(2, pessoaJuridica.getAdotante()
					.getEndereco().getCidade());
			preparedStatement.setString(3, pessoaJuridica.getAdotante()
					.getEndereco().getBairro());
			preparedStatement.setString(4, pessoaJuridica.getAdotante()
					.getEndereco().getRua());
			preparedStatement.setString(5, pessoaJuridica.getAdotante()
					.getEndereco().getNumero());
			preparedStatement.setString(6, pessoaJuridica.getAdotante()
					.getEndereco().getCep());
			preparedStatement.setString(7, pessoaJuridica.getAdotante()
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
			System.out.println("Endereco");
			preparedStatement.close();

			query = "insert into adotante (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement
					.setString(1, pessoaJuridica.getAdotante().getNome());
			preparedStatement.setInt(2, id);
			preparedStatement.setString(3, pessoaJuridica.getAdotante()
					.getTelefoneFixo());
			preparedStatement.setString(4, pessoaJuridica.getAdotante()
					.getTelefoneCelular());
			preparedStatement.setString(5, pessoaJuridica.getAdotante()
					.getEmail());

			affectedRows = preparedStatement.executeUpdate();

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
			System.out.println("adotante");

			query = "insert into pessoajuridica (cnpj, idResponsavel, idAdotante) values (?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getCnpj());
			preparedStatement.setInt(2, id);
			preparedStatement.setInt(3, id);

			System.out.println("Pessoa Juridica"); //teste
			
			affectedRows = preparedStatement.executeUpdate(); // ERRO AQUII!!!!

			System.out.println("Pessoa Juridica"); //teste 
			
			
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
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	
}
