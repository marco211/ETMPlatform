package it.unisa.etm.autenticazione;

import java.io.IOException;

import it.unisa.etm.model.manager.AutenticazioneManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.Amministratore;
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
		AutenticazioneManager am = (AutenticazioneManager) em.createAutenticazioneManager();
		Amministratore admin=am.getAdmin(email, password);
		if(admin!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			System.out.print("admin preso: "+email+" "+password);
			response.sendRedirect(request.getContextPath()+"/homePageAdmin.jsp");
		}
		else {
			Utente utente=am.getUtente(email, password);
			if(utente!=null) {
				if(utente.getValidazione().equals("valido")) {
					HttpSession session=request.getSession();
					session.setAttribute("utente", utente);
					response.sendRedirect(request.getContextPath()+"/homePage.jsp");
				}
				else {
					response.sendRedirect(request.getContextPath()+"/loginFallitoRegistrazioneNonConfermata.jsp");
				}				
			}
			else {
				response.sendRedirect(request.getContextPath()+"/loginFallitoAccountInesistente.jsp");
			}
		}			
	}
}
