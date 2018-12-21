package it.unisa.etm.autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import it.unisa.etm.model.manager.AutenticazioneManager;
import it.unisa.etm.model.manager.UtenteManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;



/**
 * Estende la classe HttpServlet e fonisce la funzionalit� di login.
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
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("passwordLogin");
		String email=request.getParameter("emailLogin");
		ManagerFactory em = new ManagerFactory();
		UtenteManager um = (UtenteManager) em.createUtenteManager();
		try {
			Utente utente=um.getUtente(email, password);
			if(utente!=null) {
				request.getSession().setAttribute("tipo", utente.getTipo()+"");
				response.sendRedirect(request.getContextPath()+"/homePage.jsp");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
	}

}
