package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.Partecipa;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPartecipa {
	private Partecipa partecipaOk;
	private Partecipa partecipaNotOk;
	
	@BeforeAll
	public void setUp() {
		partecipaOk= new Partecipa(11,"umberto@unisa,it");
		partecipaNotOk= new Partecipa(999,"error@fail.com");
		
	}
	@AfterAll
	public void tearDown() {
		partecipaOk=null;
		partecipaNotOk=null;
		
	}
	@Test
	public void testGetPropostaTesiId() {
		int id= partecipaOk.getPropostaTesiId();
		assertEquals(id, 11);// Id Corretto
		
		id= partecipaNotOk.getPropostaTesiId();
		assertEquals(id, 999);// Id Errato
		
	}
	@Test
	public void testSetPropostaTesiId() {
		int id= 11;
		partecipaOk.setPropostaTesiId(id);
		assertEquals(11, partecipaOk.getPropostaTesiId());
		
		id= 999;
		partecipaNotOk.setPropostaTesiId(id);
		assertEquals(999, partecipaNotOk.getPropostaTesiId());
	}
	@Test
	public void testGetUtenteEmail() {
		String email= partecipaOk.getUtenteEmail();
		assertEquals(email, "umberto@unisa.it"); //Email Corretta
		email= partecipaNotOk.getUtenteEmail();
		assertEquals(email, "error@fail.com"); // Email Errata
		
		
	}

	public void testSetUtenteEmail() {
		String email = "umberto@unisa.it";
		partecipaOk.setUtenteEmail(email);
		assertEquals("umberto@unisa.it",email);
		
		email= "error@fail.com";
		partecipaNotOk.setUtenteEmail(email);
		assertEquals("error@fail.com",email);
	}

}
