package it.unisa.etm.model.interfaces;

import java.sql.SQLException;

import it.unisa.etm.bean.Utente;

public interface AutenticazioneModelInterface {
	public boolean inserisciUtente(Utente u) throws SQLException;
	public boolean checkUtente(Utente u) throws SQLException;
	
}
