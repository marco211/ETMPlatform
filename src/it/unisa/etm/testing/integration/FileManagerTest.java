package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.servlet.http.Part;

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
	
	
	@Test
	public void testAggiungiFile() {
		/*
			non testabile l'inserimento di file in quanto necessita di un driver che generi un file da caricare
		*/
		File file_test=new File("File2",1, "descrizione2", -1,"descrizione voto2","email2@unisa.it");
		boolean test=filem.aggiungiFile(file_test); //restituisce false poich� il voto non � valido
		assertFalse(test);
	}
	
	
	
	@Test
	public void testModificaFile() {
		boolean test=filem.modificaFile(1, "File1.pdf", 25, "descrizione modificata1"); //restituisce true
		assertTrue(test); 
		
		test=filem.modificaFile(2, "File010101", 25, "descrizione modificata1"); //restituisce false poch� non esiste un file associato a questo nome
		assertFalse(test); 
		
	}
	
	@Test
	public void testEliminaFile() {
		boolean test= filem.eliminaFile(1, "File2.pdf"); //restituiscee true
		assertTrue(test);
		
		test= filem.eliminaFile(1, "File03030"); //restituiscee false poich� non esiste un file associato a questo nome
		assertFalse(test);
	}
	
	@Test
	public void testGetFile() {
		File f = filem.getListaFile(10).get(0);
		
		File file=filem.getFile(f.getPropostaTesiId(), f.getNome()); //restituisce il file corrispondente
		assertNotEquals(file,null);
		
		file=filem.getFile(1, "File0303"); //restituisce null poch� non esiste un file associato a questo nome
		assertEquals(file,null);
	}
	
	@Test
	public void TestScaricaFile() {
		File f = filem.getListaFile(1).get(0);
		
		File file=filem.scaricaFile(f.getPropostaTesiId(), f.getNome()); //restituisce il file corrispondente
		assertNotEquals(file,null);
		
		file=filem.scaricaFile(1, "File0303"); //restituisce null poch� non esiste un file associato a questo nome
		assertEquals(file,null);
	}
	
	@Test
	public void testGetListaFile() {
		ArrayList<File> lista=filem.getListaFile(1); //restituisce una lista file
		assertNotEquals(lista,null);
		
		lista=filem.getListaFile(-1); //restituisce null poch� l'id proposta tesi non � corretto
		assertEquals(lista,null); 
	}
}
