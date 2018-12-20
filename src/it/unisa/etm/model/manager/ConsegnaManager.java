package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.Consegna;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.ConsegnaModelInterface;

public class ConsegnaManager implements ConsegnaModelInterface {
	public ConsegnaManager() {
		
	}
	
	

	
	public boolean aggiungiConsegna(Consegna consegna) throws SQLException {
		String selectSQL="INSERT INTO Consegna(ID,SCANDENZA,NOME,DESCRIZIONE,PROPOSTATESI_ID) VALUES(?,?,?,?,?)";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, consegna.getId());
			prepared.setString(2, consegna.getScadenza());
			prepared.setString(3, consegna.getNome());
			prepared.setString(4, consegna.getDescrzione());
			prepared.setInt(5, consegna.getId());
			prepared.executeUpdate();
			connection.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
		
		
	}

	@Override
	public boolean modificaConsegna(Consegna c) throws SQLException {
		String selectSQL="UPDATE Consegna SET ID = ?,"
						+ "SCADENZA = ?,"
						+ "NOME = ?,"
						+ "DESCRIZIONE = ?"
						+ "WHERE PROPOSTATESI_ID = ?";
		
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, c.getId());
			prepared.setString(2, c.getScadenza());
			prepared.setString(3, c.getNome());
			prepared.setString(4, c.getDescrzione());
			prepared.setInt(5, c.getId());
			prepared.executeUpdate();
			connection.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if(prepared!=null) {
				prepared.close();
			}
		}
	}

	
	@Override
	public boolean eliminaConsegna(int id) throws SQLException {
		String selectSQL="DELETE FROM Consegna WHERE ID=?";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, id);			
			prepared.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e){
			return false;
		
		} finally {
		
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
	}
	
	@Override
	public Consegna getConsegna(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Connection connection=null;
	private PreparedStatement prepared=null;


}
