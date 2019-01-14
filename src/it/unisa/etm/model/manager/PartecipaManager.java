package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.PartecipaModelInterface;
/**
 * Classe che implementa le funzionalità dedicate alle partecipazioni ad una proposta di tesi.
 * @author ETM
 *
 */
public class PartecipaManager implements PartecipaModelInterface {

	public boolean inserisciPartecipazione(int richiestaId, String utenteEmail){
		String selectSQL="SELECT * FROM richiestapartecipazione WHERE id=?;";
		String insertSQL="insert into PARTECIPA (Utente_Email, PropostaTesi_Id) values (?,?);";
		int propostaTesiId=0;
		try {
			Connection connection=DatabaseManager.getIstance();
			PreparedStatement prepared1=connection.prepareStatement(selectSQL);
			prepared1.setInt(1, richiestaId);			
			ResultSet rs1 = prepared1.executeQuery();
			while(rs1.next()) {
				propostaTesiId = rs1.getInt("PropostaTesi_Id");
			}
			PreparedStatement prepared=connection.prepareStatement(insertSQL);
			prepared.setString(1, utenteEmail);
			prepared.setInt(2, propostaTesiId);
			prepared.executeUpdate();
			prepared.close();
			rs1.close();
		}catch(Exception e) {
			return false;			
		}
		return true;
	}

	@Override
	public ArrayList<Partecipa> getListaPartecipazione(ArrayList<PropostaTesi> list) {
		String selectSQL="SELECT * FROM PARTECIPA WHERE PROPOSTATESI_ID=?";
		try {
			Connection connection=DatabaseManager.getIstance();
			ArrayList<Partecipa> lista = new ArrayList<Partecipa>();
			for(int i=0;i<list.size();i++) {
				PreparedStatement prepared=connection.prepareStatement(selectSQL);
				prepared.setInt(1, list.get(i).getId());
				ResultSet rs=prepared.executeQuery();
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
		} catch (SQLException e) {
			return null;
		}
	
	}

}

