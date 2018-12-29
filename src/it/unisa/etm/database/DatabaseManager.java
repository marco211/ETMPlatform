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
				try {
					createConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return connection;
		}
		
		private static void createConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			String username = "root";//inserite la vostra username
<<<<<<< HEAD
			String password = "admin";//inserite la vostra password
=======
<<<<<<< HEAD
			String password = "root";//inserite la vostra password
=======
			String password = "854621abC";//inserite la vostra password
>>>>>>> 40a049c5c7004d0e79b7a662fdb6905c33a7e8c6
>>>>>>> da11c10ed6d9b487fd73a7ecb6b561f34a528121
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ETM_PLATFORM?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
			Logger.getLogger("global").info("**** Connessione creata con successo **** " + connection.toString() + "\n");		
		}
	}