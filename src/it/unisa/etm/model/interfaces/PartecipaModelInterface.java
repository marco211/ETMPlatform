package it.unisa.etm.model.interfaces;

import java.util.ArrayList;

import it.unisa.etm.bean.Partecipa;

public interface PartecipaModelInterface {

	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail);
	public Partecipa getPartecipazione (int propostaTesiId, String utenteEmail);
	public boolean rimuoviPartecipazione(int propostaTesiId, String utenteEmail);
	public ArrayList<Partecipa> getListaPartecipazione(int propostaTesiId);

}
