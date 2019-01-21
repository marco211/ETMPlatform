package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.manager.UtenteManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtenteManagerTest {
  private static UtenteManager um;
  private Utente st;
  private Utente doc;

  @BeforeClass
  public static void setUp() {
    um = new UtenteManager();
  }

  @AfterClass
  public static void tearDown() {
    um = null;
  }

  @Test
  public void testGetInfo() {
    assertNotEquals(um.getInfo("etm.utente@unisa.it"),null);

    assertNotEquals(um.getInfo("etm.docente@unisa.it"),null);

    assertEquals(um.getInfo("questaemailnonesiste@email.it"),null);
  }
  
  @Test
  public void testCercaUtente() {
    assertNotEquals(um.cercaUtente("etm.utente@unisa.it"),null);

    assertNotEquals(um.cercaUtente("etm.docente@unisa.it"),null);

    assertEquals(um.cercaUtente("Emailchenonesiste@email.it"), null);
  }

  @Test
  public void testModificaPassword() {    
    st = um.cercaUtente("etm.utente@unisa.it");
    doc = um.cercaUtente("etm.docente@unisa.it");

    //setto la stessa password per non modificare dati nel database
    st.setPassword(st.getPassword());
    doc.setPassword(doc.getPassword());

    assertTrue(um.modificaPassword(st));
    assertTrue(um.modificaPassword(doc));
    
    st.setEmail("");
    assertFalse(um.modificaPassword(st));

  }

  @Test
  public void testModificaUtente() {
    st = um.cercaUtente("etm.utente@unisa.it");
    doc = um.cercaUtente("etm.docente@unisa.it");
    
    st.setMatricola("0552100552");
    doc.setUfficio("Ufficio 01");

    assertTrue(um.modificaUtente(st));
    assertTrue(um.modificaUtente(doc));
    
    st.setEmail("emailfake@email.it");
    assertFalse(um.modificaUtente(st));

  }

  @Test
  public void testCercaListaUtenteNome() {

    assertNotEquals(um.cercaListaUtenteNome("Utente"), null);

    assertNotEquals(um.cercaListaUtenteNome("Clelia"), null);

    assertEquals(um.cercaListaUtenteNome("gkfoeaf"), null);

  }

  @Test
  public void testCercaListaUtenteCognome() {


    assertNotEquals(um.cercaListaUtenteCognome("Di Prova"), null);

    assertNotEquals(um.cercaListaUtenteCognome("De Felice"), null);

    assertEquals(um.cercaListaUtenteCognome("gkfoeaf"), null);

  }
}