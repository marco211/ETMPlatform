package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import it.unisa.etm.bean.Ha;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.HaModelInterface;

public class HaManager implements HaModelInterface {

	@Override
	public void addHa(Ha ha) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("INSERT INTO HA (UTENTE_EMAIL,CONSEGNA_ID,STATO) VALUES (?,?,?)");
		prepared.setString(1, ha.getUtente_Email());
		prepared.setInt(2, ha.getConsegna_id());
		prepared.setBoolean(3, ha.isStato());
		prepared.executeUpdate();	
		prepared.close();
	}

	@Override
	public void modificaStato(String utenteEmail, int consegnaId, boolean stato) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("UPDATE HA SET STATO=?  Where UTENTE_EMAIL=? AND CONSEGNA_ID=?");
		prepared.setBoolean(1, stato);
		prepared.setString(2, utenteEmail);
		prepared.setInt(3, consegnaId);
		prepared.executeUpdate();	
		prepared.close();
	}
	
	private Connection connection;
	private PreparedStatement prepared;
}
