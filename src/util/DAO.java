package util;

import java.sql.Connection;

import util.ConnectionFactory;

public abstract class DAO {
	private Connection conn = null;
	
	protected Connection getConnection() {
		if (conn == null)
			conn = ConnectionFactory.getConnection();
		return conn;
	}

}
