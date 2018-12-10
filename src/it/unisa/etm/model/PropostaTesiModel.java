package it.unisa.etm.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PropostaTesiModel<T> {
	public ArrayList<T> doRetriveAll() throws SQLException;
	public ArrayList<T> doRetriveById(int id) throws SQLException;
	public void doSave(T propostaTesi) throws SQLException;
	public void doDelete(int id) throws SQLException;
}
