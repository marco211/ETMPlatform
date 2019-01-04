package it.unisa.etm.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende la casse HttpServlet e fornisce all'utente la funzionalit� di poter modificare il proprio profilo.
 */
@WebServlet("/ModificaProfiloUtenteServlet")
public class ModificaProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaProfiloUtenteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Utente utente=(Utente) request.getSession().getAttribute("utente");
		if(utente.getTipo().equals("s")) 
			utente.setMatricola(Long.parseLong(request.getParameter("matricola")));
		else {
			utente.setUfficio(request.getParameter("ufficio"));
		}
		if(modificaProfiloUtente(utente)==true) {
			response.sendRedirect(request.getContextPath()+"/homePage.jsp");
		} else {			
			response.sendRedirect(request.getContextPath()+"/registrazioneFallita.jsp");					
		}
	}
	/**
	 * Riceve le modifiche effettuate dall'utente e le appliche al profilo di quest'ultimo.
	 * @param utente rappresenta il profilo modificato dall'utente
	 * @return boolean true se le modifiche sono andate a buon fine;
	 * <p>
	 * false in caso contrario.
	 */

	private boolean modificaProfiloUtente(Utente utente){
		ManagerFactory mf=new ManagerFactory();
		UtenteManager um=(UtenteManager) mf.createUtenteManager();
		return um.modificaUtente(utente);
	}
	
}
