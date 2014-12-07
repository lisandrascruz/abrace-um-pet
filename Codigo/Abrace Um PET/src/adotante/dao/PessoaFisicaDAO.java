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
	 */
	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			
			int idEndereco = inserirEndereco(pessoaFisica, con);
			int idPessoa = inserirPessoa(pessoaFisica, con, idEndereco);
			inserirPessoaFisica(pessoaFisica, con, idPessoa);
			inserirAdotante(con, idPessoa);
			
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
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
	 * INSERE ENDERECO DA PESSOA FISICA
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
	 * INSERE PESSOA FISICA
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
		PreparedStatement statementPessoa = null;
		PreparedStatement statementEndereco = null;
		
		ResultSet resultPessoaFisica = null;
		ResultSet resultPessoa = null;
		ResultSet resultEndereco = null;
		
		try {
			String queryPessoaFisicaPessoa = "SELECT pf.id, pf.cpf, pf.rg, pf.genero, pf.idPessoa FROM pessoafisica as"
					+ " pf INNER JOIN pessoa as p ON pf.idPessoa = p.id WHERE cpf = ?";
			statementPessoaFisica = connection.prepareStatement(queryPessoaFisicaPessoa);
			statementPessoaFisica.setString(1, cpf);
			resultPessoaFisica = statementPessoaFisica.executeQuery();
			
			String queryPessoaEndereco = "SELECT p.id, p.nome, p.idEndereco, p.telefoneFixo, p.telefoneCelular, p.email FROM pessoa as"
					+ " p INNER JOIN endereco as ende ON p.idEndereco = ende.id";
			statementPessoa = connection.prepareStatement(queryPessoaEndereco);
			resultPessoa = statementPessoa.executeQuery();
			
			String queryEndereco = "SELECT ende.id, ende.estado, ende.cidade, ende.bairro, ende.rua, ende.numero, ende.complemento, ende.cep FROM endereco as"
					+ " ende INNER JOIN pessoa as p ON p.idEndereco = ende.id";
			statementEndereco = connection.prepareStatement(queryEndereco);
			resultEndereco = statementEndereco.executeQuery();
			
			Endereco endereco = new Endereco();
			Pessoa pessoa = new Pessoa();
			PessoaFisica pessoaFisica = new PessoaFisica();
			
			if (resultEndereco.next()) {
				
				endereco.setId(resultEndereco.getInt("id"));
				endereco.setRua(resultEndereco.getString("rua"));
				endereco.setBairro(resultEndereco.getString("bairro"));
				endereco.setNumero(resultEndereco.getString("numero"));
				endereco.setCidade(resultEndereco.getString("cidade"));
				endereco.setEstado(resultEndereco.getString("estado"));
				endereco.setCep(resultEndereco.getString("cep"));
				
				if (resultPessoa.next()) {
					
					pessoa.setId(resultPessoa.getInt("id"));
					pessoa.setNome(resultPessoa.getString("nome"));
					pessoa.setEmail(resultPessoa.getString("email"));
					pessoa.setTelefoneCelular(resultPessoa.getString("telefoneCelular"));
					pessoa.setTelefoneFixo(resultPessoa.getString("telefoneFixo"));
					pessoa.setEndereco(endereco);
					if (resultPessoaFisica.next()) {
						
						pessoaFisica.setId(resultPessoaFisica.getInt("id"));
						pessoaFisica.setCpf(resultPessoaFisica.getString("cpf"));
						pessoaFisica.setRg(resultPessoaFisica.getString("rg"));
						pessoaFisica.setGenero(resultPessoaFisica.getString("genero"));
						pessoaFisica.setPessoa(pessoa);
						
					}
				}
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
