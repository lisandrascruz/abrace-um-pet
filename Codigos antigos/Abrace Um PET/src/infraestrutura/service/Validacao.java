package infraestrutura.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adotante.dao.PessoaFisicaDAO;
import adotante.dao.PessoaJuridicaDAO;
import adotante.dominio.PessoaFisica;
import adotante.dominio.PessoaJuridica;
import usuario.dao.UsuarioDAO;
import usuario.dominio.Usuario;
import usuario.gui.CadastroUsuarioGUI;

public class Validacao {
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDao = new UsuarioDAO();
	PessoaFisica pessoaFisica = new PessoaFisica();
	PessoaJuridica pessoaJuridica = new PessoaJuridica();
	PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO();
	PessoaJuridicaDAO pessoaJuridicaDao = new PessoaJuridicaDAO();
	CadastroUsuarioGUI cadastroUsuario = new CadastroUsuarioGUI();

	/**
	 * VALIDAR SE LOGIN JA EXISTE NO BANCO DE DADOS
	 * @param login
	 * @return
	 */
	public boolean validarCadastro(String login) { //mudar nome de método para validarCadastroUsuario
		boolean valido;
		usuario.setLogin(login);

		if (usuarioDao.consultarUsuario(login)) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}
	public boolean validarCpfResponsavelJuridico(String cpf) {
		boolean valido;
		pessoaFisica.setCpf(cpf);
		if (pessoaFisicaDao.consultarPessoaFisica(cpf)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}
	public boolean validarCadastroPf(String cpf) {
		boolean valido;
		pessoaFisica.setCpf(cpf);
		
		if (pessoaFisicaDao.consultarPessoaFisica(cpf)){
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}


	/**
	 * VALIDAR CAMPO LOGIN (MINIMO 3 CARACTERES)
	 * 
	 * @param login
	 * @return
	 */
	public boolean validarLogin(String login) {
		boolean valido;
		int tamanhoLogin = login.length();

		if (tamanhoLogin > 3) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR CAMPO SENHA (MINIMO 6 CARACTERES E PELO MENOS UM CARACTER
	 * ESPECIAL)
	 * 
	 * @param senha
	 * @return
	 */
	public boolean validarSenha(String senha) {
		boolean valido;
		int tamanhoSenha = senha.length();
		usuario.setSenha(senha);

		if (!senha.equals( "")) {
			if (tamanhoSenha < 6
					&& (!(senha.contains("!") || senha.contains("@")
							|| senha.contains("#") || senha.contains("%")
							|| senha.contains("&") || senha.contains("$")))) {
				valido = false;
			} else {
				valido = true;
			}

		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR SE SENHA E CONFIRMAR SENHA CONFEREM
	 * 
	 * @param senha
	 * @param confirmacaoSenha
	 * @return
	 */
	public boolean validarConfirmacaoSenha(String senha, String confirmacaoSenha) {
		boolean valido;

		cadastroUsuario.setConfirmarSenha(confirmacaoSenha);
		usuario.setSenha(senha);

		if ((cadastroUsuario.getConfirmarSenha().equals(usuario.getSenha()))) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR EMAIL DO USUARIO
	 * 
	 * @param email
	 * @return
	 */
	public boolean validarEmail(String email) {
		boolean valido;
		usuario.setEmail(email);

		if (!email.equals("")) {
			if ((usuario.getEmail().contains("@"))
					&& (usuario.getEmail().contains(".com"))
					&& (!(usuario.getEmail()).contains(" "))) {

				String nomeEmail = new String(email.substring(0,
						email.lastIndexOf('@')));

				String dominio = new String(email.substring(
						email.lastIndexOf('@') + 1, email.length()));

				if (!(nomeEmail.length() >= 1) && (!nomeEmail.contains("@"))
						&& (dominio.contains(".com"))
						&& (!dominio.contains("@"))
						&& (dominio.indexOf(".com") >= 1)
						&& (dominio.lastIndexOf(".com") < dominio.length() - 1)) {
					valido = false;
				} else {
					valido = true;
				}
			} else {
				valido = false;
			}

		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR NOME DA PESSOA FISICA
	 * 
	 * @param nome
	 * @return
	 */
	public boolean validarNome(String nome) {
		boolean valido;

		if (!nome.equals("")) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR SEXO DA PESSOA FISICA
	 * 
	 * @param genero
	 * @return
	 */
	public boolean validarSexoPessoaFisica(String genero) {
		boolean valido;
		if (!genero.equals(" ")) {
			valido = true;
		} else {
			valido = false ;
		}
		
		return valido;
	}

	/**
	 * VALIDAR TELEFONE FIXO DA PESSOA FISICA
	 * 
	 * @param telefoneFixo
	 * @return
	 */
	public boolean validarTelefoneFixo(String telefoneFixo) {
		boolean valido;
		int tamanhoTelFixo = telefoneFixo.length();

		if ((telefoneFixo != "") && (tamanhoTelFixo == 11)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR TELEFONE CELULAR DA PESSOA FISICA
	 * 
	 * @param telefoneCelular
	 * @return
	 */
	public boolean validarCelular(String telefoneCelular) {
		boolean valido;
		int tamanhoTelCelular = telefoneCelular.length();

		if ((telefoneCelular != "") && (tamanhoTelCelular == 11)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR CPF
	 * @param cpf
	 * @return
	 */
	public boolean validarCpf(String cpf) {
		boolean valido;
		int tamanhoCpf = cpf.length();

		if ((cpf != "") && (tamanhoCpf == 11)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR RG
	 * @param rg
	 * @return
	 */
	public boolean validarRg(String rg) {
		boolean valido;
		int tamanhoRg = rg.length();

		if ((!rg.equals("")) && (tamanhoRg == 7)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
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
	 * VALIDAR CEP
	 * @param cep
	 * @return
	 */
	public boolean validarCep(String cep) {
		boolean valido;
		int tamanhoCep = cep.length();
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(cep);

		if ((!cep.equals("")) && (tamanhoCep == 8) && (matcher.find())) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	/**
	 * VALIDAR BAIRRO
	 * @param bairro
	 * @return
	 */
	public boolean validarBairro(String bairro) {
		boolean valido;
		if (!bairro.equals("")){
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
	
	/**
	 *  VALIDAR CNPJ
	 * 
	 * @param cnpj
	 * @return
	 */
	public boolean validarCnpj(String cnpj) {
		int tamanhoCnpj = cnpj.length();
		boolean valido;

		if ((!cnpj.equals("")) && (tamanhoCnpj == 14)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

}




//package infraestrutura.service;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import adotante.dao.PessoaFisicaDAO;
//import adotante.dao.PessoaJuridicaDAO;
//import adotante.dominio.PessoaFisica;
//import adotante.dominio.PessoaJuridica;
//import usuario.dao.UsuarioDAO;
//import usuario.dominio.Usuario;
//import usuario.gui.CadastroUsuarioGUI;
//
//public class Validacao {
//	Usuario usuario = new Usuario();
//	UsuarioDAO usuarioDao = new UsuarioDAO();
//	PessoaFisica pessoaFisica = new PessoaFisica();
//	PessoaJuridica pessoaJuridica = new PessoaJuridica();
//	PessoaFisicaDAO pessoaFisicaDao = new PessoaFisicaDAO();
//	PessoaJuridicaDAO pessoaJuridicaDao = new PessoaJuridicaDAO();
//	CadastroUsuarioGUI cadastroUsuario = new CadastroUsuarioGUI();
//
//	/**
//	 * VALIDAR SE LOGIN JA EXISTE NO BANCO DE DADOS
//	 * @param login
//	 * @return
//	 */
//	public boolean validarCadastro(String login) { //mudar nome de método para validarCadastroUsuario
//		boolean valido;
//		usuario.setLogin(login);
//
//		if (usuarioDao.consultarUsuario(login)) {
//			valido = false;
//		} else {
//			valido = true;
//		}
//		return valido;
//	}
//	public boolean validarCpfResponsavelJuridico(String cpf) {
//		boolean valido;
//		String nome = null;
//		pessoaFisica.setCpf(cpf);
//		if (pessoaFisicaDao.consultarPessoaFisica(cpf)) {
//			valido = false;
//		} else {
//			valido = true;
//		}
//		return valido;
//	}
//	public boolean validarCadastroPf(String cpf) {
//		boolean valido;
//		pessoaFisica.setCpf(cpf);
//		
//		if (pessoaFisicaDao.consultarPessoaFisica(cpf)){
//			valido = false;
//		} else {
//			valido = true;
//		}
//		return valido;
//	}
//
//
//	/**
//	 * VALIDAR CAMPO LOGIN (MINIMO 3 CARACTERES)
//	 * 
//	 * @param login
//	 * @return
//	 */
//	public boolean validarLogin(String login) {
//		boolean valido;
//		int tamanhoLogin = login.length();
//
//		if (tamanhoLogin > 3) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR CAMPO SENHA (MINIMO 6 CARACTERES E PELO MENOS UM CARACTER
//	 * ESPECIAL)
//	 * 
//	 * @param senha
//	 * @return
//	 */
//	public boolean validarSenha(String senha) {
//		boolean valido;
//		int tamanhoSenha = senha.length();
//		usuario.setSenha(senha);
//
//		if (!senha.equals( "")) {
//			if (tamanhoSenha < 6
//					&& (!(senha.contains("!") || senha.contains("@")
//							|| senha.contains("#") || senha.contains("%")
//							|| senha.contains("&") || senha.contains("$")))) {
//				valido = false;
//			} else {
//				valido = true;
//			}
//
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR SE SENHA E CONFIRMAR SENHA CONFEREM
//	 * 
//	 * @param senha
//	 * @param confirmacaoSenha
//	 * @return
//	 */
//	public boolean validarConfirmacaoSenha(String senha, String confirmacaoSenha) {
//		boolean valido;
//
//		cadastroUsuario.setConfirmarSenha(confirmacaoSenha);
//		usuario.setSenha(senha);
//
//		if ((cadastroUsuario.getConfirmarSenha().equals(usuario.getSenha()))) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR EMAIL DO USUARIO
//	 * 
//	 * @param email
//	 * @return
//	 */
//	public boolean validarEmail(String email) {
//		boolean valido;
//		usuario.setEmail(email);
//
//		if (!email.equals("")) {
//			if ((usuario.getEmail().contains("@"))
//					&& (usuario.getEmail().contains(".com"))
//					&& (!(usuario.getEmail()).contains(" "))) {
//
//				String nomeEmail = new String(email.substring(0,
//						email.lastIndexOf('@')));
//
//				String dominio = new String(email.substring(
//						email.lastIndexOf('@') + 1, email.length()));
//
//				if (!(nomeEmail.length() >= 1) && (!nomeEmail.contains("@"))
//						&& (dominio.contains(".com"))
//						&& (!dominio.contains("@"))
//						&& (dominio.indexOf(".com") >= 1)
//						&& (dominio.lastIndexOf(".com") < dominio.length() - 1)) {
//					valido = false;
//				} else {
//					valido = true;
//				}
//			} else {
//				valido = false;
//			}
//
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR NOME DA PESSOA FISICA
//	 * 
//	 * @param nome
//	 * @return
//	 */
//	public boolean validarNomePessoaFisica(String nome) {
//		boolean valido;
//
//		if (!nome.equals("")) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR SEXO DA PESSOA FISICA
//	 * 
//	 * @param genero
//	 * @return
//	 */
//	public boolean validarSexoPessoaFisica(String genero) {
//		boolean valido;
//		if (!genero.equals(" ")) {
//			valido = true;
//		} else {
//			valido = false ;
//		}
//		
//		return valido;
//	}
//
//	/**
//	 * VALIDAR TELEFONE FIXO DA PESSOA FISICA
//	 * 
//	 * @param telefoneFixo
//	 * @return
//	 */
//	public boolean validarTelefoneFixo(String telefoneFixo) {
//		boolean valido;
//		int tamanhoTelFixo = telefoneFixo.length();
//
//		if ((telefoneFixo != "") && (tamanhoTelFixo == 11)) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR TELEFONE CELULAR DA PESSOA FISICA
//	 * 
//	 * @param telefoneCelular
//	 * @return
//	 */
//	public boolean validarCelular(String telefoneCelular) {
//		boolean valido;
//		int tamanhoTelCelular = telefoneCelular.length();
//
//		if ((telefoneCelular != "") && (tamanhoTelCelular == 11)) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR CPF
//	 * @param cpf
//	 * @return
//	 */
//	public boolean validarCpf(String cpf) {
//		boolean valido;
//		int tamanhoCpf = cpf.length();
//
//		if ((cpf != "") && (tamanhoCpf == 11)) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR RG
//	 * @param rg
//	 * @return
//	 */
//	public boolean validarRg(String rg) {
//		boolean valido;
//		int tamanhoRg = rg.length();
//
//		if ((!rg.equals("")) && (tamanhoRg == 7)) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR RUA DO ENDERECO
//	 * 
//	 * @param rua
//	 * @return
//	 */
//	public boolean validarRua(String rua) {
//		boolean valido;
//
//		if (!rua.equals("")) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR NUMERO DO ENDERECO
//	 * 
//	 * @param numero
//	 * @return
//	 */
//	public boolean validarNumero(String numero) {
//		boolean valido;
//
//		if (!numero.equals("")) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR CEP
//	 * @param cep
//	 * @return
//	 */
//	public boolean validarCep(String cep) {
//		boolean valido;
//		int tamanhoCep = cep.length();
//		Pattern pattern = Pattern.compile("[0-9]");
//		Matcher matcher = pattern.matcher(cep);
//
//		if ((!cep.equals("")) && (tamanhoCep == 8) && (matcher.find())) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR BAIRRO
//	 * @param bairro
//	 * @return
//	 */
//	public boolean validarBairro(String bairro) {
//		boolean valido;
//		if (!bairro.equals("")){
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR CIDADE
//	 * 
//	 * @param rua
//	 * @return
//	 */
//	public boolean validarCidade(String cidade) {
//		boolean valido;
//
//		if (!cidade.equals("")) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//	/**
//	 * VALIDAR ESTADO
//	 * @param estado
//	 * @return
//	 */
//	public boolean validarEstado(String estado) {
//		boolean valido;
//
//		if (!estado.equals("")) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//	
//	/**
//	 *  VALIDAR CNPJ
//	 * 
//	 * @param cnpj
//	 * @return
//	 */
//	public boolean validarCnpj(String cnpj) {
//		int tamanhoCnpj = cnpj.length();
//		boolean valido;
//
//		if ((!cnpj.equals("")) && (tamanhoCnpj == 14)) {
//			valido = true;
//		} else {
//			valido = false;
//		}
//		return valido;
//	}
//
//}
