package it.unisa.etm.testing.integration;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.UtenteManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
public class UtenteManagerTest {
	private static UtenteManager um;
	private Utente st,doc;
	
	@BeforeClass
	public static void setUp() {
		um= new UtenteManager();
	}

	@AfterClass
	public static void tearDown() {
		um=null;
	}

	@Test
	public void testGetInfo() {
		
			
		st = um.getInfo("etm.utente@unisa.it");
		doc = um.getInfo("etm.docente@unisa.it");
		
		assertNotEquals(st,null);

		assertNotEquals(doc,null);
		
		st=um.getInfo("questaemailnonesiste@email.it");
		assertEquals(st,null);


	}
	@Test
	public void testCercaUtente() {
		st = um.cercaUtente("etm.utente@unisa.it");
		doc = um.cercaUtente("etm.docente@unisa.it");

		assertNotEquals(st,null);
		assertNotEquals(doc,null);
		
		st=um.cercaUtente("Emailchenonesiste@email.it");
		assertEquals(st, null);


	}
	@Test
	public void testModificaPassword() {
		
		st=um.cercaUtente("etm.utente@unisa.it");
		doc=um.cercaUtente("etm.docente@unisa.it");

		st.setPassword("prova");
		doc.setPassword("prova");
		
		assertTrue(um.modificaPassword(st));
		assertTrue(um.modificaPassword(doc));


		st.setEmail("");
		assertFalse(um.modificaPassword(st));

	}
	
	@Test
	public void testModificaUtente() {
		st=um.cercaUtente("etm.utente@unisa.it");
		doc=um.cercaUtente("etm.docente@unisa.it");

		st.setMatricola("0552100552");
		doc.setUfficio("Ufficio 01");
		
		assertTrue(um.modificaUtente(st));
		assertTrue(um.modificaUtente(doc));


		st.setEmail("emailfake@email.it");
		assertFalse(um.modificaUtente(st));

	}
	
	@Test
	public void testCercaListaUtenteNome() {

		ArrayList<Utente> lista = um.cercaListaUtenteNome("Utente");
		assertNotEquals(lista, null);

		 lista = um.cercaListaUtenteNome("Clelia");
			assertNotEquals(lista, null);
	
		lista = um.cercaListaUtenteNome("gkfoeaf");
		assertEquals(lista, null);

	}
	
	@Test
	public void testCercaListaUtenteCognome() {


		ArrayList<Utente> lista = um.cercaListaUtenteCognome("Di Prova");
		assertNotEquals(lista, null);

		lista = um.cercaListaUtenteCognome("De Felice");
		assertNotEquals(lista, null);
	
		lista = um.cercaListaUtenteCognome("gkfoeaf");
		assertEquals(lista, null);

	}
}