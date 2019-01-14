package it.unisa.etm.testing.integration;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.model.manager.PropostaTesiManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.cj.result.LocalDateValueFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;


public class PropostaTesiManagerTest {
	private static PropostaTesiManager pm;
	private static RichiestaPartecipazione richiesta;
	private static PropostaTesi proposta;

	@BeforeClass
	public static void setUp() {
		LocalDate date=LocalDate.now();
		pm= (PropostaTesiManager) new ManagerFactory().createPropostaTesiManager();
		proposta = new PropostaTesi("I sistemi Operativi", "Informatica", 20,"Architettura","Breve Descrizione","etm.docenteuno@unisa.it",false,false );
		richiesta= new RichiestaPartecipazione(date,1,"etm.utentedue@unisa.it");
	}

	@AfterClass
	public static void tearDown() {
		pm=null;
		richiesta= null;
		proposta= null;
	}

	@Test
	public void testAccettaRichiestaPartecipazione() {

		boolean accetta= pm.accettaRichiestaPartecipazione(1); //Id corretto
		assertTrue(accetta);


		accetta= pm.accettaRichiestaPartecipazione(999);
		assertFalse(accetta);
	}

	@Test
	public void testRifiutaRichiestaPartecipazione() {

		boolean rifiuta= pm.rifiutaRichiestaPartecipazione(2); //Id corretto
		assertTrue(rifiuta);

		rifiuta= pm.rifiutaRichiestaPartecipazione(999);
		assertFalse(rifiuta);
	}

	@Test
	public void testCercaRichiestaPartecipazione() {

		ArrayList<RichiestaPartecipazione> cercaRichiesta= pm.cercaRichiestePartecipazione("etm.docente@unisa.it");
		assertNotEquals(cercaRichiesta, null);// Ritorna L'email corretta

		cercaRichiesta= pm.cercaRichiestePartecipazione("emailnonesiste");
		assertEquals(cercaRichiesta,null); //Ritorna Null poichè l'email è inesistente
	}

	@Test 
	public void testInserisciRichiestaPartecipazione() {
		int id = richiesta.getId();

		boolean inserisciRichiesta= pm.inserisciRichiestaPartecipazione(richiesta);
		assertTrue(inserisciRichiesta);// Inserisce la richiesta correttamente		

		richiesta.setId(30);
		richiesta.setUtente_mail("ddd");
		inserisciRichiesta= pm.inserisciRichiestaPartecipazione(richiesta);
		assertFalse(inserisciRichiesta);// L'inserimento non va a buon fine

		richiesta.setId(id);
		richiesta.setUtente_mail("etm.utentedue@unisa.it");
	}

	@Test
	public void testInserisciPropostaTesi() {
		boolean inserisciProposta= pm.inserisciPropostaTesi(proposta);
		assertTrue(inserisciProposta);//Inserisce la proposta correttamente	

		proposta.setUtenteEmail("ciao");
		inserisciProposta= pm.inserisciPropostaTesi(proposta);
		assertFalse(inserisciProposta);// La proposta inserita non è valida
		proposta.setUtenteEmail("etm.docenteuno@unisa.it");
	}

	@Test
	public void testArchiviaPropostaTesi (){

		boolean archivia= pm.archiviaPropostaTesi(1);
		assertTrue(archivia);// Archivia correttamente	


		archivia=pm.archiviaPropostaTesi(99);
		assertFalse(archivia);// Non archivia poichè l'ID è inesistente
	}



	@Test
	public void testChiudiPropostaTesi() {

		boolean chiudiProposta= pm.chiudiPropostaTesi(1);
		assertTrue(chiudiProposta);// La proposta viene chiusa correttamente


		chiudiProposta= pm.chiudiPropostaTesi(999);
		assertFalse(chiudiProposta);// La proposta non viene chiusa per ID errato

	}



	@Test
	public void testGetProposteTesiAttive() {
		ArrayList<PropostaTesi> proposteAttive= pm.getProposteTesiAttive();
		assertNotEquals(proposteAttive, null);// Restituisce la lista delle proposta attive
	}

	@Test
	public void testGetProposteTesiDocente() {
		String email= proposta.getUtenteEmail();
		ArrayList<PropostaTesi> proposteDocente= pm.getProposteTesiDocente(email);
		assertNotEquals(proposteDocente, null);// Restituisce la lista delle proposta correttamente

		email="emailinesistente@ciao.it";
		proposteDocente= pm.getProposteTesiDocente(email);
		assertEquals(proposteDocente, null);// Non restituisce la lista poichè l'email è inesistente

	}

	@Test
	public void testGetPropostaTesi() {

		PropostaTesi proposta= pm.getPropostaTesi(1);
		assertNotEquals(proposta, null);// Proposta tesi correttamente selezionata	


		proposta=pm.getPropostaTesi(99);
		assertEquals(proposta,null);// La proposta tesi selezionata non esiste

	}

	@Test
	public void testModificaPropostaTesi() {
		int id = proposta.getId();

		proposta.setAmbito("NuovoAmbito");
		proposta.setId(1);

		boolean modifica= pm.modificaPropostaTesi(proposta);
		assertTrue(modifica);// Proposta modificata correttamente

		proposta.setId(20);
		modifica= pm.modificaPropostaTesi(proposta);
		assertFalse(modifica);// Modifica della proposta fallita

		proposta.setUtenteEmail("etm.docenteuno@unisa.it");
		proposta.setId(id);
	}

	@Test
	public void testGetRichiestaStudente() {

		ArrayList<RichiestaPartecipazione> richieste= pm.getRichiestaStudente(richiesta.getUtente_mail());
		assertNotEquals(richieste, null);// Richiesta per studente corretta

		richieste = pm.getRichiestaStudente("emailnonesistente");
		assertEquals(richieste, null);// Richiesta per studente errata per l'Email

	}
	@Test
	public void testGetInsegnamenti() {
		ArrayList<Insegnamento> insegnamento= pm.getInsegnamenti();
		assertNotEquals(insegnamento, null);// Restituisce la lista degli insegnamenti

	}

	@Test
	public void testGetTesiRecenti() {
		ArrayList<PropostaTesi> recenti= pm.getTesiRecenti();
		assertNotEquals(recenti, null);// Restituisce la lista delle Tesi recenti
	}
}