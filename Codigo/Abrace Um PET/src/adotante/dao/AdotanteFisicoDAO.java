package adotante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import adotante.adotante.PessoaFisica;

public class AdotanteFisicoDAO {

//  Inclusao de Pessoas
    public void incluir(Connection conn, PessoaFisica pessoaFisica) {
 
        String sqlInsert = "INSERT INTO pessoafisica(rg, cpf, genero, idAdotante) VALUES (?,?,?,?)";
 
        PreparedStatement stm = null;
        try {
 
            stm = conn.prepareStatement(sqlInsert);
            
            stm.setString(1, pessoaFisica.getRg());
            stm.setString(2, pessoaFisica.getCpf());
            stm.setLong(3, pessoaFisica.getGenero());
            stm.setInt(4, pessoaFisica.getAdotante().getId());
            
            stm.execute();
 
        } catch (Exception e) {
            //Caso tenha uma exce��o printa na tela
            e.printStackTrace();
                try {
                    //Aqui ele 'tenta' retroceder, na a��o que deu errado.
                    // quase um Ctrl+Z da vida.
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
        } finally {
            // Comando finally sempre � executado
            if (stm != null) {
                try {
                    // Encerra as opera��es.
                    stm.close();
                } catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
    }
}
