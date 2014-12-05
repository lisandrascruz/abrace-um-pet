package adotante.service;

import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaService {
	private PessoaJuridicaDAO	pessoaJuridicaDAO	= new PessoaJuridicaDAO();

	public boolean adicionarPessoaJuridicaService(PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaDAO.adicionarPessoaJuridica(pessoaJuridica);
	}

	public PessoaFisica consultarRepresentante(String cpf) {
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		try {
			pessoaFisica = pessoaFisicaDAO.consultarRepresentante(cpf);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return pessoaFisica;
	}
}
