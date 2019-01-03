package it.unisa.etm.model.interfaces;
import java.util.ArrayList;

import it.unisa.etm.bean.Consegna;
/**
 * Metodi dedicati alle consegne relative ad un'area privata condivisa.
 * @author ETM
 *
 */
public interface ConsegnaModelInterface {
/**
 * Aggiunge una consegna, creata da parte di un utente registrato come docente, all'area privata condivisa.
 * @param c Consegna da aggiungere all'area privata condivisa.
 * @return boolean che � true se la consegna viene aggiunta con successo;
 * <p>
 * false altrimenti.
 */
	public boolean aggiungiConsegna(Consegna c);
	
	/**
	 * Effettua la modifica da parte del docente di una consegna da lui creata nell'area privata condivisa.
	 * @param scadenza stringa che indica la scadenza della consegna;
	 * @param id identificativo della consegna.
	 * @return boolean che � true se la modifica � avvenuta con successo;
	 * <p>
	 * false in caso d'insuccesso.
	 */
	public boolean modificaConsegna(String scadenza, int id);
	
	/**
	 * Si occupa dell'eliminazione, da parte di un docente, di una consegna creata da lui in precedenza,
	 * @param id identificativo della consegna da eliminare.
	 * @return boolean true se l'eliminazione � avvenuta con successo;
	 * <p>
	 * false in caso contrario.
	 */
	public boolean eliminaConsegna(int id);
	
	/**
	 * Ritorna una determinata consegna.
	 * @param id identificativo della consegna desiderata.
	 * @return un oggetto Consegna che rappresenta la consegna desiderata, in caso di successo;
	 * <p>
	 * null in caso in cui la consegna non esiste o di fallimento.
	 */
	public Consegna getConsegna(int id);
	
	/**
	 * Ritorna all'utente tutte le consegne presenti nell'area privata condivisa.
	 * @param propostaTesiId identificativo della proposta tesi per la quale � attiva l'area privata condivisa.
	 * @return ArrayList di oggetti Consegna che rappresenta tutte le consegne presenti nell'area privata condivisa, in caso di successo.
	 * <p>
	 * null in caso in cui d'insuccesso o di nessuna consegna presente nell'area.
	 */
	public ArrayList<Consegna> getListaConsegne(int propostaTesiId);
}
