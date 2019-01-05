package it.unisa.etm.testing.utente;

import it.unisa.etm.bean.Insegnamento;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestInsegnamento {
	private Insegnamento insegnamentoOk;
	private Insegnamento insegnamentoNotOk;
	
	@BeforeAll
	public void setUp() {
		insegnamentoOk= new Insegnamento("Informatica",12);
		insegnamentoNotOk= new Insegnamento("PastaConIlTonno",142);
		
	}
	@AfterAll
	public void tearDown() {
		insegnamentoOk=null;
		insegnamentoNotOk=null;
		
	}
	@Test
	public void testGetCfu() {
		int cfu= insegnamentoOk.getCfu();
		assertEquals(cfu,12); //CFU giusti
		cfu= insegnamentoNotOk.getCfu();
		assertEquals(cfu,142);//CFU errati
	}
	@Test
	public void testSetCfu() {
		int cfu= 12;
		insegnamentoOk.setCfu(cfu);
		assertEquals(12,insegnamentoOk.getCfu());
		
		cfu= 142;
		insegnamentoNotOk.setCfu(cfu);
		assertEquals(142,insegnamentoNotOk.getCfu());
	}

	public void testGetNome() {
		String nome= insegnamentoOk.getNome();
		assertEquals(nome, "Informatica");
		
		nome= insegnamentoNotOk.getNome();
		assertEquals(nome, "PastaConIlTonno");
		
	}

	public void testSetNome() {
		String nome= "Informatica";
		insegnamentoOk.setNome(nome);
		assertEquals("Informatica",insegnamentoOk.getNome());
		
		nome= "PastaConIlTonno";
		insegnamentoNotOk.setNome(nome);
		assertEquals(nome,"PastaConIlTonno");
	}
}
