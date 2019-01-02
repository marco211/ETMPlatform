package it.unisa.etm.user;

import java.io.IOException;
import it.unisa.etm.model.manager.UtenteManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Utente;

/**
 * Estende la classe HttpServlet e fornisce ad un utente la funzionalit� di poter cercare un altro utente.
 */
@WebServlet("/CercaUtenteServlet")
public class CercaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaUtenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("cerca");
		System.out.println(email);
		try{
			UtenteManager um=new UtenteManager();
			Utente utenti=(Utente) um.cercaUtente(email);
			request.setAttribute("utenti", utenti);
			request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);
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
