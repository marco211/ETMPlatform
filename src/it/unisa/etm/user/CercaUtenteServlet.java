package it.unisa.etm.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Utente;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	private Utente cercaUtente(String username){
		return null;
		
	}

}
