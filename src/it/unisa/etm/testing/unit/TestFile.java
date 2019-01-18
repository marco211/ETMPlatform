package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.model.bean.File;

public class TestFile {
	private static File fileOk,fileNotOk;
	
	@BeforeClass
	public static void setUp() {
		fileOk=new File("File1",1, "descrizione1", 30,"descrizione voto1","email1@unisa.it");
		fileNotOk=new File("File2",2, "descrizione2", 18,"descrizione voto2","email2@unisa.it");
	}
	
	@AfterClass
	public static void tearDown() {
		fileOk=null;
		fileNotOk=null;
	}
	
	@Test
	public void testGetNome() {
		String nome=fileOk.getNome();
		assertEquals(nome,"File1"); //nome corretto
		
		nome=fileNotOk.getNome();
		assertNotEquals(nome,"File3"); //nome sbagliato, il nome giusto e File2
	}

	@Test
	public void testSetNome() {
		String nome="File1";
		fileOk.setNome(nome);
		assertEquals("File1",fileOk.getNome());
		
		nome="File2";
		fileNotOk.setNome(nome);
		assertEquals("File2",fileNotOk.getNome());
	}

	@Test
	public void testGetEmail() {
		String email=fileOk.getEmail();
		assertEquals(email,"email1@unisa.it"); //email corretta
		
		email=fileNotOk.getEmail();
		assertNotEquals(email,"email3@unisa.it"); //email sbagliata, l'email giusta e email2@unisa.it
		
	}

	@Test
	public void testSetEmail() {
		String email="email1@unisa.it";
		fileOk.setEmail(email);
		assertEquals("email1@unisa.it",fileOk.getEmail());
		
		email="email2@unisa.it";
		fileNotOk.setEmail(email);
		assertEquals("email2@unisa.it",fileNotOk.getEmail());
	}

	@Test
	public void testGetVoto() {
		int voto=fileOk.getVoto();
		assertEquals(voto,30); //voto corretto
		
		voto=fileNotOk.getVoto();
		assertNotEquals(voto,23); //voto sbagliato, il voto corretto e 18
	}

	@Test
	public void testSetVoto() {
		int voto=30;
		fileOk.setVoto(voto);
		assertEquals(30,fileOk.getVoto());
		
	}
	
	@Test
	public void testGetDescrizione() {
		String descrizione=fileOk.getDescrizione();
		assertEquals(descrizione,"descrizione1");//descrizione corretta
		
		descrizione=fileNotOk.getDescrizione();
		assertNotEquals(descrizione,"descrizione3");//descrzione sbagliata, la descrizione giusta e descrizione2
	}
	
	@Test
	public void testSetDescrizione() {
		String descrizione="descrizione1";
		fileOk.setDescrizione(descrizione);
		assertEquals("descrizione1",fileOk.getDescrizione());
		
	}

	@Test
	public void testGetDescrizioneVoto() {
		String descrizione=fileOk.getDescrizioneVoto();
		assertEquals(descrizione,"descrizione voto1"); //descrizione voto corretta
		
		descrizione=fileNotOk.getDescrizioneVoto();
		assertNotEquals(descrizione,"descrizione voto3"); //descrizione voto sbagliata, la descrizione voto giusta e descrizione voto2
	}

	@Test
	public void testSetDescrizioneVoto() {
		String descrizione="descrizione voto1";
		fileOk.setDescrizioneVoto(descrizione);
		assertEquals("descrizione voto1",fileOk.getDescrizioneVoto());
	}
	
	@Test
	public void testGetPropostaTesiId() {
		int id=fileOk.getPropostaTesiId();
		assertEquals(id,1); //proposta tesi id corretto
		
		id=fileNotOk.getPropostaTesiId();
		assertNotEquals(id,3); //proposta tesi id sbagliato, il proposta tesi id corretto e 2
	}
	@Test
	public void testSetPropostaTesiId() {
		int id=1;
		fileOk.setPropostaTesiId(id);
		assertEquals(1,fileOk.getPropostaTesiId());
		
	}
	
}
