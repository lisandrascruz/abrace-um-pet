package launcher;

import raca.dominio.Raca;
import animal.dominio.Animal;
import animal.service.AnimalService;

public class TesteAnimal {

	public static void main(String[] args) {
		AnimalService animalService = new AnimalService();
		Animal animal = new Animal();
		Raca raca = new Raca();

		raca.setNome("testeaa");
		//System.out.println(raca.getId());
		raca.setOrigem("Coreano");
		raca.setTamanhoMax(2.0);
		raca.setTamanhoMin(1.5);
		raca.setTemperamento("Variante");
		raca.setExpectativaVida(15);
		
		animal.setNome("julaiiaia");
		animal.setTipo("DOG");
		animal.setRga("12345");
		animal.setDataNascimento("20/11/2222");
		animal.setRaca(raca);
		animal.setGenero("Macho");
		animal.setDeficiencia("Nenhuma deficiência");
		animal.setVacinado(true);
		animal.setCastrado(true);
		animal.setTamanho(1.7);
		animal.setPeso(3.0);
		animal.setTemperamento("Manhoso");
		animal.setObservacao(null);
		animal.setDataResgate("77/44/4422");
			
		animalService.adicionarAnimal(animal);

	}

}
