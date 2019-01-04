package it.unisa.etm.testing.tesi;

import java.time.LocalDate;

import it.unisa.etm.bean.RichiestaPartecipazione;

public class TestRichiestaPartecipazione {
	private RichiestaPartecipazione partecipazione;
	
	public TestRichiestaPartecipazione() {
		
	}
	
	public TestRichiestaPartecipazione(RichiestaPartecipazione partecipazione) {
		this.partecipazione=partecipazione;
	}	
	
	public int testGetId() {
		return partecipazione.getId();
	}
	
	public void testSetId(int id) {
		partecipazione.setId(id);
	}
	
	public LocalDate testGetData() {
		return partecipazione.getData();
	}
	
	public void testSetData(LocalDate data) {
		partecipazione.setData(data);
	}
	
	public int testGetPropostatesi_id() {
		return partecipazione.getPropostatesi_id();
	}
	
	public void testSetPropostatesi_id(int propostatesi_id) {
		partecipazione.setPropostatesi_id(propostatesi_id);
	}
	
	public String testGetUtente_mail() {
		return partecipazione.getUtente_mail();
	}
	
	public void testSetUtente_mail(String utente_mail) {
		partecipazione.setUtente_mail(utente_mail);
	}
}
