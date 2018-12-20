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
 * Estende HttpServlet e fornisce all'utente la funzionalità di poter scaricare un file presente nell'area privata condivisa.
 */
@WebServlet("/ScaricaFileServlet")
public class ScaricaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScaricaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File();
		boolean deleted = scaricaFile(file);
	}

	/**
	 * Permette il download di un file preso in input.
	 * @param file da scaricare
	 * @return boolean true se il download è avvenuto con successo;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean scaricaFile(File file){
		ManagerFactory mf=new ManagerFactory();
		AreaCondivisaManager fm= (AreaCondivisaManager) mf.createAreaCondivisaManager();

		return true;
		
	}
}
