package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisa.etm.bean.File;

public interface AreaCondivisaModelInterface {
	public boolean inserisciFile(File f) throws SQLException;
	public File getFile(int id) throws SQLException;
	public List<File> getFileByPropostaTesi(int idProposta) throws SQLException;
	public boolean inserisciValutazione(int idFile, String descrizione, int voto) throws SQLException;
	public boolean rimuoviFile(int idFile) throws SQLException;
	
}
