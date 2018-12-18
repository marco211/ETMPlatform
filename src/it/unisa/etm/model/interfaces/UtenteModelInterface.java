package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.List;

import it.unisa.etm.bean.Utente;

public interface UtenteModelInterface {
	public List<Utente> getUtenti(String name) throws SQLException;
	public Utente getUtente(String email) throws SQLException;
	public boolean modificaPassword(Utente u) throws SQLException;
	public boolean modificaUtente(Utente u) throws SQLException;

}
