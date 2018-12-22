package it.unisa.etm.model.interfaces;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;

public interface PropostaTesiModelInterface {
	
	public void inserisciRichiestaPartecipazione(RichiestaPartecipazione richiestaPartecipazione) throws SQLException;
	public boolean inserisciPropostaTesi(PropostaTesi proposta)  throws SQLException;
	public boolean archiviaPropostaTesi(int id)  throws SQLException;
	public ArrayList<PropostaTesi> getPropostaTesi(String titolo)  throws SQLException;
	public boolean chiudiPropostaTesi(String titoloProposta)  throws SQLException;
	public boolean rimuoviPropostaTesi(String titoloProposta) throws SQLException;
	public ArrayList<PropostaTesi> getProposteTesiAttive()  throws SQLException;
	public List<Attivita> getStoricoAttivita(String titoloProposta) throws SQLException;
}
