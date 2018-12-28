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
 * Estende la classe HttpServlet e fornisce all'utente registrato come docente la possibilitÓ di aggiungere una nuova proposta di tesi.
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			int count = (int) session.getAttribute("count");
			PropostaTesi p = new PropostaTesi();
			if(count==0) { 
				ArrayList<Insegnamento> insegnamenti = this.getInsegnamenti();
				p.setTitolo(request.getParameter("propostatesi_titolo"));
				p.setAmbito(request.getParameter("propostatesi_ambito"));
				p.setTempoDiSviluppo(Integer.parseInt(request.getParameter("propostatesi_tempo")));
				p.setDecrizione(request.getParameter("propostatesi_descrizione"));
				p.setMaterie(request.getParameter("propostatesi_materia"));
				session.setAttribute("propostacorrente", p);
				int id= Integer.parseInt(request.getParameter("propostatesi_id"));
				session.setAttribute("proposta_tesi_id", id);
				session.setAttribute("insegnamenti", insegnamenti);
				request.getRequestDispatcher("modificaPropostaTesi.jsp").forward(request, response);
				}
			else {
				int id = (int) session.getAttribute("proposta_tesi_id");
				String titolo=request.getParameter("titolo");
				String ambito=request.getParameter("ambito");
				int tempo=Integer.parseInt(request.getParameter("tempo"));
				String descrizione= request.getParameter("descrizione");
				String materia=request.getParameter("materia");
				Utente utente = (Utente) session.getAttribute("utente");
				String utenteEmail = utente.getEmail();
				PropostaTesi tesi = new PropostaTesi(titolo, ambito, tempo, materia, descrizione, utenteEmail, false, false);
				tesi.setId(id);
				count=0;
				session.setAttribute("count", count);
				if(this.modificaPropostaTesi(tesi))
				{
					session=request.getSession();
					session.setAttribute("tesi", tesi);
				}
				response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");
					}
					
				}
			}
	/**
	 * Modifica la proposta di tesi selezionata dall'utente registrato come docente con i cambiamenti apportati da quest'ultimo.
	 * @param tesi rappresenta la proposta di tesi che il docene vuole modificare.
	 * @return boolean: se la modifica ha avuto successo allora torna true;
	 * <p>
	 * altrimenti torna false.
	 */
	private boolean modificaPropostaTesi(PropostaTesi tesi){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		try {
			ptm.modificaPropostaTesi(tesi);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
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
