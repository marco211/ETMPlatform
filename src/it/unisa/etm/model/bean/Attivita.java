package it.unisa.etm.model.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Attivita implements Serializable {
  private static final long serialVersionUID = 1L;

  public Attivita() {
    super();
    tipo = null;
    propostaTesiId = -10;
  }

  /**
   * Costruttore.
   */
  
  public Attivita(String utenteEmail, String nome, LocalDate data, 
      String tipo, int propostaTesiId) {
    super();
    this.utenteEmail = utenteEmail;
    this.nome = nome;
    this.data = data;
    this.tipo = tipo;
    if(propostaTesiId != -10) this.propostaTesiId = propostaTesiId;
    letto = false;
  }

  public String getUtente_Email() {
    return utenteEmail;
  }

  public void setUtente_Email(String utenteEmail) {
    this.utenteEmail = utenteEmail;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public boolean getLetto() {
    return letto;
  }
  
  public void setLetto(boolean l) {
    letto = l;
  }
  
  /**
   * af, ef, vf (aggiunto file, valutato file, caricato file)
   * at, mt, dt (aggiunta tesi, modificato tesi, disabilitato tesi)
   * Primo carattere indica l'operazione, secondo indica su dove viene effettuata
   */
  @Override
  public String toString() {
    
    
    if(!tipo.equals(null)) {
      char[] toDo = {tipo.charAt(0), tipo.charAt(1)}; 
      if (toDo[1] == 'f') {
        // operation to a file
        
        if(toDo[0] == 'a') {
          return "L'utente " + utenteEmail + " ha aggiunto il file: " + 
              nome + " il giorno: " + data + "";
        } else if(toDo[0] == 'e') {
          return "L'utente " + utenteEmail + " ha eliminato il file: " + 
              nome + " il giorno: " + data + "";
        } else if(toDo[0] == 'v') {
          return "Il docente " + utenteEmail + " ha valutato il file: " + 
              nome + " il giorno: " + data + "";
        } else return "";
        
      } else if (toDo[1] == 't') {
        // operation to a thesis
        
        if(toDo[0] == 'a') {
          return "Il docente " + utenteEmail + " ha aggiunto una nuova proposta tesi: " + 
              nome + "! Scoprila ora! Data: " + data;
        } if(toDo[0] == 'm') {
          return "Il docente " + utenteEmail + " ha modificato la tesi " + nome + "! Vedi le modifiche! Data: " + data;
        } else return "";
        
      } else {
        return "";
      }
      
      
    }else return "";
    
    
    
    
  }

  private int id;
  private String utenteEmail;
  private String nome;
  private LocalDate data;
  private String tipo;
  private int propostaTesiId;
  private boolean letto;
}
