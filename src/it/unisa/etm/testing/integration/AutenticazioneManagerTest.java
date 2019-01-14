package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AutenticazioneManager;

public class AutenticazioneManagerTest {
	private static AutenticazioneManager autenticazioneManager;
	@SuppressWarnings("unused")
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
		assertTrue(new AutenticazioneManager().registraUtente(new Utente("Nappi","1997-11-04","Domenico","s","etm.utentetre@unisa.it","ciao","0512104963","valido")));
		assertTrue(new AutenticazioneManager().registraUtente(new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Docmenico","etm.docentedue@unisa.it","ciao","MMI","valido")));
		assertTrue(new AutenticazioneManager().registraUtente(new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Docmenico","etm.docentetre@unisa.it","ciao","ETC","valido")));
	}

	@Test
	public void testGetUtente() {
		assertNotEquals(autenticazioneManager.getUtente("etm.docente@unisa.it", "ciao"),null); //etm.docente@unisa.it è un docente registrato nel db
		
		assertNotEquals(autenticazioneManager.getUtente("etm.utente@unisa.it", "ciao"), null);

		assertEquals(autenticazioneManager.getUtente("prova", "nonesisto"), null);
	}

	@Test
	public void testGetAdmin() {
		assertNotEquals(autenticazioneManager.getAdmin("boss@admin.it", "qwert"),null);

		assertEquals(autenticazioneManager.getAdmin("admin@nonesiste.it", "qwert"),null);
	}

	@Test
	public void testGetPassword() {
		assertEquals(autenticazioneManager.getPassword("etm.docente@unisa.it"),"ciao");
	}

	@Test
	public void testSetValidazione() {
		assertTrue(autenticazioneManager.setValidazione("valido"));
	}
	
}
