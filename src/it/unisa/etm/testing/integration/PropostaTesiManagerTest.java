package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.RichiestaPartecipazione;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class PropostaTesiManagerTest {

  private static PropostaTesiManager pm;
  private static RichiestaPartecipazione richiesta;
  private static PropostaTesi proposta;

  /**
   * Starting up.
   */
  @BeforeClass
  public static void setUp() {
    LocalDate date = LocalDate.now();
    pm = (PropostaTesiManager) new ManagerFactory().createPropostaTesiManager();
    proposta = new PropostaTesi("I sistemi Operativi", "Informatica", 20,
        "Architettura","Breve Descrizione","etm.docenteuno@unisa.it",false,false);
    richiesta = new RichiestaPartecipazione(date,1,"etm.utentedue@unisa.it");
  }

  /**
   * When the test ends.
   */

  @AfterClass
  public static void tearDown() {
    pm = null;
    richiesta = null;
    proposta = null;
  }

  @Test
  public void testAccettaRichiestaPartecipazione() {

    assertTrue(pm.accettaRichiestaPartecipazione(1)); //Id corretto

    assertFalse(pm.accettaRichiestaPartecipazione(999)); //id sbagliato
  }

  @Test
  public void testRifiutaRichiestaPartecipazione() {
    assertTrue(pm.rifiutaRichiestaPartecipazione(2)); //Id corretto

    assertFalse(pm.rifiutaRichiestaPartecipazione(999));
  }

  @Test
  public void testCercaRichiestaPartecipazione() {
    // Ritorna L'email corretta
    assertNotEquals(pm.cercaRichiestePartecipazione("etm.docente@unisa.it"), null);

    //Ritorna Null poich� l'email � inesistente
    assertEquals(pm.cercaRichiestePartecipazione("emailnonesiste"),null); 
  }

  @Test 
  public void testInserisciRichiestaPartecipazione() {
    int id;

    id = richiesta.getId();

    // Inserisce la richiesta correttamente 
    assertTrue(pm.inserisciRichiestaPartecipazione(richiesta)); 

    richiesta.setId(30);
    richiesta.setUtente_mail("ddd");

    assertFalse(pm.inserisciRichiestaPartecipazione(richiesta)); // L'inserimento non va a buon fine

    richiesta.setId(id);
    richiesta.setUtente_mail("etm.utentedue@unisa.it");
  }

  @Test
  public void testInserisciPropostaTesi() {
    assertTrue(pm.inserisciPropostaTesi(proposta));//Inserisce la proposta correttamente

    proposta.setUtenteEmail("ciao");

    assertFalse(pm.inserisciPropostaTesi(proposta));// La proposta inserita non � valida

    proposta.setUtenteEmail("etm.docenteuno@unisa.it");
  }

  @Test
  public void testArchiviaPropostaTesi() {
    assertTrue(pm.archiviaPropostaTesi(1));// Archivia correttamente

    assertFalse(pm.archiviaPropostaTesi(99));// Non archivia poich� l'ID � inesistente
  }



  @Test
  public void testChiudiPropostaTesi() {
    assertTrue(pm.chiudiPropostaTesi(1));// La proposta viene chiusa correttamente

    assertFalse(pm.chiudiPropostaTesi(999));// La proposta non viene chiusa per ID errato
  }



  @Test
  public void testGetProposteTesiAttive() {
    assertNotEquals(pm.getProposteTesiAttive(), null);// Restituisce la lista delle proposta attive
  }

  @Test
  public void testGetProposteTesiDocente() {
    // Restituisce la lista delle proposta correttamente
    assertNotEquals(pm.getProposteTesiDocente("etm.docente@unisa.it"), null);

    // Non restituisce la lista poich� l'email � inesistente
    assertEquals(pm.getProposteTesiDocente("emailinesistente@ciao.it"), null);

  }

  @Test
  public void testGetPropostaTesi() {
    assertNotEquals(pm.getPropostaTesi(1), null);// Proposta tesi correttamente selezionata

    assertEquals(pm.getPropostaTesi(99),null);// La proposta tesi selezionata non esiste
  }

  @Test
  public void testModificaPropostaTesi() {
    int id;

    id = proposta.getId();

    proposta.setAmbito("NuovoAmbito");
    proposta.setId(1);

    assertTrue(pm.modificaPropostaTesi(proposta));// Proposta modificata correttamente

    proposta.setId(20);

    assertFalse(pm.modificaPropostaTesi(proposta));// Modifica della proposta fallita

    proposta.setUtenteEmail("etm.docenteuno@unisa.it");
    proposta.setId(id);
  }

  @Test
  public void testGetRichiestaStudente() {
    // Richiesta per studente corretta

    assertNotEquals(pm.getRichiestaStudente("etm.utentetre@unisa.it"), null);
    // Richiesta per studente errata per l'Email
    assertEquals(pm.getRichiestaStudente("emailnonesistente"), null);
  }

  @Test
  public void testGetInsegnamenti() {
    assertNotEquals(pm.getInsegnamenti(), null);// Restituisce la lista degli insegnamenti

  }

  @Test
  public void testGetTesiRecenti() {
    assertNotEquals(pm.getTesiRecenti(), null);// Restituisce la lista delle Tesi recenti
  }

  @Test
  public void testRimuoviPropostaTesi() {
    assertTrue(pm.rimuoviPropostaTesi(proposta.getId()));
  }
}