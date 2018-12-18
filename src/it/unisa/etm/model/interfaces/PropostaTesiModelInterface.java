package it.unisa.etm.model.interfaces;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.PropostaTesi;

public interface PropostaTesiModelInterface {
	
	public boolean inserisciRichiestaPropostaTesi(String titoloProposta, String emailUtente) throws SQLException;
	public boolean inserisciPropostaTesi(PropostaTesi p)  throws SQLException;
	public boolean archiviaPropostaTesi(String titoloProposta)  throws SQLException;
	public PropostaTesi getPropostaTesi(String titolo)  throws SQLException;
	public boolean chiudiPropostaTesi(String titoloProposta)  throws SQLException;
	public boolean rimuoviPropostaTesi(String titoloProposta) throws SQLException;
	public List<PropostaTesi> getProposteTesiAttive()  throws SQLException;
	public List<Attivita> getStoricoAttivita(String titoloProposta) throws SQLException;
}
