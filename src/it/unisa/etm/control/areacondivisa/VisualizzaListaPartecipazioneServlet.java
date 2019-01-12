package it.unisa.etm.control.areacondivisa;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.*;

/**
 * Estende HttpServlet fornisce la funzionalita di visualizzare tutti i partecipanti all'area privata condivisa.
 */
@WebServlet("/VisualizzaListaPartecipazioneServlet")
public class VisualizzaListaPartecipazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaListaPartecipazioneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		ManagerFactory em=new ManagerFactory();
		PropostaTesiManager tesi=(PropostaTesiManager) em.createPropostaTesiManager();
		ArrayList<PropostaTesi> list=null;
			list=tesi.getProposteTesiDocente(utente.getEmail());
			PartecipaManager partecipa=(PartecipaManager) em.createPartecipaManager();
			ArrayList<Partecipa> partecipazioni;
			partecipazioni=partecipa.getListaPartecipazione(list);
			request.getSession().setAttribute("listaPartecipazione", partecipazioni);
			request.getSession().removeAttribute("listaFile");
			request.getSession().removeAttribute("disabilita");
		
		String action=request.getParameter("action");
		if (action!=null) {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/homePage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.getSession().setAttribute("listaTesiDocente", list);
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/areaPrivataCondivisaDocente.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
