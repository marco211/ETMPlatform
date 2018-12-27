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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Utente utente=(Utente) session.getAttribute("utente");
		String email= utente.getEmail();
		String tipo= utente.getTipo();
		String validazione=utente.getValidazione();
		String password=utente.getPassword();
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String data=request.getParameter("data_nascita");
		System.out.println("Sono dentro?");
			if(tipo.equals("s")){
						long matricola=Long.parseLong(request.getParameter("matricola"));
						utente=new Utente(email, nome, cognome, password, data, tipo, matricola, validazione);
						System.out.println("Qui Ci sono Arrivato?");
						
						 }else{
							String insegnamento=request.getParameter("insegnamento").toLowerCase();
							String ufficio=request.getParameter("ufficio");
							utente= new Utente(email, nome, cognome, password, data, tipo, ufficio, insegnamento, validazione);
							   }
								if(this.modificaProfiloUtente(utente))
									{
										session=request.getSession();
										session.setAttribute("utente", utente);
									}
								response.sendRedirect(request.getContextPath()+"/homePage.jsp");
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
