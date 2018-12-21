package it.unisa.etm.autenticazione;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende HttpServlet e fornisce la funzionalit� di registrazione.
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String password=request.getParameter("password");
		String data=request.getParameter("data");
		String tipo=request.getParameter("tipo");
		Utente utente;
		if(tipo.equals("s"))
		{
			long matricola=Long.parseLong(request.getParameter("matricola"));
			utente=new Utente(cognome, data, nome, tipo, email, password, matricola);
		}
		else
		{
			String insegnamento=request.getParameter("insegnamento");
			String ufficio=request.getParameter("ufficio");
			utente=new Utente(cognome, data, ufficio, tipo, nome, email, password, insegnamento);
		}
<<<<<<< HEAD
		if(registrazioneControl(utente))
		{
			
		}
		
=======
		registrazioneControl(utente);
		request.getRequestDispatcher("index.jsp").forward(request, response);
>>>>>>> 5882c2cccb380dbc93d1f1058fa86a117757b7ab

	}



	/**
	 * Effettua la registrazione di un utente.
	 * @param utente non ancora registrato, ma che ha inserito gi� i parametri si registrazione.
	 * @return boolean true se la registrazione � andata a buono fine;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean registrazioneControl(Utente utente){
		ManagerFactory mf=new ManagerFactory();
		UtenteManager um=(UtenteManager) mf.createUtenteManager();
		try {
			um.registraUtente(utente);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
