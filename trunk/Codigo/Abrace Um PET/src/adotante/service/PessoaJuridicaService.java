package adotante.service;

import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;

public class PessoaJuridicaService {
	private PessoaJuridicaDAO	pessoaJuridicaDAO	= new PessoaJuridicaDAO();
	PessoaFisicaDAO				pessoaFisicaDao		= new PessoaFisicaDAO();
	PessoaFisica				pessoaFisica		= new PessoaFisica();
	PessoaJuridica				pessoaJuridica		= new PessoaJuridica();
	
	public boolean adicionarPessoaJuridicaService(PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaDAO.adicionarPessoaJuridica(pessoaJuridica);
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
	
	public boolean validarCpfResponsavelJuridico(String cpf) {
		boolean valido;
		pessoaFisica.setCpf(cpf);
		if (pessoaFisicaDao.consultarPessoaFisicaCPF(cpf)) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}
	
	/**
	 * VERIFICA SE O CNPJ JA ESTÁ CADASTRADO NO SISTEMA
	 * @param cnpj
	 * @return
	 */
	public boolean validarCadastroPessoaJuridica(String cnpj) {
		boolean valido;
		pessoaJuridica.setCnpj(cnpj);
		
		if (pessoaJuridicaDAO.consultarPessoaJuridicaCNPJ(cnpj) == false) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
}
