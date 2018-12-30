package it.unisa.etm.bean;

import java.io.Serializable;

public class Ha implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Ha() {
		
	}
	
	public Ha(String utente_Email, int consegna_id, boolean stato) {
		super();
		this.utente_Email = utente_Email;
		this.consegna_id = consegna_id;
		this.stato = stato;
	}
	
	public String getUtente_Email() {
		return utente_Email;
	}
	
	public void setUtente_Email(String utente_Email) {
		this.utente_Email = utente_Email;
	}
	
	public int getConsegna_id() {
		return consegna_id;
	}
	
	public void setConsegna_id(int consegna_id) {
		this.consegna_id = consegna_id;
	}
	
	public boolean isStato() {
		return stato;
	}
	
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	private String utente_Email;
	private int consegna_id;
	private boolean stato;
}
