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
	
	public int TestGetId() {
		return attivita.getId();
	}

	public void TestSetId(int id) {
		attivita.setId(id);
	}

	public String TestGetUtente_Email() {
		return attivita.getUtente_Email();
	}

	public void TestSetUtente_Email(String utente_Email) {
		attivita.setUtente_Email(utente_Email);	
	}

	public String TestGetNomeFile() {
		return attivita.getNomeFile();
	}

	public void TestSetNomeFile(String nomeFile) {
		attivita.setNomeFile(nomeFile);
	}

	public LocalDate TestGetData() {
		return attivita.getData();
	}

	public void TestSetData(LocalDate data) {
		attivita.setData(data);
	}

	public String TestGetTipo() {
		return attivita.getTipo();
	}

	public void TestSetTipo(String tipo) {
		attivita.setTipo(tipo);
	}

	public int TestGetPropostatesi_id() {
		return attivita.getPropostatesi_id();
	}

	public void TestSetPropostatesi_id(int propostatesi_id) {
		attivita.setPropostatesi_id(propostatesi_id);;
	}
	
		
}
