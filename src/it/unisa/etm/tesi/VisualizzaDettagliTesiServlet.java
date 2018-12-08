package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet ed offre all'utente la possibilità di visualizzare i dettagli di una determinata proposta di tesi.
 */
@WebServlet("/VisualizzaDettagliTesiServlet")
public class VisualizzaDettagliTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDettagliTesiServlet() {
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
	 * Torna i dettagli di una determinata PropostaTesi presa come input.
	 * @param tesi oggetto della classe PropostaTesi, che rappresenta la tesi scelta per conoscere le info.
	 * @return String con i dettagli della proposta di tesi presa come input;
	 * <p>
	 * null se non vi sono dettagli della proposta di tesi.
	 */
	private String visualizzaDettagliPropostaTesi(PropostaTesi tesi){
		return null;
		
	}
}
