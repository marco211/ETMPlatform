package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AutenticazioneManager;
import it.unisa.etm.model.manager.UtenteManager;

public class AmministratoreManagerTest {
	private static AmministratoreManager amministratoreManager;
	
	@BeforeClass
	public static void setUp() {
		amministratoreManager= new AmministratoreManager();
		assertTrue(new AutenticazioneManager().registraUtente(new Utente("TestProva","1900-01-02","Prova","s","emailtest@unisa.it","error123","111111","valido")));
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
		Utente utente = amministratoreManager.getUtente("emailtest@unisa.it");
		assertNotEquals(null, utente);
		
		
		utente=amministratoreManager.getUtente("fakeemail@email.it");
		assertEquals(utente,null); //ritorna null poiché non esiste nessun utente associato alla email fakeemail@email.it
	}
	
	@Test
	public void testEliminaUtente() {
		boolean test=amministratoreManager.eliminaUtente("emailtest@unisa.it");
		assertTrue(test); //ritorna true, deve aver eliminato il primo utente (inserito in setUp)
		
		test=amministratoreManager.eliminaUtente("fakeemail@email.it");
		assertFalse(test); //ritorna false poiché non esiste nessun utente associato alla email fakeemail@email.it
		
	}
	

	
	
}
