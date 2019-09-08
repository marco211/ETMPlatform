package it.unisa.etm.model.bean;

public class Notifica {
  
  private int id, propostaTesiId;
  private String utenteEmail, tipo, nomeFile;
  
  public int getPropostaTesiId() {
    return propostaTesiId;
  }

  public void setPropostaTesiId(int propostaTesiId) {
    this.propostaTesiId = propostaTesiId;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


  public Notifica () {
    
  }
  
  public Notifica(int id, String utenteEmail, int propostaTesiId,String tipo, String nomeFile) {
    
    this.id = id;
    this.utenteEmail = utenteEmail;
    this.nomeFile = nomeFile;
    this.propostaTesiId = propostaTesiId;
    this.tipo = tipo;
    
    
  }

  public String getNomeFile() {
    return nomeFile;
  }

  public void setNomeFile(String nomeFile) {
    this.nomeFile = nomeFile;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUtenteEmail() {
    return utenteEmail;
  }

  public void setUtenteEmail(String utenteEmail) {
    this.utenteEmail = utenteEmail;
  }


}
