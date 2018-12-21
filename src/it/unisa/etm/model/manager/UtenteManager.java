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
	public void registraUtente(Utente utente) throws SQLException{
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement ps=null;
		String insertSQL=null;
		if(utente.getTipo().equals("s"))
		{
			insertSQL = "insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo) "
					+ "values(?,?,?,?,?,?,?);";
			ps=istance.prepareStatement(insertSQL);
			ps.setString(1, utente.getEmail());
			ps.setString(2, utente.getNome());;
			ps.setString(3, utente.getCognome());
			ps.setString(4, utente.getPassword());
			ps.setString(5, utente.getDataDiNascita());
			ps.setLong(6, utente.getMatricola());
			ps.setString(7, String.valueOf(utente.getTipo()));
			ps.executeUpdate();
		}
		else
		{
			insertSQL = "insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo) "
					+ "values(?,?,?,?,?,?,?);";
			ps=istance.prepareStatement(insertSQL);
			ps.setString(1, utente.getEmail());
			ps.setString(2, utente.getNome());;
			ps.setString(3, utente.getCognome());
			ps.setString(4, utente.getPassword());
			ps.setString(5, utente.getDataDiNascita());
			ps.setString(6, utente.getUfficio());
			ps.setString(7, String.valueOf(utente.getTipo()));
			ps.executeUpdate();
		}
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
		utente.setMatricola(rs.getLong("MATRICOLA"));
		utente.setTipo(rs.getString("TIPO"));
		if(rs.getInt("PROPOSTATESI_ID")==0)
		utente.setPropostaTesi_ID(rs.getInt("PROPOSTATESI_ID"));
		utente.setEmail(rs.getString("EMAIL"));
		utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
		utente.setPassword(rs.getString("PASSWORD"));
		}
		else if(rs.getString("TIPO").equals("d")) {
			utente.setNome(rs.getString("NOME"));
			utente.setCognome(rs.getString("COGNOME"));
			utente.setEmail(rs.getString("EMAIL"));
			utente.setTipo(rs.getString("TIPO"));
			utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
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
