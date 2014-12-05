package animal.service;

import java.sql.SQLException;

import animal.dao.AnimalDAO;
import animal.dominio.Animal;

public class AnimalService {
	private AnimalDAO animalDAO = new AnimalDAO();

	public boolean consultarAnimalService(String rga) throws SQLException {
		if (animalDAO.consultarAnimal(rga) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean adicionarAnimal(Animal animal) {
		return animalDAO.adicionarAnimal(animal);
	}
}
