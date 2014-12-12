package animal.dao;

import infraestrutura.dao.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import raca.dao.RacaDAO;
import raca.dominio.Raca;
import animal.dominio.Animal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AnimalDAO {
	
	public Animal consultarAnimal(String rga) throws SQLException {
		Connection connection = (Connection) Conexao.abrirConceccaoMySQL();
		PreparedStatement statementAnimal = null;
		java.sql.ResultSet resultAnimal = null;
		
		try {
			String queryAnimal = "SELECT a.id, a.nome, a.tipo, a.rga, a.dataNascimento, a.idRaca, a.genero,"
					+ "a.deficiencia, a.vacinado, a.castrado, a.tamanho, a.peso, a.temperamento,"
					+ "a.observacao, a.dataResgate, r.nome, r.origem, r.tamanhoMax, r.tamanhoMin, r.expectativaVida  "
					+ "FROM animal as a INNER JOIN raca as r ON a.idRaca = r.id WHERE rga = ?";
			statementAnimal = (PreparedStatement) connection.prepareStatement(queryAnimal);
			statementAnimal.setString(1, rga);
			resultAnimal = statementAnimal.executeQuery();
			Animal animal = new Animal();
			Raca raca = new Raca();
			if (resultAnimal.next()) {
				//Raca
				raca.setId(resultAnimal.getInt("idRaca"));
				raca.setExpectativaVida(resultAnimal.getInt("expectativaVida"));
				raca.setNome(resultAnimal.getString("nome"));
				raca.setOrigem(resultAnimal.getString("origem"));
				raca.setTamanhoMax(resultAnimal.getDouble("tamanhoMax"));
				raca.setTamanhoMin(resultAnimal.getDouble("tamanhoMin"));
				//Animal
				animal.setId(resultAnimal.getInt("id"));
				animal.setNome(resultAnimal.getString("nome"));
				animal.setTipo(resultAnimal.getString("tipo"));
				animal.setRga(resultAnimal.getString("rga"));
				animal.setDataNascimento(resultAnimal.getString("dataNascimento"));
				animal.setGenero(resultAnimal.getString("genero"));
				animal.setDeficiencia(resultAnimal.getString("deficiencia"));
				animal.setVacinado(resultAnimal.getString("vacinado"));
				animal.setCastrado(resultAnimal.getString("castrado"));
				animal.setTamanho(resultAnimal.getDouble("tamanho"));
				animal.setPeso(resultAnimal.getDouble("peso"));
				animal.setTemperamento(resultAnimal.getString("temperamento"));
				animal.setObservacao(resultAnimal.getString("observacao"));
				animal.setDataResgate(resultAnimal.getString("dataResgate"));
				animal.setRaca(raca);
				
			}
			return animal;
		} finally {
			if (resultAnimal != null) {
				resultAnimal.close();
			}
			if (statementAnimal != null) {
				statementAnimal.close();
			}
		}
	}
	
	public boolean adicionarAnimal(Animal animal) {
		try {
			Connection con = (Connection) Conexao.abrirConceccaoMySQL();
			RacaDAO racaDAO = new RacaDAO();
			int idRaca = racaDAO.inserirRaca(animal, con);
			inserirAnimal(animal, con, idRaca);
			
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	private int inserirAnimal(Animal animal, Connection con, int idRaca) {
		int id = 0;
		String query = "insert into animal (nome, tipo, rga, dataNascimento, idRaca, genero, deficiencia, vacinado, castrado, tamanho,"
				+ "peso, temperamento, observacao, dataResgate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1, animal.getNome());
			preparedStatement.setString(2, animal.getTipo());
			preparedStatement.setString(3, animal.getRga());
			preparedStatement.setString(4, animal.getDataNascimento());
			preparedStatement.setInt(5, idRaca);
			preparedStatement.setString(6, animal.getGenero());
			preparedStatement.setString(7, animal.getDeficiencia());
			preparedStatement.setString(8, animal.getVacinado());
			preparedStatement.setString(9, animal.getCastrado());
			preparedStatement.setDouble(10, animal.getTamanho());
			preparedStatement.setDouble(11, animal.getPeso());
			preparedStatement.setString(12, animal.getTemperamento());
			preparedStatement.setString(13, animal.getObservacao());
			preparedStatement.setString(14, animal.getDataResgate());
			
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
