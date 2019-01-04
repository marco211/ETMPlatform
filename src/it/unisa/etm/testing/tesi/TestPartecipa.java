package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.Partecipa;

public class TestPartecipa {
	private Partecipa partecipa;
	
	public TestPartecipa() {
		
	}
	
	public TestPartecipa(Partecipa partecipa) {
		this.partecipa=partecipa;
	}
	
	public int TestGetPropostaTesiId() {
		return partecipa.getPropostaTesiId();
	}

	public void TestSetPropostaTesiId(int propostaTesiId) {
		partecipa.setPropostaTesiId(propostaTesiId);
	}

	public String TestGetUtenteEmail() {
		return partecipa.getUtenteEmail();
	}

	public void TestSetUtenteEmail(String utenteEmail) {
		partecipa.setUtenteEmail(utenteEmail);
	}

}
