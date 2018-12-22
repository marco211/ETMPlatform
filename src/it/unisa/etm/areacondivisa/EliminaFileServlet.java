package it.unisa.etm.areacondivisa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.File;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AreaCondivisaManager;

/**
 * Estende HttpServlet e fornisce all'utente la funzionalità di poter eliminare un file dall'area privata condivisa.
 */
@WebServlet("/EliminaFileServlet")
public class EliminaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File();
		boolean deleted = deleteFile(file);
	}

	/**
	 * Fornisce la funzionalità di elimiazione di un file dall'area privata condivisa
	 * @param file presente nell'area privata condivisa
	 * @return boolean true se l'elimiazione è terminata con successo;
	 * <p>
	 * false se non è andata a buon fine.
	 */
	private boolean deleteFile(File file){
		ManagerFactory mf=new ManagerFactory();
		AreaCondivisaManager fm= (AreaCondivisaManager) mf.createAreaCondivisaManager();

		return true;
		
	}
}
