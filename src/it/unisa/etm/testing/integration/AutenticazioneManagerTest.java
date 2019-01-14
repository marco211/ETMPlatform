package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.Amministratore;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AutenticazioneManager;

public class AutenticazioneManagerTest {
	private static AutenticazioneManager autenticazioneManager;
	private static AmministratoreManager am;

	@BeforeClass
	public static void setUp() {
		autenticazioneManager=(AutenticazioneManager) new ManagerFactory().createAutenticazioneManager();
		am = (AmministratoreManager) new ManagerFactory().createAmministratoreManager();
	}

	@AfterClass
	public static void tearDown() {
		autenticazioneManager = null;
	}

	@Test
	public void testRegistraUtente() {
		Utente studente=new Utente("Nappi","1997-11-04","Domenico","s","etm.utentetre@unisa.it","ciao","0512104963","valido");
		Utente docente=new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Docmenico","etm.docentedue@unisa.it","ciao","MMI","valido");
		Utente docentedue=new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Docmenico","etm.docentetre@unisa.it","ciao","ETC","valido");
		
		boolean test =autenticazioneManager.registraUtente(studente);
		boolean testdoc = autenticazioneManager.registraUtente(docente);
		boolean testdoc2 = autenticazioneManager.registraUtente(docentedue);
		
		assertTrue(test);
		assertTrue(testdoc);
		assertTrue(testdoc2);

	}

	@Test
	public void testGetUtente() {
		Utente utente=autenticazioneManager.getUtente("etm.docente@unisa.it", "ciao"); //etm.docente@unisa.it è un docente registrato nel db
		assertNotEquals(utente,null);

		utente=autenticazioneManager.getUtente("etm.utente@unisa.it", "ciao");
		assertNotEquals(utente, null);

		utente=autenticazioneManager.getUtente("prova", "nonesisto");
		assertEquals(utente, null);
	}

	@Test
	public void testGetAdmin() {
		Amministratore admin=autenticazioneManager.getAdmin("boss@admin.it", "qwert");
		assertNotEquals(admin,null);

		admin=autenticazioneManager.getAdmin("admin@nonesiste.it", "qwert");
		assertEquals(admin,null);
	}

	@Test
	public void testGetPassword() {
		String password=autenticazioneManager.getPassword("etm.docente@unisa.it");
		assertEquals(password,"ciao");
	}

	@Test
	public void testSetValidazione() {
		boolean test=autenticazioneManager.setValidazione("valido");
		assertTrue(test);
	}
}
