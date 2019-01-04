package it.unisa.etm.testing.utente;

import java.util.ArrayList;

import it.unisa.etm.bean.Utente;

public class TestUtente {
	private Utente utente;
	
	public TestUtente() {
		
	}
	
	public TestUtente(Utente utente) {
		this.utente=utente;
	}
	
	public String TestGetCognome() {
		return utente.getCognome();
	}

	public void TestSetCognome(String cognome) {
		utente.setCognome(cognome);
	}

	public String TestGetDataDiNascita() {
		return utente.getDataDiNascita();
	}

	public void TestSetDataDiNascita(String dataDiNascita) {
		utente.setDataDiNascita(dataDiNascita);
	}

	public String TestGetMatricola() {
		return utente.getMatricola();
	}

	public void TestSetMatricola(String matricola) {
		utente.setMatricola(matricola);
	}

	public String TestGetUfficio() {
		return utente.getUfficio();
	}

	public void TestSetUfficio(String ufficio) {
		utente.setUfficio(ufficio);
	}

	public String TestGetTipo() {
		return utente.getTipo();
	}

	public void TestSetTipo(String tipo) {
		utente.setTipo(tipo);
	}

	public String TestGetNome() {
		return utente.getNome();
	}

	public void TestSetNome(String nome) {
		utente.setNome(nome);
	}

	public String TestGetEmail() {
		return utente.getEmail();
	}

	public void TestSetEmail(String email) {
		utente.setEmail(email);
	}

	public String TestGetPassword() {
		return utente.getPassword();
	}

	public void TestSetPassword(String password) {
		utente.setPassword(password);
	}
		
	public ArrayList<String> TestGetInsegnamento() {
		return utente.getInsegnamento();
	}

	public void TestSetInsegnamento(String insegnamento) {
		utente.setInsegnamento(insegnamento);
	}

	public int TestGetPropostaTesi_ID() {
		return utente.getPropostaTesi_ID();
	}

	public void TestSetPropostaTesi_ID(int propostaTesi_ID) {
		utente.setPropostaTesi_ID(propostaTesi_ID);
	}

	public String TestGetValidazione()
	{
		return utente.getValidazione();
	}
	
	public void TestSetValidazione(String validazione)
	{
		utente.setValidazione(validazione);
	}
}
