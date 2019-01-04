package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.PropostaTesi;

public class TestPropostaTesi {
	private PropostaTesi proposta_tesi;
	
	public TestPropostaTesi() {
		
	}
	
	public TestPropostaTesi(PropostaTesi proposta_tesi) {
		this.proposta_tesi=proposta_tesi;
	}
	
	public String testGetTitolo() {
		return proposta_tesi.getTitolo();
	}

	public void testSetTitolo(String titolo) {
		proposta_tesi.setTitolo(titolo);
	}

	public String testGetAmbito() {
		return proposta_tesi.getAmbito();
	}

	public void testSetAmbito(String ambito) {
		proposta_tesi.setAmbito(ambito);
	}

	public int testGetTempoDiSviluppo() {
		return proposta_tesi.getTempoDiSviluppo();
	}

	public void testSetTempoDiSviluppo(int tempoDiSviluppo) {
		proposta_tesi.setTempoDiSviluppo(tempoDiSviluppo);
	}

	public String testGetMaterie() {
		return proposta_tesi.getMaterie();
	}

	public void testSetMaterie(String materie) {
		proposta_tesi.setMaterie(materie);
	}

	public String testGetDecrizione() {
		return proposta_tesi.getDecrizione();
	}

	public void testSetDecrizione(String decrizione) {
		proposta_tesi.setDecrizione(decrizione);
	}

	public int testGetId() {
		return proposta_tesi.getId();
	}

	public void testSetId(int id) {
		proposta_tesi.setId(id);
	}

	public String testGetUtenteEmail() {
		return proposta_tesi.getUtenteEmail();
	}

	public void testSetUtenteEmail(String utenteEmail) {
		proposta_tesi.setUtenteEmail(utenteEmail);
	}

	public boolean testIsChiuso() {
		return proposta_tesi.isChiuso();
	}

	public void testSetChiuso(boolean chiuso) {
		proposta_tesi.setChiuso(chiuso);
	}

	public boolean testIsArchiviato() {
		return proposta_tesi.isArchiviato();
	}

	public void testSetArchiviato(boolean archiviato) {
		proposta_tesi.setArchiviato(archiviato);
	}
}
