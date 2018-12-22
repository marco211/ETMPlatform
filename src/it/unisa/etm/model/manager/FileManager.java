package it.unisa.etm.model.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import it.unisa.etm.bean.File;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.FileModelInterface;

public class FileManager implements FileModelInterface {
	public FileManager() {

	}

	@Override
	public boolean aggiungiFile(File c, Part filePart) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("INSERT INTO FILE (NOME,PROPOSTATESI_ID,FILE,DESCRIZIONE,UTENTE_EMAIL) VALUES (?,?,?,?,?)");
		prepared.setString(1, filePart.getName());
		prepared.setInt(2, c.getPropostaTesiId());
		try {
			prepared.setBlob(3, filePart.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prepared.setString(4, c.getDescrizione());
		prepared.setString(5, c.getEmail());
		prepared.executeUpdate();	
		prepared.close();
		
		return true;
	}

	@Override
	public boolean modificaFile(File c) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminaFile(int idTesi, String nomeFile) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public File getFile(int id, String nomeFile) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("SELECT * FROM FILE WHERE PROPOSTATESI_ID=? AND NOME=?");
		prepared.setInt(1, id);
		prepared.setString(2, nomeFile);
		rs=prepared.executeQuery();
			File file=new File();
			file.setNome(rs.getString("NOME"));
			file.setEmail(rs.getString("UTENTE_EMAIL"));
			file.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			file.setDescrizione(rs.getString("DESCRIZIONE"));
			file.setDescrizioneVoto(rs.getString("DESCRIZIONE_VOTO"));
			file.setVoto(rs.getInt("VOTO"));
		prepared.close();
		rs.close();
		return file;
	}

	@Override
	public ArrayList<File> getListaFile(int idTesi,String email) throws SQLException {
		connection=DatabaseManager.getIstance();
		prepared=connection.prepareStatement("SELECT * FROM FILE WHERE PROPOSTATESI_ID=? AND UTENTE_EMAIL=?");
		prepared.setInt(1, idTesi);
		prepared.setString(2, email);
		rs=prepared.executeQuery();
		ArrayList<File> list=new ArrayList<File>();
		while(rs.next()) {
			File file=new File();
			file.setNome(rs.getString("NOME"));
			file.setEmail(rs.getString("UTENTE_EMAIL"));
			file.setPropostaTesiId(rs.getInt("PROPOSTATESI_ID"));
			file.setDescrizione(rs.getString("DESCRIZIONE"));
			file.setDescrizioneVoto(rs.getString("DESCRIZIONE_VOTO"));
			file.setVoto(rs.getInt("VOTO"));
			list.add(file);
		}
		prepared.close();
		rs.close();
		return list;
	}

	private Connection connection;
	private PreparedStatement prepared;
	private ResultSet rs;
	
}
