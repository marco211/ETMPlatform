package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.model.bean.Notifica;

import it.unisa.etm.model.database.DatabaseManager;
import it.unisa.etm.model.interfaces.NotificheModelInterface;

public class NotificheManager implements NotificheModelInterface {
  
  String utente, titolo, nomefile;
  
  
  String [] tipo = {utente+" ha aggiunto il file con titolo: "+nomefile, utente+" ha aggiunto una nuova proposta di tesi con titolo: "+titolo, utente+" ha inviato una richiesta alla proposta di tesi con titolo: "+titolo, utente+" ha accettato la richiesta alla proposta di tesi con titolo: "+titolo, utente+" ha rifiutato la richista di proposta di testi con titolo: "+titolo, utente+" ha chiuso la proposta di tesi con titolo:", utente+" ha archiviato la proposta di testi con titolo: "+titolo, utente+" ha modificato il titolo della proposta tesi con : "+titolo};
  
  @Override
  public int inserisciNotifica(Notifica notifica) {
    // TODO Auto-generated method stub
    String sql = "Insert into Notifica(propostaTesi_id,tipo,nomeFile) values (?,?,?)";
    
    Connection connection = null;
    PreparedStatement ps = null;

    UtenteManager utenteManager = new UtenteManager();
    
    String nomeUtente = utenteManager.getInfo(notifica.getUtenteEmail()).getCognome() + " "+ utenteManager.getInfo(notifica.getUtenteEmail()).getNome();
    
    utente = nomeUtente;    
    
    
    try {
      connection = DatabaseManager.getIstance();
      ps = connection.prepareStatement(sql); 
      
      ps.setInt(1, notifica.getPropostaTesiId());
      
      if(notifica.getTipo().equals("ModificaFilePropostaTesi")) {
        nomefile = notifica.getNomeFile();
        ps.setString(3, nomefile);
        ps.setString(2, tipo[1]);
      } else {
        
        ps.setString(3, null);
        
       if(notifica.getTipo().equals("newPropostaTesi")){

          
          ps.setString(2, tipo[2]);

        } else if(notifica.getTipo().equals("richiestaPropostaTesi")) {
         
          ps.setString(2, tipo[3]);

        } else if(notifica.getTipo().equals("richiestaAccettata")) {
        
          ps.setString(2, tipo[4]);

        }else if(notifica.getTipo().equals("richiestaRifiutata")) {
        
          ps.setString(2, tipo[5]);

        }else if(notifica.getTipo().equals("PropostaTesiChiusa")) {
      
          ps.setString(2, tipo[6]);

        } else if(notifica.getTipo().equals("PropostaTesiArchiviata")) {

          ps.setString(2, tipo[7]);

        } else if(notifica.getTipo().equals("ModificaTitoloPropostaTesi")) {
    
          ps.setString(2, tipo[8]);

        }
      }
      if (ps.executeUpdate() < 1) {
        ResultSet rs = ps.getGeneratedKeys();
        
        return rs.getInt(1);
      }
      return -1;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return -1;
    }
    
  }

  @Override
  public boolean associaNotifica(Notifica notifica, String utenteRicevente) {
    // TODO Auto-generated method stub
    
    Connection connection = null;
    PreparedStatement ps = null;
    
    String sql = "Insert into AssociaNotifica(Id_Notifica,Utente_Email, letto) values (?,?,?)";
    

      try {
        connection = DatabaseManager.getIstance();
        ps = connection.prepareStatement(sql); 
        
        ps.setInt(1, notifica.getId());
        ps.setString(2, utenteRicevente);
        ps.setBoolean(3, false);
        
        if (ps.executeUpdate() < 1) {
          return false;
        }
        
        return true;
        
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
      }
      
    

  }

  @Override
  public boolean disabilitaAbilitaNotificheProposteTesi(String utenteEmail, boolean bool) {
    // TODO Auto-generated method stub
    Connection connection = null;
    PreparedStatement ps = null;
    
    String sql = "UPDATE gestioneNotifiche SET PropostaTesiNotifica ="+bool+"where Utente_Email ="+utenteEmail;
    

      try {
        connection = DatabaseManager.getIstance();
        ps = connection.prepareStatement(sql); 
        
        
        
        if (ps.executeUpdate() < 1) {
          return false;
        }
        
        return true;
        
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
      }
  }

  @Override
  public boolean disabilitaAbilitaNotificheSeguaci(String utenteEmail, boolean bool) {
    // TODO Auto-generated method stub
    Connection connection = null;
    PreparedStatement ps = null;
    
    String sql = "UPDATE gestioneNotifiche SET FollowerNotifica ="+bool+"where Utente_Email ="+utenteEmail;
    

      try {
        connection = DatabaseManager.getIstance();
        ps = connection.prepareStatement(sql); 
        
        
        
        if (ps.executeUpdate() < 1) {
          return false;
        }
        
        return true;
        
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return false;
      }
  }

  @Override
  public ArrayList<Notifica> getNotificheByUser(String utenteEmail) {
    // TODO Auto-generated method stub
    
    String sql = "SELECT Id_Notifica FROM AssociaNotifica where Utente_Email = "+utenteEmail;
    Connection connection = null;
    PreparedStatement ps = null;

    ArrayList<Notifica> notifiche = null;
    ArrayList<Integer> idNotifiche = null;
    
    
    try {
      connection = DatabaseManager.getIstance();
      ps = connection.prepareStatement(sql);
      ResultSet rs = ps.executeQuery(sql);
      notifiche = new ArrayList<Notifica>();
      idNotifiche = new ArrayList<Integer>();
      
      while(rs.next()) {
        
        idNotifiche.add(rs.getInt(1));
        
      }
      
      
      for(int i =0; i<idNotifiche.size(); i++) {
        
        int id= idNotifiche.get(i);
        
        
       notifiche.add(this.getNotifica(id));
        
        
        
        
      }
      
      return notifiche;
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      
      return null;
    }

  
  }
  
  public Notifica getNotifica(int id) {
    
    String sql = "SELECT propostaTesi_id,tipo,nomeFile FROM Notifica where id = ?";
    Connection connection = null;
    PreparedStatement ps = null;
    Notifica notifica = null;

    
    try {
      connection = DatabaseManager.getIstance();
      ps = connection.prepareStatement(sql);
      
      ps.setInt(1, id);
      
      notifica = new Notifica();
      
      ResultSet rs = ps.executeQuery(sql);
      
      notifica.setId(id);
      notifica.setPropostaTesiId(rs.getInt(1));
      notifica.setTipo(rs.getString(2));
      notifica.setNomeFile(rs.getString(3));
      
      return notifica;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }

  
    
  }

  @Override
  public int getNumNotificheDaLeggere(String utenteEmail) {
    // TODO Auto-generated method stub
    
    String sql = "SELECT count(letto) FROM  AssociaNotifica where Utente_Email ="+utenteEmail;
    Connection connection = null;
    PreparedStatement ps = null;
    
    try {
      connection = DatabaseManager.getIstance();
      ps = connection.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery(sql);
      
      return rs.getInt(1);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      
      return -1;
    }
    

  }
  
  
  
  
  
  

}
