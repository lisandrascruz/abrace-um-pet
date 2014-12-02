package adocao.dao;

import infraestrutura.dao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import adocao.dominio.Adocao;

import com.mysql.jdbc.PreparedStatement;

public class AdocaoDAO {
	Conexao conexao = new Conexao();

	public boolean adicionarAdocao(Adocao adocao) {
		try {
			int id;
			Connection con = Conexao.abrirConceccaoMySQL();

			String query = "insert into adocao (idAnimal, idAdotante) values (?, ?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setInt(1, adocao.getAdotante().getId());
			preparedStatement.setInt(2, adocao.getAnimal().getId());

			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException(
							"Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();

			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
