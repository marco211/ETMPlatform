package it.unisa.etm.testing.utente;

import java.util.ArrayList;
import it.unisa.etm.bean.Utente;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
public class TestUtente {
	private static Utente studenteOk, studenteNotOk, docenteOk, docenteNotOk;
	
	@BeforeClass
	public static void setUp() {
		studenteOk= new Utente("Carpio","1993-05-25","Umberto","s","umberto@unisa.it","umberto123","123456","valido");
		studenteNotOk= new Utente("Error","1900-01-02","Fail","x","error@fail.com","error123","111111","!valido");
		docenteOk= new Utente("Ferrucci","1974-11-14","3B","d","Filomena","f.ferrucci@unisa.it","is2019","Ingegneria del Software","valido");
		docenteNotOk= new Utente("Error","1900-01-02","XX","x","Fail","error@fail.com","error123","Errore del Software","!valido");
		
	}
	
	@AfterClass
	public static void tearDown() {
		studenteOk=null;
		studenteNotOk=null;
		docenteOk= null;
		docenteNotOk= null;
	}
	@Test
	public void testGetCognome() {
		String cognome= studenteOk.getCognome();
		String cognome2= docenteOk.getCognome();
		assertEquals(cognome,"Carpio");//Cognome Studente Corretto
		assertEquals(cognome2,"Ferrucci");//Cognome Docente Corretto
		
		cognome= studenteNotOk.getCognome();
		cognome2= docenteNotOk.getCognome();
		assertNotEquals(cognome,"Error2");//Cognome Studente Errato
		assertNotEquals(cognome2, "Err3or");//Cognome Docente Errato
	}
	@Test
	public void testSetCognome() {
		String cognome= "Carpio";
		String cognome2= "Ferrucci";
		studenteOk.setCognome(cognome);
		docenteOk.setCognome(cognome2);
		assertEquals("Carpio",studenteOk.getCognome());
		assertEquals("Ferrucci", docenteOk.getCognome());
		
		cognome="Error";
		cognome2="Error";
		studenteNotOk.setCognome(cognome);
		docenteNotOk.setCognome(cognome2);
		assertEquals("Error", studenteNotOk.getCognome());
		assertEquals("Error", docenteNotOk.getCognome());
		
		
	}
	@Test
	public void testGetDataDiNascita() {
		String data= studenteOk.getDataDiNascita();
		String data2= docenteOk.getDataDiNascita();
		assertEquals(data,"1993-05-25");
		assertEquals(data2,"1974-11-14");//Data Corretta
		
		data= studenteNotOk.getDataDiNascita();
		data2= docenteNotOk.getDataDiNascita();
		assertNotEquals(data,"1900-02-02");
		assertNotEquals(data2,"1900-01-04");//Data Errata
		
	}
	@Test
	public void testSetDataDiNascita() {
		String data="1993-05-25";
		String data2="1974-11-14";
		studenteOk.setDataDiNascita(data);
		docenteOk.setDataDiNascita(data2);
		assertEquals("1993-05-25", studenteOk.getDataDiNascita());
		assertEquals("1974-11-14", docenteOk.getDataDiNascita());
		
		data="1900-01-02";
		data2="1900-01-02";
		studenteNotOk.setDataDiNascita(data);
		docenteNotOk.setDataDiNascita(data2);
		assertEquals("1900-01-02",studenteNotOk.getDataDiNascita());
		assertEquals("1900-01-02", docenteNotOk.getDataDiNascita());
		
	}
	@Test
	public void testGetMatricola() {
		String matricola= studenteOk.getMatricola();
		assertEquals(matricola, "123456");// Matricola Corretta
		
		matricola= studenteNotOk.getMatricola();
		assertNotEquals(matricola, "1113341");// Matricola Errata
	}
	@Test
	public void testSetMatricola() {
		String matricola= "123456";
		studenteOk.setMatricola(matricola);
		assertEquals("123456", studenteOk.getMatricola());
		
		matricola= "111111";
		studenteNotOk.setMatricola(matricola);
		assertEquals("111111", studenteNotOk.getMatricola());
		
	}
	@Test
	public void testGetUfficio() {
		String ufficio= docenteOk.getUfficio();
		assertEquals(ufficio, "3B");// Ufficio Corretto
		
		ufficio= docenteNotOk.getUfficio();
		assertNotEquals(ufficio, "X3X");// Ufficio Errato
	}
	@Test
	public void testSetUfficio() {
		String ufficio = "3B";
		docenteOk.setUfficio(ufficio);
		assertEquals("3B", docenteOk.getUfficio());
		
		ufficio="XX";
		docenteNotOk.setUfficio(ufficio);
		assertEquals("XX", docenteNotOk.getUfficio());
	}
	@Test
	public void testGetTipo() {
		String tipo= studenteOk.getTipo();
		String tipo2= docenteOk.getTipo();
		
		assertEquals(tipo, "s");// Tipo Corretto
		assertEquals(tipo2, "d");// Tipo Corretto
		
		tipo= studenteNotOk.getTipo();
		tipo2= docenteNotOk.getTipo();
		
		assertNotEquals(tipo, "b");//Tipo Errato
		assertNotEquals(tipo2, "b");//Tipo Errato
	}
	@Test
	public void testSetTipo() {
		String tipo= "s";
		String tipo2="d";
		studenteOk.setTipo(tipo);
		docenteOk.setTipo(tipo2);
		assertEquals("s", studenteOk.getTipo());
		assertEquals("d", docenteOk.getTipo());
		
		tipo="x";
		tipo2="x";
		studenteNotOk.setTipo(tipo);
		docenteNotOk.setTipo(tipo2);
		assertEquals("x", studenteNotOk.getTipo());
		assertEquals("x", docenteNotOk.getTipo());
		
	}
	@Test
	public void testGetNome() {
		String nome= studenteOk.getNome();
		String nome2= docenteOk.getNome();
		assertEquals(nome, "Umberto");// Nome Studente Corretto
		assertEquals(nome2, "Filomena");// Nome Docente Corretto
		
		nome= studenteNotOk.getNome();
		nome2= docenteNotOk.getNome();
		assertNotEquals(nome,"Fai23l");// Nome Studente Errato
		assertNotEquals(nome2, "Fail2");// Nome Docente Errato
	}
	@Test
	public void testSetNome() {
		String nome= "Umberto";
		String nome2= "Filomena";
		studenteOk.setNome(nome);
		docenteOk.setNome(nome2);
		assertEquals("Umberto", studenteOk.getNome());
		assertEquals("Filomena", docenteOk.getNome());
		
		nome= "Fail";
		nome2="Fail";
		studenteNotOk.setNome(nome);
		docenteNotOk.setNome(nome2);
		assertEquals("Fail", studenteNotOk.getNome());
		assertEquals("Fail", docenteNotOk.getNome());
		
	}
	@Test
	public void testGetEmail() {
		String email= studenteOk.getEmail();
		String email2= docenteOk.getEmail();
		assertEquals(email, "umberto@unisa.it");// Email Studente Corretto
		assertEquals(email2, "f.ferrucci@unisa.it");// Email Docente Corretto
		
		email= studenteNotOk.getEmail();
		email2= docenteNotOk.getEmail();
		assertNotEquals(email,"error@fail2.com");// Email Studente Errato
		assertNotEquals(email2, "error@fa3il.com");// Email Docente Errato
		
	}
	@Test
	public void testSetEmail() {
		String email= "umberto@unisa.it";
		String email2= "f.ferrucci@unisa.it";
		studenteOk.setEmail(email);
		docenteOk.setEmail(email2);
		assertEquals("umberto@unisa.it", studenteOk.getEmail());
		assertEquals("f.ferrucci@unisa.it", docenteOk.getEmail());
		
		email= "error@fail.com";
		email2="error@fail.com";
		studenteNotOk.setEmail(email);
		docenteNotOk.setEmail(email2);
		assertEquals("error@fail.com", studenteNotOk.getEmail());
		assertEquals("error@fail.com", docenteNotOk.getEmail());
	}
	@Test
	public void testGetPassword() {
		String password= studenteOk.getPassword();
		String password2= docenteOk.getPassword();
		assertEquals(password, "umberto123");//Password Studente Corretto
		assertEquals(password2, "is2019");//Password Docente Corretto
		
		password= studenteNotOk.getPassword();
		password2= docenteNotOk.getPassword();
		assertNotEquals(password,"error12309");//Password Studente Errato
		assertNotEquals(password2, "error12893");//Password Docente Errato
		
	}
	@Test
	public void testSetPassword() {
		String password= "umberto123";
		String password2= "is2019";
		studenteOk.setPassword(password);
		docenteOk.setPassword(password2);
		assertEquals("umberto123", studenteOk.getPassword());
		assertEquals("is2019", docenteOk.getPassword());
		
		password= "error123";
		password2="error123";
		studenteNotOk.setEmail(password);
		docenteNotOk.setEmail(password2);
		assertEquals("error123", studenteNotOk.getPassword());
		assertEquals("error123", docenteNotOk.getPassword());
		
	}
	@Test	
	public void testGetInsegnamento() {
		ArrayList <String> insegnamento= docenteOk.getInsegnamento();
		assertNotEquals(insegnamento,null);// Insegnamento Corretto
		
		insegnamento= docenteNotOk.getInsegnamento();
		assertNotEquals(insegnamento, null);// Insegnamento Errato
	}
	@Test
	public void testSetInsegnamento() {
		String insegnamento= "Ingegneria del Software";
		docenteOk.setInsegnamento(insegnamento);
		assertNotEquals(null, docenteOk.getInsegnamento());
		
		insegnamento= "Errore del Software";
		docenteNotOk.setInsegnamento(insegnamento);
		assertNotEquals(null, docenteNotOk.getInsegnamento());
		
		
	}
	@Test
	public void testGetValidazione(){
		String valida= studenteOk.getValidazione();
		String valida2= docenteOk.getValidazione();
		assertEquals(valida,"valido");// Studente Validato Correttamente
		assertEquals(valida2,"valido");// Docente Validato Correttamente
		
		valida= studenteNotOk.getValidazione();
		valida2= docenteNotOk.getValidazione();
		
		assertNotEquals(valida,"!3valido");// Studente Validato in modo Errato
		assertNotEquals(valida2,"!2valido");// Docente Validato in modo Errato
		
		
	}
	@Test
	public void testSetValidazione(){
		String valida= "valido";
		String valida2= "valido";
		studenteOk.setValidazione(valida);
		docenteOk.setValidazione(valida2);
		assertEquals("valido", studenteOk.getValidazione());
		assertEquals("valido", docenteOk.getValidazione());
		
		valida="!valido";
		valida2="!valido";
		studenteNotOk.setValidazione(valida);
		docenteNotOk.setValidazione(valida2);
		assertEquals("!valido",studenteNotOk.getValidazione());
		assertEquals("!valido", docenteNotOk.getValidazione());
	}
}
