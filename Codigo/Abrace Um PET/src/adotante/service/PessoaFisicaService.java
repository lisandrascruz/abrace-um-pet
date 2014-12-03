package adotante.service;

import java.sql.SQLException;
import java.util.List;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;

public class PessoaFisicaService {
	private PessoaFisicaDAO	pessoaFisicaDAO	= new PessoaFisicaDAO();

	public boolean adicionarPessoaFisicaService(PessoaFisica pessoaFisica) {
		return pessoaFisicaDAO.adicionarPessoaFisica(pessoaFisica);
	}

	public List<PessoaFisica> retornarPF(String cpf) {

		try {
			return pessoaFisicaDAO.retornarPessoaFisica(cpf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
