package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Consegna;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Servlet implementation class VisualizzaListaConsegneServlet
 */
@WebServlet("/VisualizzaListaConsegneServlet")
public class VisualizzaListaConsegneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaListaConsegneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		int propostaTesiId=utente.getPropostaTesi_ID();
		ManagerFactory em=new ManagerFactory();
		ConsegnaManager consegna=(ConsegnaManager) em.createConsegnaManager();
		PropostaTesiManager tesi=(PropostaTesiManager) em.createPropostaTesiManager();
		
			PropostaTesi propostaTesi=tesi.getPropostaTesi(propostaTesiId);
			request.getSession().setAttribute("propostaTesi", propostaTesi);
			ArrayList<Consegna> consegne=consegna.getListaConsegne(propostaTesiId);
			request.getSession().setAttribute("listaConsegne", consegne);		
		response.sendRedirect(request.getContextPath()+"/VisualizzaListaFileServlet?idTesi="+utente.getPropostaTesi_ID()+"&utenteEmail="+utente.getEmail());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
