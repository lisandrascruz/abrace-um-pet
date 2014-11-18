package adotante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import adotante.adotante.PessoaJuridica;

public class AdotanteJuridicoDAO {
	
//  Inclusao de Pessoas
    public void incluir(Connection conn, PessoaJuridica pessoaJuridica) {
 
        String sqlInsert = "INSERT INTO pessoajuridica(cnpj, idResponsavel, idAdotante) VALUES (?,?,?)";
 
        PreparedStatement stm = null;
        try {
 
            stm = conn.prepareStatement(sqlInsert);
            
            stm.setString(1, pessoaJuridica.getCnpj());
            stm.setInt(2, pessoaJuridica.getResponsavel().getId());
            stm.setInt(3, pessoaJuridica.getAdotante().getId());
            
            stm.execute();
 
        } catch (Exception e) {
            //Caso tenha uma exceção printa na tela
            e.printStackTrace();
                try {
                    //Aqui ele 'tenta' retroceder, na ação que deu errado.
                    // quase um Ctrl+Z da vida.
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
        } finally {
            // Comando finally sempre é executado
            if (stm != null) {
                try {
                    // Encerra as operações.
                    stm.close();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
    }	
}
