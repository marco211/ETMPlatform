package it.unisa.etm.testing.integration;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
		Consegna consegna=new Consegna("Consegna1","Descrizione consegna1","2019-01-06",1);
		boolean test=consegnam.aggiungiConsegna(consegna); //restituisce true
		assertTrue(test); 
		
		consegna=new Consegna("","Descrizione consegna2","2019-01-06",-2);
		test=consegnam.aggiungiConsegna(consegna); //restituisce false
		assertFalse(test); 
	}
	
	
	@Test
	public void testModificaConsegna() {
		Consegna consegna = null;
		int i = 1;
		while(consegna==null) {
			consegna = consegnam.getConsegna(i);
			i++;
		}
		
		boolean test=consegnam.modificaConsegna("2019-05-01", consegna.getId()); //restituisce true
		assertTrue(test); 
		
		test=consegnam.modificaConsegna("ciao", 2); //restituisce false perché la data inserita è sbagliata
		assertFalse(test); 
	}
	
	
	@Test
	public void testEliminaConsegna() {
		Consegna consegna = null;
		int i = 1;
		while(consegna==null) {
			consegna = consegnam.getConsegna(i);
			i++;
		}
		
		boolean test=consegnam.eliminaConsegna(consegna.getId());//restituisce true, elimina la prima consegna
		assertTrue(test);
		
		test=consegnam.eliminaConsegna(-1); //restiruisce false poiché l'id non è valido
		assertFalse(test);
	}
	
	@Test
	public void testGetConsegna() {
		Consegna consegna = null;
		int i = 1;
		while(consegna==null) {
			consegna = consegnam.getConsegna(i);
			i++;
		} //restituisce  la prima consegna
		
		assertNotEquals(consegna,null); 
		
		consegna=consegnam.getConsegna(-1); //restituisce null poiché l'id inserito non è valido
		assertEquals(consegna,null);
	}
	
	@Test
	public void testGetListaConsegna() {
		ArrayList<Consegna> lista=consegnam.getListaConsegne(1); //restituisce una lista
		assertNotEquals(lista,null);
		
		lista=consegnam.getListaConsegne(-1); //restituisce null poiché l'id della proposta tesi inserito non è valido
		assertEquals(lista,null);
		
	}
}
