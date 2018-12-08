package it.unisa.etm.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come docente la possibilità di archiviare una propria proposta di tesi.
 */
@WebServlet("/ArchiviaPropostaTesiServlet")
public class ArchiviaPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArchiviaPropostaTesiServlet() {
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
	 * Archivia la proposta di tesi scelta dall'utente registrato come docente, aggiungendola alla lista di quelle archiviate.
	 * @param tesi rappresenta la proposta di tesi scelta dall'utente registrato come docente.
	 * @return boolean true se l'archiviazione è avvenuta con successo;
	 * <p>
	 * false in caso di fallimento.
	 */
	private boolean archiviaPropostaTesi(PropostaTesi tesi){
		return false;
		
	}
}
