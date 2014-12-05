package adotante.service;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;

public class PessoaFisicaService {
	private PessoaFisicaDAO	pessoaFisicaDAO	= new PessoaFisicaDAO();

	public boolean adicionarPessoaFisicaService(PessoaFisica pessoaFisica) {
		return pessoaFisicaDAO.adicionarPessoaFisica(pessoaFisica);
	}
}
