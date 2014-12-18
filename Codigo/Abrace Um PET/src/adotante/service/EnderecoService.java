package adotante.service;

import java.sql.SQLException;

import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.Endereco;

public class EnderecoService {
	
	
	public Endereco consultarEndereco(int id){
		Endereco endereco = new Endereco();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		try {
			endereco = pessoaFisicaDAO.consultarEndereco(id);
		} catch (SQLException e) {
			System.out.println("Erro ServiceEndereco");
			e.printStackTrace();
		}
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
