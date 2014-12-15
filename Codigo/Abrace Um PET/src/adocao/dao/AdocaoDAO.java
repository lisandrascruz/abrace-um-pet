package adocao.dao;

import infraestrutura.dao.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import usuario.service.SessaoUsuario;
import adocao.dominio.Adocao;

import com.mysql.jdbc.PreparedStatement;

public class AdocaoDAO {
	Conexao	conexao	= new Conexao();
	SessaoUsuario sessao =SessaoUsuario.getInstancia();

	/**
	 * ADICIONA PESSOA NO BANCO DE DADOS
	 * 
	 * @param adocao
	 * @return
	 */
	public boolean adicionarAdocao(Adocao adocao) {
		try {
			Connection con = Conexao.abrirConceccaoMySQL();
			inserirAdocao(adocao, con);
			Conexao.fecharConecaoMySQL();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * INSERE ADOCAO NO BANCO
	 * 
	 * @param adocao
	 * @param con
	 * @return
	 */
	public int inserirAdocao(Adocao adocao, Connection con) {
		int id;
		String query = "insert into adocao (idAdotante, idAnimal,idUsuario) values (?, ?,?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setInt(1, adocao.getAdotante().getId());
			preparedStatement.setInt(2, adocao.getAnimal().getId());
			preparedStatement.setInt(3, sessao.getUsuarioLogado().getId());


			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
			preparedStatement.close();
		} catch (Exception ex) {
			return -1;
		}
		return id;
	}

}
