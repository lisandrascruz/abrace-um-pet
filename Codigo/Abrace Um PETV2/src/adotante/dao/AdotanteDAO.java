package adotante.dao;

import infraestrutura.dao.Conexao;
import adotante.dominio.Adotante;

public class AdotanteDAO {
	/**
	 * inserir no bd
	 * @param adotante
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
    
	public void apagarAdotante (Adotante adotante){	
    	Conexao.abrirConceccaoMySQL();
    	String nome = adotante.getNome();
    	String cpf = adotante.getCpf();
    	String query = "DELETE INTO tbl_adotante VALUES('" + nome + "','" + cpf + "')";
    	Conexao.comandoMySQL(query);
    	Conexao.fecharConecaoMySQL();
    }

}
