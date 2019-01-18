package it.unisa.etm.control.areacondivisa;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.model.bean.Consegna;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;


/**
 * Estende HttpServlet fornisce la funzionalita di visualizzare le informazioni di una consegna dell'area privata condivisa.
 */
@WebServlet("/VisualizzaInfoConsegnaServlet")
public class VisualizzaInfoConsegnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaInfoConsegnaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idConsegna"));
		ManagerFactory em=new ManagerFactory();
		ConsegnaManager um=(ConsegnaManager) em.createConsegnaManager();
		Consegna consegna=null;
			consegna=um.getConsegna(id);
		
		request.setAttribute("infoConsegna", consegna);
		RequestDispatcher view=getServletContext().getRequestDispatcher("/visualizzaInfoConsegna.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
