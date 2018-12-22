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

import it.unisa.etm.bean.Consegna;
import it.unisa.etm.bean.Partecipa;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.*;

/**
 * Servlet implementation class VisualizzaListaPartecipazioneServlet
 */
@WebServlet("/VisualizzaListaPartecipazioneServlet")
public class VisualizzaListaPartecipazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaListaPartecipazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		ManagerFactory em = new ManagerFactory();
		PropostaTesiManager tesi=(PropostaTesiManager)em.createPropostaTesiManager();
		ArrayList<PropostaTesi> list;
		try {
			list = tesi.getProposteTesiDocente(utente.getEmail());
			PartecipaManager partecipa = (PartecipaManager) em.createPartecipaManager();
			ArrayList<Partecipa> partecipazioni;
			partecipazioni = partecipa.getListaPartecipazione(list);
			request.getSession().setAttribute("listaPartecipazione", partecipazioni);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/areaPrivataCondivisaDocente.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
