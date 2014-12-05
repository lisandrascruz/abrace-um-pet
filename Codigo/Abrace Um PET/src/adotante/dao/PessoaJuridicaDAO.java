package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
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
			int idPessoa = inserirPessoa(pessoaJuridica, con, idEndereco);
			inserirPessoaJuridica(pessoaJuridica, con, idPessoa);
			inserirAdotante(con, idPessoa);
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

			preparedStatement.setString(1, pessoaJuridica.getPessoa().getEndereco().getEstado());
			preparedStatement.setString(2, pessoaJuridica.getPessoa().getEndereco().getCidade());
			preparedStatement.setString(3, pessoaJuridica.getPessoa().getEndereco().getBairro());
			preparedStatement.setString(4, pessoaJuridica.getPessoa().getEndereco().getRua());
			preparedStatement.setString(5, pessoaJuridica.getPessoa().getEndereco().getNumero());
			preparedStatement.setString(6, pessoaJuridica.getPessoa().getEndereco().getCep());
			preparedStatement.setString(7, pessoaJuridica.getPessoa().getEndereco().getComplemento());

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
			preparedStatement.setInt (3, pessoaJuridica.getResponsavel().getId());

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

	public List<PessoaJuridica> retornarPessoaJuridica(String cnpj) throws SQLException {
		Connection connection = Conexao.abrirConceccaoMySQL();
		PreparedStatement statementPessoaJuridica = null;
		PreparedStatement statementPessoa = null;
		PreparedStatement statementEndereco = null;
		PreparedStatement statementAdotante = null;
		PreparedStatement statementRepresentante = null;
		ResultSet resultPessoaJuridica = null;
		ResultSet resultPessoa = null;
		ResultSet resultEndereco = null;
		ResultSet resultAdotante = null;
		ResultSet resultRepresentante = null;
		try {
			String queryPessoaJuridica = "SELECT pj.id, pj.cnpj, pj.idPessoa, pj.idPessoaFisica FROM pessoajuridica as"
					+ " pj INNER JOIN pessoa as p ON pj.idPessoa = p.id WHERE cnpj = ?";
			statementPessoaJuridica = connection.prepareStatement(queryPessoaJuridica);
			statementPessoaJuridica.setString(1, cnpj);
			resultPessoaJuridica = statementPessoaJuridica.executeQuery();

			String queryPessoa = "SELECT p.id, p.nome, p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email FROM pessoa as"
					+ " p INNER JOIN endereco as ende ON p.idEndereco = ende.id";
			statementPessoa = connection.prepareStatement(queryPessoa);
			resultPessoa = statementPessoa.executeQuery();

			String queryEndereco = "SELECT ende.id, ende.estado, ende.cidade, ende.bairro, ende.rua, ende.numero, ende.complemento, ende.cep FROM endereco as"
					+ " ende INNER JOIN pessoa as p ON p.idEndereco = ende.id";
			statementEndereco = connection.prepareStatement(queryEndereco);
			resultEndereco = statementEndereco.executeQuery();

			String queryAdotante = "SELECT adot.impedimento, adot.motivoImpedimeto, adot.idPessoa FROM adotante as "
					+ " adot INNER JOIN pessoa as p ON adot.idPessoa = p.id";
			statementAdotante = connection.prepareStatement(queryAdotante);
			resultAdotante = statementAdotante.executeQuery();

			String queryRepresentante = "SELECT pf.id FROM pessoafisica as pf INNER JOIN pessoajuridica as pj ON pj.idPessoaFisica = pf.id";
			statementRepresentante = connection.prepareStatement(queryRepresentante);
			resultRepresentante = statementRepresentante.executeQuery();

			List<PessoaJuridica> listPessoaJuridica = new ArrayList<PessoaJuridica>();

			if (resultEndereco.next()) {

				Endereco endereco = new Endereco();
				endereco.setId(resultEndereco.getInt("id"));
				endereco.setRua(resultEndereco.getString("rua"));
				endereco.setBairro(resultEndereco.getString("bairro"));
				endereco.setNumero(resultEndereco.getString("numero"));
				endereco.setCidade(resultEndereco.getString("cidade"));
				endereco.setEstado(resultEndereco.getString("estado"));
				endereco.setCep(resultEndereco.getString("cep"));

				if (resultPessoa.next()) {

					Pessoa pessoa = new Pessoa();
					pessoa.setId(resultPessoa.getInt("id"));
					pessoa.setNome(resultPessoa.getString("nome"));
					pessoa.setEmail(resultPessoa.getString("email"));
					pessoa.setTelefoneCelular(resultPessoa.getString("telefoneCelular"));
					pessoa.setTelefoneFixo(resultPessoa.getString("telefoneFixo"));
					pessoa.setEndereco(endereco);

					if (resultAdotante.next()) {
						pessoa.setImpedimento(resultAdotante.getBoolean("impedimento"));
						pessoa.setMotivoImpedimento(resultAdotante.getString("motivoImpedimeto"));
					}
					if (resultPessoaJuridica.next()) {

						PessoaJuridica pessoaJuridica = new PessoaJuridica();
						pessoaJuridica.setId(resultPessoaJuridica.getInt("id"));
						pessoaJuridica.setCnpj(resultPessoaJuridica.getString("cnpj"));
						
						if (resultRepresentante.next()) {
							pessoaJuridica.getResponsavel().setCpf(resultRepresentante.getString("responsavel"));
							pessoaJuridica.setPessoa(pessoa);
						}
						listPessoaJuridica.add(pessoaJuridica);
					}
				}
			}
			return listPessoaJuridica;
		} finally {
			if (resultPessoaJuridica != null) {
				resultPessoaJuridica.close();
			}
			if (statementPessoaJuridica != null) {
				statementPessoaJuridica.close();
			}
		}

	}

}
