package it.unisa.etm.model.interfaces;

import java.sql.SQLException;
import it.unisa.etm.bean.Ha;

public interface HaModelInterface {
	public void addHa (Ha ha) throws SQLException;
	public void modificaStato(String utenteEmail, int consegnaId, boolean stato) throws SQLException;
}
