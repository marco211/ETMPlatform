package it.unisa.etm.model.manager;

import java.sql.SQLException;
import java.util.List;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.database.DatabaseManager;
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;

public class PropostaTesiManager implements PropostaTesiModelInterface {

	public PropostaTesiManager() {
		
	}


	
	@Override
	public boolean inserisciRichiestaPropostaTesi(String titoloProposta, String emailUtente) throws SQLException{
		DatabaseManager.getIstance();
		return false;
	}
	@Override
	public boolean inserisciPropostaTesi(PropostaTesi p) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean archiviaPropostaTesi(String titoloProposta) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public PropostaTesi getPropostaTesi(String titolo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean chiudiPropostaTesi(String titoloProposta) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean rimuoviPropostaTesi(String titoloProposta) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<PropostaTesi> getProposteTesiAttive() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Attivita> getStoricoAttivita(String titoloProposta) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
