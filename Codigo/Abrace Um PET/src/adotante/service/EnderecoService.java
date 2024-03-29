package adotante.service;

import adotante.dao.EnderecoDAO;
import adotante.dominio.Endereco;

public class EnderecoService {
	/**
	 * FAZ A CONSULTA DO ENDERE�O ATRAV�S DO ID
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Endereco consultarEndereco(int id) throws Exception {
		Endereco endereco = new Endereco();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		endereco = enderecoDAO.consultarEndereco(id);
		return endereco;
	}
	
	/**
	 * VALIDAR RUA DO ENDERECO
	 * 
	 * @param rua
	 * @return
	 */
	public boolean validarRua(String rua) {
		boolean valido;
		
		if (!rua.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	/**
	 * VALIDAR NUMERO DO ENDERECO
	 * 
	 * @param numero
	 * @return
	 */
	public boolean validarNumero(String numero) {
		boolean valido;
		
		if (!numero.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	/**
	 * VALIDAR BAIRRO
	 * 
	 * @param bairro
	 * @return
	 */
	public boolean validarBairro(String bairro) {
		boolean valido;
		if (!bairro.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	/**
	 * VALIDAR CIDADE
	 * 
	 * @param rua
	 * @return
	 */
	public boolean validarCidade(String cidade) {
		boolean valido;
		
		if (!cidade.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	
	/**
	 * VALIDAR ESTADO
	 * 
	 * @param estado
	 * @return
	 */
	public boolean validarEstado(String estado) {
		boolean valido;
		
		if (!estado.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
}
