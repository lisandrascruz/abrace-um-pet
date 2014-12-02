package infraestrutura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import adotante.dominio.PessoaFisica;

public class Conexao {
	private static Connection conexao = null;
	private static Statement statement;
	private static ResultSet resultSet = null;
	private static String stringSQL = null;

	public static ResultSet getResultSet() {
		return resultSet;
	}
	
	

	/*public static PreparedStatement ConnectionStatement(String sql) {
		PreparedStatement preparedStatement = (PreparedStatement) conexao.prepareStatement(sql);
		return preparedStatement;
	}*/



	public static void setResultSet(ResultSet resultSet) {
		Conexao.resultSet = resultSet;
	}

	/**
	 * ABRE CONEXÃO COM COM BANCO
	 */
	public static Connection abrirConceccaoMySQL() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
		}  catch (ClassNotFoundException e) {    
            throw new SQLException(e.getMessage());  
		}
	}

	/**
	 * FECHA CONEXÃO COM COM BANCO
	 */
	public static void fecharConecaoMySQL() {
		try {
			conexao.close();
		} catch (Exception erro) {
			System.out.println("MYSQL Erro(fechar): " + erro);
		}
	}

	/**
	 * RESULTADO DA CONSULTA NO BANCO
	 */
	public static ResultSet queryMySQL(String qry) {
		try {
			statement = conexao.createStatement();
			stringSQL = qry;
			setResultSet(statement.executeQuery(stringSQL));
			getResultSet().first();
			return getResultSet();
		} catch (Exception erro) {
			System.out.println("MYSQL Erro: " + erro);
			return null;
		}
	}

	/**
	 * EXECUTAR COMANDOS
	 */
	public static long comandoMySQL(String comando) {
		long x = -1;
		try {
			statement = conexao.createStatement();
			statement.execute(comando);
		} catch (Exception erro) {
			System.out.println("MYSQL Erro: " + erro);
		}
		return x;
	}
	/**
	 * GERAL PARA CONSULTA
	 * 
	 * @param query
	 * @return
	 */
	public boolean consultar(String query) {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean usuario = false;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				usuario = true;
			} else {
				usuario = false;
			}
			Conexao.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	

}
