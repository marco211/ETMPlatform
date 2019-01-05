package it.unisa.etm.testing.utente;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import it.unisa.etm.bean.Insegna;

public class TestInsegna {
	private Insegna insegnaOk,insegnaNotOk;
	
	@BeforeAll
	public void setUp() {
		insegnaOk=new Insegna("utente1@unisa.it","Insegnamento1");
		insegnaNotOk=new Insegna("utente2@unisa.it","Insegnamento2");
	}
	
	@AfterAll
	public void tearDown() {
		insegnaOk=null;
		insegnaNotOk=null;
	}
	
	@Test
	public void testGetUtenteEmail() {
		String email=insegnaOk.getUtenteEmail();
		assertEquals(email,"utente1@unisa.it"); //utente email corretta
		
		email=insegnaNotOk.getUtenteEmail();
		assertEquals(email,"utente2@unisa.it"); //utente email sbagliata, l'utente email corretta è utente2@unisa.it
	}

	@Test
	public void testSetUtenteEmail() {
		String email="utente1@unisa.it";
		insegnaOk.setUtenteEmail(email);
		assertEquals("utente1@unisa.it", insegnaOk.getUtenteEmail());
		
		email="utente2@unisa.it";
		insegnaNotOk.setUtenteEmail(email);
		assertEquals("utente2@unisa.it", insegnaNotOk.getUtenteEmail());
	}

	@Test
	public void testGetInsegnamentoNome() {
		String nome=insegnaOk.getInsegnamentoNome();
		assertEquals(nome,"Insegnamento1"); //nome insegamento corretto
		
		nome=insegnaNotOk.getInsegnamentoNome();
		assertEquals(nome,"Insegnamento2"); //nome insegamento sbagliato, il nome dell'insegnamento corretto è Insegnamento2
	}

	@Test
	public void testSetInsegnamentoNome() {
		String nome="Insegnamento1";
		insegnaOk.setInsegnamentoNome(nome);
		assertEquals("Insegnamento1",insegnaOk.getInsegnamentoNome());
		
		nome="Insegnamento2";
		insegnaNotOk.setInsegnamentoNome(nome);
		assertEquals("Insegnamento2",insegnaNotOk.getInsegnamentoNome());
	}

}
