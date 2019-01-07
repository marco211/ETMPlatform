package it.unisa.etm.testing.areacondivisa;

import java.time.LocalDate;
import it.unisa.etm.bean.Attivita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAttivita {
	
	private static Attivita attivitaOk, attivitaNotOk;
	
	@BeforeClass
	public static void setUp() {
		attivitaOk=new Attivita("email@unisa.it","File1",LocalDate.now(),"A",1);
		attivitaNotOk=new Attivita("false@unisa.it","File2",LocalDate.now(),"B",2);
	}
	
	@AfterClass
	public static void tearDown() {
		attivitaOk=null;
		attivitaNotOk=null;
	}
	
	@Test
	public void testGetId() {
		//non è implementato nel costruttore di Attivita
	}

	@Test
	public void testSetId() {
		//non è implementato nel costruttore di Attivita
	}

	@Test
	public void testGetUtente_Email() {
		String email = attivitaOk.getUtente_Email();
		assertEquals(email,"email@unisa.it"); //email giusta
		
		email=attivitaNotOk.getUtente_Email();
		assertNotEquals(email,"sbagliata@email.it"); //email sbagliata, l'ìemail giusta è false@unisa.it
		
		
	}

	@Test
	public void testSetUtente_Email() {
		String email="email@unisa.it";
		attivitaOk.setUtente_Email(email);
		assertEquals("email@unisa.it",attivitaOk.getUtente_Email());
				
		email="false@unisa.it";
		attivitaNotOk.setUtente_Email(email);
		assertEquals("false@unisa.it",attivitaNotOk.getUtente_Email());		
	}

	@Test
	public void testGetNomeFile() {
		String nomeFile=attivitaOk.getNomeFile();
		assertEquals(nomeFile,"File1");//nome file giusto
		
		nomeFile=attivitaNotOk.getNomeFile();
		assertNotEquals(nomeFile,"File001");//nome file sbagliato, il nome file giusto è File2
	}

	@Test
	public void testSetNomeFile() {
		String nomeFile="File1";
		attivitaOk.setNomeFile(nomeFile);
		assertEquals("File1",attivitaOk.getNomeFile());
		
		nomeFile="File2";
		attivitaNotOk.setNomeFile(nomeFile);
		assertEquals("File2",attivitaNotOk.getNomeFile());
	}

	@Test
	public void testGetData() {		
		LocalDate date=attivitaOk.getData();
		assertEquals(date,attivitaOk.getData());// data giusta
		
		date=attivitaNotOk.getData();
		assertNotEquals(date,"2001-01-01");// data sbagliata, poiché la data inserita nel test è già passata
	}

	@Test
	public void testSetData() {
		LocalDate data=LocalDate.now();
		attivitaOk.setData(data);
		assertEquals(LocalDate.now(),attivitaOk.getData());
		
		attivitaNotOk.setData(data);
		assertEquals(LocalDate.now(),attivitaNotOk.getData());		
	}

	@Test
	public void testGetTipo() {
		String tipo=attivitaOk.getTipo();
		assertEquals(tipo,"A");// tipo giusto
		
		tipo=attivitaNotOk.getTipo();
		assertNotEquals(tipo,"C"); // tipo sbagliato, il tipo giusto è B
	}

	@Test
	public void testSetTipo() {
		String tipo="A";
		attivitaOk.setTipo(tipo);
		assertEquals("A",attivitaOk.getTipo());
		
		tipo="B";
		attivitaNotOk.setTipo(tipo);
		assertEquals("B",attivitaNotOk.getTipo());
	}

	@Test
	public void testGetPropostatesi_id() {
		int id=attivitaOk.getPropostatesi_id();
		assertEquals(id,1);// proposta tesi id giusto
		
		id=attivitaNotOk.getPropostatesi_id();
		assertNotEquals(id,3);// proposta tesi id sbagliato, il proposta tesi id giusto è 2
	}

	@Test
	public void testSetPropostatesi_id() {
		int id=1;
		attivitaOk.setPropostatesi_id(id);
		assertEquals(1,attivitaOk.getPropostatesi_id());
		
		id=2;
		attivitaNotOk.setPropostatesi_id(id);
		assertEquals(2,attivitaNotOk.getPropostatesi_id());
	}
	
		
}
