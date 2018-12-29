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
 * Servlet implementation class ConfermaModificaPropostaTesiServlet
 */
@WebServlet("/ConfermaModificaPropostaTesiServlet")
public class ConfermaModificaPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfermaModificaPropostaTesiServlet() {
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
		HttpSession session = request.getSession();
		synchronized(session) {
			PropostaTesi p = new PropostaTesi();
			int id = (int) session.getAttribute("proposta_tesi_id");
			String titolo=request.getParameter("titolo");
			String ambito=request.getParameter("ambito");
			int tempo=Integer.parseInt(request.getParameter("tempo"));
			String descrizione= request.getParameter("descrizione");
			String materia=request.getParameter("materia");
			Utente utente = (Utente) session.getAttribute("utente");
			String utenteEmail = utente.getEmail();
			PropostaTesi tesi = new PropostaTesi(titolo, ambito, tempo, materia, descrizione, utenteEmail, false, false);
			tesi.setId(id);
			if(this.modificaPropostaTesi(tesi))
			{
				session=request.getSession();
				session.setAttribute("tesi", tesi);
			}
			response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");
				
		}
	}

	/**
	 * Modifica la proposta di tesi selezionata dall'utente registrato come docente con i cambiamenti apportati da quest'ultimo.
	 * @param tesi rappresenta la proposta di tesi che il docene vuole modificare.
	 * @return boolean: se la modifica ha avuto successo allora torna true;
	 * <p>
	 * altrimenti torna false.
	 */
	private boolean modificaPropostaTesi(PropostaTesi tesi){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
			ptm.modificaPropostaTesi(tesi);
		return true;	
	}
}
