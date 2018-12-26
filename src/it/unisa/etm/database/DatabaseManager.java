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
			String password = "root";//inserite la vostra password
=======
			String password = "admin";//inserite la vostra password
>>>>>>> 470060ed932f92b7ebace9cb60c9fc75bf7dcbd4
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ETM_PLATFORM?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
			Logger.getLogger("global").info("**** Connessione creata con successo **** " + connection.toString() + "\n");		
		}
	}