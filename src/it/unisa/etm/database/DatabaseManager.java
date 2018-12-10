package it.unisa.etm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseManager {
	
	private DatabaseManager(){
		log = Logger.getLogger("log");
	}
	
	public static Connection getIstance() throws SQLException {
		if(connection==null) createConnection();
		return connection;
	}
	

	
	private static void createConnection() throws SQLException {
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ETM_PLATFORM?zeroDateTimeBehavior=convertToNull", username, password);
		log.info("**** Connessione creata con successo ****\"\n");		
	}
	
	private static Connection connection = null;
	private static String username = "etm";//inserite la vostra username
	private static String password = "Etm1";//inserite la vostra password
	private static Logger log;
}
