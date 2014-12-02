package adotante.service;

import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaService {
	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

	public boolean adicionarPessoaJuridicaService(PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaDAO.adicionarPessoaJuridica(pessoaJuridica);
	}
}
