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
		pessoasFisicas = dao.retornarPessoaFisica("08244456570");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for (PessoaFisica pessoaFisica : pessoasFisicas) {
		
		System.out.println("Informações da tabela pessoa");
		System.out.println("Id: " + pessoaFisica.getPessoa().getId());
		System.out.println("Nome: " + pessoaFisica.getPessoa().getNome());
		System.out.println("Celular: " + pessoaFisica.getPessoa().getTelefoneCelular());
		System.out.println("Telefone Fixo: " + pessoaFisica.getPessoa().getTelefoneFixo());
		System.out.println("Email: " + pessoaFisica.getPessoa().getEmail()+"\n");
		
		System.out.println("Informacoes da tabela Endereco: ");
		System.out.println("Id: " + pessoaFisica.getPessoa().getEndereco().getId());
		System.out.println("Rua: " + pessoaFisica.getPessoa().getEndereco().getRua());
		System.out.println("Numero: " + pessoaFisica.getPessoa().getEndereco().getNumero());
		System.out.println("Bairro: " + pessoaFisica.getPessoa().getEndereco().getBairro());
		System.out.println("Cep: " + pessoaFisica.getPessoa().getEndereco().getCep());
		System.out.println("Cidade: " + pessoaFisica.getPessoa().getEndereco().getCidade());
		System.out.println("Estado: " + pessoaFisica.getPessoa().getEndereco().getEstado());
		
		System.out.println("Informações da tabela pessoa fisica");
		System.out.println("ID: " + pessoaFisica.getId());
		System.out.println("CPF : " + pessoaFisica.getCpf());
		System.out.println("RG : " + pessoaFisica.getRg());
		System.out.println("Genero : " + pessoaFisica.getGenero());
		
	}
}
	

}
