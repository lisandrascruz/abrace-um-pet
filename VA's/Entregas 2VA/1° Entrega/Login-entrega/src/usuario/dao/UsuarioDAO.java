package usuario.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import usuario.usuario.Usuario;

import com.mysql.jdbc.Statement;

public class UsuarioDAO {
	private boolean acesso;
	   public boolean consultarUsuario(Usuario usuario){
		  String login = usuario.getLogin();
		  String senha = usuario.getSenha();
		   Connection conn = null;
		   Statement consulta = null;
		   ResultSet tabela = null;
		   
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "");
			   consulta = (Statement) conn.createStatement();
			   tabela=consulta.executeQuery("select login, senha from tbl_usuario where login='"+login+"'and senha='"+senha+"'");
			  
			   if(tabela.next()){	
					acesso = true;
					conn.close();
				}else{
					acesso = false;
					conn.close();
				}
		   }catch(ClassNotFoundException |SQLException e){
		  }
		   return acesso;
	   } 
}
