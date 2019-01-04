package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.unisa.etm.bean.Amministratore;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AutenticazioneModelInterface;
/**
 * Classe che implementa le funzionalità dedicate alla registrazione e al login.
 * @author ETM
 *
 */
public class AutenticazioneManager implements AutenticazioneModelInterface{

	@Override
	public boolean registraUtente(Utente utente){
		Connection istance;
		try {
			istance = DatabaseManager.getIstance();
			PreparedStatement ps=null;
			String insertSQL=null;
			if(utente.getTipo().equals("s")) {
				insertSQL = "insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) "
						+ "values(?,?,?,?,?,?,?,?);";
				ps=istance.prepareStatement(insertSQL);
				ps.setString(1, utente.getEmail());
				ps.setString(2, utente.getNome());;
				ps.setString(3, utente.getCognome());
				ps.setString(4, utente.getPassword());
				ps.setString(5, utente.getDataDiNascita());
				ps.setString(6, utente.getMatricola());
				ps.setString(7, String.valueOf(utente.getTipo()));
				ps.setString(8, utente.getValidazione());
				ps.executeUpdate();
			}
			else {
				insertSQL = "insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo, validazione) "
						+ "values(?,?,?,?,?,?,?,?);";
				ps=istance.prepareStatement(insertSQL);
				ps.setString(1, utente.getEmail());
				ps.setString(2, utente.getNome());;
				ps.setString(3, utente.getCognome());
				ps.setString(4, utente.getPassword());
				ps.setString(5, utente.getDataDiNascita());
				ps.setString(6, utente.getUfficio());
				ps.setString(7, String.valueOf(utente.getTipo()));
				ps.setString(8, utente.getValidazione());
				ps.executeUpdate();
				
				String SQL = "select nome from insegnamento where nome='" + utente.getInsegnamento().get(0) + "';";
				PreparedStatement preparedStatement=istance.prepareStatement(SQL);
				ResultSet rs=preparedStatement.executeQuery(SQL);
				if(!rs.next()) {
					String insertSQL1="insert into insegnamento (nome) values(?);";
					PreparedStatement ps1=istance.prepareStatement(insertSQL1);
					ps1.setString(1, utente.getInsegnamento().get(0));
					ps1.executeUpdate();
				}
				String insertSQL2="insert into insegna (utente_email, insegnamento_nome) values(?,?);";			
				PreparedStatement ps2=istance.prepareStatement(insertSQL2);
				ps2.setString(1, utente.getEmail());
				ps2.setString(2, utente.getInsegnamento().get(0));
				ps2.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public Utente getUtente(String email, String password){
		Connection istance;
		try {
			istance = DatabaseManager.getIstance();
			PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=? AND PASSWORD=?");
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				Utente utente=new Utente();
				if(rs.getString("TIPO").equals("s")){
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setMatricola(rs.getString("MATRICOLA"));
				utente.setTipo(rs.getString("TIPO"));
				if(rs.getInt("PROPOSTATESI_ID")!=0)
				utente.setPropostaTesi_ID(rs.getInt("PROPOSTATESI_ID"));
				utente.setEmail(rs.getString("EMAIL"));
				utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setValidazione(rs.getString("VALIDAZIONE"));
				}
				else if(rs.getString("TIPO").equals("d")) {
					utente.setNome(rs.getString("NOME"));
					utente.setCognome(rs.getString("COGNOME"));
					utente.setEmail(rs.getString("EMAIL"));
					utente.setTipo(rs.getString("TIPO"));
					utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
					utente.setPassword(rs.getString("PASSWORD"));
					utente.setUfficio(rs.getString("UFFICIO"));
					utente.setValidazione(rs.getString("VALIDAZIONE"));
					PreparedStatement pr1=istance.prepareStatement("SELECT INSEGNAMENTO_NOME FROM INSEGNA WHERE UTENTE_EMAIL=?");
					pr1.setString(1, email);
					ResultSet rs1=pr1.executeQuery();
					while(rs1.next()) {
						utente.setInsegnamento(rs1.getString("INSEGNAMENTO_NOME"));
					}
				}
				return utente;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public Amministratore getAdmin(String email, String password){
		Connection istance;
		try {
			istance = DatabaseManager.getIstance();
			PreparedStatement pr=istance.prepareStatement("SELECT * FROM AMMINISTRATORE WHERE EMAIL=? AND PASSWORD=?");
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				Amministratore admin=new Amministratore();
				admin.setNome(rs.getString("NOME"));
				admin.setCognome(rs.getString("COGNOME"));
				admin.setEmail(rs.getString("EMAIL"));
				admin.setPassword(rs.getString("PASSWORD"));
				return admin;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getPassword(String email){
		try {
			Connection istance=DatabaseManager.getIstance();
			PreparedStatement pr;
			pr = istance.prepareStatement("SELECT PASSWORD FROM UTENTE WHERE EMAIL=?");
			pr.setString(1, email);
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				return rs.getString("password");
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean setValidazione(String validazione){
		Connection istance;
		try {
			istance = DatabaseManager.getIstance();
			PreparedStatement pr=istance.prepareStatement("SELECT VALIDAZIONE FROM UTENTE WHERE VALIDAZIONE=?");
			pr.setString(1, validazione);
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				PreparedStatement ps1=null;
				String updateSQL = "update utente set validazione=? where validazione=?;";
				ps1=istance.prepareStatement(updateSQL);
				ps1.setString(1, "valido");
				ps1.setString(2, validazione);;
				ps1.executeUpdate();
			}
			else {
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}

}
