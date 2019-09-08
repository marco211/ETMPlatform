package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AutenticazioneManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AutenticazioneManagerTest {

  private static AutenticazioneManager autenticazioneManager;

  @BeforeClass
  public static void setUp() {
    autenticazioneManager = (AutenticazioneManager) 
        new ManagerFactory().createAutenticazioneManager();
  }

  @AfterClass
  public static void tearDown() {
    autenticazioneManager = null;
  }

  @Test
  public void testRegistraUtente() {
    Utente u = new Utente("Nappi","1997-11-04","Domenico",
        "s","etm.utenteinesistente@unisa.it","ciao","0512104963","valido");
    assertTrue(autenticazioneManager.registraUtente(u));
    
    u = new Utente("Nappi","1997-11-04","Ufficiamoci","d", "Domenico",
        "etm.docenteinesistente@unisa.it","ciao","MMI","valido");
    assertTrue(autenticazioneManager.registraUtente(u));
    
    new ManagerFactory().createAmministratoreManager().eliminaUtente("etm.utenteinesistente@unisa.it");
    new ManagerFactory().createAmministratoreManager().eliminaUtente("etm.docenteinesistente@unisa.it");
  }

  @Test
  public void testGetUtente() {
    assertNotEquals(autenticazioneManager.getUtente(
        "etm.docente@unisa.it", "ciao"),null); //etm.docente@unisa.it è un docente registrato nel db

    assertNotEquals(autenticazioneManager.getUtente("etm.utente@studenti.unisa.it", "ciao"), null);

    assertEquals(autenticazioneManager.getUtente("prova", "nonesisto"), null);
  }

  @Test
  public void testGetAdmin() {
    assertNotEquals(autenticazioneManager.getAdmin("boss@admin.it", "qwert"),null);

    assertEquals(autenticazioneManager.getAdmin("admin@nonesiste.it", "qwert"),null);
  }

  @Test
  public void testGetPassword() {
    assertEquals(autenticazioneManager.getPassword("etm.docente@unisa.it"),"ciao");
  }

  @Test
  public void testSetValidazione() {
    assertTrue(autenticazioneManager.setValidazione("valido"));
  }

}
