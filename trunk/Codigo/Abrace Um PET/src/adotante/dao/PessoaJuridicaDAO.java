package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

import com.mysql.jdbc.PreparedStatement;

public class PessoaJuridicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * @param usuario
	 * @return
	 */
	Conexao conexao = new Conexao();
	public boolean adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			int idEndereco = inserirEndereco(pessoaJuridica, con);
			int idAdotante = inserirAdotante( pessoaJuridica,  con,  idEndereco);
			inserirPessoaJuridica(pessoaJuridica,  con,  idAdotante);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean consultarPessoaFisica(String cnpj) {
		String resultSet = ("select cpf from pessoajuridica where cnpj='" + cnpj + "'");
		return (conexao.consultar(resultSet));
	}

	public int inserirEndereco(PessoaJuridica pessoaJuridica, Connection con) {
		int id;
		String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getAdotante().getEndereco().getEstado());
			preparedStatement.setString(2, pessoaJuridica.getAdotante().getEndereco().getCidade());
			preparedStatement.setString(3, pessoaJuridica.getAdotante().getEndereco().getBairro());
			preparedStatement.setString(4, pessoaJuridica.getAdotante().getEndereco().getRua());
			preparedStatement.setString(5, pessoaJuridica.getAdotante().getEndereco().getNumero());
			preparedStatement.setString(6, pessoaJuridica.getAdotante().getEndereco().getCep());
			preparedStatement.setString(7, pessoaJuridica.getAdotante().getEndereco().getComplemento());
			
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

	public int inserirAdotante(PessoaJuridica pessoaJuridica, Connection con, int idEndereco) {
		int id;
		String query = "insert into adotante (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getAdotante().getNome());
			preparedStatement.setInt   (2, idEndereco);
			preparedStatement.setString(3, pessoaJuridica.getAdotante().getTelefoneFixo());
			preparedStatement.setString(4, pessoaJuridica.getAdotante().getTelefoneCelular());
			preparedStatement.setString(5, pessoaJuridica.getAdotante().getEmail());

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

	public int inserirPessoaJuridica(PessoaJuridica pessoaJuridica, Connection con, int idAdotante){
		int id;
		String query = "insert into pessoajuridica (cnpj, idAdotante) values (?, ?)";
		try{
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
		
		preparedStatement.setString(1, pessoaJuridica.getCnpj());
		preparedStatement.setInt   (2, idAdotante);
		//preparedStatement.setInt   (3, id);
		
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
