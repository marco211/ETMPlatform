package it.unisa.etm.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FileModelInterface<T> {
	public ArrayList<T> doRetriveAll() throws SQLException;
	public T doRetriveByPropostaTesiId(int propostaTesiId) throws SQLException;
	public void doSave(T file) throws SQLException;
	public void doDelete(int propostaTesiId) throws SQLException;
	
}
