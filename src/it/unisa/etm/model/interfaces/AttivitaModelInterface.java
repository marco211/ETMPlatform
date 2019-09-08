package it.unisa.etm.model.interfaces;

import it.unisa.etm.model.bean.Attivita;
import java.util.ArrayList;

/**
 * Metodi dedicati alle attivit� effettuate da 
 * parte degli utenti che fanno parte di un'area privata condivisa.
 * @author ETM
 *
 */
public interface AttivitaModelInterface {
  /**
   * Aggiunge un'attivit� effettuata da un utent.
   * @param attivita da aggiungere.
   * @return boolean true se l'aggiunta � avvenuta con successo;
   *         false se non � avvenuta con successo.
   */
  public boolean aggiungiAttivita(Attivita attivita);

  /**
   * Torna una lista delle attivit� svolte da parte di un utente nell'area privata condivisa.
   * @param propostaTesiId identificativo della proposta tesi alla quale si sta partecipando.
   * @return lista di oggetti Attivita che 
   *         rappresentano le attivit� svolte nell'area privata condivisa
   *         null in caso di nessun attivit� o d'insuccesso.
   */
  public ArrayList<Attivita> getListaAttivita(int propostaTesiId);
  
  public ArrayList<Attivita> getNotifiche(String email);
  
  public ArrayList<String> getListaSeguiti(String email);
  
  public boolean seguiUtente(String emailSeguace, String emailSeguito, 
      boolean addPropTesi, boolean changePropTesi, boolean disabilitaPropTesi);
  
  
  public boolean leggiNotifiche(String email);
  
  public boolean unfollow(String emailSeguace, String emailSeguito);
}

