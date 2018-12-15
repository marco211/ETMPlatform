package it.unisa.etm.model.manager;

import java.sql.SQLException;
import java.util.List;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.interfaces.AmministratoreModelInterface;
import it.unisa.etm.database.DatabaseManager;
public class AmministratoreManager implements AmministratoreModelInterface{

	public AmministratoreManager() {
		
	}

	@Override
	public List<Utente> getListaUtenti() throws SQLException {
		DatabaseManager.getIstance();
		return null;
	}

	@Override
	public boolean eliminaUtente(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
