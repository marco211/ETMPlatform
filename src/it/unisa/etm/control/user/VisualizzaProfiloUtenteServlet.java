package it.unisa.etm.control.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende la classe HttpServlet e fornisce all'utente la funzionalit� di poter visualizzare il proprio profilo.
 */
@WebServlet("/VisualizzaProfiloUtenteServlet")
public class VisualizzaProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaProfiloUtenteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=(String) request.getParameter("utente_email");
		Utente utente=(Utente) visualizzaProfiloUtente(email);
		request.setAttribute("toShow", utente);
		if(utente.getTipo().equals("d")) {
			ManagerFactory em = new ManagerFactory();
			PropostaTesiManager pt = (PropostaTesiManager) em.createPropostaTesiManager();
			ArrayList<PropostaTesi> proposte;
				proposte = pt.getProposteTesiDocente(email);
				request.setAttribute("proposte", proposte);
				request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);
		}else if(utente.getTipo().equals("s")&& utente.getPropostaTesi_ID()>0){
			ManagerFactory em = new ManagerFactory();
			PropostaTesiManager pt = (PropostaTesiManager) em.createPropostaTesiManager();
			PropostaTesi proposta;
				proposta = pt.getPropostaTesi(utente.getPropostaTesi_ID());
				request.setAttribute("proposta", proposta);
				request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);

		}else {
		request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Torna il profilo con lo username selezionato dall'utente.
	 * @param username strigna che rappresenta lo username dell'utente cercato.
	 * @return Utente l'utente cercato.
	 */

	private Utente visualizzaProfiloUtente(String email){
		ManagerFactory em=new ManagerFactory();
		UtenteManager um=(UtenteManager) em.createUtenteManager();
		
		return um.getInfo(email);
		
	}
	
}
