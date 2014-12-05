package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	Conexao	conexao	= new Conexao();

	public boolean adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			int idEndereco = inserirEndereco(pessoaJuridica, con);
			System.out.println(idEndereco);
			int idPessoa = inserirPessoa(pessoaJuridica, con, idEndereco);
			inserirPessoaJuridica(pessoaJuridica, con, idPessoa);
			inserirAdotante(con, idPessoa);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean consultarPessoaJuridica(String cnpj) {
		String resultSet = ("select cpf from pessoajuridica where cnpj='" + cnpj + "'");
		return (conexao.consultar(resultSet));
	}

	public int inserirEndereco(PessoaJuridica pessoaJuridica, Connection con) {
		int id;
		String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			Pessoa pessoa = pessoaJuridica.getPessoa();
			Endereco endereco = pessoa.getEndereco();
			preparedStatement.setString(1, endereco.getEstado());
			preparedStatement.setString(2, endereco.getCidade());
			preparedStatement.setString(3, endereco.getBairro());
			preparedStatement.setString(4, endereco.getRua());
			preparedStatement.setString(5, endereco.getNumero());
			preparedStatement.setString(6, endereco.getCep());
			preparedStatement.setString(7, endereco.getComplemento());

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

		} catch (Exception ex) {
			return -1;
		}
		return id;
	}

	public int inserirPessoa(PessoaJuridica pessoaJuridica, Connection con, int idEndereco) {
		int id;
		String query = "insert into pessoa (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getPessoa().getNome());
			preparedStatement.setInt(2, idEndereco);
			preparedStatement.setString(3, pessoaJuridica.getPessoa().getTelefoneFixo());
			preparedStatement.setString(4, pessoaJuridica.getPessoa().getTelefoneCelular());
			preparedStatement.setString(5, pessoaJuridica.getPessoa().getEmail());

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
		} catch (Exception ex) {
			return -1;
		}
		return id;

	}

	public int inserirAdotante(Connection con, int idPessoa) {
		int id;
		String query = "insert into adotante (idPessoa) values (?)";
		try {

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setInt(1, idPessoa);

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

		} catch (Exception ex) {
			return -1;
		}
		return id;
	}

	public int inserirPessoaJuridica(PessoaJuridica pessoaJuridica, Connection con, int idPessoa) {
		int id;
		String query = "insert into pessoajuridica (cnpj, idPessoa, idPessoaFisica) values (?, ?, ?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getCnpj());
			preparedStatement.setInt(2, idPessoa);
			preparedStatement.setInt(3, pessoaJuridica.getResponsavel().getId());

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
		} catch (Exception ex) {
			return -1;
		}
		return id;
	}

}
