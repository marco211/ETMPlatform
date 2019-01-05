package it.unisa.etm.testing.tesi;

import it.unisa.etm.bean.PropostaTesi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPropostaTesi {
	private PropostaTesi propostaOk;
	private PropostaTesi propostaNotOk;
	

	@BeforeAll
	public void setUp() {
		propostaOk= new PropostaTesi("I sistemi Operativi", "Informatica", 20,"Architettura","Breve Descrizione","umberto@unisa.it",false,false );
		propostaNotOk= new PropostaTesi("Errori a non finire 123","Pasta E Patate",120,"Fallimentare","Nessuna Descrizione","error@fail.com", true, true);
		
	}
	
	@AfterAll
	public void tearDown() {
		propostaOk=null;
		propostaNotOk=null;
	}
	@Test
	public void testGetTitolo() {
		String titolo = propostaOk.getTitolo();
		assertEquals(titolo, "I sistemi Operativi");// Titolo Corretto
		titolo = propostaNotOk.getTitolo();
		assertEquals(titolo, "Errori a non finire 123"); // Titolo errato
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
		assertEquals(ambito, "Pasta E Patate"); // Ambito errato
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
		assertEquals(tempo, 120); // Tempo di sviluppo errato
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
		assertEquals(materia, "Fallimentare"); // Materia errato
	}
	@Test
	public void testSetMaterie(String materie) {
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
		assertEquals(descrizione, "Nessuna Descrizione"); // Materia errato
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
		assertEquals(email, "error@fail.com"); // Email errata
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
		assertEquals(chiuso, true);
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
		assertEquals(archiviato, true);
		
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
