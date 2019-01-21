package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import it.unisa.etm.model.bean.Partecipa;
import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PartecipaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



public class PartecipaManagerTest {
  private static  PartecipaManager partecipaManager;
  private static Partecipa partecipa;

  @BeforeClass
  public static void setUp() {
    partecipaManager = (PartecipaManager) new ManagerFactory().createPartecipaManager();
    partecipa = new Partecipa(1,"etm.utenteuno@unisa.it");
  }

  @AfterClass
  public static void tearDown() {
    partecipaManager = null;
    partecipa = null;
  }

  @Test
  public void  testInserisciPartecipazione() {
    assertTrue(partecipaManager.inserisciPartecipazione(2, partecipa.getUtenteEmail()));

    assertFalse(partecipaManager.inserisciPartecipazione(99, "boh"));
  }

  @Test
  public void testGetListaPartecipazione() {
    PropostaTesiManager ptm = (PropostaTesiManager) 
        new ManagerFactory().createPropostaTesiManager();


    assertNotEquals(partecipaManager
        .getListaPartecipazione(ptm.getProposteTesiDocente("etm.docente@unisa.it")), null);
    ArrayList<PropostaTesi> lista =  ptm.getProposteTesiDocente("etm.docente@unisa.it");
    ArrayList<Partecipa> partecipazioni = partecipaManager.getListaPartecipazione(lista);
    assertNotEquals(partecipazioni, null);
  }
}
