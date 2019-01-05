package it.unisa.etm.testing.areacondivisa;

import java.time.LocalDate;
import it.unisa.etm.bean.Attivita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class TestAttivita {
	
	private Attivita attivitaOk;
	private Attivita attivitaNotOk;
	
	@AfterAll
	public void setUp() {
	
	}
	
	@Test
	void testGetId() {
		int id = attivitaOk.getId();
		assertEquals(id, 1); //ad esempio, se 1 è l'id settato in set up.. 
		//poi fate anche qualche assert false per vedere sempre se va bene (con attivitaNotOk per esempio)
	}

	void testSetId(int id) {
		attivitaOk.setId(id);
	}

	public void testGetUtente_Email() {
		String email = attivitaOk.getUtente_Email();
	}

	public void testSetUtente_Email(String utente_Email) {
		attivitaOk.setUtente_Email(utente_Email);	
	}

	public String testGetNomeFile() {
		return attivitaOk.getNomeFile();
	}

	public void testSetNomeFile(String nomeFile) {
		attivitaOk.setNomeFile(nomeFile);
	}

	public LocalDate testGetData() {
		return attivitaOk.getData();
	}

	public void testSetData(LocalDate data) {
		attivitaOk.setData(data);
	}

	public String testGetTipo() {
		return attivitaOk.getTipo();
	}

	public void testSetTipo(String tipo) {
		attivitaOk.setTipo(tipo);
	}

	public int testGetPropostatesi_id() {
		return attivitaOk.getPropostatesi_id();
	}

	public void testSetPropostatesi_id(int propostatesi_id) {
		attivitaOk.setPropostatesi_id(propostatesi_id);;
	}
	
		
}
