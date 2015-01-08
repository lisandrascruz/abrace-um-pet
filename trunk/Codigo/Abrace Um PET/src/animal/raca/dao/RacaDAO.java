package animal.raca.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import animal.raca.dominio.Raca;

public class RacaDAO {
	Conexao	conexao	= new Conexao();
	
	/**
	 * RETORNA OS OBJETOS DE RAÇAS EXISTENTES NO BANCO DE DADOS
	 * 
	 * @return
	 * @throws Exception
	 */
	public List < Raca> getRaca() throws Exception {
		
		Connection conn = (Connection) Conexao.abrir();
		PreparedStatement statement = conn.prepareStatement("select * from raca");
		ResultSet resultSet = statement.executeQuery();
		
		List < Raca> racas = new ArrayList < Raca>();
		while (resultSet.next()) {
			
			Raca raca = new Raca();
			raca.setId(resultSet.getInt("id"));
			raca.setNome(resultSet.getString("nome"));
			raca.setOrigem(resultSet.getString("origem"));
			raca.setTamanhoMax(resultSet.getInt("tamanhoMax"));
			raca.setTamanhoMin(resultSet.getInt("tamanhoMin"));
			raca.setExpectativaVida(resultSet.getInt("expectativaVida"));
			raca.setTemperamento(resultSet.getString("temperamento"));
			raca.setTipo(resultSet.getString("tipo"));
			
			racas.add(raca);
		}
		return racas;
	}
	
	/**
	 * INSERIR CADASTRO DE RAÇA NO BANCO DE DADOS
	 * 
	 * @param raca
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public int inserirRaca(Raca raca) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		String query = "INSERT INTO raca(nome, origem, tamanhoMax, tamanhoMin, expectativaVida, temperamento,tipo) values (?, ?, ?, ?, ?, ?,?)";
		
		try {
			con = (Connection) Conexao.abrir();
			preparedStatement = (PreparedStatement) con.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, raca.getNome());
			preparedStatement.setString(2, raca.getOrigem());
			preparedStatement.setDouble(3, raca.getTamanhoMax());
			preparedStatement.setDouble(4, raca.getTamanhoMin());
			preparedStatement.setInt(5, raca.getExpectativaVida());
			preparedStatement.setString(6, raca.getTemperamento());
			preparedStatement.setString(7, raca.getTipo());
			
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
			throw new Exception("Erro ao cadastrar a raça", ex);
		}
		return id;
	}
	
	/**
	 * ADICIONAR A TABELA BANCO DE DADOS
	 * 
	 * @author Lisandra Cruz
	 * @param raca
	 * @return
	 * @throws Exception
	 */
	public boolean adicionarRaca(Raca raca) throws Exception {
		PreparedStatement preparedStatement = null;
		boolean valido = false;
		ResultSet generatedKeys = null;
		Connection con = null;
		RacaDAO racaDAO = new RacaDAO();
		try {
			con = (Connection) Conexao.abrir();
			racaDAO.inserirRaca(raca);
			valido = true;
			return valido;
		} catch (Exception ex) {
			throw new Exception("Erro ao cadastrar a raça", ex);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
	}
	
	/**
	 * CONSULTA SE RACA EXISTE E RETORNA TRUE OU FALSE
	 * 
	 * @param nome
	 * @return
	 */
	public boolean booleanConsultarRaca(String nome) throws Exception {
		String query = ("SELECT nome FROM raca where nome='" + nome + "'");
		return (Conexao.consultar(query));
	}
	
	/**
	 * CONSULTA RACA
	 * 
	 * @param nome
	 * @return
	 * @throws Exception
	 */
	public Raca consultarRaca(String nome) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementAnimal = null;
		ResultSet resultAnimal = null;
		
		try {
			String queryRaca = "SELECT a.nome, a.origem, a.tamanhoMax, a.tamanhoMin, "
					+ "a.expectativaVida, a.temperamento, a.tipo FROM raca as a WHERE a.nome = ?";
			
			statementAnimal = connection.prepareStatement(queryRaca);
			statementAnimal.setString(1, nome);
			resultAnimal = statementAnimal.executeQuery();
			
			Raca raca = new Raca();
			
			if (resultAnimal.next()) {
				raca.setId(resultAnimal.getInt("id"));
				raca.setNome(resultAnimal.getString("nome"));
				raca.setOrigem(resultAnimal.getString("origem"));
				raca.setTamanhoMax(resultAnimal.getDouble("tamanhoMax"));
				raca.setTamanhoMin(resultAnimal.getDouble("tamanhoMin"));
				raca.setTipo(resultAnimal.getString("tipo"));
				raca.setExpectativaVida(resultAnimal.getInt("expectativaVida"));
			}
			return raca;
		} catch (Exception e) {
			throw new Exception("Raça não pôde ser consultada.", e);
		} finally {
			Conexao.fechar(connection, statementAnimal, resultAnimal);
		}
		
	}
	
	/**
	 * METODO RESPONSAVEL PELA ATUALIZAÇÃO DOS DADOS DE RAÇA
	 * 
	 * @param raca
	 * @throws Exception
	 */
	public void editarRaca(Raca raca) throws Exception {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		con = Conexao.abrir();
		
		String queryAnimal = "UPDATE raca SET nome =?, tipo =?, origem =?, tamanhoMax=?, tamanhoMin=?, "
				+ "expectativaVida=?, temperamento=? WHERE id=?";
		try {
			
			pst = (PreparedStatement) con.prepareStatement(queryAnimal,
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, raca.getNome());
			pst.setString(2, raca.getTipo());
			pst.setString(3, raca.getOrigem());
			pst.setDouble(4, raca.getTamanhoMax());
			pst.setDouble(5, raca.getTamanhoMin());
			pst.setInt(6, raca.getExpectativaVida());
			pst.setString(7, raca.getTemperamento());
			pst.executeUpdate();
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao atualizar raça", ex);
		} finally {
			Conexao.fechar(con, pst, generatedKeys);
		}
		
	}
}
