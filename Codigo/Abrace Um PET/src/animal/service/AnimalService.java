package animal.service;

import java.sql.SQLException;

import animal.dao.AnimalDAO;
import animal.dominio.Animal;

public class AnimalService {
	private AnimalDAO	animalDAO	= new AnimalDAO();
	
	public boolean validarCadastroAnimal(String rga) throws Exception {
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
		return animalDAO.adicionarAnimal(animal);
	}
	
	public void excluirAnimal(Animal animal) throws Exception{
		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.excluirAnimal(animal);
	}
	public void edicaoAnimal(Animal animal) throws Exception{
		AnimalDAO animalDAO = new AnimalDAO();
		animalDAO.editarAnimal(animal);
	}
	public Animal consultarAnimal(String rga) throws Exception {
		AnimalDAO animalDAO = new AnimalDAO();
		return animalDAO.consultarAnimal(rga);
	}
	
}