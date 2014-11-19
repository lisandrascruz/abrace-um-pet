package adotante.dao;

import dao.Conexao;
import adotante.adotante.Adotante;

public class AdotanteDAO {
	
    /**
     * erro no auto increment.. 
     */
	public void adicionarAdotante (Adotante adotante){	
    	Conexao.abrirConceccaoMySQL();
    	String nome = adotante.getNome();
    	String cpf = adotante.getCpf();
    	String query = "INSERT INTO tbl_adotante VALUES('" + nome + "','" + cpf + "')";
    	Conexao.comandoMySQL(query);
    	Conexao.fecharConecaoMySQL();
    }
    /**
     * Consultar no bd 
     */
	public void consultarAdorante(Adotante adotante){
		Conexao.abrirConceccaoMySQL();
		
	}
    

}
