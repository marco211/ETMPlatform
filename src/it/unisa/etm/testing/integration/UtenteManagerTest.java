package it.unisa.etm.testing.integration;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.UtenteManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
public class UtenteManagerTest {
	private static UtenteManager utenteOk, utenteNotOk;
	private AmministratoreManager am= new AmministratoreManager();
	private static Utente studenteNotOk;
	
	@BeforeClass
	public static void setUp() {
		utenteOk= new UtenteManager();
		utenteNotOk= new UtenteManager();
		studenteNotOk= new Utente("Error","1900-01-02","Fail","x","error@fail.com","error123","111111","!valido");
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
		}
    	
    }
    @Test
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
		}
    	
    }
    @Test
    public void testModificaPassword() {
    	try {
			Utente utente=am.getListaUtenti().get(0);
			boolean modifica= utenteOk.modificaPassword(utente);
			assertTrue(modifica);
		} catch (Exception e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    	try {
    		boolean modifica= utenteNotOk.modificaPassword(studenteNotOk);
    		assertTrue(modifica);
    	}catch (Exception e) {
		}
    	
    	
    }
    @Test
    public void testModificaUtente() {
    	try {
			Utente utente=am.getListaUtenti().get(0);
			boolean modifica= utenteOk.modificaUtente(utente);
			assertTrue(modifica);
		} catch (Exception e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    	try {
    		boolean modifica=utenteNotOk.modificaUtente(studenteNotOk);
    		assertTrue(modifica);
    	}catch (Exception e) {
		}
    }
    @Test
    public void testCercaListaUtenteNome() {
    	try {
			String nome=am.getListaUtenti().get(0).getNome();
			ArrayList<Utente> modifica= utenteOk.cercaListaUtenteNome(nome);
			assertNotEquals(modifica, null);
		} catch (Exception e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    	try {
			String nome="giova32nni";
			ArrayList<Utente> modifica= utenteOk.cercaListaUtenteNome(nome);
			assertNotEquals(modifica, null);
		} catch (Exception e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    }
    @Test
    public void testCercaListaUtenteCognome() {
    	try {
			String cognome=am.getListaUtenti().get(0).getNome();
			ArrayList<Utente> modifica= utenteOk.cercaListaUtenteCognome(cognome);
			assertNotEquals(modifica, null);
		} catch (Exception e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    	try {
			String cognome="giova32nni";
			ArrayList<Utente> modifica= utenteOk.cercaListaUtenteCognome(cognome);
			assertNotEquals(modifica, null);
		} catch (Exception e) {
			fail("non deve lanciare eccezioni");
			e.printStackTrace();
		}
    }
}