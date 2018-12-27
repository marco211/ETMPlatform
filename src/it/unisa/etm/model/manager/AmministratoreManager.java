package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.interfaces.AmministratoreModelInterface;
import it.unisa.etm.database.DatabaseManager;
public class AmministratoreManager implements AmministratoreModelInterface{

	public AmministratoreManager() {
		log = Logger.getLogger("global");
	}

	@Override
	public List<Utente> getListaUtenti() throws SQLException {
		String SQL = "SELECT * FROM Utente;";

		log.info("Ci sono");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList <Utente> utenti = null;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			ResultSet rs = statement.executeQuery(SQL);
			utenti = new ArrayList<Utente>();
			while(rs.next()) {
				Utente utente=new Utente();
				utente.setEmail(rs.getString(1));
				utente.setNome(rs.getString(2));
				utente.setCognome(rs.getString(3));
				utente.setPassword(rs.getString(4));
				utente.setDataDiNascita(rs.getString(5));
				utente.setPropostaTesi_ID(rs.getInt(6));
				utente.setMatricola(rs.getLong(7));
				utente.setUfficio(rs.getString(8));
				utente.setTipo(rs.getString(9));
				utenti.add(utente);
				
			}
		}finally {
			if(statement!=null)
				statement.close();
		}
		
		return utenti;
	}

	@Override
	public boolean eliminaUtente(String email){
		log.info("Amministratore, elimina utente");
		Connection connection = null;
		PreparedStatement prepared = null;
		
		try {
			connection = DatabaseManager.getIstance();
			prepared=connection.prepareStatement("DELETE FROM Utente WHERE email =?;");
			
			prepared.setString(1, email);
			prepared.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally {
			try{
				prepared.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
	}

	@Override
	public Utente getUtente(String email) throws SQLException {
		ArrayList<Utente> utenti=(ArrayList<Utente>) this.getListaUtenti();
		
		for(Utente u: utenti)
			if(u.getEmail().equalsIgnoreCase(email)) {
				System.out.println("AmministartoreManager: utente preso");
				return u;
			}
	
		
	return null;
	}

	@Override
	public List<Utente> cercaUtente(String nome) throws SQLException {
		String SQL = "SELECT u FROM Utente WHERE u.nome="+nome+";";
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList <Utente> utenti = null;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			ResultSet rs = statement.executeQuery(SQL);
			utenti = new ArrayList<Utente>();
			while(rs.next()) {
				Utente utente=new Utente();
				utente.setEmail(rs.getString(1));
				utente.setNome(rs.getString(2));
				utente.setCognome(rs.getString(3));
				utente.setPassword(rs.getString(4));
				utente.setDataDiNascita(rs.getString(5));
				utente.setPropostaTesi_ID(rs.getInt(6));
				utente.setMatricola(rs.getLong(7));
				utente.setUfficio(rs.getString(8));
				utente.setTipo(rs.getString(9));
				utenti.add(utente);
			}
		}finally {
			if(statement!=null)
				statement.close();
		}
		return utenti;
	}
	
	
	private Logger log;
}
	
	
	


