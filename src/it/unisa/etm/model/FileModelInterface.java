package it.unisa.etm.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FileModelInterface<T> {
	public ArrayList<T> doRetriveAll() throws SQLException;
	public T doRetriveById(int propostatesi_id) throws SQLException;
	public void doSave(T file) throws SQLException;
	public void doDelete(int propostatesi_id) throws SQLException;
	
}
