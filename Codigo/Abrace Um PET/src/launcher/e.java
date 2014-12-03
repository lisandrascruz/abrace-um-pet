package launcher;

import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;

public class e {

	public static void main(String[] args) {

		PessoaFisicaService pfs = new PessoaFisicaService();
		System.out.println(pfs.retornarPF("09791366441"));
		PessoaFisica pf = new PessoaFisica();
		System.out.println(pf.getCpf());
		System.out.println(pf.getGenero());
		System.out.println(pf.getId());
		System.out.println(pf.getPessoa());
		System.out.println(pf.getRg());
		
		

	}

}
