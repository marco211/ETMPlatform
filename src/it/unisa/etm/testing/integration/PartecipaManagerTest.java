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
	private static Partecipa partecipa;
	
	@BeforeClass
	public static void setUp() {
		pm=new PropostaTesiManager();
		partecipaManager= (PartecipaManager) new ManagerFactory().createPartecipaManager();
		partecipa= new Partecipa(1,"etm.utenteuno@unisa.it");
	}
	
	@AfterClass
	public static void tearDown() {
		partecipaManager=null;
		partecipa=null;
		pm=null;
	}
	
	@Test
	public void  testInserisciPartecipazione() {
		
		boolean inserisciPartecipazione= partecipaManager.inserisciPartecipazione(2, partecipa.getUtenteEmail());
		assertTrue(inserisciPartecipazione);
		
		inserisciPartecipazione=partecipaManager.inserisciPartecipazione(99, "boh");
		assertFalse(inserisciPartecipazione);
				
	}
	
	@Test
	public void testGetListaPartecipazione() {
		PropostaTesiManager ptm = (PropostaTesiManager) new ManagerFactory().createPropostaTesiManager();
		
		ArrayList<PropostaTesi> lista=  ptm.getProposteTesiDocente("etm.docente@unisa.it");
		ArrayList<Partecipa> partecipazioni= partecipaManager.getListaPartecipazione(lista);
		assertNotEquals(partecipazioni, null);
	}
}
