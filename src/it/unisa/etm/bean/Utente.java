package it.unisa.etm.bean;

import java.sql.Date;

public class Utente {
	
	private String email;
	private String nome;
	private String cognome;
	private String password;
	private Date data;
	private char tipo;
	private long matricola;
	private String ufficio;
	
	
	public Utente()
	{
		;
	}

	public Utente(String email, String nome, String cognome, String password, Date data, char tipo, String ufficio)
	{
		;
	}
	
	public Utente(String email, String nome, String cognome, String password, Date data, char tipo, long matricola)
	{
		;
	}
	
	public static void aggiungiUtente(Utente utente)
	{
		;
	}
	
	public static Utente loginUtente(String email, String password)
	{
		return null;  //da fare
	}
}
