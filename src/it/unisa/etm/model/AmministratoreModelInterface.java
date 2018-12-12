package it.unisa.etm.model;



public interface AmministratoreModelInterface<T> {
	public T visualizzaListaUtenti(String username);
	public boolean eliminaUtente(String email);
	public T visualizzaProfiloUtente(String username);

}
