package it.unisa.etm.model.manager;

import it.unisa.etm.model.bean.Consegna;
import it.unisa.etm.model.database.DatabaseManager;
import it.unisa.etm.model.interfaces.ConsegnaModelInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe che implementa le funzionalit� dedicate alle consegne di un'area privata condivisa.
 * @author ETM
 *
 */

public class ConsegnaManager implements ConsegnaModelInterface {
  public ConsegnaManager() {

  }

  @Override
  public boolean aggiungiConsegna(Consegna consegna) {
    String selectSql = "INSERT INTO CONSEGNA (SCADENZA, NOME, DESCRIZIONE, PROPOSTATESI_ID)"
        + " VALUES (?,?,?,?)";
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement(selectSql);  
      prepared.setString(1, consegna.getScadenza());
      prepared.setString(2, consegna.getNome());
      prepared.setString(3, consegna.getDescrzione());
      prepared.setInt(4, consegna.getPropostaTesiId());
      prepared.executeUpdate();
      prepared.close();
    } catch (SQLException e) {
      return false;
    }

    return true;
  }

  @Override
  public boolean modificaConsegna(String scadenza, int id) {
    Consegna consegna = this.getConsegna(id);
    if (consegna == null) {
      return false;
    }
      
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement("UPDATE CONSEGNA SET Scadenza=? Where Id=?");
      prepared.setString(1, scadenza);
      prepared.setInt(2, id);
      prepared.executeUpdate();
      prepared.close();
    } catch (SQLException e) {
      return false;
    }
    return true;
  }


  @Override
  public boolean eliminaConsegna(int id) {
    if (this.getConsegna(id) == null) {
      return false;
    }   

    String selectSql = "DELETE FROM Consegna WHERE ID=?";
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement(selectSql);
      prepared.setInt(1, id);
      prepared.executeUpdate();
      prepared.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public Consegna getConsegna(int id) {
    if (id <= 0) {
      return null;
    }

    String selectSql = "SELECT * FROM CONSEGNA WHERE ID=?";
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement(selectSql);
      prepared.setInt(1, id);
      rs = prepared.executeQuery();
      rs.next();
      Consegna consegna = new Consegna();
      consegna.setNome(rs.getString("NOME"));
      consegna.setDescrzione(rs.getString("DESCRIZIONE"));
      consegna.setId(rs.getInt("ID"));
      consegna.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
      consegna.setScadenza(rs.getString("SCADENZA"));
      prepared.close();
      rs.close();
      return consegna;
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public ArrayList<Consegna> getListaConsegne(int propostaTesiId) {
    if (propostaTesiId < 0) {
      return null;
    }

    String selectSql = "SELECT * FROM CONSEGNA "
        + "WHERE PROPOSTATESI_ID=?";
    try {
      connection = DatabaseManager.getIstance();
      prepared = connection.prepareStatement(selectSql);
      prepared.setInt(1, propostaTesiId);
      rs = prepared.executeQuery();
      ArrayList<Consegna> list = new ArrayList<Consegna>();
      while (rs.next()) {
        Consegna consegna = new Consegna();
        consegna.setNome(rs.getString("NOME"));
        consegna.setDescrzione(rs.getString("DESCRIZIONE"));
        consegna.setId(rs.getInt("ID"));
        consegna.setPropostaTesiId(propostaTesiId);
        consegna.setScadenza(rs.getString("SCADENZA"));
        list.add(consegna);
      }
      prepared.close();
      rs.close();
      return list;
    } catch (Exception e) {
      return null;
    }
  }

  private ResultSet rs;
  private Connection connection = null;
  private PreparedStatement prepared = null;
}
