package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.Partecipa;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class TestPartecipa {
	private static Partecipa partecipaOk;
	private static Partecipa partecipaNotOk;
	
	@BeforeClass
	public static void setUp() {
		partecipaOk= new Partecipa(1,"umberto@unisa,it");
		partecipaNotOk= new Partecipa(2,"error@fail.com");
		
	}
	@AfterClass
	public static void tearDown() {
		partecipaOk=null;
		partecipaNotOk=null;
		
	}
	@Test
	public void testGetPropostaTesiId() {
		int id= partecipaOk.getPropostaTesiId();
		assertEquals(id,1); // Id Corretto
		
		id= partecipaNotOk.getPropostaTesiId();
		assertEquals(id,2); // Id Errato
		
	}	
	@Test
	public void testSetPropostaTesiId() {
		int id=1;
		partecipaOk.setPropostaTesiId(id);
		assertEquals(1,partecipaOk.getPropostaTesiId());
		id=2;
		partecipaNotOk.setPropostaTesiId(id);
		assertEquals(2,partecipaNotOk.getPropostaTesiId());
	} 
	@Test
	public void testGetUtenteEmail() {
		String utenteEmail= partecipaOk.getUtenteEmail();
		assertEquals(utenteEmail, "umberto@unisa.it"); //Email Corretta
		utenteEmail= partecipaNotOk.getUtenteEmail();
		assertEquals(utenteEmail, "error@fail.com"); // Email Errata
		
		
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
