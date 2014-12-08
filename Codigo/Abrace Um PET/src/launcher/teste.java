package launcher;

import java.sql.SQLException;

import animal.dao.RacaDAO;
import animal.dominio.Raca;

public class teste {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RacaDAO racaDAO = new RacaDAO();
		Raca raca = new Raca();
		try {
			Raca listarRaca = racaDAO.listarRaca();
			System.out.println(listarRaca.getId());
			System.out.println(listarRaca.getNome());
			System.out.println(listarRaca.getOrigem());
			System.out.println(listarRaca.getTamanhoMax());
			System.out.println(listarRaca.getTamanhoMin());
			System.out.println(listarRaca.getTemperamento());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		raca.getNome();
//		raca.getOrigem();
//		raca.getTamanhoMax();
//		raca.getTamanhoMin();
//		raca.getTemperamento();
//		raca.getId();
//		raca.getExpectativaVida();
	}
	
}
