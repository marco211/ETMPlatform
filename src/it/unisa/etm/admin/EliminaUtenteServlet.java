package it.unisa.etm.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.model.manager.AmministratoreManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.Utente;
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
		synchronized(session){
			Utente utente=new Utente();
			AmministratoreManager am=new AmministratoreManager();
			String email=(String) request.getAttribute("utente_email");
			ArrayList<Utente> utenti=new ArrayList<Utente>();
			try {
				utenti = (ArrayList<Utente>) am.getListaUtenti();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i=0;i<utenti.size();i++) {
				if(utenti.get(i).getEmail().equalsIgnoreCase(email))
					utente=utenti.get(i);
			}
			try {
				if(this.eliminaUtente(utente)){
					request.getRequestDispatcher("visualizzaListaUtenti.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
	@SuppressWarnings("unused")
	private boolean eliminaUtente(Utente utente) throws SQLException{
		ManagerFactory mf=new ManagerFactory();
		AmministratoreManager am= (AmministratoreManager) mf.createAmministratoreManager();
		try {
			am.eliminaUtente(utente.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

