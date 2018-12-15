package it.unisa.etm.model.interfaces;

public interface UtenteModelInterface<T> {
	public T cercaUtente(String username);
	public boolean modificaPassword(String password);
	public boolean modificaProfiloUtente(T utente);
	public T visualizzaProfiloUtente(String username);

}
