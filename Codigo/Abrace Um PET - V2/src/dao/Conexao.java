package dao;

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
     * Faz conexão com o BD 
     */
    public static void abrirConceccaoMySQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
            System.out.println("MySQL conectado");
        } catch(Exception erro){
            System.out.println("MYSQL Erro(abrir): " + erro);
        }
    }

    /**
     * fecha conexão com o BD 
     */
    public static void fecharConecaoMySQL(){
        try{
            conexao.close();
            System.out.println("MYSQL Desconectado.");
        } catch(Exception erro){
        	System.out.println("MYSQL Erro(fechar): " + erro);
        }
    }
    
    /**
     * Resultado da consulta no BD
     */
    public static ResultSet queryMySQL(String qry){
        try{
            statement = conexao.createStatement();
            stringSQL = qry;
            setResultSet(statement.executeQuery(stringSQL));
            getResultSet().first();
            return getResultSet();
        } catch(Exception erro){
        	System.out.println("MYSQL Erro: " + erro);
            return null;
        }
    }
    /**
     * consulta no o BD 
     */
    public static void comandoMySQL(String comando){
        try{
            statement = conexao.createStatement();
            statement.execute(comando);
        } catch(Exception erro){
        	System.out.println("MYSQL Erro: " + erro);
        }
    }

}

