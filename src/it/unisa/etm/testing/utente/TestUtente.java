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
	
	public String testGetCognome() {
		return utente.getCognome();
	}

	public void testSetCognome(String cognome) {
		utente.setCognome(cognome);
	}

	public String testGetDataDiNascita() {
		return utente.getDataDiNascita();
	}

	public void testSetDataDiNascita(String dataDiNascita) {
		utente.setDataDiNascita(dataDiNascita);
	}

	public String testGetMatricola() {
		return utente.getMatricola();
	}

	public void testSetMatricola(String matricola) {
		utente.setMatricola(matricola);
	}

	public String testGetUfficio() {
		return utente.getUfficio();
	}

	public void testSetUfficio(String ufficio) {
		utente.setUfficio(ufficio);
	}

	public String testGetTipo() {
		return utente.getTipo();
	}

	public void testSetTipo(String tipo) {
		utente.setTipo(tipo);
	}

	public String testGetNome() {
		return utente.getNome();
	}

	public void testSetNome(String nome) {
		utente.setNome(nome);
	}

	public String testGetEmail() {
		return utente.getEmail();
	}

	public void testSetEmail(String email) {
		utente.setEmail(email);
	}

	public String testGetPassword() {
		return utente.getPassword();
	}

	public void testSetPassword(String password) {
		utente.setPassword(password);
	}
		
	public ArrayList<String> testGetInsegnamento() {
		return utente.getInsegnamento();
	}

	public void testSetInsegnamento(String insegnamento) {
		utente.setInsegnamento(insegnamento);
	}

	public int testGetPropostaTesi_ID() {
		return utente.getPropostaTesi_ID();
	}

	public void testSetPropostaTesi_ID(int propostaTesi_ID) {
		utente.setPropostaTesi_ID(propostaTesi_ID);
	}

	public String testGetValidazione()
	{
		return utente.getValidazione();
	}
	
	public void testSetValidazione(String validazione)
	{
		utente.setValidazione(validazione);
	}
}
