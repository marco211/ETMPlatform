package it.unisa.etm.control.tesi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Estende HttpServlet ed offre all'utente registrato come docente la funzionalita di poter eliminare una proposta di tesi caricata da lui precedentemente.
 */
@WebServlet("/RimuoviPropostaTesiServlet")
public class RimuoviPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviPropostaTesiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propostatesi_id = Integer.parseInt(request.getParameter("propostatesi_id"));
		if(this.rimuoviPropostaTesi(propostatesi_id)) {
			response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");
		}else {
			int count = 6;
			request.setAttribute("count", count);
			request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Rimuove la proposta di tesi individuata dal utente registrato come docente e passata come input al metodo.
	 * @param tesi rappresenta la proposta di tesi da rimuovere;
	 * @return boolean true se la proposta di tesi e stata rimossa correttamente;
	 * <p>
	 * false se la rimozione non e riuscita.
	 */
	private boolean rimuoviPropostaTesi(int proposta_id){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		return ptm.rimuoviPropostaTesi(proposta_id);		
	}
}
