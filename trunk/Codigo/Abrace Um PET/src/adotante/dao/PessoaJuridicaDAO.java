package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaDAO {
	Conexao	conexao	= new Conexao();
	
	/**
	 * ADICIONA PESSOA JURIDICA NO BANCO
	 * 
	 * @param pessoaJuridica
	 * @return
	 */
	public boolean adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		try {
			Connection con = Conexao.abrir();
			int idEndereco = inserirEndereco(pessoaJuridica, con);
			int idPessoa = inserirPessoa(pessoaJuridica, con, idEndereco);
			inserirPessoaJuridica(pessoaJuridica, con, idPessoa);
			inserirAdotante(con, idPessoa);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			Conexao.fechar(con, );
		}
	}
	
	/**
	 * CONSULTA A EXISTENCIA DE PESSOA JURIDICA NO BANCO
	 * 
	 * @param cnpj
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings ("static-access" )
	public boolean consultarPessoaJuridicaCNPJ(String cnpj) throws Exception {
		String resultSet = ("select cnpj from pessoajuridica where cnpj='" + cnpj + "'");
		return (conexao.consultar(resultSet));
	}
	
	/**
	 * INSERE ENDERECO DA PESSOA JURIDICA
	 * 
	 * @param pessoaJuridica
	 * @param con
	 * @return
	 */
	public int inserirEndereco(PessoaJuridica pessoaJuridica, Connection con) {
		int id = 0;
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
			ex.printStackTrace();
		}
		return id;
	}
	
	/**
	 * INSERE PESSOA DA PESSOA JURIDICA
	 * 
	 * @param pessoaJuridica
	 * @param con
	 * @param idEndereco
	 * @return
	 */
	public int inserirPessoa(PessoaJuridica pessoaJuridica, Connection con, int idEndereco) {
		int id = 0;
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
			ex.printStackTrace();
		}
		return id;
		
	}
	
	/**
	 * INSERE ADOTANTE DA PESSOA JURIDICA
	 * 
	 * @param con
	 * @param idPessoa
	 * @return
	 */
	public int inserirAdotante(Connection con, int idPessoa) {
		int id = 0;
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
			ex.printStackTrace();
		}
		return id;
	}
	
	/**
	 * INSERE PESSOA JURIDICA
	 * 
	 * @param pessoaJuridica
	 * @param con
	 * @param idPessoa
	 * @return
	 */
	public int inserirPessoaJuridica(PessoaJuridica pessoaJuridica, Connection con, int idPessoa) {
		int id = 0;
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
			ex.printStackTrace();
		}
		return id;
	}
	
	/**
	 * CONSULTA PESSOA JURIDICA ATRAVEZ DO CNPJ E RETORNA VALORES
	 * 
	 * @param cnpj
	 * @return
	 * @throws SQLException
	 */
	public PessoaJuridica consultarPessoaJuridica(String cnpj) throws SQLException {
		Connection connection = Conexao.abrir();
		PreparedStatement statementPessoaJuridica = null;
		ResultSet resultPessoaJuridica = null;
		
		try {
			String queryPessoaJuridicaPessoa = "SELECT pj.id, pj.cnpj, pj.idPessoa, pj.idPessoaFisica, p.nome, "
					+ "p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email FROM pessoajuridica as"
					+ " pj INNER JOIN pessoa as p ON pj.idPessoa = p.id WHERE cnpj = ?";
			statementPessoaJuridica = connection.prepareStatement(queryPessoaJuridicaPessoa);
			statementPessoaJuridica.setString(1, cnpj);
			resultPessoaJuridica = statementPessoaJuridica.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			PessoaJuridica pessoaJuridica = new PessoaJuridica();
			Endereco endereco = new Endereco();
			PessoaFisica pessoaFisica = new PessoaFisica();
			if (resultPessoaJuridica.next()) {
				
				pessoa.setId(resultPessoaJuridica.getInt("idPessoa"));
				pessoa.setNome(resultPessoaJuridica.getString("nome"));
				pessoa.setEmail(resultPessoaJuridica.getString("email"));
				pessoa.setTelefoneCelular(resultPessoaJuridica.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultPessoaJuridica.getString("telefoneFixo"));
				
				pessoaJuridica.setId(resultPessoaJuridica.getInt("id"));
				pessoaJuridica.setCnpj(resultPessoaJuridica.getString("cnpj"));
				
				endereco.setId(resultPessoaJuridica.getInt("idEndereco"));
				
				pessoaFisica.setId(resultPessoaJuridica.getInt("idPessoaFisica"));
				pessoaJuridica.setResponsavel(pessoaFisica);
				
				pessoaJuridica.setPessoa(pessoa);
				pessoaJuridica.setResponsavel(pessoaFisica);
				pessoaJuridica.getPessoa().setEndereco(endereco);
			}
			
			return pessoaJuridica;
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
