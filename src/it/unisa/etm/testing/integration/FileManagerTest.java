package it.unisa.etm.testing.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.Part;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unisa.etm.model.bean.File;
import it.unisa.etm.model.manager.FileManager;

public class FileManagerTest {
	private static FileManager filem;
	private static Part filePart;

	@BeforeClass
	public static void setUp() {
		filem= new FileManager();
		
		//necessario per la simulazione di inserimento file
		filePart = new Part() {
			
			
			@Override
			public long getSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public InputStream getInputStream() throws IOException {
				return new InputStream() {	
					@Override
					public int read() throws IOException {return 0;}
				};
			}
			
			@Override
			public Collection<String> getHeaders(String name) {return null;	}
			
			@Override
			public Collection<String> getHeaderNames() {return null;}
			
			
			@Override
			public String getHeader(String name) {return null;};
			
			
			@Override
			public String getContentType() {return null;}
			
			@Override
			public void delete() throws IOException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public String getSubmittedFileName() {return null;}

			@Override
			public void write(String fileName) throws IOException {	}
		};
	}
	
	@AfterClass
	public static void tearDown() {
		filem=null;
	}
	
	
	@Test
	public void testAggiungiFile() {
			
		File file_test=new File("File3",1, "descrizione File3", 24,"descrizione voto","etm.utente@unisa.it");
		file_test.setFilePart(filePart);
		assertTrue(filem.aggiungiFile(file_test));	//restituisce true
		
		boolean test= filem.eliminaFile(1, "File3"); //restituiscee true
		assertTrue(test);
	}
	
	
	
	@Test
	public void testModificaFile() {
		File file_test=new File("File4",1, "descrizione File4", 25,"descrizione voto","etm.utente@unisa.it");
		file_test.setFilePart(filePart);
		assertTrue(filem.aggiungiFile(file_test));
		
		boolean test=filem.modificaFile(1,  "File4", 30, "descrizione modificata: voto cambiato"); //restituisce true
		assertTrue(test); 
		
		test= filem.eliminaFile(1, "File4"); //restituiscee true
		assertTrue(test);
		
		test=filem.modificaFile(2, "File010101", 25, "descrizione modificata1"); //restituisce false poché non esiste un file associato a questo nome
		assertFalse(test); 
		
	}
	
	@Test
	public void testEliminaFile() {
		File file_test=new File("FileDaEliminare",1, "Questo file è da eliminare", 25,"descrizione voto","etm.utente@unisa.it");
		file_test.setFilePart(filePart);
		assertTrue(filem.aggiungiFile(file_test));
		
		boolean test= filem.eliminaFile(1, "FileDaEliminare"); //restituiscee true
		assertTrue(test);
		
		test= filem.eliminaFile(1, "File03030"); //restituiscee false poiché non esiste un file associato a questo nome
		assertFalse(test);
	}
	
	@Test
	public void testGetFile() {
		File f = filem.getFile(1, "File1");
		
		File file=filem.getFile(f.getPropostaTesiId(), f.getNome()); //restituisce il file corrispondente
		assertNotEquals(file,null);
		
		file=filem.getFile(1, "File0303"); //restituisce null poché non esiste un file associato a questo nome
		assertEquals(file,null);
	}
	
	@Test
	public void TestScaricaFile() {
		File f = filem.getFile(1, "File1");
		
		File file=filem.scaricaFile(f.getPropostaTesiId(), f.getNome()); //restituisce il file corrispondente
		assertNotEquals(file,null);
		
		file=filem.scaricaFile(1, "File0303"); //restituisce null poché non esiste un file associato a questo nome
		assertEquals(file,null);
	}
	
	@Test
	public void testGetListaFile() {
		ArrayList<File> lista=filem.getListaFile(1); //restituisce una lista file
		assertNotEquals(lista,null);
		
		lista=filem.getListaFile(-1); //restituisce null poché l'id proposta tesi non e corretto
		assertEquals(lista,null); 
	}
}
