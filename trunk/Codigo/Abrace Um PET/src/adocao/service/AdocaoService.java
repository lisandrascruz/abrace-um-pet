package adocao.service;

import adocao.dao.AdocaoDAO;
import adocao.dominio.Adocao;
import adotante.dao.AdotanteDAO;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;

public class AdocaoService {
	private AdocaoDAO adocaoDAO = new AdocaoDAO();

	public boolean adicionarAdocaoService(Adocao adocao) {
		return adocaoDAO.adicionarAdocao(adocao);
	}
	
	public Adotante consultarAdotante(Pessoa pessoa){
		Adotante adotante = new Adotante();
		AdotanteDAO AdotanteDAO = new AdotanteDAO();
		try{
			adotante = AdotanteDAO.consultarAdotante(pessoa);
		} catch (Exception ex) {
			
		}
		return adotante;
	}
}
