package it.unisa.etm.model.interfaces;

import java.util.ArrayList;
import it.unisa.etm.bean.File;

public interface FileModelInterface {
	public boolean aggiungiFile(File c);
	public boolean modificaFile(int idTesi, String nomeFile, int voto, String descrizioneVoto);
	public boolean eliminaFile(int idTesi, String nomeFile) ;
	public File getFile(int id,String nomeFile);
	public ArrayList<File> getListaFile(int idTesi);
	public File scaricaFile(int idTesi, String nomeFile);
}
