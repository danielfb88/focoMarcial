package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexão
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 14-09-2012
 * @version 1.0
 * 
 */
public class ConnectionFactory {

	/**
	 * Retorna objeto Connection para todo tipo de operação de BD.
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			
			String url = "jdbc:sqlite:core/db/focoMarcial.db";			

			conn = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e1) {
			e1.getMessage();
			e1.printStackTrace();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		return conn;
	}
}