package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.UtenteModelInterface;

public class UtenteManager implements UtenteModelInterface{

	public UtenteManager() {
		
	}
	
	@Override
	public Boolean registraUtente(Utente utente) throws SQLException{
		//to do
		return true;
	}

	@Override
	public List<Utente> getUtenti(String name) throws SQLException{
		DatabaseManager.getIstance();
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

	@Override
	public Utente getUtente(String email, String password) throws SQLException {
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=? AND PASSWORD=?");
		pr.setString(1, email);
		pr.setString(2, password);
		ResultSet rs=pr.executeQuery();
		rs.next();
		Utente utente=new Utente();
		if(rs.getString("TIPO").equals("s")){
		utente.setNome(rs.getString("NOME"));
		utente.setCognome(rs.getString("COGNOME"));
		utente.setMatricola(rs.getString("MATRICOLA"));
		utente.setEmail(rs.getString("EMAIL"));
		utente.setDataDiNascita(rs.getDate("DATE"));
		utente.setPassword(rs.getString("PASSWORD"));
		}
		else if(rs.getString("TIPO").equals("d")) {
			utente.setNome(rs.getString("NOME"));
			utente.setCognome(rs.getString("COGNOME"));
			utente.setEmail(rs.getString("EMAIL"));
			utente.setDataDiNascita(rs.getDate("DATE"));
			utente.setPassword(rs.getString("PASSWORD"));
			utente.setUfficio(rs.getString("UFFICIO"));
			PreparedStatement pr1=istance.prepareStatement("SELECT INSEGNAMENTO_NOME FROM INSEGNA WHERE UTENTE_EMAIL=?");
			pr1.setString(1, email);
			ResultSet rs1=pr1.executeQuery();
			while(rs1.next()) {
				utente.setInsegnamento(rs1.getString("INSEGNAMENTO_NOME"));
			}
		}
		return utente;
	}
	
	
}
