package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisa.etm.bean.File;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AreaCondivisaModelInterface;

public class AreaCondivisaManager implements AreaCondivisaModelInterface {
	public AreaCondivisaManager() {
		
	}
	
	
	
	
	@Override
	public boolean inserisciFile(File file) throws SQLException {
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
	public File getFile(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inserisciValutazione(int idFile, String descrizione, int voto) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rimuoviFile(int idFile) throws SQLException {
		String selectSQL="DELETE FROM File WHERE FILE_ID=?";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(selectSQL);
			prepared.setInt(1, idFile);			
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

	
	
	//DA CONTROLLARE, CHIEDERE PRIMA DI USARE
	//ATTENZIONE - IL METODO NON E' CORRETTO
	@Override
	public List<File> getFileByPropostaTesi(int idProposta) throws SQLException {
		String selectSQL="SELECT * FROM File WHERE propostatesi_id=?";
		File file=new File();
		try {
		connection = DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		prepared.setInt(1, idProposta);
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
		return null; //return file
	}
	
	
	private Connection connection=null;
	private PreparedStatement prepared=null;
}