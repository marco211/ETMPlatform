package it.unisa.etm.tesi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende HttpServlet ed offre all'utente la funzionalità di poter visualizzare le proposte tesi attive.
 */
@WebServlet("/ProposteTesiAttiveServlet")
public class ProposteTesiAttiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProposteTesiAttiveServlet() {
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
	 * Torna all'utente registato le proposte tesi attive.
	 * @return Lista di proposte tesi attive che assume il valore null qualora non vi fossero tesi attive in quel momento.
	 */
	private List<PropostaTesi> visualizzaPropostaTesiAttive(){
		return null;
		
	}
}
