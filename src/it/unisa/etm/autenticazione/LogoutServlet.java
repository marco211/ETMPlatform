package it.unisa.etm.autenticazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import it.unisa.etm.bean.Utente;

/**
 * Offre la funzionalit� di poter effettuare il logout
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
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
		HttpSession session=request.getSession();
		session.invalidate(); 
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * Effettua il logout di un determinato utente.
	 * @param utente che vuole effettuare il logout (oggetto della classe Utente)
	 * @return boolean true se il logout � avvenuto con successo;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean logout(){
		return true;
	}

}
