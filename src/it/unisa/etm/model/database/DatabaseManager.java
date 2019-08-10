package it.unisa.etm.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class DatabaseManager {
  private static Connection connection = null;
  private static String username = "root";
  private static String password = "root";
  
  /**
 * Metodo per prendere l'istanza di una connesione al DB.
 * @return connection
 */
  
  public static Connection getIstance() throws SQLException {  
    if (connection == null) {
      try {
        createConnection();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  private static void createConnection() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");


    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
        + "ETM_PLATFORM?useUnicode=true&useJDBCCompliantTimezoneShift="
        + "true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
    Logger.getLogger("global").info("**** Connessione creata con successo **** " 
        + connection.toString() + "\n");
  }
}