package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.bean.File;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.FileModelInterface;

public class FileManager implements FileModelInterface<File> {
	public FileManager() {
		
	}
	
	public ArrayList doRetriveAll() throws SQLException {
		ArrayList<File> list=new ArrayList<File>();
		String selectSQL="SELECT * FROM File";
		try {
		connection = DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		ResultSet rs=prepared.executeQuery();
		while(rs.next()) {
			File file=new File();
			file.setNome(rs.getString("NOME"));
			file.setDescrizione(rs.getString("DESCRIZIONE"));
			file.setDescrizioneVoto(rs.getString("DESCRIZIONE_VOTO"));
			file.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			file.setVoto(rs.getInt("VOTO"));
			
			list.add(file);
		}
	}finally{
		
			if(prepared!=null) {
				prepared.close();
			}
		}
		return list;
	}

	@Override
	public File doRetriveByPropostaTesiId(int propostaTesiId) throws SQLException {
		String selectSQL="SELECT * FROM File WHERE propostatesi_id=?";
		File file=new File();
		try {
		connection = DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		prepared.setInt(1, propostaTesiId);
		ResultSet rs=prepared.executeQuery();
		while(rs.next()) {
			file.setNome(rs.getString("NOME"));
			file.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			file.setDescrizione(rs.getString("DESCRIZIONE"));
		}
	}finally{
		
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
		return file;
		
	}

	
	public void doSave(File file) throws SQLException {
		String selectSQL="INSERT INTO File(PROPOSTATESI_ID,NOME,DESCRIZIONE,DESCRIZIONE_VOTO,VOTO,EMAIL) VALUES(?,?,?,?,?,?)";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, file.getPropostaTesiId());
			prepared.setString(2, file.getNome());
			prepared.setString(3, file.getDescrizione());
			prepared.setString(4, file.getDescrizioneVoto());
			prepared.setInt(5, file.getVoto());
			prepared.setString(6, file.getEmail());
			prepared.executeUpdate();
			connection.commit();
		} finally {
			if(prepared!=null) {
				prepared.close();
				connection.close();
			}
		}
		
		
	}


	
	public void doDelete(int propostaTesiId) throws SQLException {
		String selectSQL="DELETE FROM File WHERE PROPOSTATESI_ID=?";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, propostaTesiId);			
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