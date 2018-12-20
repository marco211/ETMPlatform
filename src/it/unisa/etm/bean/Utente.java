package it.unisa.etm.bean;

import java.io.Serializable;
import java.sql.Date;

public class Utente implements Serializable	 {
	
	public Utente() {
		
	}
	
	

	public Utente(String cognome, Date dataDiNascita, String nome, String email, String password, String matricola) {
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.matricola = matricola;
	}



	public Utente(String cognome, Date dataDiNascita, String ufficio, String tipo, String nome,
			String email, String password, String insegnamento) {
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.ufficio = ufficio;
		this.tipo = tipo;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.insegnamento = insegnamento;
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


	public char getTipo() {
		return tipo;
	}


	public void setTipo(char tipo) {
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

<<<<<<< HEAD
=======
	
	
	public String getInsegnamento() {
		return insegnamento;
	}



	public void setInsegnamento(String insegnamento) {
		this.insegnamento = insegnamento;
	}



	public static Utente loginUtente(String email, String password) {
		return null;
	}
	
	public static void aggiungiUtente(Utente utente) {
		
	}

>>>>>>> a0ed1316c624eb141f4fc664fa7e7155e94da8f1
	private String cognome;
	private Date dataDiNascita;
	private String matricola;
	private String ufficio;
	private char tipo;
	private String nome;
	private String email;
	private String password;
	private String insegnamento;
}
