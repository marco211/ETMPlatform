package it.unisa.etm.model.interfaces;

import java.util.ArrayList;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;

public interface PartecipaModelInterface {
	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail);
	public ArrayList<Partecipa> getListaPartecipazione(ArrayList<PropostaTesi> list);
}
