package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PropostaTesiModelInterface<T> {
	
	public void aggiungiPropostaTesi(T propostaTesi)  throws SQLException;
	public void archiviaPropostaTesi(T propostaTesi)  throws SQLException;
	public T cercaPropostaTesi(String titolo)  throws SQLException;
	public void chiudiPropostaTesi(T propostaTesi)  throws SQLException;
	public boolean comunicaEsito(T propostaTesi)  throws SQLException;
	public void inviaPropostaTesi(T propostaTesi)  throws SQLException;
	public void modificaPropostaTesi(T propostaTesi)  throws SQLException;
	public ArrayList<T> proposteTesiAttive()  throws SQLException;
	public void rimuoviPropostaTesi(T propostaTesi)  throws SQLException;
	public String visualizzaDettagliPropostaTesi(T propostaTesi)  throws SQLException;
	
}
