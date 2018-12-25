package it.unisa.etm.bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Attivita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Attivita() {

	}

	public Attivita(String utente_Email, String nomeFile, String data, String tipo, int propostatesi_id) {
		super();
		this.utente_Email = utente_Email;
		NomeFile = nomeFile;
		this.data = data;
		this.tipo = tipo;
		this.propostatesi_id = propostatesi_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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
		// TODO Auto-generated method stub
		//valutare bene il tipo, io farei un controllo, se non ricordo male serviva ad indicare se il file era stato caricato o eliminato.
		String t = "eliminato";
		if(tipo.equals("c"))
			t = "caricato";
		return "L'utente: "+utente_Email+" ha "+t+" il file: "+NomeFile+" il giorno: "+data+"";
	}

	private int id;
	private String utente_Email;
	private String NomeFile;
	private String data;
	private String tipo;
	private int propostatesi_id;

}
