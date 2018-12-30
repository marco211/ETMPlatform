package it.unisa.etm.admin;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.manager.AmministratoreManager;

/**
 * Estende HttpServlet fornisce all'amministratore la funzionalit� di visualizzare gli utenti registrati.
 */
@WebServlet("/ListaUtentiServlet")
public class ListaUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUtentiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			AmministratoreManager am= new AmministratoreManager();
			ArrayList<Utente> utenti= (ArrayList<Utente>) am.getListaUtenti();
			request.setAttribute("utenti", utenti);
			request.getRequestDispatcher("visualizzaListaUtenti.jsp").forward(request, response);
		}catch(Exception e) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
