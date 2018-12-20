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
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende HttpServlet fornisce la funzionalità di caricare un file nell'area privata condivisa.
 */
@WebServlet("/CaricaFileServlet")
public class CaricaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaricaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File();
		boolean uploaded = uploadFileControl(file);
	}

	/**
	 * Aggiunge un file all'area privata condivisa
	 * @param file caricato dall'utente 
	 * @return boolean true se il caricamento è avvenuto con successo;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean uploadFileControl(File file){
		ManagerFactory mf=new ManagerFactory();
		AreaCondivisaManager fm= (AreaCondivisaManager) mf.createAreaCondivisaManager();

		return true;
	}
}
