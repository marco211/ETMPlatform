package it.unisa.etm.area;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.File;

/**
 * Estende HttpServlet e fornisce all'utente la funzionalità di poter eliminare un file dall'area privata condivisa.
 */
@WebServlet("/EliminaFileServlet")
public class EliminaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaFileServlet() {
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
	 * Fornisce la funzionalità di elimiazione di un file dall'area privata condivisa
	 * @param file presente nell'area privata condivisa
	 * @return boolean true se l'elimiazione è terminata con successo;
	 * <p>
	 * false se non è andata a buon fine.
	 */
	private boolean deleteFileBean(File file){
		return false;
		
	}
}
