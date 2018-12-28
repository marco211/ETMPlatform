package it.unisa.etm.model.interfaces;

import it.unisa.etm.bean.Amministratore;
import it.unisa.etm.bean.Utente;

public interface AutenticazioneModelInterface {
	public boolean registraUtente(Utente utente);
	public Utente getUtente(String email,String password);
	public String getPassword(String email);
	public boolean setValidazione(String validazione);
	public Amministratore getAdmin(String email, String password);
}
