package it.unisa.etm.testing.integration;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.model.manager.PropostaTesiManager;
import it.unisa.etm.model.manager.PartecipaManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
public class PropostaTesiManagerTest {
	private static PropostaTesiManager pm;
	private static PartecipaManager pam;
	private static RichiestaPartecipazione richiestaOk;
	
	@BeforeClass
	public static void setUp() {
		LocalDate date=LocalDate.now();
		pm= new PropostaTesiManager();
		pam=new PartecipaManager();
		richiestaOk= new RichiestaPartecipazione(date,11,"umberto@unisa,it");
	}
	
	@AfterClass
	public static void tearDown() {
		pm=null;
		pam=null;
	}
	
	@Test
	public void testAccettaRichiestaPartecipazione() {
		int id= 
	}
}