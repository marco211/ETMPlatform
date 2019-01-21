package it.unisa.etm.model.interfaces;

import it.unisa.etm.model.bean.Partecipa;
import it.unisa.etm.model.bean.PropostaTesi;
import java.util.ArrayList;


/**
 * Metodi dedicati alle partecipazioni degli 
 * utenti registrati come studenti determinate proposta di tesi.
 * @author ETM
 *
 */
public interface PartecipaModelInterface {
  /**
   * Inserisce la partecipazione ad una proposta di tesi 
   * di un'utente registrato come studente dopo l'accettazione di un'utente registrato come docente.
   * @param propostaTesiId identificaivo della proposta di 
   *     tesi alla quale inserire la partecipazione.
   * @param utenteEmail email dell'utente registrato come studente.
   * @return boolean che e true se l'inserimento avviene con successo;
   *     false in caso contrario.
   */
  public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail);

  /**
   * Ritorna la lista delle partecipazioni a tutte le proposte di tesi.
   * @param list ArrayList di oggetti PropostaTesi che rappresentano 
   *     tutte le proposte di tesi attualmente presenti sulla piattaforma.
   * @return ArayList di oggetti Partecipa che rappresentano 
   *     le partecipazioni alle proposte di tesi date in input, in caso di successo;
   *     null se non esistono partecipazioni o in caso d'insuccesso.
   */
  public ArrayList<Partecipa> getListaPartecipazione(ArrayList<PropostaTesi> list);
}
