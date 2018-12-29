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
		String selectSQL="INSERT INTO CONSEGNA (SCADENZA, NOME, DESCRIZIONE, PROPOSTATESI_ID) VALUES (?,?,?,?)";
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);  
			prepared.setString(1, consegna.getScadenza());
			prepared.setString(2, consegna.getNome());
			prepared.setString(3, consegna.getDescrzione());
			prepared.setInt(4, consegna.getPropostaTesiId());
			prepared.executeUpdate();
			prepared.close();
		return true;
		
	}

	@Override
	public boolean modificaConsegna(String scadenza, int id) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("UPDATE CONSEGNA SET Scadenza=? Where Id=?");
		prepared.setString(1, scadenza);
		prepared.setInt(2, id);
		prepared.executeUpdate();	
		prepared.close();
		return true;
	}

	
	@Override
	public boolean eliminaConsegna(int id) throws SQLException {
		String selectSQL="DELETE FROM Consegna WHERE ID=?";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, id);			
			prepared.executeUpdate();
			prepared.close();
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	@Override
	public Consegna getConsegna(int id) throws SQLException {
		String selectSQL="SELECT * FROM CONSEGNA WHERE ID=?";
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		prepared.setInt(1, id);
		rs=prepared.executeQuery();
		rs.next();
			Consegna consegna = new Consegna();
			consegna.setNome(rs.getString("NOME"));
			consegna.setDescrzione(rs.getString("DESCRIZIONE"));
			consegna.setId(rs.getInt("ID"));
			consegna.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			consegna.setScadenza(rs.getString("SCADENZA"));	

		prepared.close();
		rs.close();
		
		return consegna;
	}
	
	@Override
	public ArrayList<Consegna> getListaConsegne(int propostaTesiId) throws SQLException {
		String selectSQL="SELECT * FROM CONSEGNA WHERE PROPOSTATESI_ID=?";
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, propostaTesiId);
			rs=prepared.executeQuery();
			ArrayList<Consegna> list = new ArrayList<Consegna>();
			while(rs.next()) {
				Consegna consegna = new Consegna();
				consegna.setNome(rs.getString("NOME"));
				consegna.setDescrzione(rs.getString("DESCRIZIONE"));
				consegna.setId(rs.getInt("ID"));
				consegna.setPropostaTesiId(propostaTesiId);
				consegna.setScadenza(rs.getString("SCADENZA"));	
				list.add(consegna);
			}
			prepared.close();
			rs.close();
			
			return list;	
	}

	private ResultSet rs;
	private Connection connection=null;
	private PreparedStatement prepared=null;
}
