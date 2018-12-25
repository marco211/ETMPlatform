package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import it.unisa.etm.bean.Attivita;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AttivitaModelInterface;

public class AttivitaManager implements AttivitaModelInterface {

	@Override
	public boolean aggiungiAttivita(Attivita attivita) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("INSERT INTO ATTIVITA (UTENTE_EMAIL,NOMEFILE,DATA,TIPO,PROPOSTATESI_ID) VALUES (?,?,?,?,?)");
		prepared.setString(1, attivita.getUtente_Email());
		prepared.setString(2, attivita.getNomeFile());
		prepared.setString(3, attivita.getData());
		prepared.setString(4, attivita.getTipo());
		prepared.setInt(5, attivita.getPropostatesi_id());
		prepared.executeUpdate();	
		prepared.close();
		return true;
	}

	@Override
	public boolean eliminaAttivita(int id, String utenteEmail) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Attivita> getListaAttivita(int propostaTesiId) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("SELECT * FROM ATTIVITA WHERE PROPOSTATESI_ID=?");
		prepared.setInt(1, propostaTesiId);
		rs=prepared.executeQuery();
		ArrayList<Attivita> list=new ArrayList<Attivita>();
		while(rs.next()) {
			Attivita attivita=new Attivita();
			attivita.setUtente_Email(rs.getString("UTENTE_EMAIL"));
			attivita.setNomeFile(rs.getString("NOMEFILE"));
			attivita.setData(rs.getString("DATA"));
			attivita.setTipo(rs.getString("TIPO"));
			attivita.setPropostatesi_id(propostaTesiId);
			list.add(attivita);
		}
		prepared.close();
		rs.close();
		return list;
	}

	private Connection connection;
	private PreparedStatement prepared;
	private ResultSet rs;
}
