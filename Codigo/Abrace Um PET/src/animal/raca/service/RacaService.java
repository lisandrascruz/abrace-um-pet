package animal.raca.service;

import animal.raca.dao.RacaDAO;
import animal.raca.dominio.Raca;

public class RacaService {
	RacaDAO	racaDAO	= new RacaDAO();
	Raca	raca	= new Raca();
	
	public boolean adicionarRaca(Raca raca) {
		return racaDAO.adicionarRaca(raca);
	}
	
	public boolean validarRaca(String nome) throws Exception {
		boolean valido = false;
		raca.setNome(nome);
		
		if (racaDAO.consultarRaca(nome))
			throw new Exception("Raça já cadastrada!!");
		else{
			valido = true;
		}
		
		return valido;
	}
	
}
