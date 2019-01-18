package it.unisa.etm.control.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come docente la possibilita di archiviare una propria proposta di tesi.
 */
@WebServlet("/ArchiviaPropostaTesiServlet")
public class ArchiviaPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArchiviaPropostaTesiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propostatesi_id=Integer.parseInt(request.getParameter("propostatesi_id"));
		if(this.archiviaPropostaTesi(propostatesi_id)) {
			response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Archivia la proposta di tesi scelta dall'utente registrato come docente, aggiungendola alla lista di quelle archiviate.
	 * @param propostatesi_id rappresenta 'identificativo della proposta di tesi scelta dall'utente registrato come docente.
	 * @return boolean true se l'archiviazione e avvenuta con successo;
	 * <p>
	 * false in caso di fallimento.
	 */
	private boolean archiviaPropostaTesi(int propostatesi_id){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		return ptm.archiviaPropostaTesi(propostatesi_id);
	}
}
