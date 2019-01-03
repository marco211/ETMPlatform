package it.unisa.etm.model.interfaces;

import java.util.ArrayList;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
/**
 * Metodi dedicati alle partecipazioni degli utenti registrati come studenti determinate proposta di tesi.
 * @author ETM
 *
 */
public interface PartecipaModelInterface {
	/**
	 * Inserisce la partecipazione ad una proposta di tesi di un'utente registrato come studente dopo l'accettazione di un'utente registrato come docente.
	 * @param propostaTesiId identificaivo della proposta di tesi alla quale inserire la partecipazione.
	 * @param utenteEmail email dell'utente registrato come studente.
	 * @return boolean che è true se l'inserimento avviene con successo;
	 * <p>
	 * false in caso contrario.
	 */
	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail);
	
	/**
	 * Ritorna la lista delle partecipazioni a tutte le proposte di tesi.
	 * @param list ArrayList di oggetti PropostaTesi che rappresentano tutte le proposte di tesi attualmente presenti sulla piattaforma.
	 * @return ArayList di oggetti Partecipa che rappresentano le partecipazioni alle proposte di tesi date in input, in caso di successo;
	 * <p>
	 * null se non esistono partecipazioni o in caso d'insuccesso.
	 */
	public ArrayList<Partecipa> getListaPartecipazione(ArrayList<PropostaTesi> list);
}
