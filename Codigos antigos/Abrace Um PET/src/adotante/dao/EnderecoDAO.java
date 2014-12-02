package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import adotante.dominio.Endereco;

/**
 * RETORNA UMA LISTA COM TODOS OS ENDERECOS PRESENTES NO BD
 * @author Lisandra Cruz
 */
public class EnderecoDAO {
	
	public List<Endereco> getListaEndereco() {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery("select * from endereco");
			List<Endereco> enderecos = new ArrayList<Endereco>();

			while (resultSet.next()) {

				Endereco endereco = new Endereco();
				endereco.setId(resultSet.getInt("id"));
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getString("numero"));
				endereco.setCep(resultSet.getString("complemento"));
				endereco.setCep(resultSet.getString("cep"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setEstado(resultSet.getString("estado"));

				enderecos.add(endereco);
			}
			Conexao.fecharConecaoMySQL();
			return enderecos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
