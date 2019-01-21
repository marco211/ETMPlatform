package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import it.unisa.etm.model.bean.Insegnamento;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestInsegnamento {
  private static Insegnamento insegnamentoOk;
  private static Insegnamento insegnamentoNotOk;

  /**
   * Starting up.
   */
  @BeforeClass
  public static void setUp() {
    insegnamentoOk = new Insegnamento("Informatica",12);
    insegnamentoNotOk = new Insegnamento("Pasta",142);

  }
  
  /**
   * Exiting.
   */  
  @AfterClass
  public static void tearDown() {
    insegnamentoOk = null;
    insegnamentoNotOk = null;

  }
  
  @Test
  public void testGetCfu() {
    int cfu = insegnamentoOk.getCfu();
    assertEquals(cfu,12); //CFU giusti
    cfu = insegnamentoNotOk.getCfu();
    assertNotEquals(cfu,1434);//CFU errati
  }
  
  @Test
  public void testSetCfu() {
    int cfu = 12;
    insegnamentoOk.setCfu(cfu);
    assertEquals(12,insegnamentoOk.getCfu());

  }

  @Test
  public void testGetNome() {
    String nome = insegnamentoOk.getNome();
    assertEquals(nome, "Informatica");

    nome = insegnamentoNotOk.getNome();
    assertNotEquals(nome, "PastaConIlTonn34o");

  }

  @Test
  public void testSetNome() {
    String nome = "Informatica";
    insegnamentoOk.setNome(nome);
    assertEquals("Informatica",insegnamentoOk.getNome());

  }
}
