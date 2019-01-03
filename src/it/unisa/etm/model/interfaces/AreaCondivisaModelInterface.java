package it.unisa.etm.model.interfaces;


import java.util.List;
import it.unisa.etm.bean.File;
/**
 * Metodi per gli utenti che fanno parte di un'area privata condivisa
 * @author ETM
 *
 */
public interface AreaCondivisaModelInterface {
	/**
	 * Permette all'utente di poter inserire un file nell'area privata condivisa
	 * @param f File da inserire nell'area privata condivisa.
	 * @return boolean che � true se l'inserimento � avvenuto con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean inserisciFile(File f);
	
	/**
	 * Permette all'utente di poter visualizzare una lista dei File presenti nell'area privata condivisa
	 * @param idProposta identificativo della proposta tesi per la quale si vogliono conoscere i file.
	 * @return Lista di oggetti File dell'area privata condivisa per quella determinata tesi.
	 * <p>
	 * null in caso di nessun file o insuccesso.
	 */
	public List<File> getFileByPropostaTesi(int idProposta);
	
	/**
	 * Permette all'utente di rimuovere i file presente nell'area privata condivisa a cui partecipa.
	 * @param idFile identificativo del file da eliminare.
	 * @return boolean true se la rimozione avviene con successo;
	 * <p>
	 * false in caso d'insuccesso.
	 */
	public boolean rimuoviFile(int idFile);
}
