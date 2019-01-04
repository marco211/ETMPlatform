package it.unisa.etm.testing.areacondivisa;

import java.time.LocalDate;

import it.unisa.etm.bean.Attivita;

public class TestAttivita {
	private Attivita attivita;
	
	public TestAttivita() {
		
	}
	
	public TestAttivita(Attivita attivita) {
		this.attivita=attivita;
	}
	
	public int testGetId() {
		return attivita.getId();
	}

	public void testSetId(int id) {
		attivita.setId(id);
	}

	public String testGetUtente_Email() {
		return attivita.getUtente_Email();
	}

	public void testSetUtente_Email(String utente_Email) {
		attivita.setUtente_Email(utente_Email);	
	}

	public String testGetNomeFile() {
		return attivita.getNomeFile();
	}

	public void testSetNomeFile(String nomeFile) {
		attivita.setNomeFile(nomeFile);
	}

	public LocalDate testGetData() {
		return attivita.getData();
	}

	public void testSetData(LocalDate data) {
		attivita.setData(data);
	}

	public String testGetTipo() {
		return attivita.getTipo();
	}

	public void testSetTipo(String tipo) {
		attivita.setTipo(tipo);
	}

	public int testGetPropostatesi_id() {
		return attivita.getPropostatesi_id();
	}

	public void testSetPropostatesi_id(int propostatesi_id) {
		attivita.setPropostatesi_id(propostatesi_id);;
	}
	
		
}
