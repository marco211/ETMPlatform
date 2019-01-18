package it.unisa.etm.control.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come docente la funzionalita di poter chiudere una propria proposta di tesi.
 */
@WebServlet("/ChiudiPropostaTesiServlet")
public class ChiudiPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiudiPropostaTesiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propostatesi_id=Integer.parseInt(request.getParameter("propostatesi_id"));
		if(this.chiudiPropostaTesi(propostatesi_id)) {
			response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Chiude la proposta di tesi presa in input ritornado.
	 * @param propostatesi_id rappresenta l'identificativo della proposta di tesi che si vuole chiusere;
	 * @return boolean true se la proposta e stata chiusa con successo;
	 * <p>
	 * false se la proposta non e stata chiusa.
	 */
	private boolean chiudiPropostaTesi(int propostatesi_id) {
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		return ptm.chiudiPropostaTesi(propostatesi_id);		
	}
	
}
