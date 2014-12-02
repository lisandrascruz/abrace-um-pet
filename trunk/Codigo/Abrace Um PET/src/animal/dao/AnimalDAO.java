package animal.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import animal.dominio.Animal;


public class AnimalDAO {
	
	public Animal retornarAniaml(int rga, Connection connection) throws SQLException //Nunca lance "Exception"  
	{  
	   PreparedStatement statement = null;  
	   ResultSet result = null;  
	  
	   try {  
	      statement = connection.prepareStatement("SELECT * FROM Animal WHERE rga = ?");  
	      statement.setString(1, rga);//Aqui definimos o valor e o tipo dele  
	      resul = statement.executeQuery();  
	     
	      if (result.next())  
	      {  
	         Animal animal = new Animal();  
	         animal.setCastrado(result.getBoolean("castrado"));
	         animal.setDataNascimento(result.getDate("dataNascimento"));
	         animal.setDataResgate(dataResgate);
	         animal.setDeficiencia(result.getString("deficiencia"));
	         animal.setGenero(result.getCharacterStream("genero"));
	         animal.setNome(result.getString("nome"));
	         animal.setObservacao(result.getString("observacao"));
	         
	         return animal;  
	         System.out.println(animal); //excluir dps
	      }  
	   } finally {        
	      if (result != null) result.close();  
	      if (statement != null) statement.close();  
	   }  
	  
	   return null;  
	}  
}
