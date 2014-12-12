package animal.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import raca.dao.RacaDAO;
import animal.dao.AnimalDAO;
import animal.dominio.Animal;

public class AnimalService {
	private AnimalDAO animalDAO = new AnimalDAO();

	public boolean validarCadastroAnimal(String rga) throws SQLException {
		boolean valido;
		 Animal animal =animalDAO.consultarAnimal(rga);
		if (animal.getRga() == null) {
			valido = true;
		} else {
			valido = false;
			
		}
		return valido;
	}

	public boolean adicionarAnimal(Animal animal) {
		return animalDAO.adicionarAnimal(animal);
	}
	public List<String> getRacaCachorro() throws SQLException{
		RacaDAO dao = new RacaDAO();

		return dao.getRacaCachorro();
	}
	public List<String> getRacaGato() throws SQLException{
		RacaDAO dao = new RacaDAO();

		return dao.getRacaGato();
	}
}
