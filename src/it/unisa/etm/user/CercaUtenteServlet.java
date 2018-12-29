package it.unisa.etm.user;

import java.io.IOException;
import java.util.ArrayList;
import it.unisa.etm.model.manager.UtenteManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;

/**
 * Estende la classe HttpServlet e fornisce ad un utente la funzionalità di poter cercare un altro utente.
 */
@WebServlet("/CercaUtenteServlet")
public class CercaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("cerca");
		ManagerFactory em = new ManagerFactory();
		UtenteManager um = (UtenteManager) em.createUtenteManager();
		ArrayList<Utente> utenti= (ArrayList<Utente>) um.cercaUtente(email);
			request.getSession().setAttribute("utente", utenti);
		RequestDispatcher view=getServletContext().getRequestDispatcher("/visualizzaListaUtenti.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Torna all'utente (che cerca) il profilo dell'utente cercato tramite lo username digitato.
	 * @param username stringa che rappresenta lo username digitato dall'utente per la ricerca.
	 * @return Utente che rappresenta l'utente cercato, altrimenti null qualora questo non esistesse.
	 */
	private ArrayList<Utente> cercaUtente(String email){
		
		return null;	
		
	}

}
