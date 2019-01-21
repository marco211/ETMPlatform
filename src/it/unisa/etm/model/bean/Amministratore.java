package it.unisa.etm.model.bean;

import java.io.Serializable;

/**
 * Classe bean dell'amministratore, che rappresenta l'amministratore 
 * presente nel database.
 */

public class Amministratore implements Serializable {
  private static final long serialVersionUID = 1L;

  public Amministratore() {

  }
  
  /**
   * Costruttore.
   */
  
  public Amministratore(String email, String nome, String cognome, String password) {
    this.email = email;
    this.nome = nome;
    this.cognome = cognome;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String nome;
  private String cognome;
  private String email;
  private String password;
}
