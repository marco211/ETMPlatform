package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import it.unisa.etm.bean.File;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.AreaCondivisaModelInterface;
/**
 * Classe che implementa le funzionalità dedicate agli utenti che fanno parte di un'area privata condivisa.
 * @author ETM
 *
 */
public class AreaCondivisaManager implements AreaCondivisaModelInterface {
	public AreaCondivisaManager() {
		
	}
	
	@Override
	public boolean inserisciFile(File file){
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
		}
	}

	@Override
	public boolean rimuoviFile(int idFile){
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
		}
	}

	@Override
	public List<File> getFileByPropostaTesi(int idProposta){
		String selectSQL="SELECT * FROM File WHERE propostatesi_id=?";
		File file=new File();
		try {
		connection = DatabaseManager.getIstance();
		prepared=connection.prepareStatement(selectSQL);
		prepared.setInt(1, idProposta);
		ResultSet rs=prepared.executeQuery();
		List<File> list=new ArrayList<File>();
		while(rs.next()) {
			file.setNome(rs.getString("NOME"));
			file.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			file.setDescrizione(rs.getString("DESCRIZIONE"));
			list.add(file);
		}
		return list;
		}catch (Exception e) {
			return null; //return file
		}
	}
	
	private Connection connection=null;
	private PreparedStatement prepared=null;
}