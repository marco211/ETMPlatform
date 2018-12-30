package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Servlet implementation class RifiutaRichiestaServlet
 */
@WebServlet("/RifiutaRichiestaServlet")
public class RifiutaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RifiutaRichiestaServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propostatesi_id=Integer.parseInt(request.getParameter("richiesta_id"));
		this.rifiutaRichiestaPropostaTesi(propostatesi_id);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void rifiutaRichiestaPropostaTesi(int id){ 
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		try {
			ptm.rifiutaRichiestaPartecipazione(id);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
