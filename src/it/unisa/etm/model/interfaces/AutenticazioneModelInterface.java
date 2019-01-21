package it.unisa.etm.model.interfaces;

import it.unisa.etm.model.bean.Amministratore;
import it.unisa.etm.model.bean.Utente;

/**
 * Metodi dedicati alla registrazione e al login di un utente.
 * @author ETM
 *
 */
public interface AutenticazioneModelInterface {
  /**
   * Effettua la registrazione di un utente.
   * @param utente da registrare.
   * @return boolean che e true se la resgistrazione e avvenuta con successo.
   *         false altrimenti.
   */
  public boolean registraUtente(Utente utente);

  /**
   * Effettua il login di un determinato utente.
   * @param email email dell'utente che effettua il login;
   * @param password password dell'utente che effettua il login.
   * @return Utente che rappresenta l'utente registrato, in caso di successo;
   *         null in caso d'insuccesso e quindi di login fallito.
   */
  public Utente getUtente(String email,String password);

  /**
   * Ritorna la password dell'utente nel caso in cui venga fatta la procedura di recupera password.
   * @param email dell'utente che vuole recuperare la password.
   * @return la password dell'utente in caso di successo;
   *         null in caso d'insuccesso.
   */
  public String getPassword(String email);

  /**
   * Si occupa di settare la validazione di un 
   * account dopo che l'utente abbia usato il link di validazione.
   * @param validazione che rappresenta il link utilizzato dall'utente per confermare il suo account
   * @return boolean che e true se la validazione avviene con successo;
   *         false in caso d'insuccesso.
   */
  public boolean setValidazione(String validazione);
  
  public Amministratore getAdmin(String email, String password);
}
