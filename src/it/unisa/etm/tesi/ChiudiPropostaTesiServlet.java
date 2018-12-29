package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come docente la funzionalità di poter chiudere una propria proposta di tesi.
 */
@WebServlet("/ChiudiPropostaTesiServlet")
public class ChiudiPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiudiPropostaTesiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized(session) {
			int propostatesi_id = Integer.parseInt(request.getParameter("propostatesi_id"));
			Utente utente = (Utente) session.getAttribute("utente");
			if(this.chiudiPropostaTesi(propostatesi_id)) {
				response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");			}
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Chiude la proposta di tesi presa in input ritornado.
	 * @param propostatesi_id rappresenta l'identificativo della proposta di tesi che si vuole chiusere;
	 * @return boolean true se la proposta è stata chiusa con successo;
	 * <p>
	 * false se la proposta non è stata chiusa.
	 */
	private boolean chiudiPropostaTesi(int propostatesi_id){ //cambiato come in archiva con l'id in precedenza in iput c'era la proposta
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		boolean b = false;
			b = ptm.chiudiPropostaTesi(propostatesi_id);
		return b;
		
	}
}
