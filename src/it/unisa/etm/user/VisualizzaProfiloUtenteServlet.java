package it.unisa.etm.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
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
			try {
				proposte = pt.getProposteTesiDocente(email);
				request.setAttribute("proposte", proposte);
				request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		Utente utente;
		try {
			utente=um.getInfo(email);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return utente;	
	}
	
}
