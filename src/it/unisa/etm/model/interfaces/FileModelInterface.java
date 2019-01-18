package it.unisa.etm.model.interfaces;

import java.util.ArrayList;

import it.unisa.etm.model.bean.File;
/**
 * Metodi dedicati alle operazioni svolte sui file da parte degli utenti di un'area privata condivisa.
 * @author ETM
 *
 */
public interface FileModelInterface {
	/**
	 * Aggiunge un file all'area privata condivisa.
	 * @param c oggetto File che rappresenta il file da aggiungere.
	 * @return boolean true se l'aggiunta del file avviene con successo;
	 * <p>
	 * false in caso contrario.
	 */
	public boolean aggiungiFile(File c);
	
	/**
	 * Si occupa della valutazione di un file da parte dell'utente registrato come docente.
	 * @param idTesi identificativo della proposta di tesi per la quale e attiva l'area privata condivisa.
	 * @param nomeFile nome de file che si vuole modificare.
	 * @param voto voto da dare al file.
	 * @param descrizioneVoto descrizione della votazione che si vuole dare al file.
	 * @return boolean true se la valutazione avviene con successo;
	 * <p>
	 * false in caso contrario.
	 */
	public boolean modificaFile(int idTesi, String nomeFile, int voto, String descrizioneVoto);
	
	/**
	 * Elimina un file presente nell'area privata condivisa.
	 * @param idTesi identificativo della proposta di tesi per la quale e attiva l'area privata condivisa.
	 * @param nomeFile nome de file che si vuole eliminare.
	 * @return boolean true se l'eliminazione e avvenuta con successo;
	 * <p>
	 * false in caso d'insuccesso.
	 */
	public boolean eliminaFile(int idTesi, String nomeFile) ;
	
	/**
	 * Ritorna un determinato file.
	 * @param id identificativo della proposta di tesi per la quale e attiva l'area privata condivisa.
	 * @param nomeFile nome de file che si vuole ottenere.
	 * @return il File desiderato se esiste e se l'opezione ha successo;
	 * <p>
	 * null se il file non esiste o in caso d'insuccesso.
	 */
	public File getFile(int id,String nomeFile);
	
	/**
	 * Ritorna i File presenti all'interno dell'area privata condivisa.
	 * @param idTesi identificativo della proposta di tesi per la quale e attiva l'area privata condivisa.
	 * @return lista di oggetti File che rappresentano i file presenti nell'area privata condivisa, in caso di successo.
	 * <p>
	 * null nel caso di nessun file presente o d'insuccesso.
	 */
	public ArrayList<File> getListaFile(int idTesi);
	
	/**
	 * Si occupa del download di un file presente dell'area privata condivisa.
	 * @param idTesi identificativo della proposta di tesi per la quale e attiva l'area privata condivisa.
	 * @param nomeFile nome de file che si vuole scaricare.
	 * @return oggetto File che rappresenta il file scaricato, in caso di successo.
	 * <p>
	 * null in caso d'insuccesso.
	 */
	public File scaricaFile(int idTesi, String nomeFile);
}
