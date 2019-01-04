package it.unisa.etm.testing.utente;

import it.unisa.etm.bean.Insegnamento;

public class TestInsegnamento {
	private Insegnamento insegnamento;
	
	public TestInsegnamento() {
		
	}
	
	public TestInsegnamento(Insegnamento insegnamento) {
		this.insegnamento=insegnamento;
	}
	
	public int TestGetCfu() {
		return insegnamento.getCfu();
	}

	public void TestSetCfu(int cfu) {
		insegnamento.setCfu(cfu);
	}

	public String TestGetNome() {
		return insegnamento.getNome();
	}

	public void TestSetNome(String nome) {
		insegnamento.setNome(nome);
	}
}
