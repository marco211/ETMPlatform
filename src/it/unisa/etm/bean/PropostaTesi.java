package it.unisa.etm.bean;

import java.io.Serializable;


public class PropostaTesi implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PropostaTesi() {
		
	}
	
	
	
	public PropostaTesi(String titolo, String ambito, int tempoDiSviluppo, String materie, String decrizione, int id,
			String utenteEmail, boolean chiuso, boolean archiviato) {
		super();
		this.titolo = titolo;
		this.ambito = ambito;
		this.tempoDiSviluppo = tempoDiSviluppo;
		this.materie = materie;
		this.decrizione = decrizione;
		this.id = id;
		this.utenteEmail = utenteEmail;
		this.chiuso = chiuso;
		this.archiviato = archiviato;
	}

	

	public String getTitolo() {
		return titolo;
	}



	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}



	public String getAmbito() {
		return ambito;
	}



	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}



	public int getTempoDiSviluppo() {
		return tempoDiSviluppo;
	}



	public void setTempoDiSviluppo(int tempoDiSviluppo) {
		this.tempoDiSviluppo = tempoDiSviluppo;
	}



	public String getMaterie() {
		return materie;
	}



	public void setMaterie(String materie) {
		this.materie = materie;
	}



	public String getDecrizione() {
		return decrizione;
	}



	public void setDecrizione(String decrizione) {
		this.decrizione = decrizione;
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



	public boolean isChiuso() {
		return chiuso;
	}



	public void setChiuso(boolean chiuso) {
		this.chiuso = chiuso;
	}



	public boolean isArchiviato() {
		return archiviato;
	}



	public void setArchiviato(boolean archiviato) {
		this.archiviato = archiviato;
	}



	private String titolo;
	private String ambito;
	private int tempoDiSviluppo;
	private String materie;
	private String decrizione;
	private int id;
	private String utenteEmail;
	private boolean chiuso;
	private boolean archiviato;

}
