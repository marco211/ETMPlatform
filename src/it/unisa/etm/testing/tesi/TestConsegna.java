package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.Consegna;

public class TestConsegna {
	private Consegna consegna;
	
	public TestConsegna() {
		
	}
	
	public TestConsegna(Consegna consegna) {
		this.consegna=consegna;
	}
	
	public int testGetId() {
		return consegna.getId();
	}
	
	public void testSetId(int id) {
		consegna.setId(id);
	}
	
	public String testGetNome() {
		return consegna.getNome();
	}
	
	public void testSetNome(String nome) {
		consegna.setNome(nome);
	}
	
	public String testGetDescrzione() {
		return consegna.getDescrzione();
	}
	
	public void testSetDescrzione(String descrzione) {
		consegna.setDescrzione(descrzione);
	}
	
	public String testGetScadenza() {
		return consegna.getScadenza();
	}
	
	public void testSetScadenza(String scadenza) {
		consegna.setScadenza(scadenza);
	}
	
	public int testGetPropostaTesiId() {
		return consegna.getPropostaTesiId();
	}

	public void testSetPropostaTesiId(int propostaTesiId) {
		consegna.setPropostaTesiId(propostaTesiId);
	}

	
}
