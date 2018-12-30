package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;
/**
 * Estende HttpServlet e fornisce all'utente la funzionalit� di visualizzare lo storico delle attivit� effettuate.
 */
@WebServlet("/VisualizzaStoricoServlet")
public class VisualizzaStoricoServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaStoricoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente) request.getSession().getAttribute("utente");
		int propostaTesiId;
		if(utente.getTipo().equals("d")) {
			propostaTesiId=(int) request.getSession().getAttribute("numeroTesiDocente");
		}
		else {
			propostaTesiId=Integer.parseInt(request.getParameter("propostaTesiId"));
		}
		if(propostaTesiId!=0) {
			ManagerFactory em=new ManagerFactory();
			AttivitaManager attivita=(AttivitaManager) em.createAttivitaManager();
			
				ArrayList<Attivita> lista=(ArrayList<Attivita>) attivita.getListaAttivita(propostaTesiId);
				request.getSession().setAttribute("storico", lista);
			
		}
		RequestDispatcher view=getServletContext().getRequestDispatcher("/visualizzaStoricoAttivita.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
