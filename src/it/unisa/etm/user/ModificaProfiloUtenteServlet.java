package it.unisa.etm.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.Utente;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Riceve le modifiche effettuate dall'utente e le appliche al profilo di quest'ultimo.
	 * @param utente rappresenta il profilo modificato dall'utente
	 * @return boolean true se le modifiche sono andate a buon fine;
	 * <p>
	 * false in caso contrario.
	 */
	private boolean modificaProfiloUtente(Utente utente){
		return false;
		
	}

}
