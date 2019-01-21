package it.unisa.etm.model.interfaces;

import it.unisa.etm.model.bean.Utente;
import java.util.List;


/**
 * Metodi per l'utente registrato come amministratore.
 * @author ETM
 *
 */
public interface AmministratoreModelInterface {
  /**
   * Permette di ottenere la lista degli utenti registrati.
   * @return lista di oggetti Utente che rapprensenta gli utenti registrati;
   *         null in caso di nessun utente registrato o di insuccesso.
   */
  public List<Utente> getListaUtenti();

  /**
   * Permette di eliminare un determinato utente.
   * @param email dell'utente da eliminare.
   * @return boolean che e true se l'eliminazione ha avuto successo;
   *         false altrimenti.
   */
  public boolean eliminaUtente(String email);

  /**
   * Permette di ottenere un determinato utente.
   * @param email dell'utente desiderato.
   * @return oggeto Utente che rappresenta l'utente desiderato, in caso di successo;
   *         null in caso d'insuccesso;
   */
  public Utente getUtente(String email);

  /**
   * Permette di ottenere un determinato utente da una lista di utenti.
   * @param nome dell'utente da cercare.
   * @return lista di oggetti Utente che rappresenta gli utenti con quel nome;
   * <p>
   * null in caso di insuccesso.
   */

}

