package it.unisa.etm.testing.utente;

import it.unisa.etm.bean.Insegnamento;

public class TestInsegnamento {
	private Insegnamento insegnamento;
	
	public TestInsegnamento() {
		
	}
	
	public TestInsegnamento(Insegnamento insegnamento) {
		this.insegnamento=insegnamento;
	}
	
	public int testGetCfu() {
		return insegnamento.getCfu();
	}

	public void testSetCfu(int cfu) {
		insegnamento.setCfu(cfu);
	}

	public String testGetNome() {
		return insegnamento.getNome();
	}

	public void testSetNome(String nome) {
		insegnamento.setNome(nome);
	}
}
