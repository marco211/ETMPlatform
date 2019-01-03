package it.unisa.etm.model.interfaces;

import java.util.ArrayList;
import it.unisa.etm.bean.Attivita;

public interface AttivitaModelInterface {
	public boolean aggiungiAttivita(Attivita attivita);
	public ArrayList<Attivita> getListaAttivita(int propostaTesiId);
}
