package it.unisa.etm.tesi;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Servlet implementation class AccettaRichiestaServlet
 */
@WebServlet("/AccettaRichiestaServlet")
public class AccettaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PropostaTesiModelInterface  propostamanager;                                                                                       
 
    public AccettaRichiestaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		synchronized(session) {
			LocalDate data = LocalDate.now();
			int propostatesi_id=Integer.parseInt(request.getParameter("richiesta_id"));
			propostamanager = new PropostaTesiManager();
		
			if(this.accettaRichiestaPropostaTesi(propostatesi_id));
			{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean	accettaRichiestaPropostaTesi(int id){ 
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		try {
			ptm.accettaRichiestaPartecipazione(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}
}
