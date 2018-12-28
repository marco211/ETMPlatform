package it.unisa.etm.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

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
 * Estende la casse HttpServlet e fornisce all'utente la funzionalitą di poter modificare il proprio profilo.
 */
@WebServlet("/ModificaProfiloUtenteServlet")
public class ModificaProfiloUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaProfiloUtenteServlet() {
		super();
		log = Logger.getLogger("global");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Utente utente = (Utente) request.getSession().getAttribute("utente");
				
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		log.info(utente.getNome());
		if(utente.getTipo().equals("s")) utente.setMatricola(Long.parseLong(request.getParameter("matricola")));
		else {

			utente.setInsegnamento(request.getParameter("insegnamento").toLowerCase());
			utente.setUfficio(request.getParameter("ufficio"));
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
		return um.modificaUtente(utente);

	}
	
	private Logger log;

}
