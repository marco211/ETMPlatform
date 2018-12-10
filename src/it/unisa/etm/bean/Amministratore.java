package it.unisa.etm.bean;

import java.io.Serializable;

public class Amministratore implements Serializable	 {
	
	public Amministratore() {
		
	}

	public Amministratore(String cognome,  String nome, String email,String password) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public static Amministratore loginUtente(String email, String password) {
		return null;
	}
	
	public static void aggiungiUtente(Utente utente) {
		
	}

	private String cognome;
	private String nome;
	private String email;
	private String password;
}