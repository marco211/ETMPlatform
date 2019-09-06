package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.manager.AttivitaManager;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


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
    assertTrue(attivitaManager.aggiungiAttivita(
        new Attivita("etm.utente@studenti.unisa.it","File1.pdf",LocalDate.now(),"af",1))); //restituisce true

    //restituisce false perché aggiungiAttivita lancia una SQLException
    assertFalse(attivitaManager.aggiungiAttivita(
        new Attivita("email1@unisa.it","File2.pdf",LocalDate.now(),"B",2))); 
  }

  @Test
  public void testGetListaAttivita() {

    assertNotEquals(attivitaManager.getListaAttivita(1),null); //restituisce la lista
  }

  //posso testare più metodi?
  @Test
  public void testSeguiUtente() {
    assertTrue(attivitaManager.seguiUtente
        ("etm.utente@studenti.unisa.it", "etm.docente@unisa.it", true, true, true));
    
    assertFalse(attivitaManager.seguiUtente
        ("etminesistente@unisa.it", "etm.nonce@unisa.it", false, false, false));
    
    assertNotEquals(attivitaManager.getListaSeguiti("etm.docente@unisa.it"), null);
    
    assertTrue(attivitaManager.aggiungiAttivita(
        new Attivita("etm.docente@unisa.it","File1.pdf",LocalDate.now(),"af",1))); //restituisce true
    
    assertTrue(attivitaManager.leggiNotifiche("etm.utente@studenti.unisa.it"));
    
    assertNotEquals(attivitaManager.getNotifiche("etm.utente@studenti.unisa.it"), null);
    
    assertTrue(attivitaManager.unfollow(
        "etm.utente@studenti.unisa.it", "etm.docente@unisa.it"));
    
    //corrected error: unfollow wasn't returning false if the row count was 0
    assertFalse(attivitaManager.unfollow(
        "etminesistente@unisa.it", "etm.nonce@unisa.it"));
  }

}
