package adotante.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import adotante.dominio.Pessoa;

public class PessoaDAO {

	public List<Pessoa> getListaPessoa(int id) {
		Connection conexao = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Conexao.abrirConceccaoMySQL();
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet", "root", "");
			statement = (Statement) conexao.createStatement();
			resultSet = statement.executeQuery("select id from pessoa where id='" + id + "'");
			List<Pessoa> listPessoa = new ArrayList<Pessoa>();

			if (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(resultSet.getInt("id"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setTelefoneCelular(resultSet.getString("telefoneCelular"));
				pessoa.setTelefoneFixo(resultSet.getString("telefoneFixo"));
				pessoa.setEmail(resultSet.getString("email"));
				pessoa.setMotivoImpedimento(resultSet.getString("motivoImpedimeto"));
				pessoa.setImpedimento(resultSet.getBoolean("impedimento"));
				//pessoa.setEndereco();

				listPessoa.add(pessoa);
			}
			Conexao.fecharConecaoMySQL();
			return listPessoa;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
