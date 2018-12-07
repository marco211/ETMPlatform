package it.unisa.etm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseManager {
	private static Connection connection=null;
	private DatabaseManager(){
		
	}
	
	public static Connection getIstance() throws SQLException {
		if(connection==null) {
			createConnection();
		}
		return connection;
	}
	

	
	private static void createConnection() throws SQLException {
		String username = "etm";//inserite la vostra username
		String password = "Etm1";//inserite la vostra password
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ETM_PLATFORM?zeroDateTimeBehavior=convertToNull", username, password);
		Logger.getLogger("global").info("**** Connessione creata con successo **** " + connection.toString() + "\n");		
	}
}
