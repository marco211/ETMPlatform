package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.model.manager.AreaCondivisaManager;

/**
 * Estende HttpServlet e fornisce all'utente la funzionalità di visualizzare lo storico delle attività effettuate.
 */
@WebServlet("/VisualizzaStoricoServlet")
public class VisualizzaStoricoServlet extends HttpServlet {
	AreaCondivisaManager m = new AreaCondivisaManager();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaStoricoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Torna all'utente la lista delle attività effettuate dall'utente stesso.
	 * @param utente registrato;
	 * @return lista di attivita effettuate dall'utente;
	 * <p>
	 * null se non vi sono attivita effettuate.
	 * @throws SQLException 
	 */
	private List<Attivita> getStorico(Utente utente) throws SQLException{
		m.getFile(1);
		return null;
		
	}
}
