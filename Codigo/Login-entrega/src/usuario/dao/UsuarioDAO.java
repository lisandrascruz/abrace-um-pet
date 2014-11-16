package usuario.dao;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import usuario.negocio.UsuarioService;
import usuario.usuario.Usuario;

import com.mysql.jdbc.Statement;

public class UsuarioDAO {
	private boolean acesso;

	public boolean consultarUsuario(Usuario usuario) {
		String login = usuario.getLogin();
		String senha = md5(usuario.getSenha());
		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/login",
					"root", "");
			consulta = (Statement) conn.createStatement();
			tabela = consulta
					.executeQuery("select login, senha from tbl_usuario where login='"
							+ login + "'and senha='" + senha + "'");

			if (tabela.next()) {
				acesso = true;

			} else {
				acesso = false;

			}
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		} finally {
			conn.close();
		}
		return acesso;
	}

	   public static String md5(String input) {
	         
	        String md5 = null;
	         
	        if(null == input) return null;
	         
	        try {
	             
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	         
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	 
	        //Converts message digest value in base 16 (hex) 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
	 
	        } catch (NoSuchAlgorithmException e) {
	 
	            e.printStackTrace();
	        }
	        return md5;
	    }
}
