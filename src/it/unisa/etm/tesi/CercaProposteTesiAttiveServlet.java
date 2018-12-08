package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet e fornisce all'utente la funzionalità di poter cercare proposte tesi.
 */
@WebServlet("/CercaProposteTesiAttiveServlet")
public class CercaProposteTesiAttiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaProposteTesiAttiveServlet() {
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
	 * Torna all'utente la proposta tesi cercata accettando come input il titolo digitato
	 * @param titolo rappresenta il titolo della proposta tesi digitato dall'utente.
	 * @return PropostaTesi null se la proposta tesi cercata non c'è;
	 * <p>
	 * altrimenti ritorna la proposta tesi cercata.
	 */
	private PropostaTesi ricercaPropostaTesi(String titolo){
		return null;
		
	}

}
