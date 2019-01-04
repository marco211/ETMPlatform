package it.unisa.etm.areacondivisa;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.Consegna;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;

/**
 *  Estende HttpServlet fornisce la funzionalità di aggiungere una consegna nell'area privata condivisa.
 */
@WebServlet("/AggiungiConsegnaServlet")
public class AggiungiConsegnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiConsegnaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		int idTesi=(int) request.getSession().getAttribute("numeroTesiDocente");
		ManagerFactory mf=new ManagerFactory();
		ConsegnaManager cm=(ConsegnaManager) mf.createConsegnaManager();
		if(action==null) {
			String nome=request.getParameter("nomeConsegna");
			String descrizione=request.getParameter("descrizioneConsegna");
			String dataScadenza = request.getParameter("scadenzaConsegna");
			Consegna consegna=new Consegna();
			consegna.setNome(nome);
			consegna.setDescrzione(descrizione);
			consegna.setPropostaTesiId(idTesi);
			consegna.setScadenza(dataScadenza);
			cm.aggiungiConsegna(consegna);
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/areaPrivataCondivisaDocente.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
				request.getSession().setAttribute("listaConsegne", cm.getListaConsegne(idTesi));
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/caricaConsegna.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
