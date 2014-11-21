package infraestrutura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	private static Connection conexao = null;
	private static Statement statement;
	private static ResultSet resultSet = null;
	private static String stringSQL = null;

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static void setResultSet(ResultSet resultSet) {
		Conexao.resultSet = resultSet;
	}

	/**
	 * ABRE CONEX�O COM COM BANCO
	 */
	public static void abrirConceccaoMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/abrace_um_pet", "root", "");
		} catch (Exception erro) {
			System.out.println("MYSQL Erro(abrir): " + erro);
		}
	}

	/**
	 * FECHA CONEX�O COM COM BANCO
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
	
	

}
