package it.unisa.etm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static DatabaseManager istanza=null;
	private static Connection connection;
	private DatabaseManager(){
		
	}
	
	public static synchronized DatabaseManager getIstance() throws SQLException {
		if(istanza==null) {
			istanza=new DatabaseManager();
			connection=createConnection();
		}
		return istanza;
	}
	
	public synchronized Connection getConnection() {
		return connection;
	}
	
	private static Connection createConnection() throws SQLException {
		String ip = "localhost";
		String port = "3306";
		String db = "ETM_PLATFORM";
		String username = "";//inserite la vostra username
		String password = "";//inserite la vostra password
		connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db + "?zeroDateTimeBehavior=convertToNull", username, password);
		System.out.println("**** Connessione creata con successo ****" + connection.toString() + "\n");
		return connection;
	}
}
