package it.unisa.etm.testing.utente;

import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.UtenteManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
public class UtenteManagerTest {
	private static UtenteManager utenteOk, utenteNotOk;
	private AmministratoreManager am= new AmministratoreManager();
	
	@BeforeClass
	public static void setUp() {
		utenteOk= new UtenteManager();
		utenteNotOk= new UtenteManager();
	}
	
    @AfterClass
    public static void tearDown() {
    	utenteOk=null;
    	utenteNotOk=null;
    }
    
    @Test
    public void testGetInfo() {
    	try {
    		String test=am.getListaUtenti().get(0).getEmail();
			Utente info= utenteOk.getInfo(test);
			assertNotEquals(info,null);
		} catch (SQLException e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    	
    	try {
			Utente info=utenteNotOk.getInfo("ciaoneproprio@email.it");
			assertEquals(info,null);
		} catch (SQLException e) {
			fail("deve lanciare eccezioni");
			e.printStackTrace();
		}
    	
    }
    /*@Test
    public void testCercaUtente() {
    	String test=am.getListaUtenti().get(0).getEmail();
    	Utente cerca;
		try {
			cerca = utenteOk.cercaUtente(test);
			assertNotEquals(cerca,null);
		} catch (SQLException e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
		try {
			cerca=utenteNotOk.cercaUtente("ciaoneproprio@email.it");
			assertEquals(cerca, null);
		} catch (SQLException e) {
			fail("deve lanciare eccezioni");
			e.printStackTrace();
		}
    	
    }*/
}