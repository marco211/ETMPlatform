package it.unisa.etm.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ConsegnaModelInterface<T> {
	public ArrayList<T> doRetriveAll() throws SQLException;
	public T doRetriveById(int id) throws SQLException;
	public void doSave(T consegna) throws SQLException;
	public void doDelete(int id) throws SQLException;
	
}
