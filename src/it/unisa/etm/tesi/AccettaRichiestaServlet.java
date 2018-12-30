package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PartecipaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Servlet implementation class AccettaRichiestaServlet
 */
@WebServlet("/AccettaRichiestaServlet")
public class AccettaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;                                                                                      
 
    public AccettaRichiestaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propostatesi_id=Integer.parseInt(request.getParameter("richiesta_id"));
		String utenteEmail = request.getParameter("utente_email");
		if(this.accettaRichiestaPropostaTesi(propostatesi_id,utenteEmail))
		{
			request.getSession().removeAttribute("listaPartecipazione");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			int count = 2;
			request.setAttribute("count", count);
			request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean	accettaRichiestaPropostaTesi(int id, String utenteEmail){ 
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		PartecipaManager pm=(PartecipaManager) mf.createPartecipaManager();
		boolean i = pm.inserisciPartecipazione(id, utenteEmail);
		boolean a = ptm.accettaRichiestaPartecipazione(id);
		if(a==i)
			return true;	
		else
			return false;
	}
}