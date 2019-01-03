package it.unisa.etm.testing.bean;

import java.time.LocalDate;

import it.unisa.etm.bean.RichiestaPartecipazione;

public class TestRichiestaPartecipazione {
	private RichiestaPartecipazione partecipazione;
	
	public TestRichiestaPartecipazione() {
		
	}
	
	public TestRichiestaPartecipazione(RichiestaPartecipazione partecipazione) {
		this.partecipazione=partecipazione;
	}	
	
	public int TestGetId() {
		return partecipazione.getId();
	}
	
	public void TestSetId(int id) {
		partecipazione.setId(id);
	}
	
	public LocalDate TestGetData() {
		return partecipazione.getData();
	}
	
	public void TestSetData(LocalDate data) {
		partecipazione.setData(data);
	}
	
	public int TestGetPropostatesi_id() {
		return partecipazione.getPropostatesi_id();
	}
	
	public void TestSetPropostatesi_id(int propostatesi_id) {
		partecipazione.setPropostatesi_id(propostatesi_id);
	}
	
	public String TestGetUtente_mail() {
		return partecipazione.getUtente_mail();
	}
	
	public void TestSetUtente_mail(String utente_mail) {
		partecipazione.setUtente_mail(utente_mail);
	}
}
