package launcher;

import java.util.List;

import adotante.dao.EnderecoDAO;
import adotante.dao.PessoaDAO;
import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

public class Listagem {
	public static void main(String[] args) {

		listarEndereco();
		listarPessoa();
		listarPessoasFisicas();
		listarPessoasJuridicas();
	}
	public static void listarPessoasJuridicas() {
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		List<PessoaJuridica> pessoaJuridicaList = dao.getListaPessoaJuridica();
		for (PessoaJuridica pessoaJuridica : pessoaJuridicaList) {
			System.out.println("ID Pessoa Juridica: " + pessoaJuridica.getId());
			System.out.println("CNPJ : " + pessoaJuridica.getCnpj());
			System.out.println("Responsável : " + pessoaJuridica.getResponsavel());
			System.out.println("Pessoa : " + pessoaJuridica.getPessoa());
			System.out.println("Endereço : " + pessoaJuridica.getEndereco()+"\n\n");
		}
	}

	/**
	 * 
	 */
	public static void listarPessoasFisicas() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> pessoasFisicas = dao.getListaPessoaFisica();
		for (PessoaFisica pessoaFisica : pessoasFisicas) {
			System.out.println("ID Pessoa Fisica: " + pessoaFisica.getId());
			System.out.println("CPF : " + pessoaFisica.getCpf());
			System.out.println("RG : " + pessoaFisica.getRg());
			System.out.println("Genero : " + pessoaFisica.getGenero());
			System.out.println("Pessoa : " + pessoaFisica.getPessoa()+"\n\n");
		}
	}

	public static void listarPessoa() {
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> pessoas = dao.getListaPessoa();
		for (Pessoa pessoa : pessoas) {
			System.out.println("ID Pessoa: " + pessoa.getId());
			System.out.println("Nome : " + pessoa.getNome());
			System.out.println("Celular : " + pessoa.getTelefoneCelular());
			System.out.println("Fixo : " + pessoa.getTelefoneFixo());
			System.out.println("Email : " + pessoa.getEmail());
			System.out.println("Endereço: " + pessoa.getEndereco() );
			System.out.println("Impedimento: " + pessoa.getImpedimento());
			System.out.println("Motivo Impedimento: " + pessoa.getMotivoImpedimento() + "\n\n");
		}
	}

	public static void listarEndereco() {
		EnderecoDAO dao = new EnderecoDAO();
		List<Endereco> enderecos = dao.getListaEndereco();
		for (Endereco endereco : enderecos) {
			System.out.println("ID endereco: " + endereco.getId());
			System.out.println("Rua : " + endereco.getRua());
			System.out.println("Numero : " + endereco.getNumero());
			System.out.println("Bairro : " + endereco.getBairro());
			System.out.println("Cep : " + endereco.getCep());
			System.out.println("Cidade : " + endereco.getCidade());
			System.out.println("Estado : " + endereco.getEstado());
			System.out.println("Complemento: " + endereco.getComplemento()+"\n\n");
		}
	}

}
