package bd;

import java.sql.ResultSet;

public @interface Statement {

	ResultSet executeQuery(String string);

}
