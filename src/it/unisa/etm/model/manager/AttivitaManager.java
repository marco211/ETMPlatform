package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AttivitaModelInterface;
/**
 * Classe che implementa le funzionalita dedicate alle attivita effettuate da parte degli utenti che fanno parte di un'area privata condivisa
 * @author ETM
 *
 */

public class AttivitaManager implements AttivitaModelInterface {

	@Override
	public boolean aggiungiAttivita(Attivita attivita) {
		
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement("INSERT INTO ATTIVITA (UTENTE_EMAIL,NOMEFILE,DATA,TIPO,PROPOSTATESI_ID) VALUES (?,?,?,?,?)");
			prepared.setString(1, attivita.getUtente_Email());
			prepared.setString(2, attivita.getNomeFile());
			prepared.setDate(3, java.sql.Date.valueOf(attivita.getData()));
			prepared.setString(4, attivita.getTipo());
			prepared.setInt(5, attivita.getPropostatesi_id());
			prepared.executeUpdate();	
			prepared.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Attivita> getListaAttivita(int propostaTesiId){
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement("SELECT * FROM ATTIVITA WHERE PROPOSTATESI_ID=?");
			prepared.setInt(1, propostaTesiId);
			rs=prepared.executeQuery();
			ArrayList<Attivita> list=new ArrayList<Attivita>();
			while(rs.next()) {
				Attivita attivita=new Attivita();
				attivita.setUtente_Email(rs.getString("UTENTE_EMAIL"));
				attivita.setNomeFile(rs.getString("NOMEFILE"));
				attivita.setData(rs.getDate("DATA").toLocalDate());
				attivita.setTipo(rs.getString("TIPO"));
				attivita.setPropostatesi_id(propostaTesiId);
				list.add(attivita);
			}
			prepared.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			return null;
		}
		
	}

	private Connection connection;
	private PreparedStatement prepared;
	private ResultSet rs;
}
