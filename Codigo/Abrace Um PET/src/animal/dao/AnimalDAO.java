package animal.dao;

import infraestrutura.dao.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import animal.dominio.Animal;
import animal.dominio.Raca;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class AnimalDAO {
	
	
	public List<Animal> retornarAnimal(String rga) throws SQLException {
		Connection connection = (Connection) Conexao.abrirConceccaoMySQL();
		PreparedStatement statementAnimal = null;
		PreparedStatement statementRaca = null;
		java.sql.ResultSet resultAnimal = null;
		ResultSet resultRaca = null;

		try {
			String queryAnimal = "SELECT a.id, a.nome, a.tipo, a.rga, a.dataNascimento, a.idRaca, a.genero,"
					+ "a.deficiencia, a.vacinado, a.castrado, a.tamanho, a.peso, a.temperamento,"
					+ "a.observacao, a.dataResgate FROM animal as a INNER JOIN raca as r ON "
					+ "a.idRaca = r.id WHERE rga = ?";
			statementAnimal = (PreparedStatement) connection.prepareStatement(queryAnimal);
			statementAnimal.setString(1, rga);
			resultAnimal = statementAnimal.executeQuery();

			String queryRaca = "SELECT r.id, r.nome, r.expectativaVida, r.origem, r.tamanhoMax, "
					+ "r.tamanhoMin, r.temperamento FROM raca as r";
			statementRaca = (PreparedStatement) connection.prepareStatement(queryRaca);
			resultRaca = statementRaca.executeQuery();

			List<Animal> listAnimal = new ArrayList<Animal>();

			if (resultRaca.next()) {

				Raca raca = new Raca();
				raca.setId(resultRaca.getInt("id"));
				raca.setExpectativaVida(resultRaca.getInt("expectativaVida"));
				raca.setNome(resultRaca.getString("nome"));
				raca.setOrigem(resultRaca.getString("origem"));
				raca.setTamanhoMax(resultRaca.getDouble("tamanhoMax"));
				raca.setTamanhoMin(resultRaca.getDouble("tamanhoMin"));
				raca.setTemperamento(resultRaca.getString("temperamento"));
				
				if (resultAnimal.next()) {

					Animal animal = new Animal();
					animal.setId(resultAnimal.getInt("id"));
					animal.setNome(resultAnimal.getString("nome"));
					animal.setTipo(resultAnimal.getString("tipo"));
					animal.setRga(resultAnimal.getString("rga"));
					animal.setDataNascimento(resultAnimal.getDate("dataNascimento"));
					animal.setGenero(resultAnimal.getString("genero"));
					animal.setDeficiencia(resultAnimal.getString("deficiencia"));
					animal.setVacinado(resultAnimal.getBoolean("vacinado"));
					animal.setCastrado(resultAnimal.getBoolean("castrado"));
					animal.setTamanho(resultAnimal.getDouble("tamanho"));
					animal.setPeso(resultAnimal.getDouble("peso"));
					animal.setTemperamento(resultAnimal.getString("temperamento"));
					animal.setObservacao(resultAnimal.getString("observacao"));
					animal.setDataResgate(resultAnimal.getDate("dataResgate"));
					
					animal.setRaca(raca);
						
					listAnimal.add(animal);
					}
				}
			
			return listAnimal;
		} finally {
			if (resultAnimal != null) {
				resultAnimal.close();
			}
			if (statementAnimal != null) {
				statementAnimal.close();
			}
		}
		}
		
	public static void main(String[] args) throws SQLException { //excluir main depois
		AnimalDAO and = new AnimalDAO();
		and.retornarAnimal("12345");
		System.out.println(and);
	}
}
