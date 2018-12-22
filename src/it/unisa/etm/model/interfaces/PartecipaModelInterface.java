package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;

public interface PartecipaModelInterface {

	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException;
	public Partecipa getPartecipazione (int propostaTesiId, String utenteEmail) throws SQLException;
	public boolean rimuoviPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException;
	public ArrayList<Partecipa> getListaPartecipazione(ArrayList<PropostaTesi> list) throws SQLException;

}
