package it.unisa.etm.bean;

import java.io.Serializable;

public class Attivita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Attivita() {
		
	}
	
	public Attivita(int valutazione, String descrizione) {
		super();
		this.valutazione = valutazione;
		this.descrizione = descrizione;
	}
	public int getValutazione() {
		return valutazione;
	}
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	private int valutazione;
	private String descrizione;
}
