package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

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
import it.unisa.etm.model.manager.PropostaTesiManager;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come studente la funzionalità di poter inviare all'utente registrato come docente una richiesta di tesi per una determinata proposta tesi.
 */
@WebServlet("/InviaPropostaTesiServlet")
public class InviaPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviaPropostaTesiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id_richiesta"));
		LocalDate data=LocalDate.parse(request.getParameter("data"));
		int propostatesi_id=Integer.parseInt(request.getParameter("propostatesi_id"));
		String utente_mail=request.getParameter("utente_mail");
		
		RichiestaPartecipazione richiesta = new RichiestaPartecipazione(id, data, propostatesi_id, utente_mail);
		
		if(inviaRichiestaPropostaTesi(richiesta));
		{
			HttpSession session=request.getSession();
			session.setAttribute("richiesta", richiesta);
		}
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Invia al docente la richiesta di proposta tesi fatta dall'utente registrato come studente e passata come input al metodo.
	 * @param richiesta rappresenta la richesta per la proposta di tesi effettuata dall'utente registrato come studente.
	 * @return boolean true se l'invio è avvenuto con successo;
	 * <p>
	 * false se non è avvenuto con successo.
	 */
	private boolean inviaRichiestaPropostaTesi(RichiestaPartecipazione richiesta){ //cambiato il parametro da PropostaTesi a RichiestaPartecipazione
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		try {
			ptm.inserisciRichiestaPartecipazione(richiesta);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
}
