package it.unisa.etm.control.areacondivisa;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;
import it.unisa.etm.model.manager.FileManager;

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
		ManagerFactory em=new ManagerFactory();
		FileManager um=(FileManager) em.createFileManager();
		LocalDate data=LocalDate.now();
		Utente utente=(Utente) request.getSession().getAttribute("utente");
		Attivita attivita=new Attivita(utente.getEmail(), nomeFile, data ,"e",id);
		AttivitaManager am=(AttivitaManager) em.createAttivitaManager();
			am.aggiungiAttivita(attivita);
			um.eliminaFile(id, nomeFile);
		
		RequestDispatcher view=getServletContext().getRequestDispatcher("/homePage.jsp");
		view.forward(request, response);
	}

}
