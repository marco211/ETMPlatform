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
	
    public VisualizzaProfiloUtenteServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=(String) request.getParameter("utente_email");
		Utente utenteEmail=(Utente) visualizzaProfiloUtente(email);
		HttpSession session=request.getSession();
		session.setAttribute("utenteemail", utenteEmail);
		System.out.println("VisualizzaProfiloUtente: sessione settata");
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
	@SuppressWarnings("unused")
	private Utente visualizzaProfiloUtente(String email){
	ManagerFactory em = new ManagerFactory();
	UtenteManager um = (UtenteManager) em.createUtenteManager();
	Utente utente=null;
	try {
		utente=um.getInfo(email);
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	return utente;	
}
}
