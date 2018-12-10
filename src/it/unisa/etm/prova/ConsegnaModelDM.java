package it.unisa.etm.prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.database.DatabaseManager;

public class ConsegnaModelDM implements ConsegnaModel<Consegna> {

	public ConsegnaModelDM() {
		
	}
	
	@Override
	public ArrayList doRetriveAll() throws SQLException {
		ArrayList<Consegna> list=new ArrayList<Consegna>();
		String selectSQL="SELECT * FROM Consegna";
		try {
		connection = DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		ResultSet rs=prepared.executeQuery();
		while(rs.next()) {
			Consegna consegna=new Consegna();
			consegna.setDescrzione(rs.getString("DESCRIZIONE"));
			consegna.setId(rs.getInt("ID"));
			consegna.setNome(rs.getString("NOME"));
			consegna.setScadenza(rs.getString("SCADENZA"));
			consegna.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			list.add(consegna);
		}
	}finally{
		
			if(prepared!=null) {
				prepared.close();
			}
		}
		return list;
	}

	@Override
	public Consegna doRetriveById(int id) throws SQLException {
		String selectSQL="SELECT * FROM Consegna WHERE id=?";
		Consegna consegna=new Consegna();
		try {
		connection = DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		prepared.setInt(1, id);
		ResultSet rs=prepared.executeQuery();
		while(rs.next()) {
			consegna.setDescrzione(rs.getString("DESCRIZIONE"));
			consegna.setId(rs.getInt("ID"));
			consegna.setNome(rs.getString("NOME"));
			consegna.setScadenza(rs.getString("SCADENZA"));
			consegna.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
		}
	}finally{
		
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
		return consegna;
		
	}

	
	public void doSave(Consegna consegna) throws SQLException {
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
		} finally {
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
		
		
	}


	
	public void doDelete(int id) throws SQLException {
		String selectSQL="DELETE FROM Consegna WHERE ID=?";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, id);			
			prepared.executeUpdate();
			connection.commit();
		} finally {
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
	}
	
	private Connection connection=null;
	private PreparedStatement prepared=null;
}
