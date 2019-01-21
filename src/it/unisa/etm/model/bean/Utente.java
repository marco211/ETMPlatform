package it.unisa.etm.model.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable {
  
  private static final long serialVersionUID = 1L;

  public Utente() {
    this.insegnamento = new ArrayList<String>();
  }

  /**
   * Costruttore studente.
   */
  
  public Utente(String cognome, String dataDiNascita, String nome, 
      String tipo, String email, String password, String matricola2, String validazione) {
    this.cognome = cognome;
    this.dataDiNascita = dataDiNascita;
    this.nome = nome;
    this.tipo = tipo;
    this.email = email;
    this.password = password;
    this.matricola = matricola2;
    this.validazione = validazione;
  }

  /**
   * Costruttore docente.
   */
  public Utente(String cognome, String dataDiNascita, String ufficio, String tipo, String nome,
      String email, String password, String insegnamento, String validazione) {
    this.cognome = cognome;
    this.dataDiNascita = dataDiNascita;
    this.ufficio = ufficio;
    this.tipo = tipo;
    this.nome = nome;
    this.email = email;
    this.password = password;
    this.insegnamento = new ArrayList<String>();
    this.insegnamento.add(insegnamento);
    this.validazione = validazione;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getDataDiNascita() {
    return dataDiNascita;
  }

  public void setDataDiNascita(String dataDiNascita) {
    this.dataDiNascita = dataDiNascita;
  }

  public String getMatricola() {
    return matricola;
  }

  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }

  public String getUfficio() {
    return ufficio;
  }

  public void setUfficio(String ufficio) {
    this.ufficio = ufficio;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ArrayList<String> getInsegnamento() {
    return insegnamento;
  }

  public void setInsegnamento(String insegnamento) {
    this.insegnamento.add(insegnamento);
  }

  public int getPropostaTesi_Id() {
    return propostaTesiId;
  }

  public void setPropostaTesi_Id(int propostaTesiId) {
    this.propostaTesiId = propostaTesiId;
  }

  public void setValidazione(String validazione) {
    this.validazione = validazione;
  }

  public String getValidazione() {
    return validazione;
  }

  private String cognome;
  private String dataDiNascita;
  private String matricola;
  private String ufficio;
  private String tipo;
  private String nome;
  private String email;
  private String password;
  private int propostaTesiId;
  private ArrayList<String> insegnamento;
  private String validazione;
}
