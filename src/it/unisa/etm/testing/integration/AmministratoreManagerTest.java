package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AutenticazioneManager;

public class AmministratoreManagerTest {
	private static AmministratoreManager amministratoreManager;
	
	@BeforeClass
	public static void setUp() {
		amministratoreManager= (AmministratoreManager) new ManagerFactory().createAmministratoreManager();
	}
	
	@AfterClass
	public static void tearDown() {
		amministratoreManager = null;
	}
	
	@Test
	public void testGetListaUtente() {
		ArrayList<Utente> lista=(ArrayList<Utente>) amministratoreManager.getListaUtenti();
		assertNotEquals(null,lista); //restituisce la lista
		
	}
	
	@Test
	public void testGetUtente() {
		Utente utente = amministratoreManager.getUtente("etm.utente@unisa.it");
		assertNotEquals(null, utente);
		
		utente=amministratoreManager.getUtente("fakeemail@email.it");
		assertEquals(utente,null); //ritorna null poiché non esiste nessun utente associato alla email fakeemail@email.it
	}
	
	@Test
	public void testEliminaUtente() {
		
		assertTrue(new AutenticazioneManager().registraUtente(new Utente("StudenteTestPr","1900-01-02","Prova","s","emailtest@unisa.it","error123","111111","valido")));
		assertTrue(new AutenticazioneManager().registraUtente(new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Docmenico","emailtest2@unisa.it","ciao","ETC","valido")));
		
		
		
		boolean test=amministratoreManager.eliminaUtente("emailtest@unisa.it");
		assertTrue(test); //ritorna true, deve aver eliminato il primo utente (inserito in setUp)
		test=amministratoreManager.eliminaUtente("emailtest2@unisa.it");
		assertTrue(test); 
		
		test=amministratoreManager.eliminaUtente("fakeemail@email.it");
		assertFalse(test); //ritorna false poiché non esiste nessun utente associato alla email fakeemail@email.it
		
	}
	

	
	
}
