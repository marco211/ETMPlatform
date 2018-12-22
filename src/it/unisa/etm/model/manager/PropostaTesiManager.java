package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;

public class PropostaTesiManager implements PropostaTesiModelInterface {

	public PropostaTesiManager() {
		
	}


	
	@Override
	public void inserisciRichiestaPartecipazione(RichiestaPartecipazione richiestaPartecipazione) throws SQLException{
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement ps=null;
		String insertSQL=null;
		insertSQL = "insert into RichiestaPartecipazione (Data, PropostaTesi_Id, Utente_Email) "
					+ "values(?,?,?);";
		try {
			ps=istance.prepareStatement(insertSQL); 
			ps.setDate(1, java.sql.Date.valueOf(richiestaPartecipazione.getData()));			
			ps.setInt(2, richiestaPartecipazione.getPropostatesi_id());			
			ps.setString(3, richiestaPartecipazione.getUtente_mail());								
			ps.executeUpdate();
		}finally {
			if (ps != null)
				ps.close();
		}
	}
	
	@Override
	public boolean inserisciPropostaTesi(PropostaTesi proposta) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		boolean b;
		boolean chiuso = false;
		boolean archivio = false;
		String SQL = "insert into PropostaTesi (Utente_Email, Titolo, Chiuso, Ambito, Tempo, Descrizione, Archiviato, Materia) values(?,?,?,?,?,?,?,?)";
		try {
			connection = DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, proposta.getUtenteEmail());
			statement.setString(2, proposta.getTitolo());
			statement.setBoolean(3, chiuso);
			statement.setString(4, proposta.getAmbito());
			statement.setInt(5, proposta.getTempoDiSviluppo());
			statement.setString(6, proposta.getDecrizione());
			statement.setBoolean(7, archivio);
			statement.setString(8, proposta.getMaterie());
			statement.executeUpdate();
			b=true;
		}finally {
			if (statement != null)
				statement.close();
		}
		return b;
	}
	
	@Override
	public boolean archiviaPropostaTesi(int id) throws SQLException {
		String SQL = "UPDATE PropostaTesi SET Archiviato = true WHERE p.id="+id+";";
		Connection connection = null;
		PreparedStatement statement = null;
		boolean b;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			statement.executeQuery(SQL);
			b = true;
		}finally {
			if(statement!=null)
				statement.close();
		}
		return false;
	}
	@Override
	public ArrayList<PropostaTesi> getPropostaTesi(String titolo) throws SQLException {
		String SQL = "SELECT p FROM PropostaTesi WHERE p.titolo="+titolo+";";
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList <PropostaTesi> proposte = null;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			ResultSet rs = statement.executeQuery(SQL);
			proposte = new ArrayList<PropostaTesi>();
			while(rs.next()) {
				PropostaTesi proposta = new PropostaTesi();
				proposta.setId(rs.getInt(1));
				proposta.setUtenteEmail(rs.getString(2));
				proposta.setTitolo(rs.getString(3));
				proposta.setChiuso(rs.getBoolean(4));
				proposta.setAmbito(rs.getString(5));
				proposta.setTempoDiSviluppo(rs.getInt(6));
				proposta.setDecrizione(rs.getString(7));
				proposta.setArchiviato(rs.getBoolean(8));
				proposta.setMaterie(rs.getString(9));
				proposte.add(proposta);
			}
		}finally {
			if(statement!=null)
				statement.close();
		}
		return proposte;
	}
	@Override
	public boolean chiudiPropostaTesi(String titoloProposta) throws SQLException {
		String SQL = "UPDATE PropostaTesi SET Chiuso = true WHERE p.titolo="+titoloProposta+";";
		Connection connection = null;
		PreparedStatement statement = null;
		boolean b;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			statement.executeQuery(SQL);
			b = true;
		}finally {
			if(statement!=null)
				statement.close();
		}
		return false;
	}
	@Override
	public boolean rimuoviPropostaTesi(String titoloProposta) throws SQLException {
		String SQL = "Delete p FROM PropostaTesi WHERE p.titolo="+titoloProposta+";";
		Connection connection = null;
		PreparedStatement statement = null;
		boolean b;
		try {
			connection = DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			statement.executeUpdate();
			b=true;
		}finally {
				if(statement!=null)
					statement.close();
		}
		return b;
	}
	@Override
	public ArrayList<PropostaTesi> getProposteTesiAttive() throws SQLException {
		String SQL = "SELECT * FROM PropostaTesi;";
		System.out.println("ci sono");
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList <PropostaTesi> proposte = null;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			ResultSet rs = statement.executeQuery(SQL);
			proposte = new ArrayList<PropostaTesi>();
			while(rs.next()) {
				PropostaTesi proposta = new PropostaTesi();
				proposta.setId(rs.getInt(1));
				proposta.setUtenteEmail(rs.getString(2));
				proposta.setTitolo(rs.getString(3));
				proposta.setChiuso(rs.getBoolean(4));
				proposta.setAmbito(rs.getString(5));
				proposta.setTempoDiSviluppo(rs.getInt(6));
				proposta.setDecrizione(rs.getString(7));
				proposta.setArchiviato(rs.getBoolean(8));
				proposta.setMaterie(rs.getString(9));
				proposte.add(proposta);
				System.out.println("proposta aggiunta");
			}
		}finally {
			if(statement!=null)
				statement.close();
		}
		
		return proposte;
	}
	@Override
	public List<Attivita> getStoricoAttivita(String titoloProposta) throws SQLException {
		String SQL = "SELECT * FROM Attivita;";
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList <Attivita> allActivity = null;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			ResultSet rs = statement.executeQuery(SQL);
			allActivity = new ArrayList<Attivita>();
			while(rs.next()) {
				Attivita attivita = new Attivita();
				
			}
		}finally {
			if(statement!=null)
				statement.close();
		}
		
		return allActivity;
	}



	@Override
	public ArrayList<PropostaTesi> getProposteTesiDocente(String utenteEmail) throws SQLException {
		String SQL = "SELECT * FROM PropostaTesi where Utente_Email=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ArrayList <PropostaTesi> proposte = null;
		try {
			connection =  DatabaseManager.getIstance();
			statement = connection.prepareStatement(SQL);
			statement.setString(1, utenteEmail);
			ResultSet rs = statement.executeQuery(SQL);
			proposte = new ArrayList<PropostaTesi>();
			while(rs.next()) {
				PropostaTesi proposta = new PropostaTesi();
				proposta.setId(rs.getInt(1));
				proposta.setUtenteEmail(rs.getString(2));
				proposta.setTitolo(rs.getString(3));
				proposta.setChiuso(rs.getBoolean(4));
				proposta.setAmbito(rs.getString(5));
				proposta.setTempoDiSviluppo(rs.getInt(6));
				proposta.setDecrizione(rs.getString(7));
				proposta.setArchiviato(rs.getBoolean(8));
				proposta.setMaterie(rs.getString(9));
				proposte.add(proposta);
			}
		}finally {
			if(statement!=null)
				statement.close();
		}
		
		return proposte;
	}




}
