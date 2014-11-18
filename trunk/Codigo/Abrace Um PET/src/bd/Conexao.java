package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexao {
 
    // Carrega driver JDBC
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
 
    //Obtem conexao com banco de dados
    public Connection obtemConexao() throws SQLException{
    	Connection conn = null;
    	conn = DriverManager.getConnection("jdbc:mysql://localhost/abrace_um_pet","root","");
        return conn;
    }

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
