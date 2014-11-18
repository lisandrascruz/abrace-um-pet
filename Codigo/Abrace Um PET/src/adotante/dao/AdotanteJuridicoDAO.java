package adotante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import adotante.adotante.PessoaJuridica;

public class AdotanteJuridicoDAO {
	
    public void inserir(Connection conn, PessoaJuridica pessoaJuridica) {
 
        String sqlInsert = "INSERT INTO pessoajuridica(cnpj, idResponsavel, idAdotante) VALUES (?,?,?)";
 
        PreparedStatement stm = null;
        try {
 
            stm = conn.prepareStatement(sqlInsert);
            
            stm.setString(1, pessoaJuridica.getCnpj());
            stm.setInt(2, pessoaJuridica.getResponsavel().getId());
            stm.setInt(3, pessoaJuridica.getAdotante().getId());
            
            stm.execute();
 
        } catch (Exception e) {
            e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
    }	
}
