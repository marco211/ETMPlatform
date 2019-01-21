package it.unisa.etm.control.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;
/**
 * Estende a classe HttpServlet e fornisce all'utente la funzionalita di poter modificare la password precedente.
 */
@WebServlet("/ModificaPasswordServlet")
public class ModificaPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPasswordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente) request.getSession().getAttribute("utente");	
		String pass = request.getParameter("password2");
		String nuova = request.getParameter("password");
		if(modificaPasswordUtente(utente, pass, nuova) == true) {
			response.sendRedirect(request.getContextPath()+"/homePage.jsp");
		} else {			
			response.sendRedirect(request.getContextPath()+"/cambiaPasswordFail.jsp");					
		} 
	}

	/**
	 * Modifica la password precedentemente settata con quella nuova digitata dall'utente.
	 * @param utente oggetto utente per il quale si deve modificare la passowrd
	 * @param pass stringa che rappresenta la password digitata dall'utente per la conferma
	 * @param stringa che rappresenta la password digitata dall'utente la prima volta
	 * @returnboolean true se la modifica e andata a buon fine;
	 * <p>
	 * false in caso contrario
	 */
	private boolean modificaPasswordUtente(Utente utente, String pass, String nuova){
		if(nuova.equals(pass)) {
			ManagerFactory mf=new ManagerFactory();
			UtenteManager um=(UtenteManager) mf.createUtenteManager();
			utente.setPassword(nuova);
			return um.modificaPassword(utente);
		}
		return false;
	}
}

