package bd;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {

	Conexao conexao = new Conexao();
	Statement consulta = null;
	ResultSet tabela = null;

	public void openConnection() throws SQLException {
		conexao.obtemConexao();
	}

	public void close() throws SQLException {
		conexao.obtemConexao().close();
	}

	public void inserir() {

	}

	public void consultarAnimal() {
	}

	public void consultarAdotanteFisico() {
	}

	public void consultaAdotanteJuridico() {
	}

	public void editar() {

	}

	public void remover() {

	}
}
