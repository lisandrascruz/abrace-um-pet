package adotante.service;

import java.sql.SQLException;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;


public class PessoaFisicaService {
	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

	public boolean adicionarPessoaFisicaService(PessoaFisica pessoaFisica) {
		return pessoaFisicaDAO.adicionarPessoaFisica(pessoaFisica);
	}
	public PessoaFisica retornarPF (String cpf) {
		try {
			return pessoaFisicaDAO.retornarPessoaFisica(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
