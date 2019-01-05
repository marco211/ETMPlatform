package it.unisa.etm.testing.admin;

import it.unisa.etm.bean.Amministratore;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestAmministratore {

	private Amministratore adminOk, adminNotOk;
	
	@BeforeAll
	public void setUp() {
		adminOk=new Amministratore("boss@admin.it","Marco","Della Medaglia","qwert");
		adminNotOk=new Amministratore("false@admin.it","Paolo","Bonolis","qwert");
	}
	
	@AfterAll
	public void tearDown() {
		adminOk=null;
		adminNotOk=null;
	}
	
	@Test
	public void testGetPassword(){
		String password=adminOk.getPassword();
		assertEquals(password,"qwert"); //password giusta
		
		password=adminNotOk.getPassword();
		assertEquals(password,"ciao"); //password sbagliata, la password giusta è qwert
	}
	
	
	@Test
	public void testSetPassword() {
		String password="qwert";
		adminOk.setPassword(password);
		assertEquals("qwert",adminOk.getPassword());
		
		password="qwert";
		adminNotOk.setPassword(password);
		assertEquals("qwert",adminNotOk.getPassword());
	}
	
	@Test
	public void testGetNome() {
		String nome=adminOk.getNome();
		assertEquals(nome,"Marco"); //nome giusto
		
		nome=adminNotOk.getNome();
		assertEquals(nome,"Domenico"); //nome sbagliato, il nome giusto è Paolo
	}

	@Test
	public void testSetNome() {
		String nome="Marco";
		adminOk.setNome(nome);
		assertEquals("Marco",adminOk.getNome());
		
		nome="Paolo";
		adminNotOk.setNome(nome);
		assertEquals("Paolo",adminNotOk.getNome());
	}

	@Test
	public void testGetCognome() {
		String cognome=adminOk.getCognome();
		assertEquals(cognome,"Della Medaglia");//cognome giusto
		
		cognome=adminNotOk.getCognome();
		assertEquals(cognome,"Nappi"); //cognome sbagliato, il cognome giusto è Bonolis
	}

	@Test
	public void testSetCognome() {
		String cognome="Della Medaglia";
		adminOk.setCognome(cognome);
		assertEquals("Della Medaglia",adminOk.getCognome());
		
		cognome="Bonolis";
		adminNotOk.setCognome(cognome);
		assertEquals("Bonolis",adminNotOk.getCognome());
	}

	@Test
	public void testGetEmail() {
		String email=adminOk.getEmail();
		assertEquals(email,"boss@admin.it");//email giusta
		
		email=adminNotOk.getEmail();
		assertEquals(email,"false@admin.it"); //email sbagliata, l'email giusta è false@admin.it
	}

	@Test
	public void testSetEmail(){
		String email="boss@admin.it";
		adminOk.setEmail(email);
		assertEquals("boss@admin.it",adminOk.getEmail());
		
		email="false@admin.it";
		adminNotOk.setEmail(email);
		assertEquals("false@admin.it",adminNotOk.getEmail());
	}
	
	
}

