package animal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import animal.dominio.Raca;

import com.mysql.jdbc.Connection;

import infraestrutura.dao.Conexao;

public class RacaDAO {
	Raca raca = new Raca();
	public Raca listarRaca() throws SQLException {
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
	
}
