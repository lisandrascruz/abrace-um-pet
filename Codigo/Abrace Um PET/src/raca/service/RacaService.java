package raca.service;

import animal.dao.RacaDAO;
import animal.dominio.Raca;


public class RacaService {
	RacaDAO racaDAO = new RacaDAO();
	
	public boolean adicionarRacaCachorro(Raca raca){
		return racaDAO.adicionarRacaCachorro(raca);
	}
	public boolean adicionarRacaGato(Raca raca){
		return racaDAO.adicionarRacaGatos(raca);
	}

}
