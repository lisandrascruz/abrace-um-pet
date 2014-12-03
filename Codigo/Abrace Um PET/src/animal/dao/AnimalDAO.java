package animal.dao;

import infraestrutura.dao.Conexao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import animal.dominio.Animal;
import animal.dominio.Raca;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;


public class AnimalDAO {
	
	public List<Animal> retornarAnimal(String rga) throws SQLException {
		Connection connection = (Connection) Conexao.abrirConceccaoMySQL();
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			statement = (PreparedStatement) connection
					.prepareStatement("SELECT * FROM animal as a INNER JOIN raca as r ON a.idRaca = r.id WHERE rga = ?");
			statement.setString(1, rga);
			result = (ResultSet) statement.executeQuery();
			List<Animal> listAnimal = new ArrayList<Animal>();
			
			if (result.next()) {
				
				Animal animal = new Animal();
				Raca raca = new Raca();
				//animal.getId(result.getInt("id"));
				animal.setNome(result.getString("nome"));
				animal.setTipo(result.getString("tipo"));
				animal.setRga(result.getString("rga"));
				animal.setDataNascimento(result.getDate("dataNascimento"));
				animal.setGenero(result.getString("genero"));
				animal.setDeficiencia(result.getString("deficiencia"));
				animal.setVacinado(result.getBoolean("vacinado"));
				animal.setCastrado(result.getBoolean("castrado"));
				animal.setTamanho(result.getDouble("tamanho"));
				animal.setPeso(result.getDouble("peso"));
				animal.setTemperamento(result.getString("temperamento"));
				animal.setObservacao(result.getString("observacao"));
				animal.setDataResgate(result.getDate("dataResgate"));
				
				raca.setNome(result.getString("nome"));
				raca.setTamanhoMax(result.getDouble("tamanhoMax"));
				raca.setTamanhoMin(result.getDouble("tamanhoMin"));
				raca.setExpectativaVida(result.getInt("expectativaVida"));
				raca.setTemperamento(result.getString("temperamento"));
				
				animal.setRaca(raca);
				
				//FFAZER OS GETSSSSSS
				listAnimal.add(animal);
			}
			return listAnimal;
		} finally {
			if (result != null){
				result.close();}
			if (statement != null){
				statement.close();}
		}

	}
	
	public static void main(String[] args) throws SQLException { //excluir main depois
		AnimalDAO and = new AnimalDAO();
		and.retornarAnimal("12345");
		System.out.println(and);
	}
}
