package it.unisa.etm.model.interfaces;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;

public interface PropostaTesiModelInterface {
	
	public void accettaRichiestaPartecipazione(int id);
	public void rifiutaRichiestaPartecipazione(int id);
	public ArrayList<RichiestaPartecipazione> cercaRichiestePartecipazione(String email);
	public PropostaTesi getPropostaTesi(int id);
	public void inserisciRichiestaPartecipazione(RichiestaPartecipazione richiestaPartecipazione);
	public boolean inserisciPropostaTesi(PropostaTesi proposta);
	public boolean archiviaPropostaTesi(int id);
	public ArrayList<PropostaTesi> cercaProposteTesi(String titolo);
	public boolean chiudiPropostaTesi(int id);//modificato con l'identificativo
	public boolean rimuoviPropostaTesi(int id);//modificato con l'identificativo
	public ArrayList<PropostaTesi> getProposteTesiAttive();
	public List<Attivita> getStoricoAttivita(String titoloProposta) throws SQLException;
	public ArrayList<PropostaTesi> getProposteTesiDocente(String utenteEmail) throws SQLException; //inutilizzato
	public boolean modificaPropostaTesi(PropostaTesi proposta);
	public String getNomeDocente(int id) throws SQLException; //inutilizzato
	public ArrayList<RichiestaPartecipazione> getRichiestaStudente(String utenteEmail);
	public ArrayList<Insegnamento> getInsegnamenti();
}

