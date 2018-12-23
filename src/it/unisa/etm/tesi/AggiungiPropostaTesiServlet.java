package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;

import it.unisa.etm.model.manager.PropostaTesiManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;

/**
 * Estende la classe HttpServlet e fonisce all'utente registrato come docente la possibilità di aggiungere una nuova proposta di tesi.
 */
@WebServlet("/AggiungiPropostaTesiServlet")
public class AggiungiPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiPropostaTesiServlet() {
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
		String titolo=request.getParameter("titolo");
		String ambito=request.getParameter("ambito");
		int tempo=Integer.parseInt(request.getParameter("tempo"));
		String descrizione= request.getParameter("descrizione");
		String materia=request.getParameter("materia");
		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("utente");
		String utenteEmail = utente.getEmail();
		PropostaTesi tesi = new PropostaTesi(titolo, ambito, tempo, materia, descrizione, utenteEmail, false, false);
		if(aggiungiPropostatesi(tesi))
		{
			session=request.getSession();
			session.setAttribute("tesi", tesi);
		}
		response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");
	}
	
	/**
	 * Aggiunge alla lista delle proposte di tesi, una nuova proposta creata dal docente.
	 * @param tesi rappresenta la proposta di tesi che il docente vuole aggiungere
	 * @return boolean true se l'aggiunta è avvenuta con successo;
	 * <p>
	 * false in caso contrario.
	 */
	private boolean aggiungiPropostatesi(PropostaTesi tesi){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		try {
			ptm.inserisciPropostaTesi(tesi);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}

}
