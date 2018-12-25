package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import java.util.List;
import it.unisa.etm.bean.Utente;

public interface AmministratoreModelInterface{
	//non c'era bisogno di getprofilo, che è del pacchetto utente
	//non significa niente far ritornare T, deve ritornare una lista di utenti.. e non si chiama visualizza ma get
	
	public List<Utente> getListaUtenti() throws SQLException;
	public boolean eliminaUtente(String email) throws SQLException;
	public Utente getUtente(String email) throws SQLException;
	public List<Utente> cercaUtente(String nome) throws SQLException;
}
