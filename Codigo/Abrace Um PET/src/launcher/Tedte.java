package launcher;

import java.sql.Connection;
import java.sql.SQLException;

import infraestrutura.dao.Conexao;
import adotante.dao.PessoaFisicaDAO;
import adotante.dominio.PessoaFisica;

public class Tedte {
	public static void main(String[] args) {
		PessoaFisicaDAO pfd = new PessoaFisicaDAO();
		PessoaFisica pessoaFisica = new PessoaFisica();
		//Conexao	conexao	= new Conexao();
		Connection con = null;
		try {
			con = Conexao.abrirConceccaoMySQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pfd.inserirEndereco(pessoaFisica, con);
	}
}
