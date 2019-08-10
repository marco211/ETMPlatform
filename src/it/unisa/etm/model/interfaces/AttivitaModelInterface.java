package it.unisa.etm.model.interfaces;

import it.unisa.etm.model.bean.Attivita;
import java.util.ArrayList;

/**
 * Metodi dedicati alle attivitï¿½ effettuate da 
 * parte degli utenti che fanno parte di un'area privata condivisa.
 * @author ETM
 *
 */
public interface AttivitaModelInterface {
  /**
   * Aggiunge un'attivitï¿½ effettuata da un utent.
   * @param attivita da aggiungere.
   * @return boolean true se l'aggiunta ï¿½ avvenuta con successo;
   *         false se non ï¿½ avvenuta con successo.
   */
  public boolean aggiungiAttivita(Attivita attivita);

  /**
   * Torna una lista delle attivitï¿½ svolte da parte di un utente nell'area privata condivisa.
   * @param propostaTesiId identificativo della proposta tesi alla quale si sta partecipando.
   * @return lista di oggetti Attivita che 
   *         rappresentano le attivitï¿½ svolte nell'area privata condivisa
   *         null in caso di nessun attivitï¿½ o d'insuccesso.
   */
  public ArrayList<Attivita> getListaAttivita(int propostaTesiId);
  
  /**
   * Torna una lista delle attività svolte da parte di un utente nell'area privata condivisa.
   * @param email utente al quale mostrare le attività (notifiche)
   * @return lista di oggetti Attivita che 
   *         rappresentano le attivitï¿½ svolte nell'area privata condivisa
   *         null in caso di nessun attivitï¿½ o d'insuccesso.
   */
  public ArrayList<Attivita> getListaAttivita(String email);
}

