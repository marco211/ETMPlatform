package it.unisa.etm.model.manager;

import java.sql.SQLException;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AutenticazioneModelInterface;

public class AutenticazioneManager implements AutenticazioneModelInterface{

	@Override
	public boolean inserisciUtente(Utente u) throws SQLException {
		DatabaseManager.getIstance();
		return false;
	}

	@Override
	public boolean checkUtente(Utente u) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
