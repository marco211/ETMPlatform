package it.unisa.etm.model.manager;

import java.sql.SQLException;
import java.util.List;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.UtenteModelInterface;

public class UtenteManager implements UtenteModelInterface{

	public UtenteManager() {
		
	}

	@Override
	public List<Utente> getUtenti(String name) throws SQLException{
		DatabaseManager.getIstance();
		return null;
	}

	@Override
	public Utente getUtente(String email) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificaPassword(Utente u) throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaUtente(Utente u) throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
