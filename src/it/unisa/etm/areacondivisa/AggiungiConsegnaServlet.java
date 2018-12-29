package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

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
 * Servlet implementation class AggiungiConsegnaServlet
 */
@WebServlet("/AggiungiConsegnaServlet")
public class AggiungiConsegnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiConsegnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int idTesi=(int)request.getSession().getAttribute("numeroTesiDocente");
		ManagerFactory mf=new ManagerFactory();
		ConsegnaManager cm = (ConsegnaManager) mf.createConsegnaManager();
		if(action==null) {
		String nome=request.getParameter("nomeConsegna");
		String descrizione=request.getParameter("descrizioneConsegna");
		String dataScadenza = request.getParameter("scadenzaConsegna");
		Consegna consegna = new Consegna();
		consegna.setNome(nome);
		consegna.setDescrzione(descrizione);
		consegna.setPropostaTesiId(idTesi);
		consegna.setScadenza(dataScadenza);
		try {
			cm.aggiungiConsegna(consegna);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/areaPrivataCondivisaDocente.jsp");
		requestDispatcher.forward(request, response);
		}
		else {
			try {
				request.getSession().setAttribute("listaConsegne", cm.getListaConsegne(idTesi));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/caricaConsegna.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
