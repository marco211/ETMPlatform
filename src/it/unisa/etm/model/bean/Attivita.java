package it.unisa.etm.model.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Attivita implements Serializable {
  private static final long serialVersionUID = 1L;

  public Attivita() {

  }

  /**
   * Costruttore.
   */
  
  public Attivita(String utenteEmail, String nomeFile, LocalDate data, 
      String tipo, int propostaTesiId) {
    super();
    this.utenteEmail = utenteEmail;
    this.nomeFile = nomeFile;
    this.data = data;
    this.tipo = tipo;
    this.propostaTesiId = propostaTesiId;
  }

  public String getUtente_Email() {
    return utenteEmail;
  }

  public void setUtente_Email(String utenteEmail) {
    this.utenteEmail = utenteEmail;
  }

  public String getNomeFile() {
    return nomeFile;
  }

  public void setNomeFile(String nomeFile) {
    this.nomeFile = nomeFile;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public int getPropostatesi_id() {
    return propostaTesiId;
  }

  public void setPropostatesi_id(int propostaTesiId) {
    this.propostaTesiId = propostaTesiId;
  }

  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    String t = null;
    if (tipo.equals("c")) {
      t = "caricato";
    } else if (tipo.equals("v")) {
      t = "valutato";
    } else {
      t = "eliminato";
    }
    return "L'utente: " + utenteEmail + " ha " + t + " il "
        + "file: " + nomeFile + " il giorno: " + data + "";
  }

  private int id;
  private String utenteEmail;
  private String nomeFile;
  private LocalDate data;
  private String tipo;
  private int propostaTesiId;
}
