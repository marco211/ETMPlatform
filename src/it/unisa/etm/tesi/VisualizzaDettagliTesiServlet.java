package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;


/**
 * Estende la classe HttpServlet ed offre all'utente la possibilità di visualizzare i dettagli di una determinata proposta di tesi.
 */
@WebServlet("/VisualizzaDettagliTesiServlet")
public class VisualizzaDettagliTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDettagliTesiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("propostatesi_id"));
		PropostaTesi propostaTesi = (PropostaTesi) visualizzaDettagliPropostaTesi(id);
		
		HttpSession session=request.getSession();
		session.setAttribute("propostatesi", propostaTesi);
		request.getRequestDispatcher("visualizzaDettagliPropostaTesi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**da cambiare
	 * Torna i dettagli di una determinata PropostaTesi presa come input.
	 * @param id della PropostaTesi, che rappresenta la tesi scelta per conoscere le info.
	 * @return proposta di tesi che ha l'id inserito come input;
	 * <p>
	 * null se non vi sono dettagli della proposta di tesi.
	 */
	private PropostaTesi visualizzaDettagliPropostaTesi(int id){
		ManagerFactory em = new ManagerFactory();
		PropostaTesiManager ptm = (PropostaTesiManager) em.createPropostaTesiManager();
		PropostaTesi propostaTesi;
		try {
			propostaTesi=ptm.getPropostaTesi(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return propostaTesi;	
	}
}
