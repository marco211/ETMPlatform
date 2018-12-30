package it.unisa.etm.model.interfaces;

import java.util.List;
import it.unisa.etm.bean.Utente;

public interface AmministratoreModelInterface{
	public List<Utente> getListaUtenti();
	public boolean eliminaUtente(String email);
	public Utente getUtente(String email);
	public List<Utente> cercaUtente(String nome);
}
