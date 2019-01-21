package it.unisa.etm.model.interfaces;

import it.unisa.etm.model.bean.Utente;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Metodi dedicati al profilo dell'utente registrato.
 * @author ETM
 *
 */
public interface UtenteModelInterface {


  /**
   * Si occupa della modifica della propria password da parte di un determinato utente.
   * @param u Utente che vuole eseguire l'operazione.
   * @return boolean true se la modifica e avvenuta con successo;
   *      false altrimenti.
   * @throws SQLException se la query non va a buon fine
   */
  public boolean modificaPassword(Utente u) throws SQLException;

  /**
   * Si occupa della modifica del proprio profilo da parte di un utente.
   * @param u Utente che vuole modificare il profilo.
   * @return boolean true se la modifica e avvenuta con successo;
   *      false altrimenti.
   * @throws SQLException se la query non va a buon fine
   */
  public boolean modificaUtente(Utente u) throws SQLException;

  /**
   * Ritorna le informazioni di un determinato utente.
   * @param email stringa che rappresenta l'email 
   *     dell'utente del quale si vogliono ottenere le informazioni.
   * @return oggetto Utente che rappresenta l'utente 
   *      del quale si cercavano le informazioni, in caso di successo;
   *      null in caso contrario.
   * @throws SQLException se la query non va a buon fine
   */
  public Utente getInfo(String email) throws SQLException;

  /**
   * Si occupa della ricerca di un determinato utente.
   * @param email stringa che rappresenta l'email dell'utente che si vuole cercare.
   * @return oggetto Utente che rappresenta l'utente cercato in caso di successo, null altrimenti;
   * @throws SQLException se la query non va a buon fine
   */
  public Utente cercaUtente(String email) throws SQLException;

  /**
   * Si occupa della ricerca di un determinato utente tramite il nome di questo.
   * @param nome striga che rappresenta il nome dell'utente da cercare.
   * @return ArrayList di oggetti Utente che rappresentano gli 
   *      utenti con quel nome, in caso che la ricerca abbia successo;
   *      null in caso contrario.
   */
  public ArrayList<Utente> cercaListaUtenteNome(String nome);

  /**
   * Si occupa della ricerca di un determinato utente tramite il nome di questo.
   * @param cognome striga che rappresenta il cognome dell'utente da cercare.
   * @return ArrayList di oggetti Utente che rappresentano gli 
   *       utenti con quel cognome, in caso che la ricerca abbia successo;
   *       null in caso contrario.
   */
  public ArrayList<Utente> cercaListaUtenteCognome(String cognome);
}
