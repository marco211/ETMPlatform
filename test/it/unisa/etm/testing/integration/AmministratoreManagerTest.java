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

public class AmministratoreManagerTest {
	private static AmministratoreManager amministratoreOk, amministratoreNotOk;
	
	@BeforeClass
	public static void setUp() {
		amministratoreOk= new AmministratoreManager();
		amministratoreNotOk= new AmministratoreManager();
		
	}
	
	@AfterClass
	public static void tearDown() {
		amministratoreOk=null;
		amministratoreNotOk=null;
	}
	
	@Test
	public void testGetListaUtente() {
		ArrayList<Utente> lista=(ArrayList<Utente>) amministratoreOk.getListaUtenti();
		assertNotEquals(null,lista); //restituisce la lista
		
		lista=(ArrayList<Utente>) amministratoreNotOk.getListaUtenti();
		assertNotEquals(null,lista); //restituisce la lista
	}
	
	@Test
	public void testEliminaUtente() {
		boolean test=amministratoreOk.eliminaUtente(amministratoreOk.getListaUtenti().get(0).getEmail());
		assertTrue(test); //ritorna true 
		
		test=amministratoreNotOk.eliminaUtente("fakeemail@email.it");
		assertFalse(test); //ritorna false poiché non esiste nessun utente associato alla email fakeemail@email.it
		
	}
	
	@Test
	public void testGetUtente() {
		Utente utente=amministratoreOk.getUtente(amministratoreOk.getListaUtenti().get(0).getEmail());
		assertEquals(utente.getEmail(),amministratoreOk.getListaUtenti().get(0).getEmail()); //ritorna true
		
		
		utente=amministratoreNotOk.getUtente("fakeemail@email.it");
		assertEquals(utente,null); //ritorna null poiché non esiste nessun utente associato alla email fakeemail@email.it
	}
	
	
}
