package animal.service;

import java.sql.SQLException;

import animal.dao.AnimalDAO;
import animal.dominio.Animal;

public class AnimalService {
	private AnimalDAO animalDAO = new AnimalDAO();
	private Animal animal = new Animal();

	public boolean validarCadastroAnimal(String rga) throws SQLException {
		boolean valido;
		animal.setRga(rga);

		if (animalDAO.consultarAnimalRGA(rga) == false) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	public boolean adicionarAnimal(Animal animal) {
		return animalDAO.adicionarAnimal(animal);
	}
}
