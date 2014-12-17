package adocao.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import usuario.service.SessaoUsuario;
import adocao.dominio.Adocao;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;
import animal.dominio.Animal;

import java.sql.PreparedStatement;

public class AdocaoDAO {
	Conexao			conexao	= new Conexao();
	SessaoUsuario	sessao	= SessaoUsuario.getInstancia();
	
	/**
	 * ADICIONA PESSOA NO BANCO DE DADOS
	 * 
	 * @param adocao
	 * @return
	 */
	public boolean adicionarAdocao(Adocao adocao) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			inserirAdocao(adocao, con);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean editarAdocao(Adocao adocao){
		String query = "update adocao set dataDevolucao = ? where id = ?";
		try{
			Connection con = Conexao.abrirConceccaoMySQL();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, adocao.getDataDevolucao());
			preparedStatement.setInt(2, adocao.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * INSERE ADOCAO NO BANCO
	 * 
	 * @param adocao
	 * @param con
	 * @return
	 */
	public int inserirAdocao(Adocao adocao, Connection con) {
		int id;
		String query = "insert into adocao (idAdotante, idAnimal,idUsuario, dataAdocao) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setInt(1, adocao.getAdotante().getId());
			preparedStatement.setInt(2, adocao.getAnimal().getId());
			preparedStatement.setInt(3, sessao.getUsuarioLogado().getId());
			preparedStatement.setString(4, adocao.getDataAdocao());
			
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
			return -1;
		}
		return id;
	}
	
	public Adocao consultarAdocao(String cpf, String rga) throws SQLException {
		Connection connection = Conexao.abrirConceccaoMySQL();
		PreparedStatement statementAdocao = null;
		ResultSet resultAdocao = null;
		
		try {
			String queryAdocao = "SELECT a.id, a.idAnimal, a.idAdotante, a.dataAdocao, a.dataDevolucao, "
					+ "b.id, b.nome, tipo, b.rga, b.dataNascimento, b.genero, " + "c.id, c.idPessoa, " + "d.id, d.nome, d.email, " + "e.id, e.cpf, e.idPessoa "
					+ "FROM abrace_um_pet.adocao as a " + "inner join animal as b " + "inner join adotante as c " + "inner join pessoa as d "
					+ "inner join pessoafisica as e " + "where a.idAnimal = b.id and a.idAdotante = c.id and c.idPessoa = d.id and e.idPessoa = d.id "
					+ "and e.cpf = ? and b.rga = ? ";
			
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
			
			return adocao;
		} finally {
			if (resultAdocao != null) {
				resultAdocao.close();
			}
			if (statementAdocao != null) {
				statementAdocao.close();
			}
		}
	}
	
	public Adocao consultarAdocaoJuridica(String cnpj, String rga) throws SQLException {
		Connection connection = Conexao.abrirConceccaoMySQL();
		PreparedStatement statementAdocao = null;
		ResultSet resultAdocao = null;
		
		try {
			String queryAdocao = "SELECT a.id, a.idAnimal, a.idAdotante, a.dataAdocao, a.dataDevolucao, "
					+ "b.id, b.nome, tipo, b.rga, b.dataNascimento, b.genero, " + "c.id, c.idPessoa, " + "d.id, d.nome, d.email, " + "e.id, e.cnpj, e.idPessoa "
					+ "FROM abrace_um_pet.adocao as a " + "inner join animal as b " + "inner join adotante as c " + "inner join pessoa as d "
					+ "inner join pessoajuridica as e " + "where a.idAnimal = b.id and a.idAdotante = c.id and c.idPessoa = d.id and e.idPessoa = d.id  "
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
			
			return adocao;
		} finally {
			if (resultAdocao != null) {
				resultAdocao.close();
			}
			if (statementAdocao != null) {
				statementAdocao.close();
			}
		}
	}
}
