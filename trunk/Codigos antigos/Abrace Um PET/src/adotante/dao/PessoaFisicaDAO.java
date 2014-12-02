package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import adotante.dominio.PessoaFisica;

import com.mysql.jdbc.PreparedStatement;

public class PessoaFisicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	Conexao	conexao	= new Conexao();

	public boolean adicionarPessoaFisica(PessoaFisica pessoaFisica) {
		try {
			int id;
			Connection con = Conexao.abrirConceccaoMySQL();

			String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getPessoa().getEndereco().getEstado());
			preparedStatement.setString(2, pessoaFisica.getPessoa().getEndereco().getCidade());
			preparedStatement.setString(3, pessoaFisica.getPessoa().getEndereco().getBairro());
			preparedStatement.setString(4, pessoaFisica.getPessoa().getEndereco().getRua());
			preparedStatement.setString(5, pessoaFisica.getPessoa().getEndereco().getNumero());
			preparedStatement.setString(6, pessoaFisica.getPessoa().getEndereco().getCep());
			preparedStatement.setString(7, pessoaFisica.getPessoa().getEndereco().getComplemento());

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

			query = "insert into pessoa (nome, idEndereco, telefoneFixo, telefoneCelular, email) values (?, ?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getPessoa().getNome());
			preparedStatement.setInt(2, id);
			preparedStatement.setString(3, pessoaFisica.getPessoa().getTelefoneFixo());
			preparedStatement.setString(4, pessoaFisica.getPessoa().getTelefoneCelular());
			preparedStatement.setString(5, pessoaFisica.getPessoa().getEmail());

			affectedRows = preparedStatement.executeUpdate();

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

			query = "insert into pessoafisica (rg, cpf, genero, idPessoa) values (?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaFisica.getRg());
			preparedStatement.setString(2, pessoaFisica.getCpf());
			preparedStatement.setString(3, pessoaFisica.getGenero());
			preparedStatement.setInt(4, id);

			affectedRows = preparedStatement.executeUpdate();

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

			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * 
	 * @param login
	 * @param senha
	 * @return
	 */
	public boolean consultarUsuario(String login, String senha) {

		String resultSet = (("select login, senha from usuario where login='" + login + "'and senha='" + senha + "'"));
		return conexao.consultar(resultSet);
	}

	/**
	 * CONSULTA SE A PESSOA FISICA EXISTE NO BANCO ATRAVES DO CPF
	 * 
	 * @param cpf
	 * @return
	 */
	public boolean consultarPessoaFisica(String cpf) {
		String resultSet = ("select cpf from pessoafisica where cpf='" + cpf + "'");
		return conexao.consultar(resultSet);
	}
	/**
	 * RETORNA UMA LISTA DE PESSOAS FISICAS DO BANCO DE DADOS
	 * @return
	 */
	public List<PessoaFisica> getListaPessoaFisica() {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery("select * from pessoafisica");
			List<PessoaFisica> listPessoaFisica = new ArrayList<PessoaFisica>();

			while (resultSet.next()) {
				PessoaFisica pessoaFisica = new PessoaFisica();
				
				pessoaFisica.setId(resultSet.getInt("id"));
				pessoaFisica.setCpf(resultSet.getString("cpf"));
				pessoaFisica.setRg(resultSet.getString("rg"));
				pessoaFisica.setGenero(resultSet.getString("genero"));
				//pessoaFisica.setPessoa();

				listPessoaFisica.add(pessoaFisica);
			}
			Conexao.fecharConecaoMySQL();
			return listPessoaFisica;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
