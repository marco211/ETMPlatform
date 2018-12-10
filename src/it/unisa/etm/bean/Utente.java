package it.unisa.etm.bean;

import java.io.Serializable;
import java.sql.Date;

public class Utente implements Serializable	 {
	
	public Utente() {
		
	}
	
	

	public Utente(String cognome, Date dataDiNascita, String nome, String email,String password) {
		super();
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}



	public Utente(String cognome, Date dataDiNascita, String matricola, String ufficio, String tipo, String nome,
			String email, String password) {
		super();
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.matricola = matricola;
		this.ufficio = ufficio;
		this.tipo = tipo;
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


	public Date getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getUfficio() {
		return ufficio;
	}


	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public static Utente loginUtente(String email, String password) {
		return null;
	}

	private String cognome;
	private Date dataDiNascita;
	private String matricola;
	private String ufficio;
	private String tipo;
	private String nome;
	private String email;
	private String password;
}
