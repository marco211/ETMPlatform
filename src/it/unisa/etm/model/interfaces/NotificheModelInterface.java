package it.unisa.etm.model.interfaces;


import java.util.ArrayList;

import it.unisa.etm.model.bean.Notifica;


public interface NotificheModelInterface {
  
  public int inserisciNotifica(Notifica notifica);
  
  public boolean associaNotifica(Notifica notifica, String utente);
  
  public boolean disabilitaAbilitaNotificheProposteTesi(String utenteEmail, boolean b);
  
  public boolean disabilitaAbilitaNotificheSeguaci(String utenteEmail, boolean b);
  
  public ArrayList<Notifica> getNotificheByUser(String utenteEmail);
  
  public Notifica getNotifica(int id);
  
  public int getNumNotificheDaLeggere(String utenteEmail);
  


}
