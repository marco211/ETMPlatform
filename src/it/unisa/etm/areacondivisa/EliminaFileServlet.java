package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.File;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AreaCondivisaManager;
import it.unisa.etm.model.manager.FileManager;
import it.unisa.etm.model.manager.PartecipaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Estende HttpServlet e fornisce all'utente la funzionalit� di poter eliminare un file dall'area privata condivisa.
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idTesi"));
		String nomeFile=request.getParameter("nomeFile");
		ManagerFactory em = new ManagerFactory();
		FileManager um = (FileManager) em.createFileManager();
		try {
			um.eliminaFile(id, nomeFile);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view=getServletContext().getRequestDispatcher("/homePage.jsp");
		view.forward(request, response);
	}

	/**
	 * Fornisce la funzionalit� di elimiazione di un file dall'area privata condivisa
	 * @param file presente nell'area privata condivisa
	 * @return boolean true se l'elimiazione � terminata con successo;
	 * <p>
	 * false se non � andata a buon fine.
	 */
	private boolean deleteFile(File file){
		ManagerFactory mf=new ManagerFactory();
		AreaCondivisaManager fm= (AreaCondivisaManager) mf.createAreaCondivisaManager();

		return true;
		
	}
}
