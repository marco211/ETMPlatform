package it.unisa.etm.model.manager;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.bean.Insegnamento;
import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.RichiestaPartecipazione;
import it.unisa.etm.model.database.DatabaseManager;
=======
import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.database.DatabaseManager;
>>>>>>> 2a745450ee86215a3825235e01c4512d4d13ad89
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;
/**
 * Classe che implementa le funzionalita dedicate alle proposte di tesi.
 * @author ETM
 *
 */
public class PropostaTesiManager implements PropostaTesiModelInterface {

	public PropostaTesiManager() {

	}

	@Override
	public boolean accettaRichiestaPartecipazione(int id){

		Connection istance=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		String insertSQL=null;
		String insertSQL2=null;
		String query=null;
		ResultSet rs=null;
		
		insertSQL="UPDATE utente SET PropostaTesi_ID = (Select PropostaTesi_Id FROM richiestapartecipazione WHERE ID= ?) WHERE email=(Select utente_email FROM richiestapartecipazione WHERE ID= ?)";
		insertSQL2="delete from RichiestaPartecipazione where Utente_Email=?"; 
		query= "Select utente_email FROM richiestapartecipazione WHERE id= ?";
		try {
			istance=DatabaseManager.getIstance();
			ps3= istance.prepareStatement(query);
			ps3.setInt(1, id);
			rs = ps3.executeQuery();
			rs.next();
			String email = rs.getString(1);
			
			ps=istance.prepareStatement(insertSQL); 
			ps.setInt(1, id);			
			ps.setInt(2, id);
			if(ps.executeUpdate()<1) return false;		
			ps2=istance.prepareStatement(insertSQL2); 
			ps2.setString(1, email);
			if(ps2.executeUpdate()<1) return false;
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean rifiutaRichiestaPartecipazione(int id){
		Connection istance=null;
		PreparedStatement ps=null;
		String insertSQL=null;
		insertSQL="delete from RichiestaPartecipazione where id=?";
		try {
			istance=DatabaseManager.getIstance();
			ps=istance.prepareStatement(insertSQL); 
			ps.setInt(1, id);			
			if(ps.executeUpdate()<1) return false;
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<RichiestaPartecipazione> cercaRichiestePartecipazione(String email){		
		String SQL="SELECT * FROM richiestapartecipazione WHERE propostatesi_id IN (SELECT ID FROM propostatesi WHERE utente_email=?)";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList<RichiestaPartecipazione> richieste=null;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			statement.setString(1, email);
			ResultSet rs=statement.executeQuery();
			richieste=new ArrayList<RichiestaPartecipazione>();

			if(rs.next()) {
				do {
					RichiestaPartecipazione richiesta=new RichiestaPartecipazione();
					richiesta.setId(rs.getInt(1));
					richiesta.setData(rs.getDate(2).toLocalDate()); 
					richiesta.setPropostatesi_id(rs.getInt(3)); 
					richiesta.setUtente_mail(rs.getString(4));
					richieste.add(richiesta);
				}while(rs.next());

				return richieste;
			}else return null;

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public boolean inserisciRichiestaPartecipazione(RichiestaPartecipazione richiestaPartecipazione){
		Connection istance=null;
		PreparedStatement ps=null;
		String insertSQL=null;
		insertSQL="insert into RichiestaPartecipazione (Data, PropostaTesi_Id, Utente_Email) "
				+ "values(?,?,?);";
		try {
			istance=DatabaseManager.getIstance();
			ps=istance.prepareStatement(insertSQL); 
			ps.setDate(1, java.sql.Date.valueOf(richiestaPartecipazione.getData()));			
			ps.setInt(2, richiestaPartecipazione.getPropostatesi_id());			
			ps.setString(3, richiestaPartecipazione.getUtente_mail());								
			if(ps.executeUpdate()<1) return false;
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean inserisciPropostaTesi(PropostaTesi proposta){
		Connection connection=null;
		PreparedStatement statement=null;
		boolean b;
		boolean chiuso=false;
		boolean archivio=false;
		String SQL="insert into PropostaTesi (Utente_Email, Titolo, Chiuso, Ambito, Tempo, Descrizione, Archiviato, Materia) values(?,?,?,?,?,?,?,?)";
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
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
			return b;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean archiviaPropostaTesi(int id){
		String SQL="UPDATE PropostaTesi SET Archiviato =1 WHERE id="+id+";";
		Connection connection=null;
		PreparedStatement statement=null;
		boolean b;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			if(statement.executeUpdate()<1) return false;
			b=true;
			return b;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean chiudiPropostaTesi(int id){
		String SQL="UPDATE PropostaTesi SET Chiuso =1 WHERE id="+id+";";
		Connection connection=null;
		PreparedStatement statement=null;
		boolean b;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			if(statement.executeUpdate()<1) return false;
			b=true;
			return b;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public ArrayList<PropostaTesi> getProposteTesiAttive(){
		String SQL="SELECT * FROM PropostaTesi;";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList <PropostaTesi> proposte=null;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			ResultSet rs=statement.executeQuery(SQL);
			proposte=new ArrayList<PropostaTesi>();
			while(rs.next()) {
				PropostaTesi proposta=new PropostaTesi();
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
			}return proposte;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public ArrayList<PropostaTesi> getProposteTesiDocente(String utenteEmail){
		String SQL="SELECT * FROM PropostaTesi where Utente_Email=?";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList <PropostaTesi> proposte=null;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			statement.setString(1, utenteEmail);
			ResultSet rs=statement.executeQuery();
			proposte=new ArrayList<PropostaTesi>();

			if(rs.next()) {
				PropostaTesi proposta;
				do {
					proposta=new PropostaTesi();
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
				}while(rs.next());

				return proposte;
			}else return null;

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PropostaTesi getPropostaTesi(int id){
		String SQL="SELECT * FROM PropostaTesi WHERE id="+id+";";
		Connection connection=null;
		PreparedStatement statement=null;
		PropostaTesi proposta=null;
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			ResultSet rs=statement.executeQuery(SQL);
			rs.next();
			proposta=new PropostaTesi();
			proposta.setId(rs.getInt(1));
			proposta.setUtenteEmail(rs.getString(2));
			proposta.setTitolo(rs.getString(3));
			proposta.setChiuso(rs.getBoolean(4));
			proposta.setAmbito(rs.getString(5));
			proposta.setTempoDiSviluppo(rs.getInt(6));
			proposta.setDecrizione(rs.getString(7));
			proposta.setArchiviato(rs.getBoolean(8));
			proposta.setMaterie(rs.getString(9));
			return proposta;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modificaPropostaTesi(PropostaTesi proposta){
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection = DatabaseManager.getIstance();
			String SQL = "UPDATE PropostaTesi SET Titolo = ?, Ambito = ?, Tempo = ?, Descrizione = ?, Materia = ? WHERE Id = ?;";
			statement = connection.prepareStatement(SQL);
			statement.setString(1,proposta.getTitolo());
			statement.setString(2,proposta.getAmbito());
			statement.setInt(3, proposta.getTempoDiSviluppo());
			statement.setString(4,proposta.getDecrizione());
			statement.setString(5,proposta.getMaterie());
			statement.setInt(6, proposta.getId());

			if(statement.executeUpdate() < 1) return false;
			else return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean rimuoviPropostaTesi(int id){

		String SQL="Delete FROM PropostaTesi WHERE id="+id+";";
		String SQL2="Select * FROM RichiestaPartecipazione";
		String file = "Delete FROM File WHERE PropostaTesi_id="+id+";";
		String consegnad = "Delete FROM Consegna WHERE PropostaTesi_id="+id+";";
		String attivita = "Delete FROM Attivita WHERE PropostaTesi_id="+id+";";
		String partecipa = "Delete FROM Partecipa WHERE PropostaTesi_id="+id+";";
		String utente="UPDATE Utente SET PropostaTesi_id = 0 WHERE PropostaTesi_id="+id+";";
		Connection connection=null;
		PreparedStatement statement1=null;
		PreparedStatement statement=null;
		boolean b;
		try {
			connection=DatabaseManager.getIstance();
			statement1=connection.prepareStatement(SQL);
			statement1.executeQuery(SQL2);
			ResultSet rs=statement1.getResultSet();
			PreparedStatement f = connection.prepareStatement(file);
			f.executeUpdate();
			PreparedStatement a = connection.prepareStatement(attivita);
			a.executeUpdate();
			PreparedStatement c = connection.prepareStatement(consegnad);
			c.executeUpdate();
			PreparedStatement p = connection.prepareStatement(partecipa);
			p.executeUpdate();
			PreparedStatement u = connection.prepareStatement(utente);
			u.executeUpdate();
			while(rs.next()) {
				int id_proposta=rs.getInt(3);
				if(id_proposta==id) {

					String SQL3="Delete FROM RichiestaPartecipazione WHERE id="+id_proposta+";";
					PreparedStatement statement2=connection.prepareStatement(SQL3);
					statement2.executeUpdate();
				}
			}
			statement=connection.prepareStatement(SQL);
			statement.executeUpdate();
			b=true;
			return b;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public ArrayList<RichiestaPartecipazione> getRichiestaStudente(String utenteEmail){
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList<RichiestaPartecipazione> richieste=new ArrayList<RichiestaPartecipazione>();
		String SQL="SELECT * FROM richiestapartecipazione WHERE utente_email=?;";
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			statement.setString(1, utenteEmail);
			ResultSet rs=statement.executeQuery();
			if(rs.next()) {
				RichiestaPartecipazione richiesta;
				do {
					richiesta=new RichiestaPartecipazione();
					richiesta.setId(rs.getInt(1));
					richiesta.setData(rs.getDate(2).toLocalDate()); 
					richiesta.setPropostatesi_id(rs.getInt(3)); 
					richiesta.setUtente_mail(rs.getString(4));
					richieste.add(richiesta);
				}while(rs.next());

				return richieste;
			}else return null;

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Insegnamento> getInsegnamenti(){
		String SQL="SELECT * FROM insegnamento;";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList<Insegnamento> insegnamenti=new ArrayList<Insegnamento>();
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			ResultSet rs=statement.executeQuery(SQL);
			while(rs.next()) {
				Insegnamento insegnamento=new Insegnamento();
				insegnamento.setNome(rs.getString(1));
				insegnamento.setCfu(rs.getInt(2));
				insegnamenti.add(insegnamento);
			}
			return insegnamenti;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<PropostaTesi> getTesiRecenti() {
		String SQL="SELECT * FROM PROPOSTATESI WHERE Archiviato = false ORDER BY ID DESC LIMIT 8;";
		Connection connection=null;
		PreparedStatement statement=null;
		ArrayList<PropostaTesi> list=new ArrayList<PropostaTesi>();
		try {
			connection=DatabaseManager.getIstance();
			statement=connection.prepareStatement(SQL);
			ResultSet rs=statement.executeQuery(SQL);
			while(rs.next()) {
				PropostaTesi proposta=new PropostaTesi();
				proposta.setId(rs.getInt(1));
				proposta.setUtenteEmail(rs.getString(2));
				proposta.setTitolo(rs.getString(3));
				proposta.setChiuso(rs.getBoolean(4));
				proposta.setAmbito(rs.getString(5));
				proposta.setTempoDiSviluppo(rs.getInt(6));
				proposta.setDecrizione(rs.getString(7));
				proposta.setArchiviato(rs.getBoolean(8));
				proposta.setMaterie(rs.getString(9));
				list.add(proposta);
			}
			return list;
		}catch (SQLException e) {
			return null;
		}
	}

}

