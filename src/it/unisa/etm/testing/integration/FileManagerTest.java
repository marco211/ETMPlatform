package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.bean.File;
import it.unisa.etm.model.manager.FileManager;

public class FileManagerTest {
	private static FileManager filem;
	//private File file=fileOk.scaricaFile(1, "File1.pdf");

	@BeforeClass
	public static void setUp() {
		filem= new FileManager();
		
	}
	
	@AfterClass
	public static void tearDown() {
		filem=null;
	}
	
	
	/*@Test
	public void testAggiungiFile() {
		file.setFilePart(fileOk.getFile(1, "File1.pdf").getFilePart());
		boolean test=fileOk.aggiungiFile(file); //restituisce true
		assertTrue(test);
		
		File file_test=new File("File2",1, "descrizione2", -1,"descrizione voto2","email2@unisa.it");
		test=fileOk.aggiungiFile(file_test); //restituisce false poiché il voto non è valido
		assertFalse(test);
	}*/
	
	
	
	@Test
	public void testModificaFile() {
		boolean test=filem.modificaFile(1, "File1.pdf", 25, "descrizione modificata1"); //restituisce true
		assertTrue(test); 
		
		test=filem.modificaFile(2, "File010101", 25, "descrizione modificata1"); //restituisce false poché non esiste un file associato a questo nome
		assertFalse(test); 
		
	}
	
	@Test
	public void testEliminaFile() {
		boolean test= filem.eliminaFile(1, "File2.pdf"); //restituiscee true
		assertTrue(test);
		
		test= filem.eliminaFile(1, "File03030"); //restituiscee false poiché non esiste un file associato a questo nome
		assertFalse(test);
	}
	
	@Test
	public void testGetFile() {
		File file=filem.getFile(1, "File1.pdf"); //restituisce il file corrispondente
		assertNotEquals(file,null);
		
		file=filem.getFile(1, "File0303"); //restituisce null poché non esiste un file associato a questo nome
		assertEquals(file,null);
	}
	
	@Test
	public void TestScaricaFile() {
		
		File file=filem.scaricaFile(1, "File1.pdf"); //restituisce il file corrispondente
		assertNotEquals(file,null);
		
		file=filem.scaricaFile(1, "File0303"); //restituisce null poché non esiste un file associato a questo nome
		assertEquals(file,null);
	}
	
	@Test
	public void testGetListaFile() {
		ArrayList<File> lista=filem.getListaFile(1); //restituisce una lista file
		assertNotEquals(lista,null);
		
		lista=filem.getListaFile(-1); //restituisce null poché l'id proposta tesi non è corretto
		assertEquals(lista,null); 
	}
}
