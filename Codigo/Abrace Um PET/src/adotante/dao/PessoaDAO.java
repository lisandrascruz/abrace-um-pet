package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import adotante.dominio.Pessoa;

public class PessoaDAO {
	/**
	 *  METODO RESPONSAVEL PELA ATUALIZAÇÃO DOS DADOS DE PESSOA 
	 * @param pessoa
	 * @throws Exception
	 */
	public void editarPessoa(Pessoa pessoa) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		
		con = Conexao.abrir();
		
		String queryPessoa = "UPDATE pessoa SET nome =?, idEndereco =?, telefoneFixo=?, "
				+ "telefoneCelular=?, email=? WHERE id=?";
		try {
			
			pst = (PreparedStatement) con.prepareStatement(queryPessoa,
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, pessoa.getNome());
			pst.setInt(2, pessoa.getEndereco().getId());
			pst.setString(3, pessoa.getTelefoneFixo());
			pst.setString(4, pessoa.getTelefoneCelular());
			pst.setString(5, pessoa.getEmail());
			pst.setInt(6, pessoa.getId());
			pst.executeUpdate();
			
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			throw new Exception("Erro ao atualizar pessoa", ex);
		} finally {
			Conexao.fechar(con, pst, generatedKeys);
		}
	}
}
