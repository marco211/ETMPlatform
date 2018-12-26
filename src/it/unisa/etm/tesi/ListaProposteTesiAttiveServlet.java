package it.unisa.etm.tesi;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.model.interfaces.*;
import it.unisa.etm.model.manager.*;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;

/**
 * Servlet implementation class ListaProposteTesiAttive
 */
@WebServlet("/ListaProposteTesiAttiveServlet")
public class ListaProposteTesiAttiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PropostaTesiManager  propostamanager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProposteTesiAttiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized(session) {
			ArrayList<PropostaTesi> proposte = this.getProposte();
			Utente utente = (Utente) session.getAttribute("utente");
			request.setAttribute("proposte", proposte);
			ArrayList<RichiestaPartecipazione> richieste= this.getRichieste(utente);
			if(utente.getTipo().equals("d")) {
				request.setAttribute("richieste", richieste);
				request.getRequestDispatcher("listaProposteTesiAttive.jsp").forward(request, response);
			}
			else {
				request.setAttribute("richieste_studente", richieste);
				request.getRequestDispatcher("listaTesiAttive.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Restituisce tutte le proposte di tesi
	 * @param
	 * @return ArrayList<PropostaTesi> rappresenta tutte le proposte tesi;
	 * <p>
	 * null altrimenti;
	 */
	private ArrayList<PropostaTesi> getProposte(){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager propostamanager=(PropostaTesiManager) mf.createPropostaTesiManager();
		ArrayList<PropostaTesi> lista = new ArrayList<PropostaTesi>();
		try {
			lista = propostamanager.getProposteTesiAttive();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Restituisce tutte le richieste di proposte di tesi: se l'utente è un docente restituisce tutte le richieste
	 * effettuate da parte degli studenti; se l'utente è uno studente restituisce tutte le richieste effettuate.
	 * @param
	 * @return ArrayList<RichiestaPartecipazione> rappresenta tutte le richieste per le proposte tesi;
	 * <p>
	 * null altrimenti;
	 */
	private ArrayList<RichiestaPartecipazione> getRichieste(Utente utente){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager propostamanager=(PropostaTesiManager) mf.createPropostaTesiManager();
		ArrayList<RichiestaPartecipazione> richieste = new ArrayList<RichiestaPartecipazione>();
		try {
			if(utente.getTipo().equals("d")) 
				richieste= propostamanager.cercaRichiestePartecipazione(utente.getEmail());
			else 
				richieste = propostamanager.getRichiestaStudente(utente.getEmail());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return richieste;
	}
}
