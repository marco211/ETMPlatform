package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.model.manager.AttivitaManager;

public class AttivitaManagerTest {
	private static AttivitaManager attivitaManager;
	
	@BeforeClass
	public static void setUp() {
		attivitaManager = new AttivitaManager();
	}
	
	@AfterClass
	public static void tearDown() {
		attivitaManager = null;
	}
	
	
	@Test
	public void testAggiungiAttivita() {
		assertTrue(attivitaManager.aggiungiAttivita(new Attivita("etm.utente@unisa.it","File1.pdf",LocalDate.now(),"A",1))); //restituisce true
		 
		assertFalse(attivitaManager.aggiungiAttivita( new Attivita("email1@unisa.it","File2.pdf",LocalDate.now(),"B",2))); //restituisce false perché aggiungiAttivita lancia una SQLException
	}
	
	@Test
	public void testGetListaAttivita() {
		
		assertNotEquals(attivitaManager.getListaAttivita(1),null); //restituisce la lista
	}
	
	
}
