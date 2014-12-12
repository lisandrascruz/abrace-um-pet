package raca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import raca.dominio.Raca;
import animal.dominio.Animal;

import com.mysql.jdbc.Connection;

import infraestrutura.dao.Conexao;

public class RacaDAO {
	/**
	 * LISTA TODOS OS NOMES DAS RA�AS DE CACHORRO EXISTENTES NO BANCO DE DADOS
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<String> getRacaCachorro() throws SQLException {
		
		Connection conn = (Connection) Conexao.abrirConceccaoMySQL();
		String query = "select * from racacachorro";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		List<String> racas = new ArrayList<String>();
		while (resultSet.next()) {
			
			Raca raca = new Raca();
			raca.setNome(resultSet.getString("nome"));
			String nome = raca.getNome();
			racas.add(nome);
		}
		return racas;
	}
	
	/**
	 * LISTA TODOS OS NOMES DAS RA�AS DE GATOS EXISTENTES NO BANCO DE DADOS
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<String> getRacaGato() throws SQLException {
		
		Connection conn = (Connection) Conexao.abrirConceccaoMySQL();
		String query = "select * from racagato";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		List<String> racas = new ArrayList<String>();
		while (resultSet.next()) {
			
			Raca raca = new Raca();
			raca.setNome(resultSet.getString("nome"));
			String nome = raca.getNome();
			racas.add(nome);
		}
		return racas;
	}
	
	/**
	 * USADO PARA CADASTRO DE RA�A NO BANCO DE DADOS
	 * 
	 * @author Lisandra Cruz
	 * @param raca
	 * @param con
	 * @return
	 */
	public int inserirRacaCachorro(Raca raca, Connection con) {
		int id = 0;
		String query = "insert into racacachorro(nome, origem, tamanhoMax, tamanhoMin, expectativaVida, temperamento) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1, raca.getNome());
			preparedStatement.setString(2, raca.getOrigem());
			preparedStatement.setDouble(3, raca.getTamanhoMax());
			preparedStatement.setDouble(4, raca.getTamanhoMin());
			preparedStatement.setInt(5, raca.getExpectativaVida());
			preparedStatement.setString(6, raca.getTemperamento());
			
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
	 * USADO PARA ADICIONAR A TABELA BANCO DE DADOS
	 * 
	 * @author Lisandra Cruz
	 * @param raca
	 * @return
	 */
	public boolean adicionarRacaCachorro(Raca raca) {
		try {
			Connection con = (Connection) Conexao.abrirConceccaoMySQL();
			RacaDAO racaDAO = new RacaDAO();
			racaDAO.inserirRacaCachorro(raca, con);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	/**
	 * USADO PARA CADASTRO DE RA�A NO BANCO DE DADOS
	 * 
	 * @author Lisandra Cruz
	 * @param raca
	 * @param con
	 * @return
	 */
	public int inserirRacaGato(Raca raca, Connection con) {
		int id = 0;
		String query = "insert into racagato(nome, origem, tamanhoMax, tamanhoMin, expectativaVida, temperamento) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1, raca.getNome());
			preparedStatement.setString(2, raca.getOrigem());
			preparedStatement.setDouble(3, raca.getTamanhoMax());
			preparedStatement.setDouble(4, raca.getTamanhoMin());
			preparedStatement.setInt(5, raca.getExpectativaVida());
			preparedStatement.setString(6, raca.getTemperamento());
			
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
	 * USADO PARA ADICIONAR A TABELA DO BANCO DE DADOS
	 * 
	 * @author Lisandra Cruz
	 * @param raca
	 * @return
	 */
	public boolean adicionarRacaGatos(Raca raca) {
		try {
			Connection con = (Connection) Conexao.abrirConceccaoMySQL();
			RacaDAO racaDAO = new RacaDAO();
			racaDAO.inserirRacaGato(raca, con);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public int inserirRaca(Animal animal, Connection con) {
		int id = 0;
		String query = "insert into raca(nome, origem, tamanhoMax, tamanhoMin, expectativaVida, temperamento) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			Raca raca = animal.getRaca();
			preparedStatement.setString(1, raca.getNome());
			preparedStatement.setString(2, raca.getOrigem());
			preparedStatement.setDouble(3, raca.getTamanhoMax());
			preparedStatement.setDouble(4, raca.getTamanhoMin());
			preparedStatement.setInt(5, raca.getExpectativaVida());
			preparedStatement.setString(6, raca.getTemperamento());
			
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
}