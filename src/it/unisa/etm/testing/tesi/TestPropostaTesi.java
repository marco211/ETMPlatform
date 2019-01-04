package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.PropostaTesi;

public class TestPropostaTesi {
	private PropostaTesi proposta_tesi;
	
	public TestPropostaTesi() {
		
	}
	
	public TestPropostaTesi(PropostaTesi proposta_tesi) {
		this.proposta_tesi=proposta_tesi;
	}
	
	public String TestGetTitolo() {
		return proposta_tesi.getTitolo();
	}

	public void TestSetTitolo(String titolo) {
		proposta_tesi.setTitolo(titolo);
	}

	public String TestGetAmbito() {
		return proposta_tesi.getAmbito();
	}

	public void TestSetAmbito(String ambito) {
		proposta_tesi.setAmbito(ambito);
	}

	public int TestGetTempoDiSviluppo() {
		return proposta_tesi.getTempoDiSviluppo();
	}

	public void TestSetTempoDiSviluppo(int tempoDiSviluppo) {
		proposta_tesi.setTempoDiSviluppo(tempoDiSviluppo);
	}

	public String TestGetMaterie() {
		return proposta_tesi.getMaterie();
	}

	public void TestSetMaterie(String materie) {
		proposta_tesi.setMaterie(materie);
	}

	public String TestGetDecrizione() {
		return proposta_tesi.getDecrizione();
	}

	public void TestSetDecrizione(String decrizione) {
		proposta_tesi.setDecrizione(decrizione);
	}

	public int TestGetId() {
		return proposta_tesi.getId();
	}

	public void TestSetId(int id) {
		proposta_tesi.setId(id);
	}

	public String TestGetUtenteEmail() {
		return proposta_tesi.getUtenteEmail();
	}

	public void TestSetUtenteEmail(String utenteEmail) {
		proposta_tesi.setUtenteEmail(utenteEmail);
	}

	public boolean TestIsChiuso() {
		return proposta_tesi.isChiuso();
	}

	public void TestSetChiuso(boolean chiuso) {
		proposta_tesi.setChiuso(chiuso);
	}

	public boolean TestIsArchiviato() {
		return proposta_tesi.isArchiviato();
	}

	public void TestSetArchiviato(boolean archiviato) {
		proposta_tesi.setArchiviato(archiviato);
	}
}
