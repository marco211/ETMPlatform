package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AreaCondivisaManager;
import it.unisa.etm.model.manager.AttivitaManager;
import it.unisa.etm.model.manager.FileManager;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende HttpServlet e fornisce all'utente la funzionalit� di visualizzare lo storico delle attivit� effettuate.
 */
@WebServlet("/VisualizzaStoricoServlet")
public class VisualizzaStoricoServlet extends HttpServlet {
	AreaCondivisaManager m = new AreaCondivisaManager();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaStoricoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		String propostaTesiId;
		if(utente.getTipo().equals("d")) {
		propostaTesiId=(String)request.getSession().getAttribute("numeroTesiDocente");
		}
		else {
		propostaTesiId =request.getParameter("propostaTesiId");
		}
		
		if(propostaTesiId!=null) {
		
		ManagerFactory em = new ManagerFactory();
		AttivitaManager attivita = (AttivitaManager) em.createAttivitaManager();
		try {
			ArrayList<Attivita> lista = (ArrayList<Attivita>) attivita.getListaAttivita(Integer.parseInt(propostaTesiId));
			request.getSession().setAttribute("storico", lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		RequestDispatcher view=getServletContext().getRequestDispatcher("/visualizzaStoricoAttivita.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
