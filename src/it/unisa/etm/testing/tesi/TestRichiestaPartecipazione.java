package it.unisa.etm.testing.tesi;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.unisa.etm.bean.RichiestaPartecipazione;

public class TestRichiestaPartecipazione {
	private RichiestaPartecipazione richiestaOk;
	private RichiestaPartecipazione richiestaNotOk;
	private LocalDate date=LocalDate.now();
	

	@BeforeAll
	public void setUp() {
		richiestaOk= new RichiestaPartecipazione(this.date,11,"umberto@unisa,it");
		richiestaNotOk= new RichiestaPartecipazione(this.date,999,"error@fail.com");
		
	}
	
	@AfterAll
	public void tearDown() {
		richiestaOk=null;
		richiestaNotOk=null;
	}
	@Test
	public void testGetPropostatesi_id() {
		int id= richiestaOk.getPropostatesi_id();
		assertEquals(id, 11);// Id Corretto
		
		id= richiestaNotOk.getPropostatesi_id();
		assertEquals(id, 999);// Id Errato
	}
	@Test
	public void testSetPropostatesi_id() {
		int id= 11;
		richiestaOk.setPropostatesi_id(id);
		assertEquals(11, richiestaOk.getPropostatesi_id());
		
		id= 999;
		richiestaNotOk.setPropostatesi_id(id);
		assertEquals(999, richiestaNotOk.getPropostatesi_id());
	}
	@Test
	public void testGetData() {
		LocalDate date=richiestaOk.getData();
		assertEquals(date,richiestaOk.getData());// data giusta
		
		date=richiestaNotOk.getData();
		assertEquals(date,"2001-01-01");// data errata
	}
	@Test
	public void testSetData(LocalDate data) {
		LocalDate date=LocalDate.now();
		richiestaOk.setData(date);
		assertEquals(LocalDate.now(),richiestaOk.getData());
		
		richiestaNotOk.setData(date);
		assertEquals(LocalDate.now(),richiestaNotOk.getData());
	}
	
	@Test
	public void testGetUtente_mail() {
		String email= richiestaOk.getUtente_mail();
		assertEquals(email, "umberto@unisa.it"); //Email Corretta
		email= richiestaNotOk.getUtente_mail();
		assertEquals(email, "error@fail.com"); // Email Errata
	}
	@Test
	public void testSetUtente_mail() {
		String email = "umberto@unisa.it";
		richiestaOk.setUtente_mail(email);
		assertEquals("umberto@unisa.it",email);
		
		email= "error@fail.com";
		richiestaNotOk.setUtente_mail(email);
		assertEquals("error@fail.com",email);
	}
}
