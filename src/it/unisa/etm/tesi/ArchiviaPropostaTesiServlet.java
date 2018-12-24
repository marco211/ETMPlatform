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
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;
import it.unisa.etm.model.manager.PropostaTesiManager;

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
		HttpSession session=request.getSession();
		synchronized(session) {
			int propostatesi_id = Integer.parseInt(request.getParameter("propostatesi_id"));
			Utente utente = (Utente) session.getAttribute("utente");
			System.out.println("sono arrivato alla sessione");
			if(this.archiviaPropostaTesi(propostatesi_id)) {
				System.out.println("ci arrivo?");
				response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");			}
		}
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
	 * @param propostatesi_id rappresenta 'identificativo della proposta di tesi scelta dall'utente registrato come docente.
	 * @return boolean true se l'archiviazione è avvenuta con successo;
	 * <p>
	 * false in caso di fallimento.
	 */
	private boolean archiviaPropostaTesi(int propostatesi_id){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		boolean b = false;
		try {
			b = ptm.archiviaPropostaTesi(propostatesi_id);
			System.out.println("ho provato a fare il metodo nel manager");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}
}
