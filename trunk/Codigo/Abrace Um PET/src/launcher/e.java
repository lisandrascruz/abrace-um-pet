package launcher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;
import adotante.service.PessoaFisicaService;

public class e {

	public static void main(String[] args) {
		//listarPessoasFisicas();
		listarPessoasJuridicas();
	}

	public static void listarPessoasFisicas() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> listPessoasFisicas = null;
		try {
			listPessoasFisicas = dao.retornarPessoaFisica("08244456570");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (PessoaFisica pessoaFisica : listPessoasFisicas) {

			System.out.println("Informações da tabela pessoa");
			System.out.println("Id: " + pessoaFisica.getPessoa().getId());
			System.out.println("Nome: " + pessoaFisica.getPessoa().getNome());
			System.out.println("Celular: " + pessoaFisica.getPessoa().getTelefoneCelular());
			System.out.println("Telefone Fixo: " + pessoaFisica.getPessoa().getTelefoneFixo());
			System.out.println("Email: " + pessoaFisica.getPessoa().getEmail() + "\n");

			System.out.println("Informacoes da tabela Endereco: ");
			System.out.println("Id: " + pessoaFisica.getPessoa().getEndereco().getId());
			System.out.println("Rua: " + pessoaFisica.getPessoa().getEndereco().getRua());
			System.out.println("Numero: " + pessoaFisica.getPessoa().getEndereco().getNumero());
			System.out.println("Bairro: " + pessoaFisica.getPessoa().getEndereco().getBairro());
			System.out.println("Cep: " + pessoaFisica.getPessoa().getEndereco().getCep());
			System.out.println("Cidade: " + pessoaFisica.getPessoa().getEndereco().getCidade());
			System.out.println("Estado: " + pessoaFisica.getPessoa().getEndereco().getEstado());
			System.out.println("Impedimento: " + pessoaFisica.getPessoa().getImpedimento());
			System.out.println("Motivo do impedimento: " + pessoaFisica.getPessoa().getMotivoImpedimento() + "\n");

			System.out.println("Informações da tabela pessoa fisica");
			System.out.println("ID: " + pessoaFisica.getId());
			System.out.println("CPF : " + pessoaFisica.getCpf());
			System.out.println("RG : " + pessoaFisica.getRg());
			System.out.println("Genero : " + pessoaFisica.getGenero() + "\n");
		}
	}

	public static void listarPessoasJuridicas() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		List<PessoaJuridica> listPessoaJuridica = null;
		try {
			listPessoaJuridica = dao.retornarPessoaJuridica("01234567899874");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (PessoaJuridica pessoaJuridica : listPessoaJuridica) {
			
			System.out.println("Informações da tabela pessoa juridica");
			System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
			System.out.println("ID: " + pessoaJuridica.getId());
			//System.out.println("ID Pessoa: "+ pessoaJuridica.getPessoa().getId());
			//System.out.println("ID Endereco: "+ pessoaJuridica.getPessoa().getEndereco().getId()+"\n");
			//System.out.println("Representante: "+ pessoaJuridica.getResponsavel().getCpf()+"\n");
			
			System.out.println("Informações da tabela pessoa");
			System.out.println("Id: " + pessoaJuridica.getPessoa().getId());
			System.out.println("Nome: " + pessoaJuridica.getPessoa().getNome());
			System.out.println("Celular: " + pessoaJuridica.getPessoa().getTelefoneCelular());
			System.out.println("Telefone Fixo: " + pessoaJuridica.getPessoa().getTelefoneFixo());
			System.out.println("Email: " + pessoaJuridica.getPessoa().getEmail() + "\n");

			System.out.println("Informacoes da tabela Endereco: ");
			System.out.println("Id: " + pessoaJuridica.getPessoa().getEndereco().getId());
			System.out.println("Rua: " + pessoaJuridica.getPessoa().getEndereco().getRua());
			System.out.println("Numero: " + pessoaJuridica.getPessoa().getEndereco().getNumero());
			System.out.println("Bairro: " + pessoaJuridica.getPessoa().getEndereco().getBairro());
			System.out.println("Cep: " + pessoaJuridica.getPessoa().getEndereco().getCep());
			System.out.println("Cidade: " + pessoaJuridica.getPessoa().getEndereco().getCidade());
			System.out.println("Estado: " + pessoaJuridica.getPessoa().getEndereco().getEstado());
			System.out.println("Impedimento: " + pessoaJuridica.getPessoa().getImpedimento());
			System.out.println("Motivo do impedimento: " + pessoaJuridica.getPessoa().getMotivoImpedimento() + "\n");

		}
	}

}
