package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import it.unisa.etm.bean.Attivita;

public interface AttivitaModelInterface {
	public boolean aggiungiAttivita(Attivita attivita) throws SQLException;
	public ArrayList<Attivita> getListaAttivita(int propostaTesiId) throws SQLException;
}
