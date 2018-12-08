package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come docente la funzionalità di poter chiudere una propria proposta di tesi.
 */
@WebServlet("/ChiudiPropostaTesiServlet")
public class ChiudiPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiudiPropostaTesiServlet() {
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
	 * Chiude la proposta di tesi presa in input ritornado.
	 * @param tesi rappresenta la proposta di tesi che si vuole chiusere;
	 * @return boolean true se la proposta è stata chiusa con successo;
	 * <p>
	 * false se la proposta non è stata chiusa.
	 */
	private boolean chiudiPropostaTesi(PropostaTesi tesi){
		return false;
		
	}
}
