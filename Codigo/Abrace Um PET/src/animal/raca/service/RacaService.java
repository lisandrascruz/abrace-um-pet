package animal.raca.service;

import animal.raca.dao.RacaDAO;
import animal.raca.dominio.Raca;


public class RacaService {
	RacaDAO racaDAO = new RacaDAO();
	
	public boolean adicionarRaca(Raca raca){
		return racaDAO.adicionarRaca(raca);
	}
	


}
