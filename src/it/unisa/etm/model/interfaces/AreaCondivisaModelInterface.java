package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.List;
import it.unisa.etm.bean.File;

public interface AreaCondivisaModelInterface {
	public boolean inserisciFile(File f) throws SQLException;
	public List<File> getFileByPropostaTesi(int idProposta) throws SQLException;
	public boolean rimuoviFile(int idFile) throws SQLException;
}
