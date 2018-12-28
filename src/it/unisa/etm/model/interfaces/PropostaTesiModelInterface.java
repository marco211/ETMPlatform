package it.unisa.etm.model.interfaces;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;

public interface PropostaTesiModelInterface {
	
	public void accettaRichiestaPartecipazione(int id) throws SQLException;
	public void rifiutaRichiestaPartecipazione(int id) throws SQLException;
	public ArrayList<RichiestaPartecipazione> cercaRichiestePartecipazione(String email) throws SQLException;
	public PropostaTesi getPropostaTesi(int id) throws SQLException;
	public void inserisciRichiestaPartecipazione(RichiestaPartecipazione richiestaPartecipazione) throws SQLException;
	public boolean inserisciPropostaTesi(PropostaTesi proposta)  throws SQLException;
	public boolean archiviaPropostaTesi(int id)  throws SQLException;
	public ArrayList<PropostaTesi> cercaProposteTesi(String titolo)  throws SQLException;
	public boolean chiudiPropostaTesi(int id)  throws SQLException;//modificato con l'identificativo
	public boolean rimuoviPropostaTesi(int id) throws SQLException;//modificato con l'identificativo
	public ArrayList<PropostaTesi> getProposteTesiAttive()  throws SQLException;
	public List<Attivita> getStoricoAttivita(String titoloProposta) throws SQLException;
	public ArrayList<PropostaTesi> getProposteTesiDocente(String utenteEmail) throws SQLException;
	public boolean modificaPropostaTesi(PropostaTesi proposta) throws SQLException;
	public String getNomeDocente(int id) throws SQLException;
	public ArrayList<RichiestaPartecipazione> getRichiestaStudente(String utenteEmail) throws SQLException;
	public ArrayList<Insegnamento> getInsegnamenti() throws SQLException;
}

