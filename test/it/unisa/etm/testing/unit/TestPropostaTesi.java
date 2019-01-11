package it.unisa.etm.testing.unit;

import it.unisa.etm.bean.PropostaTesi;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPropostaTesi {
	private static PropostaTesi propostaOk;
	private static PropostaTesi propostaNotOk;
	

	@BeforeClass
	public static void setUp() {
		propostaOk= new PropostaTesi("I sistemi Operativi", "Informatica", 20,"Architettura","Breve Descrizione","umberto@unisa.it",false,false );
		propostaNotOk= new PropostaTesi("Errori a non finire 123","Pasta E Patate",120,"Fallimentare","Nessuna Descrizione","error@fail.com", true, true);
		
	}
	
	@AfterClass
	public static void tearDown() {
		propostaOk=null;
		propostaNotOk=null;
	}
	@Test
	public void testGetTitolo() {
		String titolo = propostaOk.getTitolo();
		assertEquals(titolo, "I sistemi Operativi");// Titolo Corretto
		titolo = propostaNotOk.getTitolo();
		assertNotEquals(titolo, "Errori a nweon finire 123"); // Titolo errato
	}
	@Test
	public void testSetTitolo() {
		String titolo = "I sistemi Operativi";
		propostaOk.setTitolo(titolo);
		assertEquals("I sistemi Operativi", propostaOk.getTitolo());
		
		titolo = "Errori a non finire 123";
		propostaNotOk.setTitolo(titolo);
		assertEquals("Errori a non finire 123", propostaNotOk.getTitolo());
	}
	@Test
	public void testGetAmbito() {
		String ambito = propostaOk.getAmbito();
		assertEquals(ambito, "Informatica");// Ambito Corretto
		ambito = propostaNotOk.getAmbito();
		assertNotEquals(ambito, "Pasta ewE Patate"); // Ambito errato
	}
	@Test
	public void testSetAmbito() {
		String ambito = "Informatica";
		propostaOk.setAmbito(ambito);
		assertEquals("Informatica", propostaOk.getAmbito());
		
		ambito = "Pasta E Patate";
		propostaNotOk.setAmbito(ambito);
		assertEquals("Pasta E Patate", propostaNotOk.getAmbito());
	}
	@Test
	public void testGetTempoDiSviluppo() {
		int tempo = propostaOk.getTempoDiSviluppo();
		assertEquals(tempo, 20);// Tempo  di sviluppo Corretto
		tempo = propostaNotOk.getTempoDiSviluppo();
		assertNotEquals(tempo, 12340); // Tempo di sviluppo errato
	}
	@Test
	public void testSetTempoDiSviluppo() {
		int tempo = 20;
		propostaOk.setTempoDiSviluppo(tempo);
		assertEquals(20, propostaOk.getTempoDiSviluppo());
		
		tempo = 120;
		propostaNotOk.setTempoDiSviluppo(tempo);
		assertEquals(120, propostaNotOk.getTempoDiSviluppo());
	}
	@Test
	public void testGetMaterie() {
		String materia = propostaOk.getMaterie();
		assertEquals(materia, "Architettura");// Materia Corretto
		materia = propostaNotOk.getMaterie();
		assertNotEquals(materia, "Fall43imentare"); // Materia errato
	}
	@Test
	public void testSetMaterie() {
		String materia = "Architettura";
		propostaOk.setMaterie(materia);
		assertEquals("Architettura", propostaOk.getMaterie());
		
		materia = "Fallimentare";
		propostaNotOk.setMaterie(materia);
		assertEquals("Fallimentare", propostaNotOk.getMaterie());
	}
	@Test
	public void testGetDecrizione() {
		String descrizione = propostaOk.getDecrizione();
		assertEquals(descrizione, "Breve Descrizione");// Materia Corretto
		descrizione = propostaNotOk.getDecrizione();
		assertNotEquals(descrizione, "Nessuna Descr34izione"); // Materia errato
	}
	@Test
	public void testSetDecrizione() {
		String descrizione = "Breve Descrizione";
		propostaOk.setDecrizione(descrizione);
		assertEquals("Breve Descrizione", propostaOk.getDecrizione());
		
		descrizione = "Nessuna Descrizione";
		propostaNotOk.setDecrizione(descrizione);
		assertEquals("Nessuna Descrizione", propostaNotOk.getDecrizione());
	}
	@Test
	public void testGetUtenteEmail() {
		String email = propostaOk.getUtenteEmail();
		assertEquals(email,"umberto@unisa.it"); // Email corretta
		
		email = propostaNotOk.getUtenteEmail();
		assertNotEquals(email, "error@fail32.com"); // Email errata
	}
	@Test
	public void testSetUtenteEmail() {
		String email= "umberto@unisa.it";
		propostaOk.setUtenteEmail(email);
		assertEquals("umberto@unisa.it", propostaOk.getUtenteEmail());
		
		email= "error@fail.com";
		propostaNotOk.setUtenteEmail(email);
		assertEquals("error@fail.com", propostaNotOk.getUtenteEmail());
	}
	@Test
	public void testIsChiuso() {
		boolean chiuso= propostaOk.isChiuso();
		assertEquals(chiuso, false);
		
		chiuso = propostaNotOk.isChiuso();
		assertNotEquals(chiuso, false);
	}
	@Test
	public void testSetChiuso() {
		boolean chiuso= false;
		propostaOk.setChiuso(chiuso);
		assertEquals(false, chiuso);

		chiuso = true;
		propostaNotOk.setChiuso(chiuso);
		assertEquals(true,chiuso);
		
	}
	@Test
	public void testIsArchiviato() {
		boolean archiviato = propostaOk.isArchiviato();
		assertEquals(archiviato, false);
		
		archiviato = propostaNotOk.isArchiviato();
		assertNotEquals(archiviato, false);
		
	}
	@Test
	public void testSetArchiviato() {
		boolean archiviato = false;
		propostaOk.setArchiviato(archiviato);
		assertEquals(false, propostaOk.isArchiviato());
		
		archiviato = true ;
		propostaNotOk.setArchiviato(archiviato);
		assertEquals(true, propostaNotOk.isArchiviato());
	}
}
