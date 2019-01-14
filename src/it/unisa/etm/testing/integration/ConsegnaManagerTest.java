package it.unisa.etm.testing.integration;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.Consegna;
import it.unisa.etm.model.manager.ConsegnaManager;

public class ConsegnaManagerTest {
	private static ConsegnaManager consegnam;
	
	@BeforeClass
	public static void setUp() {
		consegnam=new ConsegnaManager();
	}
	
	@AfterClass
	public static void tearDown() {
		consegnam=null;
	}
	
	
	@Test
	public void testAggiungiConsegna() {		
		assertTrue(new ConsegnaManager().aggiungiConsegna(new Consegna("Consegna1","Descrizione consegna1","2019-01-06",1)));
		
		assertFalse(new ConsegnaManager().aggiungiConsegna(new Consegna("","Descrizione consegna2","2019-01-06",-2)));
	}
	
	
	@Test
	public void testModificaConsegna() {		
		assertTrue(consegnam.modificaConsegna("2019-05-01", consegnam.getConsegna(1).getId())); //restituisce true
		
		assertFalse(consegnam.modificaConsegna("ciao", 2)); //restituisce false perché la data inserita e sbagliata
	}
	
	
	@Test
	public void testEliminaConsegna() {		
		assertTrue(consegnam.eliminaConsegna(consegnam.getConsegna(2).getId()));//restituisce true, elimina la prima consegna
		
		assertFalse(consegnam.eliminaConsegna(-1)); //restiruisce false poiché l'id non e valido
	}
	
	@Test
	public void testGetConsegna() {		
		assertNotEquals(consegnam.getConsegna(1),null); //restituisce la consegna corrispondete all'id 1
		
		assertEquals(consegnam.getConsegna(-1),null); //restituisce null poiché l'id inserito non e valido
		
	}
	
	@Test
	public void testGetListaConsegna() {
		assertNotEquals(consegnam.getListaConsegne(1),null); //restituisce una lista
		
		assertEquals(consegnam.getListaConsegne(-1),null); //restituisce null poiché l'id della proposta tesi inserito non e valido	
	}
}
