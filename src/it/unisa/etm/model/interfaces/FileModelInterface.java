package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import it.unisa.etm.bean.File;

public interface FileModelInterface {
	public boolean aggiungiFile(File c) throws SQLException;
	public boolean modificaFile(int idTesi, String nomeFile, int voto, String descrizioneVoto) throws SQLException;
	public boolean eliminaFile(int idTesi, String nomeFile) throws SQLException;
	public File getFile(int id,String nomeFile) throws SQLException;
	public ArrayList<File> getListaFile(int idTesi) throws SQLException;
	public File scaricaFile(int idTesi, String nomeFile) throws SQLException;
}
