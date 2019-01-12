package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

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
		Attivita attivita=new Attivita("etm.utente@studenti.unisa.it","File1.pdf",LocalDate.now(),"A",1);
		boolean test = attivitaManager.aggiungiAttivita(attivita); //restituisce true
		assertTrue(test); 
		
		attivita = new Attivita("email1@unisa.it","File2",LocalDate.now(),"B",2);
		test=attivitaManager.aggiungiAttivita(attivita);
		assertFalse(test); //restituisce false perché aggiungiAttivita lancia una SQLException
	}
	
	@Test
	public void testGetListaAttivita() {
		ArrayList<Attivita> lista= attivitaManager.getListaAttivita(1);
		assertNotEquals(lista,null); //restituisce la lista
		
	}
	
	
}
