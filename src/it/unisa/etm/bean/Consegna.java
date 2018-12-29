package it.unisa.etm.bean;

import java.io.Serializable;

public class Consegna implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Consegna() {
		
	}
	
	public Consegna(String nome, String descrizione, String scadenza, int propostaId) {
		this.nome=nome;
		this.descrzione=descrizione;
		this.scadenza=scadenza;
		this.setPropostaTesiId(propostaId);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrzione() {
		return descrzione;
	}
	public void setDescrzione(String descrzione) {
		this.descrzione = descrzione;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	


	public int getPropostaTesiId() {
		return propostaTesiId;
	}

	public void setPropostaTesiId(int propostaTesiId) {
		this.propostaTesiId = propostaTesiId;
	}



	private int id;
	private String nome;
	private String descrzione;
	private String scadenza;
	private int propostaTesiId;

}
