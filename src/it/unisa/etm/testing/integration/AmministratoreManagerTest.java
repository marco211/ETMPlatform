package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AutenticazioneManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmministratoreManagerTest {
  private static AmministratoreManager amministratoreManager;

  @BeforeClass
  public static void setUp() {
    amministratoreManager = (AmministratoreManager) 
        new ManagerFactory().createAmministratoreManager();
  }

  @AfterClass
  public static void tearDown() {
    amministratoreManager = null;
  }

  @Test
  public void testGetListaUtente() {

    assertNotEquals(null,
        amministratoreManager.getListaUtenti());//restituisce la lista
  }

  @Test
  public void testGetUtente() {
    assertNotEquals(null, amministratoreManager.getUtente("etm.utente@unisa.it"));

    //ritorna null poich� non esiste nessun utente associato alla email fakeemail@email.it
    assertEquals(amministratoreManager
        .getUtente("fakeemail@email.it"),null); 
  }

  @Test
  public void testEliminaUtente() {

    assertTrue(new AutenticazioneManager().registraUtente(
        new Utente("StudenteTestPr","1900-01-02","Prova","s",
            "emailtest@unisa.it","error123","111111","valido")));
    assertTrue(new AutenticazioneManager().registraUtente(
        new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Docmenico",
            "emailtest2@unisa.it","ciao","ETC","valido")));



    //ritorna true, deve aver eliminato il primo utente (inserito in setUp)
    assertTrue(amministratoreManager.eliminaUtente("emailtest@unisa.it")); 
    assertTrue(amministratoreManager.eliminaUtente("emailtest2@unisa.it")); 

    //ritorna false poich� non esiste nessun utente associato alla email fakeemail@email.it
    assertFalse(amministratoreManager.eliminaUtente("fakeemail@email.it")); 

  }




}
