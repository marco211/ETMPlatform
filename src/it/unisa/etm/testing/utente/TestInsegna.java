package it.unisa.etm.testing.utente;

import it.unisa.etm.bean.Insegna;

public class TestInsegna {
	private Insegna insegna;
	
	public TestInsegna() {
		
	}
	
	public TestInsegna(Insegna insegna) {
		this.insegna=insegna;
	}
	
	public String testGetUtenteEmail() {
		return insegna.getUtenteEmail();
	}

	public void testSetUtenteEmail(String utenteEmail) {
		insegna.setUtenteEmail(utenteEmail);
	}

	public String testGetInsegnamentoNome() {
		return insegna.getInsegnamentoNome();
	}

	public void testSetInsegnamentoNome(String insegnamentoNome) {
		insegna.setInsegnamentoNome(insegnamentoNome);
	}

}
