package animal.raca.service;

import animal.raca.dao.RacaDAO;
import animal.raca.dominio.Raca;

public class RacaService {
	RacaDAO	racaDAO	= new RacaDAO();
	Raca	raca	= new Raca();
	
	/**
	 * ADICIONA RACA
	 * 
	 * @param raca
	 * @return
	 * @throws Exception 
	 */
	public boolean adicionarRaca(Raca raca) throws Exception {
		return racaDAO.adicionarRaca(raca);
	}
	
	/**
	 * VALIDA RACA
	 * 
	 * @param nome
	 * @return
	 * @throws Exception
	 */
	public boolean validarRaca(String nome) throws Exception {
		boolean valido = false;
		raca.setNome(nome);
		if (racaDAO.booleanConsultarRaca(nome))
			throw new Exception("Raça já cadastrada!");
		else {
			valido = true;
		}
		return valido;
	}
	
	/**
	 * CONSULTA DE RACA
	 * 
	 * @param nome
	 * @return 
	 * @throws Exception
	 */
	public Raca consultarRaca(String nome) throws Exception {
		return racaDAO.consultarRaca(nome);
	}
}
