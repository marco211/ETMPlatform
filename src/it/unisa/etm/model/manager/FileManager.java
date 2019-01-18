package it.unisa.etm.model.manager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.model.bean.File;
import it.unisa.etm.model.database.DatabaseManager;
import it.unisa.etm.model.interfaces.FileModelInterface;
/**
 * Classe che implementa le funzionalita dedicate ai file di un'area privata condivisa.
 * @author ETM
 *
 */
public class FileManager implements FileModelInterface {
	public FileManager() {

	}

	@Override
	public boolean aggiungiFile(File c){
	
			try {
				connection=DatabaseManager.getIstance();
				prepared=connection.prepareStatement("INSERT INTO FILE (NOME,PROPOSTATESI_ID,FILE,DESCRIZIONE,UTENTE_EMAIL) VALUES (?,?,?,?,?)");
				int i=c.getNome().indexOf(".");
				if(i+1==c.getNome().length()) {
					return false;
				}
				prepared.setString(1, c.getNome());
				prepared.setInt(2, c.getPropostaTesiId());
				InputStream stream=c.getFilePart().getInputStream();
				if (stream != null) 
	            {
	                prepared.setBinaryStream(3, stream, (int) c.getFilePart().getSize());
	            }
				prepared.setString(4, c.getDescrizione());
				prepared.setString(5, c.getEmail());
				prepared.executeUpdate();	
				prepared.close();
			} catch (SQLException e) {
				return false;
			} catch (IOException e) {
				return false;
			} 
		return true;
	}

	@Override
	public boolean modificaFile(int idTesi, String nomeFile, int voto, String descrizioneVoto) {
		File file=this.getFile(idTesi, nomeFile);
		if(file==null)
			return false;
		
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement("UPDATE FILE SET Voto=?,Descrizione_Voto=?  Where Nome=? AND PropostaTesi_Id=?");
			prepared.setInt(1, voto);
			prepared.setString(2, descrizioneVoto);
			prepared.setString(3, nomeFile);
			prepared.setInt(4, idTesi);
			prepared.executeUpdate();	
			prepared.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean eliminaFile(int idTesi, String nomeFile) {
		File file=this.getFile(idTesi, nomeFile);
		if(file==null)
			return false;
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement("DELETE FROM FILE Where Nome=? AND PropostaTesi_Id=?");
			prepared.setString(1, nomeFile);
			prepared.setInt(2, idTesi);
			prepared.executeUpdate();	
			prepared.close();
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	@Override
	public File getFile(int id, String nomeFile){
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement("SELECT * FROM FILE WHERE PROPOSTATESI_ID=? AND NOME=?");
			prepared.setInt(1, id);
			prepared.setString(2, nomeFile);
			rs=prepared.executeQuery();
			rs.next();
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
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public File scaricaFile(int idTesi, String nomeFile){
		File file=this.getFile(idTesi, nomeFile);
		if(file==null)
			return null;
		
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement("SELECT * FROM FILE WHERE NOME=? AND PROPOSTATESI_ID=?");
			prepared.setString(1, nomeFile);
			prepared.setInt(2, idTesi);
			rs=prepared.executeQuery();
			File f=new File();
			if (rs.next()) {
	            // gets file name and file blob data
	            String fileName = rs.getString("NOME");
	            Blob blob=rs.getBlob("FILE");
	            InputStream stream = blob.getBinaryStream();
	            f.setNome(fileName);
	            f.setInputStream(stream);
			}         
			return f;
		} catch (SQLException e) {
			return null;
		}
	}
	

	@Override
	public ArrayList<File> getListaFile(int idTesi){
		if(idTesi < 0)
			return null;
		
		String sql="SELECT * FROM FILE WHERE PROPOSTATESI_ID=?";
		try {
			connection=DatabaseManager.getIstance();
			prepared=connection.prepareStatement(sql);
			prepared.setInt(1, idTesi);
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
		} catch (SQLException e) {
			return null;
		}
		
		
	}
	
	private Connection connection;
	private PreparedStatement prepared;
	private ResultSet rs;

}
