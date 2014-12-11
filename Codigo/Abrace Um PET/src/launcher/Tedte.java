package launcher;

import raca.dominio.Raca;
import raca.service.RacaService;

public class Tedte {
	public static void main(String[] args) {
		Raca raca = new Raca();
		RacaService rs = new RacaService();
		raca.setNome("Pitibu");
		raca.setOrigem("Brasil");
		raca.setExpectativaVida(23);
		raca.setTamanhoMax(1.3);
		raca.setTamanhoMin(1);
		raca.setTemperamento("Normal");
		
		rs.adicionarRacaCachorro(raca);
		
	}
}
