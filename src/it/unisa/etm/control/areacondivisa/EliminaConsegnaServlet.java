package it.unisa.etm.control.areacondivisa;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;

/**
 * Estende HttpServlet fornisce la funzionalita di eliminare una consegna dell'area privata condivisa.
 */
@WebServlet("/EliminaConsegnaServlet")
public class EliminaConsegnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaConsegnaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idConsegna"));
		ManagerFactory mf=new ManagerFactory();
		ConsegnaManager cm=(ConsegnaManager) mf.createConsegnaManager();
			cm.eliminaConsegna(id);
			request.getSession().setAttribute("listaConsegne",cm.getListaConsegne((int)request.getSession().getAttribute("numeroTesiDocente")) );
		
		RequestDispatcher view=getServletContext().getRequestDispatcher("/caricaConsegna.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
