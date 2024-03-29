package adocao.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import usuario.service.SessaoUsuario;
import adocao.dominio.Adocao;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;
import animal.dominio.Animal;

public class AdocaoDAO {
	Conexao			conexao	= new Conexao();
	SessaoUsuario	sessao	= SessaoUsuario.getInstancia();
	
	/**
	 * ADICIONA PESSOA NO BANCO DE DADOS
	 * 
	 * @param adocao
	 * @return
	 * @throws Exception
	 */
	public boolean adicionarAdocao(Adocao adocao) throws Exception {
		inserirAdocao(adocao);
		return true;
	}
	
	/**
	 * EDITAR ADOCAO
	 * @param adocao
	 * @return
	 * @throws Exception
	 */
	
	public void editarAdocao(Adocao adocao) throws Exception{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		
		try {
			con = Conexao.abrir();
		
			String query = "update adocao set dataDevolucao = ? where id = ?";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, adocao.getDataDevolucao());
			preparedStatement.setInt(2, adocao.getId());
	
			
			preparedStatement.executeUpdate();
			
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao excluir animal",ex);
		} finally {
			Conexao.fechar(con,preparedStatement,generatedKeys);
		}
	}
	
	/**
	 * INSERE ADOCAO NO BANCO
	 * 
	 * @param adocao
	 * @param con
	 * @return
	 */
	public int inserirAdocao(Adocao adocao) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int id = 0;
		
		try {
			con = Conexao.abrir();
			
			int idAdotante = adocao.getAdotante().getId();
			int idAnimal = adocao.getAnimal().getId();
			int idUsuario = sessao.getUsuarioLogado().getId();
			String dataAdocao = adocao.getDataAdocao();
			
			String query = "insert into adocao (idAdotante, idAnimal,idUsuario, dataAdocao) values (?, ?, ?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, idAdotante);
			preparedStatement.setInt(2, idAnimal);
			preparedStatement.setInt(3, idUsuario);
			preparedStatement.setString(4, dataAdocao);
			
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
			throw new Exception("Erro ao inserir ado��o.", ex);
		} finally {
			Conexao.fechar(con, preparedStatement, generatedKeys);
		}
		return id;
	}
	
	/**
	 * CONSULTA ADOCAO POR CPF E RGA
	 * @param cpf
	 * @param rga
	 * @return
	 * @throws Exception
	 */
	public Adocao consultarAdocao(String cpf, String rga) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementAdocao = null;
		ResultSet resultAdocao = null;
		
		String queryAdocao = "SELECT a.id, a.idAnimal, a.idAdotante, a.dataAdocao, a.dataDevolucao, "
				+ "b.id, b.nome, tipo, b.rga, b.dataNascimento, b.genero, "
				+ "c.id, c.idPessoa, "
				+ "d.id, d.nome, d.email, "
				+ "e.id, e.cpf, e.idPessoa "
				+ "FROM abrace_um_pet.adocao as a "
				+ "inner join animal as b "
				+ "inner join adotante as c "
				+ "inner join pessoa as d "
				+ "inner join pessoafisica as e "
				+ "where a.idAnimal = b.id and a.idAdotante = c.id and c.idPessoa = d.id and e.idPessoa = d.id "
				+ "and e.cpf = ? and b.rga = ? and e.status <> 0";
		
		statementAdocao = connection.prepareStatement(queryAdocao);
		statementAdocao.setString(1, cpf);
		statementAdocao.setString(2, rga);
		resultAdocao = statementAdocao.executeQuery();
		
		Adocao adocao = new Adocao();
		Animal animal = new Animal();
		Adotante adotante = new Adotante();
		Pessoa pessoa = new Pessoa();
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		if (resultAdocao.next()) {
			
			pessoa.setId(resultAdocao.getInt("d.id"));
			pessoa.setNome(resultAdocao.getString("d.nome"));
			pessoa.setEmail(resultAdocao.getString("d.email"));
			pessoaFisica.setId(resultAdocao.getInt("e.id"));
			pessoaFisica.setCpf(resultAdocao.getString("e.cpf"));
			pessoaFisica.setPessoa(pessoa);
			adotante.setId(resultAdocao.getInt("c.id"));
			adotante.setPessoa(pessoa);
			animal.setId(resultAdocao.getInt("b.id"));
			animal.setNome(resultAdocao.getString("b.nome"));
			animal.setTipo(resultAdocao.getString("b.tipo"));
			animal.setRga(resultAdocao.getString("b.rga"));
			animal.setDataNascimento(resultAdocao.getString("b.dataNascimento"));
			animal.setGenero(resultAdocao.getString("b.genero"));
			adocao.setId(resultAdocao.getInt("a.id"));
			adocao.setDataAdocao(resultAdocao.getString("a.dataAdocao"));
			adocao.setDataDevolucao(resultAdocao.getString("a.dataDevolucao"));
			adocao.setAnimal(animal);
			adocao.setAdotante(adotante);
			
		}
		if (resultAdocao != null) {
			resultAdocao.close();
		}
		if (statementAdocao != null) {
			statementAdocao.close();
		}
		return adocao;
		
	}
	
	/**
	 * CONSULTA ADOCAO JURIDICA POR CNPJ E RGA
	 * @param cnpj
	 * @param rga
	 * @return
	 * @throws Exception
	 */
	public Adocao consultarAdocaoJuridica(String cnpj, String rga) throws Exception {
		Connection connection = Conexao.abrir();
		PreparedStatement statementAdocao = null;
		ResultSet resultAdocao = null;
		
			String queryAdocao = "SELECT a.id, a.idAnimal, a.idAdotante, a.dataAdocao, a.dataDevolucao, "
					+ "b.id, b.nome, tipo, b.rga, b.dataNascimento, b.genero, "
					+ "c.id, c.idPessoa, "
					+ "d.id, d.nome, d.email, "
					+ "e.id, e.cnpj, e.idPessoa "
					+ "FROM abrace_um_pet.adocao as a "
					+ "inner join animal as b "
					+ "inner join adotante as c "
					+ "inner join pessoa as d "
					+ "inner join pessoajuridica as e "
					+ "where a.idAnimal = b.id and a.idAdotante = c.id and c.idPessoa = d.id and e.idPessoa = d.id  "
					+ "and e.cnpj = ? and b.rga = ? ";
			
			statementAdocao = connection.prepareStatement(queryAdocao);
			statementAdocao.setString(1, cnpj);
			statementAdocao.setString(2, rga);
			resultAdocao = statementAdocao.executeQuery();
			
			Adocao adocao = new Adocao();
			Animal animal = new Animal();
			Adotante adotante = new Adotante();
			Pessoa pessoa = new Pessoa();
			PessoaJuridica pessoaJuridica = new PessoaJuridica();
			
			if (resultAdocao.next()) {
				
				pessoa.setId(resultAdocao.getInt("d.id"));
				pessoa.setNome(resultAdocao.getString("d.nome"));
				pessoa.setEmail(resultAdocao.getString("d.email"));
				pessoaJuridica.setId(resultAdocao.getInt("e.id"));
				pessoaJuridica.setCnpj(resultAdocao.getString("e.cnpj"));
				pessoaJuridica.setPessoa(pessoa);
				adotante.setId(resultAdocao.getInt("c.id"));
				adotante.setPessoa(pessoa);
				animal.setId(resultAdocao.getInt("b.id"));
				animal.setNome(resultAdocao.getString("b.nome"));
				animal.setTipo(resultAdocao.getString("b.tipo"));
				animal.setRga(resultAdocao.getString("b.rga"));
				animal.setDataNascimento(resultAdocao.getString("b.dataNascimento"));
				animal.setGenero(resultAdocao.getString("b.genero"));
				adocao.setId(resultAdocao.getInt("a.id"));
				adocao.setDataAdocao(resultAdocao.getString("a.dataAdocao"));
				adocao.setDataDevolucao(resultAdocao.getString("a.dataDevolucao"));
				adocao.setAnimal(animal);
				adocao.setAdotante(adotante);
				
			}
			
			if (resultAdocao != null) {
				resultAdocao.close();
			}
			if (statementAdocao != null) {
				statementAdocao.close();
			}
			return adocao;
	}
}
