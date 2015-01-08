package animal.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import adotante.dominio.ImagemAnimal;
import animal.dominio.Animal;

import com.mysql.jdbc.Statement;

public class AnimalDAO {
	
	public boolean adicionarAnimal(Animal animal) throws Exception {
		try {
			int idAnimal = inserirAnimal(animal);
			int idImagem = inserirImagem(animal);
			inserirImagemAnimal(idAnimal, idImagem);
		
			return true;
		}catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public Animal consultarAnimal(String rga) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementAnimal = null;
		ResultSet resultAnimal = null;
		
		try {
			String queryAnimal = "SELECT a.id, a.nome, a.tipo, a.rga, a.dataNascimento, a.idRaca, a.genero, "
					+ "a.deficiencia, a.vacinado, a.castrado, a.tamanho, a.peso, a.temperamento, "
					+ "a.observacao, a.dataResgate, a.status FROM animal as a WHERE a.status <> 0 and rga = ?";
			
			statementAnimal = connection.prepareStatement(queryAnimal);
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
		} catch(Exception e){
			throw new Exception("Animal não pôde ser encontrado.", e);
		}			
		finally {
			Conexao.fechar(connection, statementAnimal, resultAnimal);
		}
	}
	
	public int inserirAnimal(Animal animal) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = -1;
		
		String query = "insert into animal (nome, tipo, rga, dataNascimento,idRaca, genero, deficiencia, vacinado,"
				+ " castrado, tamanho,"
				+ "peso, temperamento, observacao, dataResgate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = (Connection) Conexao.abrir();
			preparedStatement = (PreparedStatement) con.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, animal.getNome());
			preparedStatement.setString(2, animal.getTipo());
			preparedStatement.setString(3, animal.getRga());
			preparedStatement.setString(4, animal.getDataNascimento());
			preparedStatement.setInt(5, animal.getIdRaca());
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

	public int inserirImagem(Animal animal) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		
		try {
			con = Conexao.abrir();
			
			String path = animal.getImagem();
			int status = 1;
			
			String query = "insert into imagem (path, status) values (?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, path);
			preparedStatement.setInt(2, status);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao cadastrar a imagem",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		return id;
		
	}

	public int inserirImagemAnimal(int idAnimal, int idImagem) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		
		try {
			con = Conexao.abrir();
			
			int status = 1;
			
			String query = "insert into imagemanimal (idimagem, idanimal, status) values (?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idImagem);
			preparedStatement.setInt(2, idAnimal);
			preparedStatement.setInt(3, status);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows != 0) {
				generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				}
			}
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao relacionar a imagem ao animal",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
		return id;
		
	}
	
	public void excluirAnimal(Animal animal) throws Exception{
		ImagemAnimal imagemAnimal = consultaImagemAnimal(animal);
		excluindoImagem(imagemAnimal.getIdImagem());
		excluindoImagemAnimal(imagemAnimal.getId());
		excluindoAnimal(animal);
	}
	
	public void excluindoImagemAnimal(int idImagemAnimal) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			String query = "update imagemanimal set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idImagemAnimal);

			
			preparedStatement.executeUpdate();
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao excluir relação imagem animal",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}
	
	public void excluindoImagem(int idImagem) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			String query = "update imagem set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idImagem);

			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao excluir imagem",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}
	
	public void excluindoAnimal(Animal animal) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
			
			int idAnimal = animal.getId();

			
			String query = "update animal set status = 0 where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idAnimal);

			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao excluir animal",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}

	public ImagemAnimal consultaImagemAnimal(Animal animal) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			
			con = Conexao.abrir();
			
			int idAnimal = animal.getId();
			
			String query = "select id, idimagem, idanimal, status from imagemanimal where idanimal = ?";
			
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, idAnimal);
			resultset = preparedStatement.executeQuery();
			
			ImagemAnimal imagemAnimal = new ImagemAnimal();
			
			if (resultset.next()) {
				
				imagemAnimal.setId(resultset.getInt("id"));
				imagemAnimal.setIdImagem(resultset.getInt("idimagem"));
				imagemAnimal.setIdAnimal(resultset.getInt("idanimal"));
				imagemAnimal.setStatus(resultset.getInt("status"));
				
			}
			return imagemAnimal;
		} catch(Exception e){
			throw new Exception("Relação imagem animal não pôde ser encontrada.", e);
		}			
		finally {
			Conexao.fechar(con,preparedStatement,resultset);
		}
	}
}
