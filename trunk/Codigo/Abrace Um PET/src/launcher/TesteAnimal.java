package launcher;

import infraestrutura.dominio.Date;
import animal.dominio.Animal;
import animal.dominio.Raca;
import animal.service.AnimalService;

public class TesteAnimal {

	public static void main(String[] args) {
		AnimalService animalService = new AnimalService();
		Animal animal = new Animal();
		Raca raca = new Raca();
		Date data = new Date();
		data.transformaData("01/10/1993");
		
		raca.setNome("Siames Branco");
		raca.setOrigem("Coreano");
		raca.setTamanhoMax(2.0);
		raca.setTamanhoMin(1.5);
		raca.setTemperamento("Variante");
		raca.setExpectativaVida(15);
		
		animal.setNome("Juvenal");
		animal.setTipo("Gato");
		animal.setRga("12345");
		animal.setDataNascimento(null);
		animal.setRaca(raca);
		animal.setGenero("Macho");
		animal.setDeficiencia("Nenhuma deficiência");
		animal.setVacinado(true);
		animal.setCastrado(true);
		animal.setTamanho(1.7);
		animal.setPeso(3.0);
		animal.setTemperamento("Manhoso");
		animal.setObservacao(null);
		animal.setDataResgate(null);
			
		animalService.adicionarAnimal(animal);

	}

}
