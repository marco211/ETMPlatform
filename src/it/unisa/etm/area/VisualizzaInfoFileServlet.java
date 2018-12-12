package it.unisa.etm.area;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.File;

/**
 * Estende HttpServlet e fornisce all'utente la funzionalità di visualizzare le informazioni di un file presente nell'area privata condivisa
 */
@WebServlet("/VisualizzaInfoFileServlet")
public class VisualizzaInfoFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaInfoFileServlet() {
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
	 * Prende in input un file dell'area privata condivisa e ne torna le informazioni
	 * @param nome stringa che rappresenza il nome del file;
	 * @return un oggetto file il cui nome è quello passato come parametro.
	 */
	private File getInfo(String nome){
		return null;
		
	}
}
