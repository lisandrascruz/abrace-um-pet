package adocao.service;

import adocao.dao.AdocaoDAO;
import adocao.dominio.Adocao;
import adotante.dao.AdotanteDAO;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;

public class AdocaoService {
	private AdocaoDAO adocaoDAO = new AdocaoDAO();

	/**
	 * CHAMA METODO DO DAO E ADICIONA ADOCAO
	 * @param adocao
	 * @return
	 * @throws Exception
	 */
	public boolean adicionarAdocaoService(Adocao adocao) throws Exception{
		return adocaoDAO.adicionarAdocao(adocao);
	}
	
	/**
	 * CHAMA METODO DO DAO E CONSULTA ADOTANTE
	 * @param pessoa
	 * @return
	 * @throws Exception
	 */
	public Adotante consultarAdotante(Pessoa pessoa) throws Exception{
		Adotante adotante = null;
		AdotanteDAO adotanteDAO = new AdotanteDAO();
			adotante = adotanteDAO.consultarAdotante(pessoa);
		return adotante;
	}
	
	/**
	 * CHAMA METODO DO DAO E CONSULTA ADOCAO
	 * @param cpf
	 * @param rga
	 * @return
	 * @throws Exception
	 */
	public Adocao consultarAdocao(String cpf, String rga) throws Exception{
		Adocao adocao = null;
		AdocaoDAO adocaoDAO = new AdocaoDAO();
		adocao = adocaoDAO.consultarAdocao(cpf, rga);
		return adocao;
	}
	
	/**
	 * CHAMA METODO DO DAO E CONSULTA ADOCAO JURIDICA	
	 * @param cnpj
	 * @param rga
	 * @return
	 * @throws Exception
	 */
	public Adocao consultarAdocaoJuridica(String cnpj, String rga) throws Exception{
		Adocao adocao = null;
		AdocaoDAO adocaoDAO = new AdocaoDAO();
	    adocao = adocaoDAO.consultarAdocaoJuridica(cnpj, rga);
		return adocao;
	}
	

	/**
	 * CHAMA METODO DO DAO E EDITA ADOCAO	
	 * @param adocao
	 * @return
	 * @throws Exception
	 */
	public void editarAdocao(Adocao adocao) throws Exception{
		AdocaoDAO adocaoDAO = new AdocaoDAO();
		adocaoDAO.editarAdocao(adocao);
	}
}
