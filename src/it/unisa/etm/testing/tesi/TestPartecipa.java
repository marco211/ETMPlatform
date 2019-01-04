package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.Partecipa;

public class TestPartecipa {
	private Partecipa partecipa;
	
	public TestPartecipa() {
		
	}
	
	public TestPartecipa(Partecipa partecipa) {
		this.partecipa=partecipa;
	}
	
	public int testGetPropostaTesiId() {
		return partecipa.getPropostaTesiId();
	}

	public void testSetPropostaTesiId(int propostaTesiId) {
		partecipa.setPropostaTesiId(propostaTesiId);
	}

	public String testGetUtenteEmail() {
		return partecipa.getUtenteEmail();
	}

	public void testSetUtenteEmail(String utenteEmail) {
		partecipa.setUtenteEmail(utenteEmail);
	}

}
