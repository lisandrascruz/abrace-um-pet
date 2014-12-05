package launcher;

import java.sql.SQLException;
import java.util.List;

import animal.dao.AnimalDAO;
import animal.dominio.Animal;


public class testAnimal {

	public static void main(String[] args) {
		listarAnimal();
	}
	
	public static void listarAnimal() {
	AnimalDAO dao = new AnimalDAO();
	List<Animal> animal = null;
	try {
		animal = dao.retornarAnimal("12345");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for (Animal animal2 : animal) {
		
		System.out.println("Informacoes da tabela Animal: ");
		System.out.println("Id: " + animal2.getId());
		System.out.println("Tipo: " + animal2.getTipo());
		System.out.println("Nome: " + animal2.getNome());
		System.out.println("Genero: " + animal2.getGenero() );
		System.out.println("Rga: " + animal2.getRga() );
		System.out.println("ID Raça: " + animal2.getRaca().getId());
		System.out.println("Deficiencia: " + animal2.getDeficiencia());
		System.out.println("OBS: " + animal2.getObservacao());
		System.out.println("Peso: " + animal2.getPeso());
		System.out.println("Tamanho: " + animal2.getTamanho());
		System.out.println("Temperamento: " + animal2.getTemperamento()+ "\n");
		
		System.out.println("Informações da tabela raca");
		System.out.println("Id: " + animal2.getRaca().getId());
		System.out.println("Nome: " + animal2.getRaca().getNome());
		System.out.println("Expectativa: " + animal2.getRaca().getExpectativaVida());
		System.out.println("Origem: " + animal2.getRaca().getOrigem());
		System.out.println("Tamanho Maximo: " + animal2.getRaca().getTamanhoMax());
		System.out.println("Tamanho minimo: " + animal2.getRaca().getTamanhoMin());
		System.out.println("Temperamento: " + animal2.getRaca().getTemperamento());
		
		
		
	}
}
	

}
