package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come docente la funzionalità di comunicare ad un utente registrato come studente l'esito della richiesta di proposta di tesi-
 */
@WebServlet("/ComunicaEsitoServlet")
public class ComunicaEsitoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComunicaEsitoServlet() {
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
	 * Comunica allo studente la scelta presa dall'utente registrato come docente per la richiesta di proposta di tesi.
	 * @param richiesta proposta dall'utente registrato come studente per una determinata Proposta di tesi;
	 * @param scelta rappresenta la scelta del docente, true l'utente registrato come docente ha accettato;
	 * <p>
	 * false l'utente registrato come docente non ha accettato.
	 * @return boolean true richiesta approvata;
	 * <p>
	 * false richiesta non approvata.
	 */
	private boolean comunicaEsitoRichiestaPropostaTesi(PropostaTesi richiesta, boolean scelta){
		return false;
		
	}
}
