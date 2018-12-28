package it.unisa.etm.bean;

import java.io.Serializable;

public class Partecipa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Partecipa() {
		
	}
	
	public Partecipa(int propostaTesiId, String utenteEmail) {
		super();
		this.propostaTesiId = propostaTesiId;
		this.utenteEmail = utenteEmail;
	}
	
	public int getPropostaTesiId() {
		return propostaTesiId;
	}

	public void setPropostaTesiId(int propostaTesiId) {
		this.propostaTesiId = propostaTesiId;
	}

	public String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	private int propostaTesiId;
	private String utenteEmail;
}
