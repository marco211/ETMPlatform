package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import it.unisa.etm.model.bean.Attivita;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestAttivita {

  private static Attivita attivitaOk;
  private static Attivita attivitaNotOk;

  /**
   * Starting up.
   */
  @BeforeClass
  public static void setUp() {
    attivitaOk = new Attivita("email@unisa.it","File1",LocalDate.now(),"A",1);
    attivitaNotOk = new Attivita("false@unisa.it","File2",LocalDate.now(),"B",2);
    attivitaOk.setTipo("af");
    Logger.getLogger("log").info(attivitaOk.toString());
    attivitaOk.setTipo("vf");
    Logger.getLogger("log").info(attivitaOk.toString());
    attivitaOk.setTipo("ef");
    Logger.getLogger("log").info(attivitaOk.toString());
  }

  @AfterClass
  public static void tearDown() {
    attivitaOk = null;
    attivitaNotOk = null;
  }


  @Test
  public void testGetUtente_Email() {
    String email = attivitaOk.getUtente_Email();
    assertEquals(email,"email@unisa.it"); //email giusta

    email = attivitaNotOk.getUtente_Email();
    assertNotEquals(email,"sbagliata@email.it"); //email sbagliata, l'iemail giusta e false@unisa.it


  }

  @Test
  public void testSetUtente_Email() {
    String email = "email@unisa.it";
    attivitaOk.setUtente_Email(email);
    assertEquals("email@unisa.it",attivitaOk.getUtente_Email());

    email = "false@unisa.it";
    attivitaNotOk.setUtente_Email(email);
    assertEquals("false@unisa.it",attivitaNotOk.getUtente_Email());
  }

  @Test
  public void testgetNome() {
    String nomeFile = attivitaOk.getNome();
    assertEquals(nomeFile,"File1");//nome file giusto

    nomeFile = attivitaNotOk.getNome();
    assertNotEquals(nomeFile,"File001");//nome file sbagliato, il nome file giusto e File2
  }

  @Test
  public void testsetNome() {
    String nomeFile = "File1";
    attivitaOk.setNome(nomeFile);
    assertEquals("File1",attivitaOk.getNome());

    nomeFile = "File2";
    attivitaNotOk.setNome(nomeFile);
    assertEquals("File2",attivitaNotOk.getNome());
  }

  @Test
  public void testGetData() {
    LocalDate date = attivitaOk.getData();
    assertEquals(date,attivitaOk.getData());// data giusta

    // data sbagliata, poich� la data inserita nel test e gia passata
    date = attivitaNotOk.getData();
    assertNotEquals(date,"2001-01-01");
  }

  @Test
  public void testSetData() {
    LocalDate data = LocalDate.now();
    attivitaOk.setData(data);
    assertEquals(LocalDate.now(),attivitaOk.getData());

    attivitaNotOk.setData(data);
    assertEquals(LocalDate.now(),attivitaNotOk.getData());
  }

  @Test
  public void testGetTipo() {
    String tipo = attivitaOk.getTipo();
    assertEquals(tipo,"ef");// tipo giusto

    tipo = attivitaNotOk.getTipo();
    assertNotEquals(tipo,"C"); // tipo sbagliato, il tipo giusto e B
  }

  @Test
  public void testSetTipo() {
    String tipo = "A";
    attivitaOk.setTipo(tipo);
    assertEquals("A",attivitaOk.getTipo());

    tipo = "B";
    attivitaNotOk.setTipo(tipo);
    assertEquals("B",attivitaNotOk.getTipo());
  }

  @Test
  public void testGetPropostatesi_id() {
    int id = attivitaOk.getPropostatesi_id();
    assertEquals(id,1);// proposta tesi id giusto

    id = attivitaNotOk.getPropostatesi_id();
    assertNotEquals(id,3);// proposta tesi id sbagliato, il proposta tesi id giusto e 2
  }

  @Test
  public void testSetPropostatesi_id() {
    int id = 1;
    attivitaOk.setPropostatesi_id(id);
    assertEquals(1,attivitaOk.getPropostatesi_id());

    id = 2;
    attivitaNotOk.setPropostatesi_id(id);
    assertEquals(2,attivitaNotOk.getPropostatesi_id());
  }


  @Test
  public void testGetLetto() {
    assertEquals(false, attivitaOk.getLetto());
        
  }
  
  @Test
  public void testSetLetto() {
    attivitaOk.setLetto(true);
    assertEquals(true, attivitaOk.getLetto());
    attivitaOk.setLetto(false);
  }
  
  @Test
  public void testGetId() {
    
  }
  
  @Test
  public void testSetId() {
    
  }
  
}
