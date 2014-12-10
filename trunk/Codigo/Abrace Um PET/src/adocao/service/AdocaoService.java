package adocao.service;

import adocao.dao.AdocaoDAO;
import adocao.dominio.Adocao;
import adotante.dao.AdotanteDAO;
//import adotante.dao.AdotanteDAO;
import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.Adotante;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;
import animal.dao.AnimalDAO;
import animal.dominio.Animal;

public class AdocaoService {
	private AdocaoDAO adocaoDAO = new AdocaoDAO();

	public boolean adicionarAdocaoService(Adocao adocao) {
		return adocaoDAO.adicionarAdocao(adocao);
	}
	
	public PessoaFisica consultarRepresentante(String cpf){
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
		try{
		pessoaFisica = pessoaFisicaDAO.consultarPessoaFisica(cpf);
		} catch (Exception ex) {
			
		}
		return pessoaFisica;
	}
	
	public PessoaJuridica consultarPessoaJuridica(String cnpj){
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
		try{
			pessoaJuridica = pessoaJuridicaDAO.consultarPessoaJuridica(cnpj);
			} catch (Exception ex) {
				
			}
		return pessoaJuridica;
	}
	
	public Animal consultarAnimal(String rga){
		Animal animal = new Animal();
		AnimalDAO AnimalDAO = new AnimalDAO();
		try{
			animal = AnimalDAO.consultarAnimal(rga);
		} catch (Exception ex) {
			
		}
		return animal;
	}
	
	public Adotante consultarAdotante(Pessoa pessoa){
		Adotante adotante = new Adotante();
		AdotanteDAO AdotanteDAO = new AdotanteDAO();
		try{
			adotante = AdotanteDAO.consultarAdotante(pessoa);
		} catch (Exception ex) {
			
		}
		return adotante;
	}
}
