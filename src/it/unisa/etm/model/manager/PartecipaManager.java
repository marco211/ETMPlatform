 package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Consegna;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
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
	public ArrayList<Partecipa> getListaPartecipazione(ArrayList<PropostaTesi> list) throws SQLException {
		String selectSQL="SELECT * FROM PARTECIPA WHERE PROPOSTATESI_ID=?";
		connection=DatabaseManager.getIstance();
		ArrayList<Partecipa> lista = new ArrayList<Partecipa>();
		for(int i=0;i<list.size();i++) {
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, list.get(i).getId());
			rs=prepared.executeQuery();
			while(rs.next()) {
				Partecipa partecipa=new Partecipa();
				partecipa.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
				partecipa.setUtenteEmail(rs.getString("UTENTE_EMAIL"));
				lista.add(partecipa);
			}
			prepared.close();
			rs.close();
		}

		return lista;	
	}

	private ResultSet rs;
	private Connection connection=null;
	private PreparedStatement prepared=null;
	

}
