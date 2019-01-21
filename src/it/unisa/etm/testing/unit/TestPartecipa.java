package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import it.unisa.etm.model.bean.Partecipa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestPartecipa {
  private static Partecipa partecipaOk;
  private static Partecipa partecipaNotOk;

  /**
   * Starting up.
   */
  @BeforeClass
  public static void setUp() {
    partecipaOk = new Partecipa(1,"umberto@unisa.it");
    partecipaNotOk = new Partecipa(2,"error@fail.com");

  }
  
  /**
   * Exiting.
   */
  @AfterClass
  public static void tearDown() {
    partecipaOk = null;
    partecipaNotOk = null;

  }
  
  @Test
  public void testGetPropostaTesiId() {
    int id = partecipaOk.getPropostaTesiId();
    assertEquals(id,1); // Id Corretto

    id = partecipaNotOk.getPropostaTesiId();
    assertNotEquals(id,32); // Id Errato
  }
  
  @Test
  public void testSetPropostaTesiId() {
    int id = 1;
    partecipaOk.setPropostaTesiId(id);
    assertEquals(1,partecipaOk.getPropostaTesiId());
  } 
  
  @Test
  public void testGetUtenteEmail() {
    String utenteEmail = partecipaOk.getUtenteEmail();
    assertEquals(utenteEmail, "umberto@unisa.it"); //Email Corretta
    utenteEmail = partecipaNotOk.getUtenteEmail();
    assertNotEquals(utenteEmail, "error@fa3il.com"); // Email Errata


  }

  @Test
  public void testSetUtenteEmail() {
    String email = "umberto@unisa.it";
    partecipaOk.setUtenteEmail(email);
    assertEquals("umberto@unisa.it",email);

  }

}
