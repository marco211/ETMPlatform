package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import it.unisa.etm.model.bean.Amministratore;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAmministratore {

  private static Amministratore adminOk;
  private static Amministratore adminNotOk;

  @BeforeClass
  public static void setUp() {
    adminOk = new Amministratore("boss@admin.it","Marco","Della Medaglia","qwert");
    adminNotOk = new Amministratore("false@admin.it","Paolo","Bonolis","qwert");
  }

  @AfterClass
  public static void tearDown() {
    adminOk = null;
    adminNotOk = null;
  }

  @Test
  public void testGetPassword() {
    String password = adminOk.getPassword();
    assertEquals(password,"qwert"); //password giusta

    password = adminNotOk.getPassword();
    assertNotEquals(password,"ciao"); //password sbagliata, la password giusta e qwert
  }


  @Test
  public void testSetPassword() {
    String password = "qwert";
    adminOk.setPassword(password);
    assertEquals("qwert",adminOk.getPassword());

    password = "qwert";
    adminNotOk.setPassword(password);
    assertEquals("qwert",adminNotOk.getPassword());
  }

  @Test
  public void testGetNome() {
    String nome = adminOk.getNome();
    assertEquals(nome,"Marco"); //nome giusto

    nome = adminNotOk.getNome();
    assertNotEquals(nome,"Domenico"); //nome sbagliato, il nome giusto e Paolo
  }

  @Test
  public void testSetNome() {
    String nome = "Marco";
    adminOk.setNome(nome);
    assertEquals("Marco",adminOk.getNome());

    nome = "Paolo";
    adminNotOk.setNome(nome);
    assertEquals("Paolo",adminNotOk.getNome());
  }

  @Test
  public void testGetCognome() {
    String cognome = adminOk.getCognome();
    assertEquals(cognome,"Della Medaglia");//cognome giusto

    cognome = adminNotOk.getCognome();
    assertNotEquals(cognome,"Nappi"); //cognome sbagliato, il cognome giusto e Bonolis
  }

  @Test
  public void testSetCognome() {
    String cognome = "Della Medaglia";
    adminOk.setCognome(cognome);
    assertEquals("Della Medaglia",adminOk.getCognome());

    cognome = "Bonolis";
    adminNotOk.setCognome(cognome);
    assertEquals("Bonolis",adminNotOk.getCognome());
  }

  @Test
  public void testGetEmail() {
    String email = adminOk.getEmail();
    assertEquals(email,"boss@admin.it");//email giusta

    email = adminNotOk.getEmail();
    assertNotEquals(email,"false0303@admin.it"); //email sbagliata, l'email giusta e false@admin.it
  }

  @Test
  public void testSetEmail() {
    String email = "boss@admin.it";
    adminOk.setEmail(email);
    assertEquals("boss@admin.it",adminOk.getEmail());

    email = "false@admin.it";
    adminNotOk.setEmail(email);
    assertEquals("false@admin.it",adminNotOk.getEmail());
  }


}

