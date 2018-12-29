package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.etm.model.manager.PropostaTesiManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.Insegnamento;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;

/**
 * Estende la classe HttpServlet e fonisce all'utente registrato come docente la possibilità di aggiungere una nuova proposta di tesi.
 */
@WebServlet("/AggiungiPropostaTesiServlet")
public class AggiungiPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiPropostaTesiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {	
				ArrayList<Insegnamento> insegnamenti = this.getInsegnamenti();
				session.setAttribute("insegnamenti", insegnamenti);
				request.getRequestDispatcher("aggiungiPropostaTesi.jsp").forward(request, response);	
				
			}}
	

	/**
	 *	ritorna la lista degli insegnamenti dei docenti
	 * @param 
	 * @return lista degli insegnamenti
	 * <p>
	 * null in caso di errore o che non sono prensenti insegnamenti.
	 */
	private ArrayList<Insegnamento> getInsegnamenti(){
		ManagerFactory mf = new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		ArrayList<Insegnamento> insegnamenti = new ArrayList<Insegnamento>();
			insegnamenti = ptm.getInsegnamenti();
		return insegnamenti;
	}
}
