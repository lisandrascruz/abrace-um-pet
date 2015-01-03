package animal.service;

import java.sql.SQLException;

import animal.dao.AnimalDAO;
import animal.dominio.Animal;

public class AnimalService {
	private AnimalDAO	animalDAO	= new AnimalDAO();
	
	public boolean validarCadastroAnimal(String rga) throws SQLException {
		boolean valido;
		Animal animal = animalDAO.consultarAnimal(rga);
		if (animal.getRga() == null) {
			valido = true;
		} else {
			valido = false;
			
		}
		return valido;
	}
	
	public boolean adicionarAnimal(Animal animal) throws Exception {
		int id;
		boolean valido = false;
		id = animalDAO.inserirAnimal(animal);
		if (id != -1) {
			valido = true;
		}
		return valido;
	}
	
	public Animal consultarAnimal(String rga) {
		Animal animal = null;
		AnimalDAO AnimalDAO = new AnimalDAO();
		try {
			animal = AnimalDAO.consultarAnimal(rga);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return animal;
	}
	
}