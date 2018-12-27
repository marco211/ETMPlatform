package it.unisa.etm.model.interfaces;

import java.sql.SQLException;

import it.unisa.etm.bean.Utente;

public interface AutenticazioneModelInterface {
	public void registraUtente(Utente utente) throws SQLException;
	public Utente getUtente(String email,String password) throws SQLException;
	public String getPassword(String email) throws SQLException;
	public boolean setValidazione(String validazione) throws SQLException;
	
}
