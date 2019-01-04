package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.Consegna;

public class TestConsegna {
	private Consegna consegna;
	
	public TestConsegna() {
		
	}
	
	public TestConsegna(Consegna consegna) {
		this.consegna=consegna;
	}
	
	public int TestGetId() {
		return consegna.getId();
	}
	
	public void TestSetId(int id) {
		consegna.setId(id);
	}
	
	public String TestGetNome() {
		return consegna.getNome();
	}
	
	public void TestSetNome(String nome) {
		consegna.setNome(nome);
	}
	
	public String TestGetDescrzione() {
		return consegna.getDescrzione();
	}
	
	public void TestSetDescrzione(String descrzione) {
		consegna.setDescrzione(descrzione);
	}
	
	public String TestGetScadenza() {
		return consegna.getScadenza();
	}
	
	public void TestSetScadenza(String scadenza) {
		consegna.setScadenza(scadenza);
	}
	
	public int TestGetPropostaTesiId() {
		return consegna.getPropostaTesiId();
	}

	public void TestSetPropostaTesiId(int propostaTesiId) {
		consegna.setPropostaTesiId(propostaTesiId);
	}

	
}
