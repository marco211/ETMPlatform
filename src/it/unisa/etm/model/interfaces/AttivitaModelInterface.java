package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import it.unisa.etm.bean.Attivita;
/**
 * Metodi dedicati alle attività effettuate da parte degli utenti che fanno parte di un'area privata condivisa
 * @author ETM
 *
 */

public interface AttivitaModelInterface {
	/**
	 * Aggiunge un'attività effettuata da un utent.
	 * @param attivita da aggiungere.
	 * @return boolean true se l'aggiunta è avvenuta con successo;
	 * <p>
	 * false se non è avvenuta con successo.
	 */
	public boolean aggiungiAttivita(Attivita attivita);
	
	/**
	 * Torna una lista delle attività svolte da parte di un utente nell'area privata condivisa.
	 * @param propostaTesiId identificativo della proposta tesi alla quale si sta partecipando.
	 * @return lista di oggetti Attivita che rappresentano le attività svolte nell'area privata condivisa;
	 * <p>
	 * null in caso di nessun attività o d'insuccesso.
	 */
	public ArrayList<Attivita> getListaAttivita(int propostaTesiId);
}

