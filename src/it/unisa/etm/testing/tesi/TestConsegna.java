package it.unisa.etm.testing.tesi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import it.unisa.etm.bean.Consegna;

public class TestConsegna {
	private Consegna consegnaOk, consegnaNotOk;
	
	@BeforeAll
	public void setUp() {
		consegnaOk=new Consegna("Consegna1","Descrizione consegna1","scadenza1",1);
		consegnaNotOk=new Consegna("Consegna2","Descrizione consegna2","scadenza2",2);
	}
	
	@AfterAll
	public void tearDown() {
		consegnaOk=null;
		consegnaNotOk=null;
	}
	
	@Test
	public void testGetId() {
		//non è implementato nel costruttore di Consegna

	}
	
	@Test
	public void testSetId() {
		//non è implementato nel costruttore di Consegna
	}
	
	@Test
	public void testGetNome() {
		String nome=consegnaOk.getNome();
		assertEquals(nome,"Consegna1");// nome giusto
		
		nome=consegnaNotOk.getNome();
		assertEquals(nome,"Consegna3");// nome sbagliato, il nome giusto è Consegna2
	}
	
	@Test
	public void testSetNome() {
		String nome="Consegna1";
		consegnaOk.setNome(nome);
		assertEquals("Consegna1",consegnaOk.getNome());
		
		nome="Consegna2";
		consegnaNotOk.setNome(nome);
		assertEquals("Consegna2",consegnaNotOk.getNome());
	}
	
	@Test
	public void testGetDescrzione() {
		String descrizione=consegnaOk.getDescrzione();
		assertEquals(descrizione,"Descrizione consegna1");// descrizione giusta
		
		descrizione=consegnaNotOk.getDescrzione();
		assertEquals(descrizione,"Descrizione consegna0303");// descrizione sbagliata, la descrizione giusta è "Descrizione consegna2"
	}
	
	@Test
	public void testSetDescrzione() {
		String descrizione="Descrizione consegna1";
		consegnaOk.setDescrzione(descrizione);
		assertEquals("Descrizione consegna1",consegnaOk.getDescrzione());
		
		descrizione="Descrizione consegna2";
		consegnaNotOk.setDescrzione(descrizione);
		assertEquals("Descrizione consegna2",consegnaNotOk.getDescrzione());
	}
	
	@Test
	public void testGetScadenza() {
		String scadenza=consegnaOk.getScadenza();
		assertEquals(scadenza,"scadenza1");//scadenza giusta
		
		scadenza=consegnaNotOk.getScadenza();
		assertEquals(scadenza,"scadenza0303");//scadenza sbaglita, la descrizione corretta è scadenza2
	}
	
	@Test
	public void testSetScadenza() {
		String scadenza="scadenza1";
		consegnaOk.setScadenza(scadenza);
		assertEquals("scandenza1",consegnaOk.getScadenza());
		
		scadenza="scadenza2";
		consegnaNotOk.setScadenza(scadenza);
		assertEquals("scandenza2",consegnaNotOk.getScadenza());
	}
	
	@Test
	public void testGetPropostaTesiId() {
		int id=consegnaOk.getPropostaTesiId();
		assertEquals(id,1); //proposta tesi id giusto
		
		id=consegnaNotOk.getPropostaTesiId();
		assertEquals(id,3); //proposta tesi id sbagliato, quello giusto è 3
	}

	@Test
	public void testSetPropostaTesiId() {
		int id=1;
		consegnaOk.setPropostaTesiId(id);
		assertEquals(1,consegnaOk.getPropostaTesiId());
		
		id=2;
		consegnaNotOk.setPropostaTesiId(id);
		assertEquals(2,consegnaNotOk.getPropostaTesiId());

	}

	
}
