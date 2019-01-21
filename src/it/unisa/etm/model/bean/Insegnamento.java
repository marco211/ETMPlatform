package it.unisa.etm.model.bean;

import java.io.Serializable;

public class Insegnamento implements Serializable {
  private static final long serialVersionUID = 1L;

  public Insegnamento() {

  }

  public Insegnamento(String nome, int cfu) {
    this.nome = nome;
    this.cfu = cfu;
  }

  public int getCfu() {
    return cfu;
  }

  public void setCfu(int cfu) {
    this.cfu = cfu;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  private int cfu;
  private String nome;
}
