package it.unisa.etm.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AreaCondivisaManager;

/**
 * Estende HttpServlet fornisce all'amministratore la funzionalità di visualizzare gli utenti registrati.
 */
@WebServlet("/ListaUtentiServlet")
public class ListaUtentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUtentiServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Torna la lista di tutti gli utenti registrati 
	 * @return lista di utenti registrati
	 * <p>
	 * null se non vi sono utenti registrati
	 */
	private List<Utente> getListaUtenti(){

		return null;
	}
}
