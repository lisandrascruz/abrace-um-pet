package launcher;

import java.sql.SQLException;
import java.util.List;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;


public class e {

	public static void main(String[] args) {
		listarPessoasFisicas();
	}
	
	public static void listarPessoasFisicas() {
	PessoaFisicaDAO dao = new PessoaFisicaDAO();
	List<PessoaFisica> pessoasFisicas = null;
	try {
		pessoasFisicas = dao.retornarPessoaFisica("09791366441");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for (PessoaFisica pessoaFisica : pessoasFisicas) {
		System.out.println("ID Pessoa Fisica: " + pessoaFisica.getId());
		System.out.println("CPF : " + pessoaFisica.getCpf());
		System.out.println("RG : " + pessoaFisica.getRg());
		System.out.println("Genero : " + pessoaFisica.getGenero());
		//System.out.println("Pessoa : " + pessoaFisica.getPessoa()+"\n\n");

	}
}
	

}
