package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Consegna;

public interface ConsegnaModelInterface {

	public boolean aggiungiConsegna(Consegna c);
	public boolean modificaConsegna(String scadenza, int id);
	public boolean eliminaConsegna(int id);
	public Consegna getConsegna(int id);
	public ArrayList<Consegna> getListaConsegne(int propostaTesiId);
}
