package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Partecipa;

public interface PartecipaModelInterface {

	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException;
	public Partecipa getPartecipazione (int propostaTesiId, String utenteEmail) throws SQLException;
	public boolean rimuoviPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException;
	public ArrayList<Partecipa> getListaPartecipazione(int propostaTesiId) throws SQLException;

}
