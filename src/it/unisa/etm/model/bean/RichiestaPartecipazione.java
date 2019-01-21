package it.unisa.etm.model.bean;

import java.time.LocalDate;

public class RichiestaPartecipazione {

  public RichiestaPartecipazione() {

  }

  /**
   * Costruttore.
   */
  
  public RichiestaPartecipazione(LocalDate data, int propostaTesiId, String utenteEmail) {
    super();
    this.data = data;
    this.propostaTesiId = propostaTesiId;
    this.utenteEmail = utenteEmail;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public int getPropostatesi_id() {
    return propostaTesiId;
  }

  public void setPropostatesi_id(int propostaTesiId) {
    this.propostaTesiId = propostaTesiId;
  }

  public String getUtente_mail() {
    return utenteEmail;
  }

  public void setUtente_mail(String utenteEmail) {
    this.utenteEmail = utenteEmail;
  }

  private int id;
  private LocalDate data;
  private int propostaTesiId;
  private String utenteEmail;
}
