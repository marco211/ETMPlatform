package it.unisa.etm.model.manager;

import it.unisa.etm.model.bean.Amministratore;
import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AttivitaModelInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hamcrest.core.IsInstanceOf;

/**
 * Classe che implementa le funzionalita dedicate alle attivita effettuate da 
 * parte degli utenti che fanno parte di un'area privata condivisa.
 * @author ETM
 *
 */

public class AttivitaManager implements AttivitaModelInterface {

  /**
   * Indica che qualcosa � avvenuto. Si aggiunge l'attivit� nel database e si notifica chi di dovere, in 
   * base al tipo di attivit�
   */
  @Override
  public boolean aggiungiAttivita(Attivita attivita) {
    String sql = "INSERT INTO ATTIVITA (ID, UTENTE_EMAIL,NOME,"
        + "DATA,TIPO,PROPOSTATESI_ID) VALUES (NULL, ?,?,?,?,?)";

    int id = -1;
    String tipo = attivita.getTipo(); // will be used to notificate users later
    int id_tesi = attivita.getPropostatesi_id();

    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

      prepared.setString(1, attivita.getUtente_Email());
      prepared.setString(2, attivita.getNome());
      prepared.setDate(3, java.sql.Date.valueOf(attivita.getData()));
      prepared.setString(4, tipo);
      prepared.setInt(5, id_tesi);
      prepared.executeUpdate();


      // ottengo l'id inserito
      rs = prepared.getGeneratedKeys();
      rs.next();
      id = rs.getInt(1);



      prepared.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }



    try {
      ArrayList<String> usersToNotificate = new ArrayList<>();


      char[] toDo = {tipo.charAt(0), tipo.charAt(1)}; 
      if (toDo[1] == 'f') {
        // operation to a file, should be notificated all the partecipating users  
        // query by thesis id

        prepared = connection.prepareStatement("SELECT EMAIL FROM UTENTE WHERE PROPOSTATESI_ID = ?");
        prepared.setInt(1, id_tesi);

        rs = prepared.executeQuery();

        while(rs.next()) {
          usersToNotificate.add(rs.getString(1));
        }
      } else if (toDo[1] == 't') {
        // operation to a thesis, should be notificated all the follower users  
        // query by user following

        // adding thesis, checking if the user want to be notified on the adding of a thesis
        if(toDo[0] == 'a') {
          prepared = connection.prepareStatement("SELECT UTENTE_EMAIL_SEGUACE FROM UTENTESEGUEUTENTE "
              + "WHERE UTENTE_EMAIL_SEGUITO = ? AND SEGUEAGGIUNTAPROPOSTATESI = 1");

          // modifying thesis, checking if the user want to be notified or not
        } else if(toDo[0] == 'm') {
          prepared = connection.prepareStatement("SELECT UTENTE_EMAIL_SEGUACE FROM UTENTESEGUEUTENTE "
              + "WHERE UTENTE_EMAIL_SEGUITO = ? AND SEGUEMODIFICAPROPOSTATESI = 1");

          // disabilitating thesis, checking if the user want to be notified on this
        } else if(toDo[0] == 'd') {
          prepared = connection.prepareStatement("SELECT UTENTE_EMAIL_SEGUACE FROM UTENTESEGUEUTENTE "
              + "WHERE UTENTE_EMAIL_SEGUITO = ? AND SEGUEAGGIUNTAPROPOSTATESI = 1");
        }

        prepared.setString(1, attivita.getUtente_Email());
        rs = prepared.executeQuery();

        while(rs.next()) {
          usersToNotificate.add(rs.getString(1));
        }
      }

      prepared = connection.prepareStatement("INSERT INTO ATTIVITANOTIFICATAUTENTE (IDATTIVITA, UTENTE_EMAIL, "
          + "LETTO) VALUES (?,?,?)");

      for(String email: usersToNotificate) {
        prepared.setInt(1, id);
        prepared.setString(2, email);
        prepared.setBoolean(3, false);
        prepared.executeUpdate();
      }

      prepared.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  @Override
  public ArrayList<Attivita> getListaAttivita(int propostaTesiId) {
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement("SELECT * FROM ATTIVITA WHERE PROPOSTATESI_ID=?");
      prepared.setInt(1, propostaTesiId);
      rs = prepared.executeQuery();
      ArrayList<Attivita> list = new ArrayList<Attivita>();
      while (rs.next()) {
        Attivita attivita = new Attivita();
        attivita.setUtente_Email(rs.getString("UTENTE_EMAIL"));
        attivita.setNome(rs.getString("NOME"));
        attivita.setData(rs.getDate("DATA").toLocalDate());
        attivita.setTipo(rs.getString("TIPO"));
        attivita.setPropostatesi_id(propostaTesiId);
        list.add(attivita);
      }
      prepared.close();
      rs.close();
      return list;
    } catch (SQLException e) {
      return null;
    }

  }

  /**
   * Getnotifiche()
   */
  @Override
  public ArrayList<Attivita> getNotifiche(String email) {
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement("SELECT * FROM ATTIVITANOTIFICATAUTENTE, ATTIVITA WHERE "
          + "ATTIVITANOTIFICATAUTENTE.UTENTE_EMAIL=? AND "
          + "ATTIVITA.ID = ATTIVITANOTIFICATAUTENTE.IDATTIVITA "
          + "ORDER BY DATA DESC");
      prepared.setString(1, email);
      rs = prepared.executeQuery();
      ArrayList<Attivita> list = new ArrayList<Attivita>();
      String emailOfMaker;
      Attivita attivita;

      int countNonLetti = 0;

      while (rs.next()) {
        emailOfMaker = rs.getString("ATTIVITA.UTENTE_EMAIL");
        if(!email.equals(emailOfMaker)) {
          attivita = new Attivita();

          attivita.setUtente_Email(emailOfMaker);
          attivita.setNome(rs.getString("NOME"));
          attivita.setData(rs.getDate("DATA").toLocalDate());

          attivita.setTipo(rs.getString("TIPO"));
          attivita.setLetto(rs.getBoolean("LETTO"));
          attivita.setPropostatesi_id(rs.getInt("PROPOSTATESI_ID"));
          list.add(attivita);


        }
      }

      prepared.close();
      rs.close();
      return list;
    } catch (SQLException e) {
      return null;
    }
  }

  //setting a bit of readed notification
  public boolean leggiNotifiche(String email) {
    try {

      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement("UPDATE ATTIVITANOTIFICATAUTENTE SET Letto = 1 WHERE UTENTE_EMAIL=?");
      prepared.setString(1, email);
      prepared.executeUpdate();

      return true;
    } catch(SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public ArrayList<String> getListaSeguaci(String email) {
    
    
    
    
    ArrayList<String> utentiSeguiti = new ArrayList<String>();

    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement("SELECT Utente_Email_Seguito FROM UtenteSegueUtente WHERE "
          + "Utente_Email_Seguace=?");
      
        prepared.setString(1, email);

      rs = prepared.executeQuery();
      
      while(rs.next()) {
        
        String emailS = rs.getString("Utente_Email_Seguito");
        
        utentiSeguiti.add(emailS);
        
      }
      
      return utentiSeguiti;

    }
    catch (SQLException e) {
      return null;
    }

 

  }


  private Connection connection;
  private PreparedStatement prepared;
  private ResultSet rs;
}
