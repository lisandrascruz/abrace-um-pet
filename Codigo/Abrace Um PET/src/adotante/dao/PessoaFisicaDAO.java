package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;

public class PessoaFisicaDAO {

	Conexao	conexao	= new Conexao();

	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */

	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			System.out.print(pessoaFisica.getRg());

			int idEndereco = inserirEndereco(pessoaFisica, con);
			int idPessoa = inserirPessoa(pessoaFisica, con, idEndereco);
			inserirPessoaFisica(pessoaFisica, con, idPessoa);
			inserirAdotante(con, idPessoa);

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

	public boolean consultarPessoaFisica(String cpf) {
		String resultSet = ("select cpf from pessoaFisica where cpf='" + cpf + "'");
		return (conexao.consultar(resultSet));
	}

	public PessoaFisica consultarRepresentante(String cpf) {
		PessoaFisica pessoaFisica = new PessoaFisica();
		String resultSet = ("select cpf from pessoaFisica where cpf='" + cpf + "'");
		return pessoaFisica;
	}

	public int inserirEndereco(PessoaFisica pessoaFisica, Connection con) {
		int id;
		String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getPessoa().getEndereco().getEstado());
			preparedStatement.setString(2, pessoaFisica.getPessoa().getEndereco().getCidade());
			preparedStatement.setString(3, pessoaFisica.getPessoa().getEndereco().getBairro());
			preparedStatement.setString(4, pessoaFisica.getPessoa().getEndereco().getRua());
			preparedStatement.setString(5, pessoaFisica.getPessoa().getEndereco().getNumero());
			preparedStatement.setString(6, pessoaFisica.getPessoa().getEndereco().getCep());
			preparedStatement.setString(7, pessoaFisica.getPessoa().getEndereco().getComplemento());

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

	public int inserirPessoa(PessoaFisica pessoaFisica, Connection con, int idEndereco) {
		int id;
		String query = "insert into pessoa (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
		try {

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getPessoa().getNome());
			preparedStatement.setInt(2, idEndereco);
			preparedStatement.setString(3, pessoaFisica.getPessoa().getTelefoneFixo());
			preparedStatement.setString(4, pessoaFisica.getPessoa().getTelefoneCelular());
			preparedStatement.setString(5, pessoaFisica.getPessoa().getEmail());

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

	public int inserirPessoaFisica(PessoaFisica pessoaFisica, Connection con, int idPessoa) {
		int id;
		String query = "insert into pessoafisica (rg, cpf, genero, idPessoa) values (?, ?, ?, ?)";
		try {

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getRg());
			preparedStatement.setString(2, pessoaFisica.getCpf());
			preparedStatement.setString(3, pessoaFisica.getGenero());
			preparedStatement.setInt(4, idPessoa);

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

	public PessoaFisica retornarPessoaFisica(String cpf) throws SQLException {
		Connection connection = Conexao.abrirConceccaoMySQL();
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			statement = connection.prepareStatement("SELECT * FROM pessoafisica WHERE cpf = ?");
			statement.setString(1, cpf);
			result = statement.executeQuery();

			if (result.next()) {
//				Endereco endereco = new Endereco();
//				endereco.setId(result.getInt("id"));
//				endereco.setBairro(result.getString("bairro"));
//				endereco.setCep(result.getString("cep"));
//
//				Pessoa pessoa = new Pessoa();
//				pessoa.setEndereco(endereco);
//				pessoa.setEmail(result.getString("email"));

				PessoaFisica pessoaFisica = new PessoaFisica();
				pessoaFisica.setId(result.getInt("id"));
				pessoaFisica.setCpf(result.getString("cpf"));
				pessoaFisica.setGenero(result.getString("genero"));
			//	pessoaFisica.setPessoa(pessoa);

				return pessoaFisica;
			}
		} finally {
			if (result != null)
				result.close();
			if (statement != null)
				statement.close();
		}

		return null;
	}
}
