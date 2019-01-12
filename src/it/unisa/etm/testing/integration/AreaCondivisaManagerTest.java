package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.File;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AreaCondivisaManager;

public class AreaCondivisaManagerTest {
	@BeforeClass
	public static void setUp() {
		am = (AreaCondivisaManager) new ManagerFactory().createAreaCondivisaManager();
		
	}
	@AfterClass
	public static void tearDown() {
		am = null;
		
	}
	
	@Test
	public void inserisciFileTest() {
		File f = new File("prova", 1, "file prova", 5, "bravo", "etm.studente@studenti.unisa.it");
		assertFalse(am.inserisciFile(f));
	}
	
	private static AreaCondivisaManager am;
}
