package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import it.unisa.etm.model.bean.Insegna;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestInsegna {
  private static Insegna insegnaOk;
  private static Insegna insegnaNotOk;

  @BeforeClass
  public static void setUp() {
    insegnaOk = new Insegna("utente1@unisa.it","Insegnamento1");
    insegnaNotOk = new Insegna("utente2@unisa.it","Insegnamento2");
  }

  @AfterClass
  public static void tearDown() {
    insegnaOk = null;
    insegnaNotOk = null;
  }

  @Test
  public void testGetUtenteEmail() {
    String email = insegnaOk.getUtenteEmail();
    assertEquals(email,"utente1@unisa.it"); //utente email corretta

    //utente email sbagliata, l'utente email corretta e utente2@unisa.it
    email = insegnaNotOk.getUtenteEmail();
    assertNotEquals(email,"utente3@unisa.it"); 
  }

  @Test
  public void testSetUtenteEmail() {
    String email = "utente1@unisa.it";
    insegnaOk.setUtenteEmail(email);
    assertEquals("utente1@unisa.it", insegnaOk.getUtenteEmail());
  }

  @Test
  public void testGetInsegnamentoNome() {
    String nome = insegnaOk.getInsegnamentoNome();
    assertEquals(nome,"Insegnamento1"); //nome insegamento corretto

    nome = insegnaNotOk.getInsegnamentoNome();
    //nome insegamento sbagliato, il nome dell'insegnamento corretto e Insegnamento2
    assertNotEquals(nome,"Insegnamento3"); 
  }

  @Test
  public void testSetInsegnamentoNome() {
    String nome = "Insegnamento1";
    insegnaOk.setInsegnamentoNome(nome);
    assertEquals("Insegnamento1",insegnaOk.getInsegnamentoNome());

  }

}
