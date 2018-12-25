package it.unisa.etm.admin;

import java.io.IOException;
import java.sql.SQLException;

import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.PropostaTesiManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.factory.ManagerFactory;

/**
 * Estende HttpServlet fornisce all'amministratore la possibilità di eliminare un utente.
 */
@WebServlet("/EliminaUtenteServlet")
public class EliminaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**;
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized(session) {
			String email = (String )request.getParameter("utente_email");
			System.out.println("sono arrivato alla sessione");
			try {
				if(this.eliminaUtente(email)) {
					System.out.println("ci arrivo?");
					response.sendRedirect(request.getContextPath()+"/ListaUtentiServlet");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Accede all'elenco di utenti ed elimina l'utente preso in input;
	 * Il metodo ritorna un booleano.
	 * @param utente da cercare
	 * @return boolean: true se l'eliminazione viene eliminata con successo;
	 * 					false se l'eliminazione non è andata a buon fine;
	 * @throws SQLException 
	 */

	private boolean eliminaUtente(String email) throws SQLException{
		ManagerFactory mf=new ManagerFactory();
		AmministratoreManager am=(AmministratoreManager) mf.createAmministratoreManager();
		boolean b = false;
		try {
			b = am.eliminaUtente(email);
			System.out.println("ho provato a fare il metodo nel manager");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}

}

