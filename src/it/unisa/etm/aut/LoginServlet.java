package it.unisa.etm.aut;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Utente;



/**
 * Estende la classe HttpServlet e fonisce la funzionalità di login.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		login(email, password);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Permette il login
	 * @param email dell'utente che vuole effettuare il login;
	 * @param password dell'utente che vuole effettuare il login;
	 * @return L'Utente registrato se il login è andato a buon fine;
	 * <p>
	 * null se il login è fallito.
	 */
	private Utente login(String email, String password){
		return Utente.loginUtente(email, password);
	}
}
