package it.unisa.etm.model.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Attivita implements Serializable{
	private static final long serialVersionUID = 1L;

	public Attivita() {

	}

	public Attivita(String utente_Email, String nomeFile, LocalDate data, String tipo, int propostatesi_id) {
		super();
		this.utente_Email = utente_Email;
		this.NomeFile = nomeFile;
		this.data = data;
		this.tipo = tipo;
		this.propostatesi_id = propostatesi_id;
	}

	public String getUtente_Email() {
		return utente_Email;
	}

	public void setUtente_Email(String utente_Email) {
		this.utente_Email = utente_Email;
	}

	public String getNomeFile() {
		return NomeFile;
	}

	public void setNomeFile(String nomeFile) {
		NomeFile = nomeFile;
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
		return propostatesi_id;
	}

	public void setPropostatesi_id(int propostatesi_id) {
		this.propostatesi_id = propostatesi_id;
	}

	@Override
	public String toString() {
		String t = null;
		if(tipo.equals("c"))
			t = "caricato";
		else if(tipo.equals("v"))
			t = "valutato";
		else t= "eliminato";
		return "L'utente: "+utente_Email+" ha "+t+" il file: "+NomeFile+" il giorno: "+data+"";
	}

	private int id;
	private String utente_Email;
	private String NomeFile;
	private LocalDate data;
	private String tipo;
	private int propostatesi_id;
}
