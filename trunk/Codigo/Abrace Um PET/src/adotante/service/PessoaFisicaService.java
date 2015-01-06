package adotante.service;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;

public class PessoaFisicaService {
	PessoaFisicaDAO	pessoaFisicaDAO	= new PessoaFisicaDAO();
	PessoaFisica pessoaFisica = new PessoaFisica();
	
	
	/**
	 * CHAMA METODO DO DAO E ADICIONA PESSOA FISICA
	 * @param pessoaFisica
	 * @return
	 * @throws Exception
	 */
	public boolean adicionarPessoaFisicaService(PessoaFisica pessoaFisica) throws Exception {
		return pessoaFisicaDAO.adicionarPessoaFisica(pessoaFisica);
	}
	
	/**
	 * VERIFICA SE O CPF JA ESTÁ CADASTRADO NO SISTEMA
	 * 
	 * @param cpf
	 * @return
	 * @throws Exception 
	 */
	public boolean validarCadastroPessoaFisica(String cpf) throws Exception {
		boolean valido;
		pessoaFisica.setCpf(cpf);

		if (pessoaFisicaDAO.consultarPessoaFisicaCPF(cpf) == false) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	/**
	 * CONSULTA REPRESENTANTE PELO CPF
	 * @param cpf
	 * @return
	 * @throws Exception
	 */
	public PessoaFisica consultarRepresentante(String cpf) throws Exception{
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		pessoaFisica = pessoaFisicaDAO.consultarPessoaFisica(cpf);
		return pessoaFisica;
	}
	
	/**
	 * CONSULTA PESSOA FISICA PELO ID
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public PessoaFisica consultarPessoaFisica(int id) throws Exception{
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
			pessoaFisica = pessoaFisicaDAO.consultarPessoaFisica(id);
		return pessoaFisica;
	}
	
	/**
	 * EXCLUI PESSOA FISICA 
	 * @param pessoaFisica
	 * @throws Exception
	 */
	public void excluirPessoaFisica(PessoaFisica pessoaFisica) throws Exception{
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		pessoaFisicaDAO.excluirPessoaFisica(pessoaFisica);
	}
}
