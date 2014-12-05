package adocao.service;

import adocao.dao.AdocaoDAO;
import adocao.dominio.Adocao;
import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;

public class AdocaoService {
	private AdocaoDAO adocaoDAO = new AdocaoDAO();

	public boolean adicionarAdocaoService(Adocao adocao) {
		return adocaoDAO.adicionarAdocao(adocao);
	}
	
	/*public PessoaFisica consultarRepresentante(String cpf){
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		pessoaFisica = pessoaFisicaDAO.consultarRepresentante(cpf);
		return pessoaFisica;
	}*/
}
