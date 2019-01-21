package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import it.unisa.etm.model.bean.Consegna;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestConsegna {
  private static Consegna consegnaOk;
  private static Consegna consegnaNotOk;

  @BeforeClass
  public static void setUp() {
    consegnaOk = new Consegna("Consegna1","Descrizione consegna1","scadenza1",1);
    consegnaNotOk = new Consegna("Consegna2","Descrizione consegna2","scadenza2",2);
  }

  /**
   * Exiting.
   */
  @AfterClass
  public static void tearDown() {
    consegnaOk = null;
    consegnaNotOk = null;

  }

  @Test
  public void testGetNome() {
    String nome = consegnaOk.getNome();
    assertEquals(nome,"Consegna1");// nome giusto

    nome = consegnaNotOk.getNome();
    assertNotEquals(nome,"Consegna0303");// nome sbagliato, il nome giusto e Consegna2
  }

  @Test
  public void testSetNome() {
    String nome = "Consegna1";
    consegnaOk.setNome(nome);
    assertEquals("Consegna1",consegnaOk.getNome());

    nome = "Consegna2";
    consegnaNotOk.setNome(nome);
    assertEquals("Consegna2",consegnaNotOk.getNome());
  }

  @Test
  public void testGetDescrzione() {
    String descrizione = consegnaOk.getDescrzione();
    assertEquals(descrizione,"Descrizione consegna1");// descrizione giusta

    // descrizione sbagliata, la descrizione giusta e "Descrizione consegna2"
    descrizione = consegnaNotOk.getDescrzione();
    assertNotEquals(descrizione,"Descrizione consegna0303");
  }

  @Test
  public void testSetDescrzione() {
    String descrizione = "Descrizione consegna1";
    consegnaOk.setDescrzione(descrizione);
    assertEquals("Descrizione consegna1",consegnaOk.getDescrzione());

    descrizione = "Descrizione consegna2";
    consegnaNotOk.setDescrzione(descrizione);
    assertEquals("Descrizione consegna2",consegnaNotOk.getDescrzione());
  }

  @Test
  public void testGetScadenza() {
    String scadenza = consegnaOk.getScadenza();
    assertEquals(scadenza,"scadenza1");//scadenza giusta

    //scadenza sbaglita, la descrizione corretta e scadenza2
    scadenza = consegnaNotOk.getScadenza();
    assertNotEquals(scadenza,"scadenza0303");
  }

  @Test
  public void testSetScadenza() {
    String scadenza = "scadenza1";
    consegnaOk.setScadenza(scadenza);
    assertEquals("scadenza1",consegnaOk.getScadenza());

    scadenza = "scadenza2";
    consegnaNotOk.setScadenza(scadenza);
    assertEquals("scadenza2",consegnaNotOk.getScadenza());
  }

  @Test
  public void testGetPropostaTesiId() {
    int id = consegnaOk.getPropostaTesiId();
    assertEquals(id,1); //proposta tesi id giusto

    id = consegnaNotOk.getPropostaTesiId();
    assertNotEquals(id,3); //proposta tesi id sbagliato, quello giusto e 3
  }

  @Test
  public void testSetPropostaTesiId() {
    int id = 1;
    consegnaOk.setPropostaTesiId(id);
    assertEquals(1,consegnaOk.getPropostaTesiId());

    id = 2;
    consegnaNotOk.setPropostaTesiId(id);
    assertEquals(2,consegnaNotOk.getPropostaTesiId());

  }


}
