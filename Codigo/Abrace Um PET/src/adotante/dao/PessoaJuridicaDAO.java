package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import adotante.dominio.PessoaJuridica;

import com.mysql.jdbc.PreparedStatement;

public class PessoaJuridicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * @param usuario
	 * @return
	 */
	Conexao conexao = new Conexao();
	public boolean adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		try {
			int id;
			Connection con = Conexao.abrirConceccaoMySQL();

			String query = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getPessoa().getEndereco().getEstado());
			preparedStatement.setString(2, pessoaJuridica.getPessoa().getEndereco().getCidade());
			preparedStatement.setString(3, pessoaJuridica.getPessoa().getEndereco().getBairro());
			preparedStatement.setString(4, pessoaJuridica.getPessoa().getEndereco().getRua());
			preparedStatement.setString(5, pessoaJuridica.getPessoa().getEndereco().getNumero());
			preparedStatement.setString(6, pessoaJuridica.getPessoa().getEndereco().getCep());
			preparedStatement.setString(7, pessoaJuridica.getPessoa().getEndereco().getComplemento());
			
			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			
			preparedStatement.close();

			query = "insert into pessoa (nome, idEndereco, telefoneFixo, telefoneCelular, email) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, pessoaJuridica.getPessoa().getNome());
			preparedStatement.setInt   (2, id);
			preparedStatement.setString(3, pessoaJuridica.getPessoa().getTelefoneFixo());
			preparedStatement.setString(4, pessoaJuridica.getPessoa().getTelefoneCelular());
			preparedStatement.setString(5, pessoaJuridica.getPessoa().getEmail());

			affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();


			query = "insert into pessoajuridica (cnpj, idPessoa) values (?, ?)";
			
			preparedStatement = (PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1, pessoaJuridica.getCnpj());
			preparedStatement.setInt   (2, id);
			//preparedStatement.setInt   (3, id);
			
			affectedRows = preparedStatement.executeUpdate(); 
			
			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();

			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean consultarPessoaFisica(String cnpj) {
		String resultSet = ("select cpf from pessoajuridica where cnpj='" + cnpj + "'");
		return (conexao.consultar(resultSet));
	}
	/**
	 * RETORNA UMA LISTA DE PESSOAS JURIDICAS DO BANCO DE DADOS
	 * @return
	 */
	public List<PessoaJuridica> getListaPessoaJuridica() {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery("select * from pessoajuridica");
			List<PessoaJuridica> listPessoaJuridica = new ArrayList<PessoaJuridica>();

			while (resultSet.next()) {
				PessoaJuridica pessoaJuridica = new PessoaJuridica();
				
				pessoaJuridica.setId(resultSet.getInt("id"));
				pessoaJuridica.setCnpj(resultSet.getString("cnpj"));
				//pessoaJuridica.setPessoa();
				//pessoaJuridica.setResponsavel();
				//pessoaJuridica.setEndereco();

				listPessoaJuridica.add(pessoaJuridica);
			}
			Conexao.fecharConecaoMySQL();
			return listPessoaJuridica;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	
	
}
