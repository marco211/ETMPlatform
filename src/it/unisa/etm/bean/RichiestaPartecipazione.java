package it.unisa.etm.bean;

import java.time.LocalDate;
import java.util.ArrayList;

public class RichiestaPartecipazione {
	public RichiestaPartecipazione() {
		
	}
	public RichiestaPartecipazione(LocalDate data, int propostatesi_id, String utente_mail) {
		super();
		this.data = data;
		this.propostatesi_id = propostatesi_id;
		this.utente_mail = utente_mail;
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
		return propostatesi_id;
	}
	public void setPropostatesi_id(int propostatesi_id) {
		this.propostatesi_id = propostatesi_id;
	}
	public String getUtente_mail() {
		return utente_mail;
	}
	public void setUtente_mail(String utente_mail) {
		this.utente_mail = utente_mail;
	}

	private int id;
	private LocalDate data;
	private int propostatesi_id;
	private String utente_mail;

}
