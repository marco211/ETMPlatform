package it.unisa.etm.model.interfaces;


import java.util.ArrayList;
import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;
/**
 * Metodi dedicate alle proposte di tesi.
 * @author ETM
 *
 */
public interface PropostaTesiModelInterface {
	/**
	 * Si occupa dell'accettazione, da parte di un utente registrato come docente, di una richiesta di partecipazione effettuata da un utente registrato come studente.
	 * @param id identificativo della richiesta di partecipazione.
	 * @return boolean true se l'accettazione e avvenuta con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean accettaRichiestaPartecipazione(int id);
	
	/**
	 * Si occupa del rifiuto, da parte di un utente registrato come docente, di una richiesta di partecipazione effettuata da un utente registrato come studente.
	 * @param id identificativo della richiesta di partecipazione.
	 * @return boolean true se il rifiuto della richiesta e avvenuta con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean rifiutaRichiestaPartecipazione(int id);
	
	/**
	 * Si occupa della ricerca di richieste di partecipazione per le proposte di tesi di un determenato utente registrato come docente.
	 * @param email Stringa dell'utente registrato come docente.
	 * @return ArrayList di richieste di oggetti RichiestaPartecipazione che rappresentano le richieste di partecipazione, in caso di successo;
	 * <p>
	 * null in caso d'insuccesso o di nessuna richiesta.
	 */
	public ArrayList<RichiestaPartecipazione> cercaRichiestePartecipazione(String email);
	
	/**
	 * Ritorna una determinata proposta di tesi.
	 * @param id identificativo della proposta di tesi da cercare.
	 * @return un oggetto PropostaTesi che rappresenta la proposta di tesi desiderata, in caso di successo;
	 * <p>
	 * null in caso d'insuccesso.
	 */
	public PropostaTesi getPropostaTesi(int id);
	
	/**
	 * Salva in memoria una richiesta di partecipazione per una determinata proposta di tesi, da parte di un utente registrato come docente.
	 * @param richiestaPartecipazione rappresenta la richiesta di partecipazione da salavare.
	 * @return boolean che e true se l'operazione e avvenuta con successo;
	 * <p>
	 * false in caso contrario.
	 */
	public boolean inserisciRichiestaPartecipazione(RichiestaPartecipazione richiestaPartecipazione);
	
	/**
	 * Inserisce una proposta di tesi creata da un utente registrato come docente.
	 * @param proposta proposta di tesi creata dall'utente registrato come docente.
	 * @return boolean che e true se la proposta di tesi viene inserita con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean inserisciPropostaTesi(PropostaTesi proposta);
	
	/**
	 * Si occupa dell'archiviazione di una proposta di tesi, effettuata da un utente registrato come docente per una proposta di tesi creata da lui in precedenza.
	 * @param id identificativo della proposta di tesi da archiviare.
	 * @return boolean che e true se la proposta di tesi e stata archiviata con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean archiviaPropostaTesi(int id);
	
	/**
	 * Si occupa della chiusura di una proposta di tesi, effettuata da un utente registrato come docente per una proposta di tesi creata da lui in precedenza.
	 * @param id identificativo della proposta di tesi da chiudere.
	 * @return boolean che e true se la proposta di tesi e stata chiusa con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean chiudiPropostaTesi(int id);
	
	
	/**
	 * Torna all'utente le proposte attive in questo momento
	 * @return ArrayList di oggetti PropostaTesi che rappresentano le proposte di tesi attive, in caso di successo;
	 * <p>
	 * null in caso d'insuccesso o di nessuna proposta tesi attiva.
	 */
	public ArrayList<PropostaTesi> getProposteTesiAttive();

	/**
	 * Torna all'utente registrato come docente tutte le proposte tesi da lui create.
	 * @param utenteEmail email dell'utente registrato come docente.
	 * @return ArrayList di oggetti PropostaTesi che rappresentano le proposte di tesi create dall'utente registrate come docente, in caso di successo.
	 * <p>
	 * null se l'utente non ha proposte di tesi attualmente registrate nella piattaforma, o in caso d'insuccesso.
	 */
	public ArrayList<PropostaTesi> getProposteTesiDocente(String utenteEmail);
	
	/**
	 * Si occupa della modifica, da parte di un utente registrato come docente, di una propria proposta di tesi.
	 * @param proposta proposta di tesi da modificare.
	 * @return boolean che e true se la modifica e avvenuta con successo;
	 * <p>
	 * false altrimenti.
	 */
	public boolean modificaPropostaTesi(PropostaTesi proposta);
	
	/**
	 * Ritorna le richieste di partecipazione di un determinato utente registrato come studente.
	 * @param utenteEmail email dell'utente registrato come studente per il quale cercare le richieste.
	 * @return ArrayList di oggetti RichiestaPartecipazione che rappresentano le richieste di partecipazione dell'utente registrato come studente, in caso di successo;
	 * <p>
	 * null in caso di nessuna richiesta di partecipazione effettuata o d'insuccesso.
	 */
	public ArrayList<RichiestaPartecipazione> getRichiestaStudente(String utenteEmail);
	
	/**
	 * Ritorna tutti gli insegnamenti degli insegnanti presenti nella piattaforma.
	 * @return ArrayList di oggetti Insegnamento che rappresentano gli insegnamenti presenti nella piattaforma, in caso di successo;
	 * <p>
	 * null in caso di nessun insegnamento presente o d'insuccesso.
	 */
	public ArrayList<Insegnamento> getInsegnamenti();
	
	/**
	 * Ritorna le ultime 8 tesi inserite nella piattaforma.
	 * @return ArrayList di oggetti PropostaTesi che rappresentano le ultime 8 tesi inserite nella piattaforma, in caso di successo;
	 * <p>
	 * null in caso di nessuna tesi inserita o d'insuccesso.
	 */
	public ArrayList<PropostaTesi> getTesiRecenti();
}

