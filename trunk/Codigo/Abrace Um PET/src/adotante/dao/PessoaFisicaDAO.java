package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import adotante.dominio.PessoaFisica;


public class PessoaFisicaDAO {
	/**
	 * ADICIONAR USUARIO NO BANCO DE DADOS
	 * @param usuario
	 * @return
	 */
	public boolean adicionarPessoFisica(PessoaFisica pessoaFisica) {
		Conexao.abrirConceccaoMySQL();

		String query = "INSERT INTO endereco (estado, cidade, bairro, rua, numero, cep, complemento) VALUES ('"
				+ pessoaFisica.getAdotante().getEndereco().getEstado()
				+ "', '"
				+ pessoaFisica.getAdotante().getEndereco().getCidade()
				+ "', '"
				+ pessoaFisica.getAdotante().getEndereco().getBairro()
				+ "', '"
				+ pessoaFisica.getAdotante().getEndereco().getRua()
				+ "', '" 
				+ pessoaFisica.getAdotante().getEndereco().getNumero() 
				+ "', '"
				+ pessoaFisica.getAdotante().getEndereco().getCep()
				+ "', '"
				+ pessoaFisica.getAdotante().getEndereco().getComplemento()+ "')";
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}

	/**
	 * DELETAR USUARIO NO BANCO DE DADOS
	 * 
	 * @param usuario
	 * @return
	 */
	/*public boolean excluirUsuario(Usuario usuario) {
		Conexao.abrirConceccaoMySQL();


		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		String email = usuario.getEmail();


		String query = "DELETE INTO tbl_usuario (login, senha, email) VALUES ('"
				+ login + "','" + senha + "','" + email + "')";
		System.out.println(query);
		Conexao.comandoMySQL(query);
		Conexao.fecharConecaoMySQL();
		return true;
	}*/

	/**
	 * CONSULTA O USUARIO NO BANCO DE DADOS, USADO NO LOGIN
	 * 
	 * @param login
	 * @param senha
	 * @return
	 */
	public boolean consultarUsuario(String login, String senha) {
		boolean acesso = false;

		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement
					.executeQuery("select login, senha from tbl_usuario where login='"
							+ login + "'and senha='" + senha + "'");
			if (resultSet.next()) {
				acesso = true;
			} else {
				acesso = false;
			}
			Conexao.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acesso;
	}

}
