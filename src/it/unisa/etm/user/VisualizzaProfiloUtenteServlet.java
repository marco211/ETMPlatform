package it.unisa.etm.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende la classe HttpServlet e fornisce all'utente la funzionalità di poter visualizzare il proprio profilo.
 */
@WebServlet("/VisualizzaProfiloUtenteServlet")
public class VisualizzaProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaProfiloUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= (request.getParameter("email"));
		String password= (request.getParameter("password"));
		Utente utente= (Utente) getUtente(email,password);
		
		HttpSession session=request.getSession();
		session.setAttribute("utente", utente);
		request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Torna il profilo con lo username selezionato dall'utente.
	 * @param username strigna che rappresenta lo username dell'utente cercato.
	 * @return Utente l'utente cercato.
	 */
	private Utente getUtente(String email, String password){
	ManagerFactory em = new ManagerFactory();
	UtenteManager um = (UtenteManager) em.createUtenteManager();
	Utente utente;
	try {
		utente=um.getUtente(email , password);
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	return utente;	
}
}
