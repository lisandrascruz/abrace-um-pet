package adotante.service;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;

public class PessoaFisicaService {
	PessoaFisicaDAO	pessoaFisicaDAO	= new PessoaFisicaDAO();
	PessoaFisica pessoaFisica = new PessoaFisica();
	
	public boolean adicionarPessoaFisicaService(PessoaFisica pessoaFisica) {
		return pessoaFisicaDAO.adicionarPessoaFisica(pessoaFisica);
	}
	
	/**
	 * VERIFICA SE O CPF JA ESTÁ CADASTRADO NO SISTEMA
	 * 
	 * @param cpf
	 * @return
	 */
	public boolean validarCadastroPessoaFisica(String cpf) {
		boolean valido;
		pessoaFisica.setCpf(cpf);

		if (pessoaFisicaDAO.consultarPessoaFisicaCPF(cpf) == false) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	public PessoaFisica consultarRepresentante(String cpf) {
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		try {
			pessoaFisica = pessoaFisicaDAO.consultarPessoaFisica(cpf);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return pessoaFisica;
	}
}
