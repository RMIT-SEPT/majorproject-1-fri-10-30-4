package dbtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection { 

	private static final String DB_URL = "jdbc:hsqldb:hsql://18.223.0.77/majorprojectdb";
	private static final String DB_USER = "SA";
	private static final String DB_PASSWORD = ""; // Currently no password.

	public static void main(String[] args) {
		System.out.println("test");
	}
	
	/**
	 * Use this method to create new connections into the database.
	 * 
	 * @return A new SQL connection object to the database. Remember to close with
	 *         closeDBConnection().
	 */
	public static Connection getNewDBConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			// TODO: Expand on this error. Make sure it gets logged once we have a proper
			// logging setup.
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Use this method to close SQL connection objects. Using this method allows
	 * future tracking of SQL connections.
	 * 
	 * @param connection SQL connection object to close.
	 * @return Success of closing the connection. True if already closed and on
	 *         close success, false on SQLException.
	 */
	public static boolean closeDBConnection(Connection connection) {
		boolean result = true;
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
