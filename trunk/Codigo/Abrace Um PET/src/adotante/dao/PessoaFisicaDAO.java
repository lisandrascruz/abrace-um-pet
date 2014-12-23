package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * @throws Exception 
	 */
	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) throws Exception {
		Connection con = null;
		try {
			con = Conexao.abrir();
			
			int idEndereco = inserirEndereco(pessoaFisica, con);
			int idPessoa = inserirPessoa(pessoaFisica, con, idEndereco);
			inserirPessoaFisica(pessoaFisica, con, idPessoa);
			inserirAdotante(con, idPessoa);
			return true;
		} catch (Exception ex) {
			throw new Exception("Erro ao adicionar pessoa f�sica no banco de dados", ex);
		}finally{
			Conexao.fechar(con, null, null);
		}
	}
	
	/**
	 * QUERY PARA O METODO CONSULTAR
	 * 
	 * @param cpf
	 * @return
	 */
	public boolean consultarPessoaFisicaCPF(String cpf) {
		String query = ("SELECT cpf FROM pessoafisica where cpf='" + cpf + "'");
		return (conexao.consultar(query));
	}
	
	/**
	 * INSERE ENDERECO DA PESSOA FISICA NO BANCO DE DADOS
	 * 
	 * @param pessoaFisica
	 * @param con
	 * @return
	 */
	public int inserirEndereco(PessoaFisica pessoaFisica, Connection con) {
		int id = 0;
		String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			Endereco endereco = pessoaFisica.getPessoa().getEndereco();
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
	 * INSERE PESSOA NO BANCO
	 * 
	 * @param pessoaFisica
	 * @param con
	 * @param idEndereco
	 * @return
	 */
	public int inserirPessoa(PessoaFisica pessoaFisica, Connection con, int idEndereco) {
		int id = 0;
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
			ex.printStackTrace();
		}
		return id;
	}
	
	/**
	 * INSERE ADOTANTE NO BANCO DE DADOS
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
	 * INSERE PESSOA FISICA NO BANCO DE DADOS
	 * 
	 * @param pessoaFisica
	 * @param con
	 * @param idPessoa
	 * @return
	 */
	public int inserirPessoaFisica(PessoaFisica pessoaFisica, Connection con, int idPessoa) {
		int id = 0;
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
			ex.printStackTrace();
		}
		return id;
	}
	
	/**
	 * CONSULTA PESSOA FISICA NO BD ATAVES DO CPF
	 * 
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public PessoaFisica consultarPessoaFisica(String cpf) throws SQLException {
		Connection connection = Conexao.abrirConceccaoMySQL();
		PreparedStatement statementPessoaFisica = null;
		ResultSet resultPessoaFisica = null;
		
		try {
			String queryPessoaFisicaPessoa = "SELECT pf.id, pf.cpf, pf.idPessoa, pf.rg, pf.genero,"
					+ "p.id,  p.nome, p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email "
					+ "FROM pessoafisica as pf INNER JOIN pessoa as p "
					+ "ON pf.idPessoa = p.id WHERE cpf = ?";
			statementPessoaFisica = connection.prepareStatement(queryPessoaFisicaPessoa);
			statementPessoaFisica.setString(1, cpf);
			resultPessoaFisica = statementPessoaFisica.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			PessoaFisica pessoaFisica = new PessoaFisica();
			Endereco endereco = new Endereco();
			if (resultPessoaFisica.next()) {
				
				pessoa.setId(resultPessoaFisica.getInt("p.id"));
				pessoa.setNome(resultPessoaFisica.getString("p.nome"));
				pessoa.setEmail(resultPessoaFisica.getString("email"));
				pessoa.setTelefoneCelular(resultPessoaFisica.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultPessoaFisica.getString("telefoneFixo"));
				pessoaFisica.setId(resultPessoaFisica.getInt("pf.id"));
				pessoaFisica.setCpf(resultPessoaFisica.getString("cpf"));
				pessoaFisica.setRg(resultPessoaFisica.getString("rg"));
				pessoaFisica.setGenero(resultPessoaFisica.getString("genero"));
				endereco.setId(resultPessoaFisica.getInt("idEndereco"));
				pessoaFisica.setPessoa(pessoa);
				pessoa.setEndereco(endereco);
			}
			
			return pessoaFisica;
		} finally {
			if (resultPessoaFisica != null) {
				resultPessoaFisica.close();
			}
			if (statementPessoaFisica != null) {
				statementPessoaFisica.close();
			}
		}
		
	}
	
	/**
	 * CONSULTA PESSOA FISICA NO BD ATAVES DO id
	 * 
	 * @param cpf
	 * @return
	 * @throws SQLException
	 */
	public PessoaFisica consultarPessoaFisica(int id) throws SQLException {
		Connection connection = Conexao.abrirConceccaoMySQL();
		PreparedStatement statementPessoaFisica = null;
		ResultSet resultPessoaFisica = null;
		
		try {
			String queryPessoaFisicaPessoa = "SELECT pf.id, pf.cpf, pf.idPessoa, pf.rg, pf.genero,"
					+ "p.id,  p.nome, p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email "
					+ "FROM pessoafisica as pf INNER JOIN pessoa as p "
					+ "ON pf.idPessoa = p.id WHERE pf.id = ?";
			statementPessoaFisica = connection.prepareStatement(queryPessoaFisicaPessoa);
			statementPessoaFisica.setInt(1, id);
			resultPessoaFisica = statementPessoaFisica.executeQuery();
			
			Pessoa pessoa = new Pessoa();
			PessoaFisica pessoaFisica = new PessoaFisica();
			Endereco endereco = new Endereco();
			if (resultPessoaFisica.next()) {
				
				pessoa.setId(resultPessoaFisica.getInt("p.id"));
				pessoa.setNome(resultPessoaFisica.getString("p.nome"));
				pessoa.setEmail(resultPessoaFisica.getString("email"));
				pessoa.setTelefoneCelular(resultPessoaFisica.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultPessoaFisica.getString("telefoneFixo"));
				pessoaFisica.setId(resultPessoaFisica.getInt("pf.id"));
				pessoaFisica.setCpf(resultPessoaFisica.getString("cpf"));
				pessoaFisica.setRg(resultPessoaFisica.getString("rg"));
				pessoaFisica.setGenero(resultPessoaFisica.getString("genero"));
				endereco.setId(resultPessoaFisica.getInt("idEndereco"));
				pessoaFisica.setPessoa(pessoa);
				pessoa.setEndereco(endereco);
			}
			
			return pessoaFisica;
		} finally {
			if (resultPessoaFisica != null) {
				resultPessoaFisica.close();
			}
			if (statementPessoaFisica != null) {
				statementPessoaFisica.close();
			}
		}
		
	}
}
