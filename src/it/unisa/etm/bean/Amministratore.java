package it.unisa.etm.bean;

import java.io.Serializable;

/**
 * Classe bean dell'amministratore, che rappresenta l'amministratore presente nel database
 *
 */

public class Amministratore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Amministratore() {
		
	}
	
	public Amministratore(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String nome, cognome, email;
}