package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come studente la funzionalità di poter inviare all'utente registrato come docente una richiesta di tesi per una determinata proposta tesi.
 */
@WebServlet("/InviaPropostaTesiServlet")
public class InviaPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviaPropostaTesiServlet() {
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
	 * Invia al docente la richiesta di proposta tesi fatta dall'utente registrato come studente e passata come input al metodo.
	 * @param richiesta rappresenta la richesta per la proposta di tesi effettuata dall'utente registrato come studente.
	 * @return boolean true se l'invio è avvenuto con successo;
	 * <p>
	 * false se non è avvenuto con successo.
	 */
	private boolean inviaRichiestaPropostaTesi(PropostaTesi richiesta){
		return false;
		
	}
}
