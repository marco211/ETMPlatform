package it.unisa.etm.testing.integration;

import it.unisa.etm.bean.Utente;
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
	private static AmministratoreManager am;

	@BeforeClass
	public static void setUp() {
		um= new UtenteManager();
		am= new AmministratoreManager();
	}

	@AfterClass
	public static void tearDown() {
		um=null;
		am=null;
	}

	@Test
	public void testGetInfo() {

		String email=am.getListaUtenti().get(0).getEmail();
		Utente info= um.getInfo(email);
		assertNotEquals(info,null);

		if(!info.getEmail().equals(email)) fail("L'email deve essere uguale a quella inserita");


		info=um.getInfo("questaemailnonesiste@email.it");
		assertEquals(info,null);


	}
	@Test
	public void testCercaUtente() {
		String email=am.getListaUtenti().get(0).getEmail();
		Utente cerca;
		cerca = um.cercaUtente(email);
		assertNotEquals(cerca,null);

		cerca=um.cercaUtente("Emailchenonesiste@email.it");
		assertEquals(cerca, null);


	}
	@Test
	public void testModificaPassword() {
		Utente utente=am.getListaUtenti().get(0);


		boolean modifica= um.modificaPassword(utente);
		assertTrue(modifica);


		utente.setEmail("emailfake@email.it");
		modifica= um.modificaPassword(utente);
		assertFalse(modifica);



	}
	@Test
	public void testModificaUtente() {
		Utente utente=am.getListaUtenti().get(0);

		boolean modifica= um.modificaUtente(utente);
		assertTrue(modifica);


		utente.setEmail("emailfake@email.it");
		modifica=um.modificaUtente(utente);
		assertFalse(modifica);

	}
	@Test
	public void testCercaListaUtenteNome() {

		String nome=am.getListaUtenti().get(0).getNome();
		ArrayList<Utente> modifica= um.cercaListaUtenteNome(nome);
		assertNotEquals(modifica, null);

		nome="giovaawdaa32nni";
		modifica= um.cercaListaUtenteNome(nome);
		assertEquals(0, modifica.size());

	}
	@Test
	public void testCercaListaUtenteCognome() {

		String cognome=am.getListaUtenti().get(0).getCognome();
		ArrayList<Utente> modifica= um.cercaListaUtenteCognome(cognome);
		assertNotEquals(modifica, null);


		cognome="gwdawiova32nni";
		modifica= um.cercaListaUtenteCognome(cognome);
		assertEquals(0, modifica.size());

	}
}