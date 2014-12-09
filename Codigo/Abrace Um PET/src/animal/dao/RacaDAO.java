package animal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import animal.dominio.Animal;
import animal.dominio.Raca;

import com.mysql.jdbc.Connection;

import infraestrutura.dao.Conexao;

public class RacaDAO {
	public Raca listarRaca() throws SQLException {
		Raca raca = new Raca();
		Connection conn = (Connection) Conexao.abrirConceccaoMySQL();
		String query = "select * from raca";
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		while(resultSet.next()){
			raca.setId(resultSet.getInt("id"));
			raca.setNome(resultSet.getString("nome"));
			raca.setOrigem(resultSet.getString("origem"));
			raca.setTamanhoMax(resultSet.getInt("tamanhoMax"));
			raca.setTamanhoMin(resultSet.getInt("tamanhoMin"));
			raca.setExpectativaVida(resultSet.getInt("expectativaVida"));
			raca.setTemperamento(resultSet.getString("temperamento"));
		
			
		}
		return raca;
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
