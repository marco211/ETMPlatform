package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.Consegna;
import it.unisa.etm.model.manager.ConsegnaManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ConsegnaManagerTest {
  private static ConsegnaManager consegnam;

  @BeforeClass
  public static void setUp() {
    consegnam = new ConsegnaManager();
  }

  @AfterClass
  public static void tearDown() {
    consegnam = null;
  }


  @Test
  public void testAggiungiConsegna() {
    assertTrue(new ConsegnaManager().aggiungiConsegna(
        new Consegna("Consegna1","Descrizione consegna1","2019-01-06",1)));

    assertFalse(new ConsegnaManager().aggiungiConsegna(
        new Consegna("","Descrizione consegna2","2019-01-06",-2)));
  }


  @Test
  public void testModificaConsegna() {
    //restituisce true
    assertTrue(consegnam.modificaConsegna("2019-05-01", consegnam.getConsegna(1).getId())); 

    //restituisce false perch� la data inserita e sbagliata
    assertFalse(consegnam.modificaConsegna("ciao", 2)); 
  }


  @Test
  public void testEliminaConsegna() {
    //restituisce true, elimina la prima consegna
    assertTrue(consegnam.eliminaConsegna(consegnam.getConsegna(2).getId()));

    assertFalse(consegnam.eliminaConsegna(-1)); //restiruisce false poich� l'id non e valido
  }

  @Test
  public void testGetConsegna() {
    assertNotEquals(consegnam.getConsegna(1),null); //restituisce la consegna corrispondete all'id 1

    //restituisce null poich� l'id inserito non e valido
    assertEquals(consegnam.getConsegna(-1),null); 

  }

  @Test
  public void testGetListaConsegna() {
    assertNotEquals(consegnam.getListaConsegne(1),null); //restituisce una lista

    //restituisce null poich� l'id della proposta tesi inserito non e valido    
    assertEquals(consegnam.getListaConsegne(-1),null); 
  }
}
