package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.interfaces.AmministratoreModelInterface;
import it.unisa.etm.database.DatabaseManager;
/**
 * Classe che implementa le funzionnalitą dedicate all'utente registrato come amministratore
 * @author ETM
 *
 */

public class AmministratoreManager implements AmministratoreModelInterface{

	public AmministratoreManager() {

	}

	@Override
	public List<Utente> getListaUtenti(){
		String SQL="SELECT * FROM Utente;";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList <Utente> utenti=null;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			ResultSet rs=statement.executeQuery(SQL);
			utenti=new ArrayList<Utente>();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try{
					if(statement!=null)
						statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
		}
		
		return utenti;
	}

	@Override
	public boolean eliminaUtente(String email){
		Utente utente= this.getUtente(email);
		Connection connection=null;
		PreparedStatement prepared1=null;
		PreparedStatement prepared2=null;
		PreparedStatement prepared3=null;
		PreparedStatement prepared=null;

		try {
			connection=DatabaseManager.getIstance();
			
			if(utente.getUfficio()==null) {
			prepared3=connection.prepareStatement("DELETE FROM File WHERE utente_email =?;");		
			prepared3.setString(1, email);
			prepared3.executeUpdate();
			prepared2=connection.prepareStatement("DELETE FROM Attivita WHERE utente_email =?;");		
			prepared2.setString(1, email);
			prepared2.executeUpdate();
			prepared1=connection.prepareStatement("DELETE FROM Partecipa WHERE utente_email =?;");		
			prepared1.setString(1, email);
			prepared1.executeUpdate();
			}
			else {
				String selectSQL = "SELECT Id FROM Propostatesi WHERE utente_email = ?";
				prepared1=connection.prepareStatement(selectSQL);	
				
				prepared1.setString(1, email);
				ResultSet rs = prepared1.executeQuery();
				
				while(rs.next()) {
					int id= rs.getInt(1);
					prepared1 = connection.prepareStatement("DELETE FROM Partecipa WHERE propostatesi_id =?;");		
					prepared1.setInt(1, id);
					prepared1.executeUpdate();
				}
				
				prepared3=connection.prepareStatement("DELETE FROM Propostatesi WHERE utente_email = ?");		
				prepared3.setString(1, email);
				prepared3.executeUpdate();
				prepared2=connection.prepareStatement("DELETE FROM Insegna WHERE utente_email =?;");		
				prepared2.setString(1, email);
				prepared2.executeUpdate();
				
			}
			prepared=connection.prepareStatement("DELETE FROM Utente WHERE email =?;");		
			prepared.setString(1, email);
			prepared.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}/*finally {
			try{
				prepared.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}*/	
	}

	@Override
	public Utente getUtente(String email){
		ArrayList<Utente> utenti=(ArrayList<Utente>) this.getListaUtenti();	
		for(Utente u: utenti)
			if(u.getEmail().equalsIgnoreCase(email)) {
				return u;
			}		
		return null;
	}

	@Override
	public List<Utente> cercaUtente(String nome){
		String SQL="SELECT u FROM Utente WHERE u.nome="+nome+";";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList <Utente> utenti=null;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			ResultSet rs=statement.executeQuery(SQL);
			utenti=new ArrayList<Utente>();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return utenti;
	}

}
	
	
	


