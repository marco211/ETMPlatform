package it.unisa.etm.model.interfaces;

import java.sql.SQLException;

import it.unisa.etm.bean.Consegna;

public interface ConsegnaModelInterface {

	public boolean aggiungiConsegna(Consegna c) throws SQLException;
	public boolean modificaConsegna(Consegna c) throws SQLException;
	public boolean eliminaConsegna(int id) throws SQLException;
	public Consegna getConsegna(int id) throws SQLException;
}
