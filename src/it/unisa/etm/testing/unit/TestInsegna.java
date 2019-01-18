package it.unisa.etm.testing.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.model.bean.Insegna;

public class TestInsegna {
	private static Insegna insegnaOk,insegnaNotOk;
	
	@BeforeClass
	public static void setUp() {
		insegnaOk=new Insegna("utente1@unisa.it","Insegnamento1");
		insegnaNotOk=new Insegna("utente2@unisa.it","Insegnamento2");
	}
	
	@AfterClass
	public static void tearDown() {
		insegnaOk=null;
		insegnaNotOk=null;
	}
	
	@Test
	public void testGetUtenteEmail() {
		String email=insegnaOk.getUtenteEmail();
		assertEquals(email,"utente1@unisa.it"); //utente email corretta
		
		email=insegnaNotOk.getUtenteEmail();
		assertNotEquals(email,"utente3@unisa.it"); //utente email sbagliata, l'utente email corretta e utente2@unisa.it
	}

	@Test
	public void testSetUtenteEmail() {
		String email="utente1@unisa.it";
		insegnaOk.setUtenteEmail(email);
		assertEquals("utente1@unisa.it", insegnaOk.getUtenteEmail());
	}

	@Test
	public void testGetInsegnamentoNome() {
		String nome=insegnaOk.getInsegnamentoNome();
		assertEquals(nome,"Insegnamento1"); //nome insegamento corretto
		
		nome=insegnaNotOk.getInsegnamentoNome();
		assertNotEquals(nome,"Insegnamento3"); //nome insegamento sbagliato, il nome dell'insegnamento corretto e Insegnamento2
	}

	@Test
	public void testSetInsegnamentoNome() {
		String nome="Insegnamento1";
		insegnaOk.setInsegnamentoNome(nome);
		assertEquals("Insegnamento1",insegnaOk.getInsegnamentoNome());
		
	}

}
