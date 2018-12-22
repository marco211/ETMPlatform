package it.unisa.etm.model.manager;

import java.util.ArrayList;

import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.model.interfaces.PartecipaModelInterface;

public class PartecipaManager implements PartecipaModelInterface {

	@Override
	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Partecipa getPartecipazione(int propostaTesiId, String utenteEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rimuoviPartecipazione(int propostaTesiId, String utenteEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Partecipa> getListaPartecipazione(int propostaTesiId) {
		// TODO Auto-generated method stub
		return null;
	}

}
