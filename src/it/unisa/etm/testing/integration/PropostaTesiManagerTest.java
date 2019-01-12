package it.unisa.etm.testing.integration;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.model.manager.PropostaTesiManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;


public class PropostaTesiManagerTest {
	private static PropostaTesiManager pm;
	private static RichiestaPartecipazione richiestaOk;
	private static PropostaTesi propostaOk;
	
	@BeforeClass
	public static void setUp() {
		LocalDate date=LocalDate.now();
		pm= (PropostaTesiManager) new ManagerFactory().createPropostaTesiManager();
		propostaOk= new PropostaTesi("I sistemi Operativi", "Informatica", 20,"Architettura","Breve Descrizione","umberto@unisa.it",false,false );
		richiestaOk= new RichiestaPartecipazione(date,11,"umberto@unisa.it");
	}
	
	@AfterClass
	public static void tearDown() {
		pm=null;
	    richiestaOk= null;
	    propostaOk= null;
	}
	
	@Test
	public void testAccettaRichiestaPartecipazione() {
		int id = richiestaOk.getPropostatesi_id();
		boolean accetta= pm.accettaRichiestaPartecipazione(id); //Id corretto
		assertTrue(accetta);
		
		id= 999; //Id Insistente
		accetta= pm.accettaRichiestaPartecipazione(id);
		assertFalse(accetta);
	}
	
	@Test
	public void testRifiutaRichiestaPartecipazione() {
		int id = richiestaOk.getPropostatesi_id();
		boolean rifiuta= pm.rifiutaRichiestaPartecipazione(id); //Id corretto
		assertTrue(rifiuta);
		
		id= 999; //Id Insistente
		rifiuta= pm.rifiutaRichiestaPartecipazione(id);
		assertFalse(rifiuta);
	}
	
	@Test
	public void testCercaRichiestaPartecipazione() {
		String email= richiestaOk.getUtente_mail();
		ArrayList<RichiestaPartecipazione> cercaRichiesta= pm.cercaRichiestePartecipazione(email);
		assertNotEquals(cercaRichiesta, null);// Ritorna L'email corretta
		
		email= "Emailinesistente@fail.it";
		cercaRichiesta= pm.cercaRichiestePartecipazione(email);
		assertEquals(cercaRichiesta, null); //Ritorna Null poichè l'email è inesistente
	}
	
	@Test 
	public void testInserisciRichiestaPartecipazione() {
		boolean inserisciRichiesta= pm.inserisciRichiestaPartecipazione(richiestaOk);
		assertTrue(inserisciRichiesta);// Inserisce la richiesta correttamente		
		
		RichiestaPartecipazione richiestaNotOk= new RichiestaPartecipazione(null,999,null);
		inserisciRichiesta= pm.inserisciRichiestaPartecipazione(richiestaNotOk);
		assertFalse(inserisciRichiesta);// L'inserimento non va a buon fine
	}
	@Test
	public void testInserisciPropostaTesi() {
		boolean inserisciProposta= pm.inserisciPropostaTesi(propostaOk);
		assertTrue(inserisciProposta);//Inserisce la proposta correttamente	
		
		PropostaTesi propostaNotOk=  new PropostaTesi("Errori a non finire 123",null,120,null,"Nessuna Descrizione",null, true, true);
		inserisciProposta= pm.inserisciPropostaTesi(propostaNotOk);
		assertFalse(inserisciProposta);// La proposta inserita non è valida
		
	}
	
	@Test
	public void testArchiviaPropostaTesi (){
		int id= propostaOk.getId();
		boolean archivia= pm.archiviaPropostaTesi(id);
		assertTrue(archivia);// Archivia correttamente	
		
		id=999;
		archivia=pm.archiviaPropostaTesi(id);
		assertFalse(archivia);// Non archivia poichè l'ID è inesistente
	}
	
	@Test
	public void testCercaPropostaTesi() {
		String titolo= propostaOk.getTitolo();
		ArrayList<PropostaTesi> cercaProposta= pm.cercaProposteTesi(titolo);
		assertNotEquals(cercaProposta, null);// La ricerca va a buon fine
		
		titolo= "TitoloInesistente";
		cercaProposta=pm.cercaProposteTesi(titolo);
		assertEquals(cercaProposta, null);// Ritorna null poichè il titolo cerca non esiste
	}
	
	@Test
	public void testChiudiPropostaTesi() {
		int id= propostaOk.getId();
		boolean chiudiProposta= pm.chiudiPropostaTesi(id);
		assertTrue(chiudiProposta);// La proposta viene chiusa correttamente
		
		id= 999;
		chiudiProposta= pm.chiudiPropostaTesi(id);
		assertFalse(chiudiProposta);// La proposta non viene chiusa per ID errato
		
	}
	
	@Test
	public void testRimuoviPropostatesi() {
		int id = propostaOk.getId();
		boolean rimuoviProposta= pm.rimuoviPropostaTesi(id);
		assertTrue(rimuoviProposta);// la proposta viene rimossa correttamente
		
		id= 999;
		rimuoviProposta=pm.rimuoviPropostaTesi(id);
		assertFalse(rimuoviProposta);// la proposta non viene rimossa correttamente
	}
	
	@Test
	public void testGetProposteTesiAttive() {
		ArrayList<PropostaTesi> proposteAttive= pm.getProposteTesiAttive();
		assertNotEquals(proposteAttive, null);// Restituisce la lista delle proposta attive
	}
	
	@Test
	public void testGetProposteTesiDocente() {
		String email= propostaOk.getUtenteEmail();
		ArrayList<PropostaTesi> proposteDocente= pm.getProposteTesiDocente(email);
		assertNotEquals(proposteDocente, null);// Restituisce la lista delle proposta correttamente
		
		email="emailinesistente@ciao.it";
		proposteDocente= pm.getProposteTesiDocente(email);
		assertEquals(proposteDocente, null);// Non restituisce la lista poichè l'email è inesistente
		
	}
	
	@Test
	public void testGetPropostaTesi() {
		int id= propostaOk.getId();
		PropostaTesi proposta= pm.getPropostaTesi(id);
		assertNotEquals(proposta, null);// Proposta tesi correttamente selezionata	
		
		id= 999;
		proposta=pm.getPropostaTesi(id);
		assertEquals(proposta,null);// La proposta tesi selezionata non esiste
		
	}
	
	@Test
	public void testModificaPropostaTesi() {
		boolean modifica= pm.modificaPropostaTesi(propostaOk);
		assertTrue(modifica);// Proposta modificata correttamente
		
		PropostaTesi propostaNotOk=  new PropostaTesi("Errori a non finire 123",null,120,null,"Nessuna Descrizione",null, true, true);
		modifica= pm.modificaPropostaTesi(propostaNotOk);
		assertFalse(modifica);// Modifica della proposta fallita
	}
	
	@Test
	public void testGetRichiestaStudente() {
		String email= richiestaOk.getUtente_mail();
		ArrayList<RichiestaPartecipazione> richiesta= pm.getRichiestaStudente(email);
		assertNotEquals(richiesta, null);// Richiesta per studente corretta
		
		email="emailinesistente@ciao.it";
		richiesta= pm.getRichiestaStudente(email);
		assertEquals(richiesta, null);// Richiesta per studente errata per l'Email
		
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