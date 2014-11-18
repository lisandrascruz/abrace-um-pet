package adotante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import adotante.adotante.PessoaFisica;

public class AdotanteFisicoDAO {

	public void inserir(Connection conn, PessoaFisica pessoaFisica) {

		String sqlInsert = "INSERT INTO pessoafisica(rg, cpf, genero, idAdotante) VALUES (?,?,?,?)";

		PreparedStatement stm = null;
		try {

			stm = conn.prepareStatement(sqlInsert);

			stm.setString(1, pessoaFisica.getRg());
			stm.setString(2, pessoaFisica.getCpf());
			stm.setLong(3, pessoaFisica.getGenero());
			stm.setInt(4, pessoaFisica.getAdotante().getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
}
