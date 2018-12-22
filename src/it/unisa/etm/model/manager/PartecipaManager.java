package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Consegna;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.PartecipaModelInterface;

public class PartecipaManager implements PartecipaModelInterface {

	@Override
	public boolean inserisciPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Partecipa getPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rimuoviPartecipazione(int propostaTesiId, String utenteEmail) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Partecipa> getListaPartecipazione(int propostaTesiId) throws SQLException {
		String selectSQL="SELECT * FROM PARTECIPA WHERE PROPOSTATESI_ID=?";
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		prepared.setInt(1, propostaTesiId);
		rs=prepared.executeQuery();
		ArrayList<Partecipa> list = new ArrayList<Partecipa>();
		while(rs.next()) {
			Partecipa partecipa=new Partecipa();
			partecipa.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			partecipa.setUtenteEmail(rs.getString("UTENTE_EMAIL"));
			list.add(partecipa);
		}
		prepared.close();
		rs.close();
		
		return list;	
	}

	private ResultSet rs;
	private Connection connection=null;
	private PreparedStatement prepared=null;

}
