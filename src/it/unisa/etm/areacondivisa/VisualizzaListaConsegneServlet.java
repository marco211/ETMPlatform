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
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int propostaTesiId =Integer.parseInt(request.getParameter("propostaTesiId"));
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		ManagerFactory em = new ManagerFactory();
		ConsegnaManager consegna = (ConsegnaManager) em.createConsegnaManager();
		try {
			ArrayList<Consegna> consegne = consegna.getListaConsegne(propostaTesiId);
			request.getSession().setAttribute("listaConsegne", consegne);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/VisualizzaListaFileServlet?idTesi="+utente.getPropostaTesi_ID()+"&utenteEmail="+utente.getEmail());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
