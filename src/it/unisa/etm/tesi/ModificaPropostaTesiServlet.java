package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet e fornisce all'utente registrato come docente la funzionalità di poter modificare una propria proposta di tesi.
 */
@WebServlet("/ModificaPropostaTesiServlet")
public class ModificaPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPropostaTesiServlet() {
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
	 * Modifica la proposta di tesi selezionata dall'utente registrato come docente con i cambiamenti apportati da quest'ultimo.
	 * @param tesi rappresenta la proposta di tesi che il docene vuole modificare.
	 * @return PropostaTesi: se la modifica ha avuto successo allora torna la proposta di tesi modificata;
	 * <p>
	 * altrimenti torna null.
	 */
	private PropostaTesi modificaPropostaTesi(PropostaTesi tesi){
		return tesi;
		
	}

}
