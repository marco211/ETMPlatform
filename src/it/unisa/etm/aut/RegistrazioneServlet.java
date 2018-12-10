package it.unisa.etm.aut;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Utente;

/**
 * Estende HttpServlet e fornisce la funzionalità di registrazione.
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String password=request.getParameter("password");
		int anno=Integer.parseInt(request.getParameter("anno"));
		int mese=Integer.parseInt(request.getParameter("mese"));
		int giorno=Integer.parseInt(request.getParameter("giorno"));
		@SuppressWarnings("deprecation")
		Date data=new Date(anno-1900,mese-1,giorno);
		char tipo=request.getParameter("tipo").charAt(0);
		Utente utente;
		if(tipo=='0')
		{
			long matricola=Long.parseLong(request.getParameter("matricola"));
			utente = new Utente(email, nome, cognome, password, data, tipo, matricola);

		}
		else
		{
			String ufficio=request.getParameter("ufficio");
			utente = new Utente(email, nome, cognome, password, data, tipo, ufficio);
		}
		//il nome è di Scala
		RegistrazioneControl(utente);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Effettua la registrazione di un utente.
	 * @param utente non ancora registrato, ma che ha inserito già i parametri si registrazione.
	 * @return boolean true se la registrazione è andata a buono fine;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean RegistrazioneControl(Utente utente){
		 	//to do expception
			Utente.aggiungiUtente(utente);
			return true;
	}
}
