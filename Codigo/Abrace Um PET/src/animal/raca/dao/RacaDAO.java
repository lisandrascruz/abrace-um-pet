package animal.raca.dao;

import infraestrutura.dao.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import animal.raca.dominio.Raca;

import com.mysql.jdbc.Connection;

public class RacaDAO {
	/**
	 * RETORNA OS OBJETOS DE RAÇAS EXISTENTES NO BANCO DE DADOS
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Raca> getRaca() throws SQLException {
		
		Connection conn = (Connection) Conexao.abrirConceccaoMySQL();
		PreparedStatement statement = conn.prepareStatement("select * from raca");
		ResultSet resultSet = statement.executeQuery();
		
		List<Raca> racas = new ArrayList<Raca>();
		while (resultSet.next()) {
			
			Raca raca = new Raca();
			raca.setId(resultSet.getInt("id"));
			raca.setNome(resultSet.getString("nome"));
			raca.setOrigem(resultSet.getString("origem"));
			raca.setTipo(resultSet.getString("tipo"));
			raca.setTamanhoMax(resultSet.getInt("tamanhoMax"));
			raca.setTamanhoMin(resultSet.getInt("tamanhoMin"));
			raca.setExpectativaVida(resultSet.getInt("expectativaVida"));
			raca.setTemperamento(resultSet.getString("temperamento"));
			
			racas.add(raca);
		}
		return racas;
	}
	
	/**
	 * USADO PARA INSERIR CADASTRO DE RAÇA NO BANCO DE DADOS
	 * 
	 * @param raca
	 * @param con
	 * @return
	 */
	public int inserirRaca(Raca raca, Connection con) {
		int id = 0;
		String query = "INSERT INTO raca(nome, origem, tamanhoMax, tamanhoMin, expectativaVida, temperamento) values (?, ?, ?, ?, ?, ?)";
		
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
	public boolean adicionarRaca(Raca raca) {
		RacaDAO racaDAO = new RacaDAO();
		try {
			Connection con = (Connection) Conexao.abrirConceccaoMySQL();
			racaDAO.inserirRaca(raca, con);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
