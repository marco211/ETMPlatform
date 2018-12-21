package it.unisa.etm.model.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.File;
import it.unisa.etm.model.interfaces.FileModelInterface;

public class FileManager implements FileModelInterface {
	public FileManager() {

	}

	@Override
	public boolean aggiungiFile(File c) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaFile(File c) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminaFile(int idTesi, String nomeFile) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public File getFile(int id, String nomeFile) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<File> getListaFile() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
