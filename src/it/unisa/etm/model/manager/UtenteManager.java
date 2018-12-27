package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.UtenteModelInterface;

public  class UtenteManager implements UtenteModelInterface{

	public UtenteManager() {
		
	}
	@Override
	public Utente getInfo(String email) throws SQLException {
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=?");
		pr.setString(1, email);
		ResultSet rs=pr.executeQuery();
		rs.next();
		Utente utente=new Utente();
		if(rs.getString("TIPO").equals("s")){
		utente.setNome(rs.getString("NOME"));
		utente.setCognome(rs.getString("COGNOME"));
		utente.setMatricola(rs.getLong("MATRICOLA"));
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
	
	
	


	

	
	@Override
	public List<Utente> getUtenti(String nome) throws SQLException{
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement ps=null;
		String SQL = "SELECT * FROM UTENTE WHERE NOME='"+nome+"';";
		ps=istance.prepareStatement(SQL);
		return null;
	}

	@Override
	public boolean modificaPassword(Utente utente) throws SQLException{
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement ps=null;
		String insertSQL=null;
		insertSQL = "UPDATE Utente SET password "
				+ "values(?)  WHERE EMAIL='"+ utente.getEmail()+"' AND MATRICOLA='"+ utente.getMatricola() +"';";
		ps=istance.prepareStatement(insertSQL);
		ps.setString(1, utente.getPassword());
		return true;
	}

	@Override
	public boolean modificaUtente(Utente utente) throws SQLException{
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement ps=null;
		String insertSQL=null;
		if(utente.getTipo().equals("s"))
		{
			insertSQL = "UPDATE utente SET nome = ?, cognome = ?, data_nascita = ?, matricola =?;";
			ps=istance.prepareStatement(insertSQL);
			ps.setString(1, utente.getNome());;
			ps.setString(2, utente.getCognome());
			ps.setString(3, utente.getDataDiNascita());
			ps.setLong(4, utente.getMatricola());
			ps.executeUpdate();
		}
		else
		{
			insertSQL = "UPDATE utente SET (nome, cognome, data_nascita, ufficio) "
					+ "values(?,?,?,?);";
			ps=istance.prepareStatement(insertSQL);
			ps.setString(1, utente.getNome());;
			ps.setString(2, utente.getCognome());
			ps.setString(3, utente.getDataDiNascita());
			ps.setString(4, utente.getUfficio());
			ps.executeUpdate();
		}
		return true;
	 }


	
	
	

	
}
