package it.unisa.etm.control.tesi;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.PropostaTesiManager;


/**
 * Estende la classe HttpServlet ed offre all'utente la possibilita di visualizzare i dettagli di una determinata proposta di tesi.
 */
@WebServlet("/VisualizzaDettagliTesiServlet")
public class VisualizzaDettagliTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDettagliTesiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("propostatesi_id"));
		PropostaTesi propostaTesi = (PropostaTesi) visualizzaDettagliPropostaTesi(id);
		ArrayList<Utente> utenti = this.getListaUtenti();
		HttpSession session=request.getSession();
		Utente utente = (Utente) session.getAttribute("utente");
		ArrayList<RichiestaPartecipazione> richieste= this.getRichieste(utente);
		request.setAttribute("propostatesi", propostaTesi);
		request.setAttribute("utenti", utenti);
		request.setAttribute("richiesteproposte", richieste);	
		Utente docente = new Utente();
		for(Utente u : utenti){
			if(propostaTesi.getUtenteEmail().equalsIgnoreCase(u.getEmail())){
				docente = u;
			}
		}
		session.setAttribute("docente", docente);
		request.getRequestDispatcher("visualizzaDettagliPropostaTesi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**da cambiare
	 * Torna i dettagli di una determinata PropostaTesi presa come input.
	 * @param id della PropostaTesi, che rappresenta la tesi scelta per conoscere le info.
	 * @return proposta di tesi che ha l'id inserito come input;
	 * <p>
	 * null se non vi sono dettagli della proposta di tesi.
	 */
	private PropostaTesi visualizzaDettagliPropostaTesi(int id){
		ManagerFactory em = new ManagerFactory();
		PropostaTesiManager ptm = (PropostaTesiManager) em.createPropostaTesiManager();
		PropostaTesi propostaTesi;
		propostaTesi=ptm.getPropostaTesi(id);
		return propostaTesi;	
	}
	
	/**da cambiare
	 * Torna la lista degli utenti.
	 * @param
	 * @return ArrayList<Utente> rappresenta la lista degli utenti
	 * <p>
	 * null se non vi utenti o si sono presentate eccezioni.
	 */
	private ArrayList<Utente> getListaUtenti(){
		ManagerFactory em = new ManagerFactory();
		AmministratoreManager atm = (AmministratoreManager) em.createAmministratoreManager();
		ArrayList<Utente> utenti = new ArrayList<Utente>();
		utenti = (ArrayList<Utente>) atm.getListaUtenti();
		return utenti;
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
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager propostamanager=(PropostaTesiManager) mf.createPropostaTesiManager();
		ArrayList<RichiestaPartecipazione> richieste = new ArrayList<RichiestaPartecipazione>();
		if(utente.getTipo().equals("d")) 
			richieste= propostamanager.cercaRichiestePartecipazione(utente.getEmail());
		else 
			richieste = propostamanager.getRichiestaStudente(utente.getEmail());
		return richieste;
	}
}
