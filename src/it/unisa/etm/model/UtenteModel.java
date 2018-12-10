package it.unisa.etm.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UtenteModel<T> {
	public ArrayList<T> doRetriveAll() throws SQLException;
	public ArrayList<T> doRetriveByEmail(String email) throws SQLException;
	public void doSave(T utente) throws SQLException;
	public void doDelete(String email) throws SQLException;

}
