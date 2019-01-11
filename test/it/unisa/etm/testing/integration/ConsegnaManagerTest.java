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
	private static ConsegnaManager consegnaOk, consegnaNotOk;
	
	@BeforeClass
	public static void setUp() {
		consegnaOk=new ConsegnaManager();
		consegnaNotOk=new ConsegnaManager();
	}
	
	@AfterClass
	public static void tearDown() {
		consegnaOk=null;
		consegnaNotOk=null;
	}
	
	
	@Test
	public void testAggiungiConsegna() {
		Consegna consegna=new Consegna("Consegna1","Descrizione consegna1","2019-01-06",1);
		boolean test=consegnaOk.aggiungiConsegna(consegna); //restituisce true
		assertTrue(test); 
		
		consegna=new Consegna("Consegna2","Descrizione consegna2","2019-01-06",1);
		test=consegnaNotOk.aggiungiConsegna(consegna); //restituisce true
		assertTrue(test); 
	}
	
	
	@Test
	public void testModificaConsegna() {
		boolean test=consegnaOk.modificaConsegna("2019-05-01", 1); //restituisce true
		assertTrue(test); 
		
		test=consegnaNotOk.modificaConsegna("ciao", 2); //restituisce false perché la data inserita è sbagliata
		assertFalse(test); 
	}
	
	/*
	@Test
	public void testEliminaConsegna() {
		boolean test=consegnaOk.eliminaConsegna(1); //restituisce true
		assertTrue(test);
		
		test=consegnaNotOk.eliminaConsegna(-1); //restiruisce false poiché l'id non è valido
		assertFalse(test);
	}
	*/
	@Test
	public void testGetConsegna() {
		Consegna consegna=consegnaOk.getConsegna(1); //restituisce  la consegna corrispondente all'id inserito
		assertNotEquals(consegna,null); 
		
		consegna=consegnaNotOk.getConsegna(-1); //restituisce null poiché l'id inserito non è valido
		assertEquals(consegna,null);
	}
	
	@Test
	public void testGetListaConsegna() {
		ArrayList<Consegna> lista=consegnaOk.getListaConsegne(1); //restituisce una lista
		assertNotEquals(lista,null);
		for(Consegna c: lista)
		System.out.println(c.getNome());
		
		lista=consegnaNotOk.getListaConsegne(-1); //restituisce null poiché l'id della proposta tesi inserito non è valido
		assertEquals(lista,null);
		
	}
}
