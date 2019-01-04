package it.unisa.etm.testing.bean;

import it.unisa.etm.bean.Insegna;

public class TestInsegna {
	private Insegna insegna;
	
	public TestInsegna() {
		
	}
	
	public TestInsegna(Insegna insegna) {
		this.insegna=insegna;
	}
	
	public String TestGetUtenteEmail() {
		return insegna.getUtenteEmail();
	}

	public void TestSetUtenteEmail(String utenteEmail) {
		insegna.setUtenteEmail(utenteEmail);
	}

	public String TestGetInsegnamentoNome() {
		return insegna.getInsegnamentoNome();
	}

	public void TestSetInsegnamentoNome(String insegnamentoNome) {
		insegna.setInsegnamentoNome(insegnamentoNome);
	}

}
