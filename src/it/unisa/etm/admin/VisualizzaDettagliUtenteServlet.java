package it.unisa.etm.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;

@WebServlet("/VisualizzaDettagliUtenteServlet")
public class VisualizzaDettagliUtenteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public VisualizzaDettagliUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=(String) request.getParameter("utente_email");
		Utente utenteEmail=(Utente) visualizzaDettagliUtente(email);		
		HttpSession session=request.getSession();
		session.setAttribute("utenteemail", utenteEmail);
		request.getRequestDispatcher("visualizzaDettagliUtente.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Utente visualizzaDettagliUtente(String email){
		ManagerFactory em=new ManagerFactory();
		AmministratoreManager am=(AmministratoreManager) em.createAmministratoreManager();
		Utente utente=null;
		try {
			utente=am.getUtente(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return utente;	
	}
	
}
