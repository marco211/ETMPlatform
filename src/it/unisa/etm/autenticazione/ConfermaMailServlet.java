package it.unisa.etm.autenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Servlet implementation class ConfermaMailServlet
 */
@WebServlet("/ConfermaMailServlet")
public class ConfermaMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfermaMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validazione=request.getParameter("validazione");
		ManagerFactory mf=new ManagerFactory();
		UtenteManager um=(UtenteManager) mf.createUtenteManager();
		try {
			um.setValidazione(validazione);
			response.sendRedirect(request.getContextPath()+"/confermaRegistrazioneRiuscita.jsp");
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath()+"/confermaRegistrazioneNonRiuscita.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
