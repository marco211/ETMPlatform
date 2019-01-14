package it.unisa.etm.testing.integration;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PartecipaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;

public class PartecipaManagerTest {
	private static PropostaTesiManager pm;
	private static  PartecipaManager partecipaManager;
	private static Partecipa partecipaOk;
	
	@BeforeClass
	public static void setUp() {
		partecipaManager= (PartecipaManager) new ManagerFactory().createPartecipaManager();
		partecipaOk= new Partecipa(11,"umberto@unisa.it");
	}
	
	@AfterClass
	public static void tearDown() {
		partecipaManager=null;
		partecipaOk=null;
	}
	
	@Test
	public void  testInserisciPartecipazione() {
		
		boolean inserisciPartecipazione= partecipaManager.inserisciPartecipazione(1,"etm.utentedieci@studenti.unisa.it");
		assertTrue(inserisciPartecipazione);
		
		inserisciPartecipazione=partecipaManager.inserisciPartecipazione(99, "boh");
		assertFalse(inserisciPartecipazione);
				
	}
	
	@Test
	public void testGetListaPartecipazione() {
		ArrayList<PropostaTesi> lista=  pm.getProposteTesiAttive();
		ArrayList<Partecipa> partecipazioni= partecipaManager.getListaPartecipazione(lista);
		assertNotEquals(partecipazioni, null);
	}
}
