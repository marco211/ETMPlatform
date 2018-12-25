package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.interfaces.AmministratoreModelInterface;
import it.unisa.etm.database.DatabaseManager;
public class AmministratoreManager implements AmministratoreModelInterface{

	public AmministratoreManager() {
		
	}

	@Override
	public List<Utente> getListaUtenti() throws SQLException {
		String SQL = "SELECT * FROM Utente;";
		System.out.println("ci sono");
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
	public boolean eliminaUtente(String email) throws SQLException {
		System.out.println("Sono in Amministratore Manager , eliminaUtente");
		Connection connection=DatabaseManager.getIstance();
		PreparedStatement prepared=connection.prepareStatement("DELETE FROM Utente WHERE email =?;");
		boolean b;
		try {
			prepared.setString(1, email);
			prepared.executeUpdate();
			b=true;
			System.out.println("AmministratoreManager: ci siamo");
		}finally {
					prepared.close();
		}
		return b;
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
	
}
	
	
	


