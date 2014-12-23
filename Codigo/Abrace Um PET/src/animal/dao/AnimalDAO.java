package animal.dao;

import infraestrutura.dao.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

import animal.dominio.Animal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AnimalDAO {
	
	public Animal consultarAnimal(String rga) throws SQLException {
		Connection connection = (Connection) Conexao.abrir();
		PreparedStatement statementAnimal = null;
		java.sql.ResultSet resultAnimal = null;
		
		try {
			String queryAnimal = "SELECT a.id, a.nome, a.tipo, a.rga, a.dataNascimento, a.idRaca, a.genero, "
					+ "a.deficiencia, a.vacinado, a.castrado, a.tamanho, a.peso, a.temperamento, "
					+ "a.observacao, a.dataResgate " + "FROM animal as a WHERE rga = ?";
			statementAnimal = (PreparedStatement) connection.prepareStatement(queryAnimal);
			statementAnimal.setString(1, rga);
			resultAnimal = statementAnimal.executeQuery();
			Animal animal = new Animal();
			if (resultAnimal.next()) {
				animal.setId(resultAnimal.getInt("id"));
				animal.setNome(resultAnimal.getString("a.nome"));
				animal.setTipo(resultAnimal.getString("tipo"));
				animal.setRga(resultAnimal.getString("rga"));
				animal.setDataNascimento(resultAnimal.getString("dataNascimento"));
				animal.setGenero(resultAnimal.getString("genero"));
				animal.setDeficiencia(resultAnimal.getString("deficiencia"));
				animal.setVacinado(resultAnimal.getString("vacinado"));
				animal.setCastrado(resultAnimal.getString("castrado"));
				animal.setTamanho(resultAnimal.getDouble("tamanho"));
				animal.setPeso(resultAnimal.getDouble("peso"));
				animal.setTemperamento(resultAnimal.getString("a.temperamento"));
				animal.setObservacao(resultAnimal.getString("observacao"));
				animal.setDataResgate(resultAnimal.getString("dataResgate"));
				
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
	
	// public boolean adicionarAnimal(Animal animal) {
	// try {
	// Connection con = (Connection) Conexao.abrir();
	// inserirAnimal(animal, con);
	// return true;
	// } catch (SQLException e) {
	// throw new Exception("Erro ao adicionar animal no banco de dados", e);
	// } finally {
	// Conexao.fechar(con,statement,resultSet);
	// }
	// }
	
	public int inserirAnimal(Animal animal) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = -1;
		
		String query = "insert into animal (nome, tipo, rga, dataNascimento, genero, deficiencia, vacinado,"
				+ " castrado, tamanho,"
				+ "peso, temperamento, observacao, dataResgate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = (Connection) Conexao.abrir();
			preparedStatement = (PreparedStatement) con.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, animal.getNome());
			preparedStatement.setString(2, animal.getTipo());
			preparedStatement.setString(3, animal.getRga());
			preparedStatement.setString(4, animal.getDataNascimento());
			preparedStatement.setString(5, animal.getGenero());
			preparedStatement.setString(6, animal.getDeficiencia());
			preparedStatement.setString(7, animal.getVacinado());
			preparedStatement.setString(8, animal.getCastrado());
			preparedStatement.setDouble(9, animal.getTamanho());
			preparedStatement.setDouble(10, animal.getPeso());
			preparedStatement.setString(11, animal.getTemperamento());
			preparedStatement.setString(12, animal.getObservacao());
			preparedStatement.setString(13, animal.getDataResgate());
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Erro ao cadastrar o animal", e);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
		return id;
	}
	
}
