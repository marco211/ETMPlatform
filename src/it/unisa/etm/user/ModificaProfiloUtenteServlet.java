package it.unisa.etm.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;

import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende la casse HttpServlet e fornisce all'utente la funzionalità di poter modificare il proprio profilo.
 */
@WebServlet("/ModificaProfiloUtenteServlet")
public class ModificaProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaProfiloUtenteServlet() {
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
		String email=request.getParameter("email");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String password=request.getParameter("password");
		String data=request.getParameter("data");
		String tipo=request.getParameter("tipo");
		String validazione=request.getParameter("validazione");
		Utente utente= null;
		if(tipo.equals("s")){

			long matricola=Long.parseLong(request.getParameter("matricola"));
			utente=new Utente(cognome, data, nome, tipo, email, password, matricola, validazione);

		}else{

			String insegnamento=request.getParameter("insegnamento").toLowerCase();
			String ufficio=request.getParameter("ufficio");
			utente=new Utente(cognome, data, ufficio, tipo, nome, email, password, insegnamento, validazione);
		}
		if(modificaProfiloUtente(utente) == true) {
			response.sendRedirect(request.getContextPath()+"/homePage.jsp");
		}else{			
			response.sendRedirect(request.getContextPath()+"/registrazioneFallita.jsp");					
		}

	}
	/**
	 * Riceve le modifiche effettuate dall'utente e le appliche al profilo di quest'ultimo.
	 * @param utente rappresenta il profilo modificato dall'utente
	 * @return boolean true se le modifiche sono andate a buon fine;
	 * <p>
	 * false in caso contrario.
	 */

	private boolean modificaProfiloUtente(Utente utente){
		ManagerFactory mf=new ManagerFactory();
		UtenteManager um=(UtenteManager) mf.createUtenteManager();
		try {
			um.modificaUtente(utente);
			System.out.println("CiaoneProprio!!!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Addio!!!");
			return false;
		}
		return true;

	}

}
