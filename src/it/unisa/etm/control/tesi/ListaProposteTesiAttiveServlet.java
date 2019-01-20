package it.unisa.etm.control.tesi;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.RichiestaPartecipazione;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.*;

/**
 * Estende HttpServlet fornisce la funzionalita di visualizzare la lista delle proposte tesi attive sia del docente che per lo studente.
 */
@WebServlet("/ListaProposteTesiAttiveServlet")
public class ListaProposteTesiAttiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProposteTesiAttiveServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<PropostaTesi> proposte = this.getProposte();
		Utente utente=(Utente) session.getAttribute("utente");
		request.setAttribute("proposte", proposte);
		ArrayList<RichiestaPartecipazione> richieste=this.getRichieste(utente);
		if(utente.getTipo().equals("d")) {
			request.setAttribute("richieste", richieste);
			request.getRequestDispatcher("listaProposteTesiAttive.jsp").forward(request, response);
		} else {
			request.setAttribute("richieste_studente", richieste);
			request.getRequestDispatcher("listaTesiAttive.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		lista=propostamanager.getProposteTesiAttive();
		return lista;
	}
	
	/**
	 * Restituisce tutte le richieste di proposte di tesi: se l'utente e un docente restituisce tutte le richieste
	 * effettuate da parte degli studenti; se l'utente e uno studente restituisce tutte le richieste effettuate.
	 * @param
	 * @return ArrayList<RichiestaPartecipazione> rappresenta tutte le richieste per le proposte tesi;
	 * <p>
	 * null altrimenti;
	 */
	private ArrayList<RichiestaPartecipazione> getRichieste(Utente utente){
		if(utente == null) return null;
		
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager propostamanager=(PropostaTesiManager) mf.createPropostaTesiManager();
		ArrayList<RichiestaPartecipazione> richieste=new ArrayList<RichiestaPartecipazione>();
		if(utente.getTipo().equals("d")) 
			richieste=propostamanager.cercaRichiestePartecipazione(utente.getEmail());
		else 
			richieste=propostamanager.getRichiestaStudente(utente.getEmail());
		return richieste;
	}
	
}
