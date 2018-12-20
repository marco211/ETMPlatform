package it.unisa.etm.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Utente implements Serializable	 {
	
	public Utente() {
		
	}
	
	
	//studente
	public Utente(String cognome, Date dataDiNascita, String nome, char tipo, String email, String password, long matricola2) {
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.nome = nome;
		this.tipo = tipo;
		this.email = email;
		this.password = password;
		this.matricola = matricola2;
	}

	//docente
	public Utente(String cognome, Date dataDiNascita, String ufficio, char tipo, String nome,
			String email, String password, String insegnamento) {
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.ufficio = ufficio;
		this.tipo = tipo;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.insegnamento.add(insegnamento);
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


	public long getMatricola() {
		return matricola;
	}


	public void setMatricola(long matricola) {
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
	
	
	public ArrayList<String> getInsegnamento() {
		return insegnamento;
	}



	public void setInsegnamento(String insegnamento) {
		this.insegnamento.add(insegnamento);
	}



	public static Utente loginUtente(String email, String password) {
		return null;
	}
	
	public static void aggiungiUtente(Utente utente) {
		
	}


	private String cognome;
	private Date dataDiNascita;
	private long matricola;
	private String ufficio;
	private char tipo;
	private String nome;
	private String email;
	private String password;
	private ArrayList<String> insegnamento;
}
