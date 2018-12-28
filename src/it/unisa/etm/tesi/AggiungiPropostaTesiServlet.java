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
			int count = (int) session.getAttribute("count2");
			if(count==0) { 
				ArrayList<Insegnamento> insegnamenti = this.getInsegnamenti();
				session.setAttribute("insegnamenti", insegnamenti);
				request.getRequestDispatcher("aggiungiPropostaTesi.jsp").forward(request, response);
				}
			else {			
				String titolo=request.getParameter("titolo");
				String ambito=request.getParameter("ambito");
				int tempo=Integer.parseInt(request.getParameter("tempo"));
				String descrizione= request.getParameter("descrizione");
				String materia=request.getParameter("materia");
				Utente utente = (Utente) session.getAttribute("utente");
				String utenteEmail = utente.getEmail();
				PropostaTesi tesi = new PropostaTesi(titolo, ambito, tempo, materia, descrizione, utenteEmail, false, false);
				count=0;
				session.setAttribute("count2", count);
				if(aggiungiPropostatesi(tesi))
				{
					session=request.getSession();
					session.setAttribute("tesi", tesi);
				}
				response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");
					}
			}}
	
	/**
	 * Aggiunge alla lista delle proposte di tesi, una nuova proposta creata dal docente.
	 * @param tesi rappresenta la proposta di tesi che il docente vuole aggiungere
	 * @return boolean true se l'aggiunta è avvenuta con successo;
	 * <p>
	 * false in caso contrario.
	 */
	private boolean aggiungiPropostatesi(PropostaTesi tesi){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		boolean b = false;
		try {
			b = ptm.inserisciPropostaTesi(tesi);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return b;	
	}

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
		try {
			insegnamenti = ptm.getInsegnamenti();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return insegnamenti;
	}
}
