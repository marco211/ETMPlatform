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
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Estende HttpServlet ed offre all'utente registrato come docente la funzionalità di poter eliminare una proposta di tesi caricata da lui precedentemente.
 */
@WebServlet("/RimuoviPropostaTesiServlet")
public class RimuoviPropostaTesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviPropostaTesiServlet() {
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
			if(this.rimuoviPropostaTesi(propostatesi_id)) {
				response.sendRedirect(request.getContextPath()+"/ListaProposteTesiAttiveServlet");
			}
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
	 * Rimuove la proposta di tesi individuata dal utente registrato come docente e passata come input al metodo.
	 * @param tesi rappresenta la proposta di tesi da rimuovere;
	 * @return boolean true se la proposta di tesi è stata rimossa correttamente;
	 * <p>
	 * false se la rimozione non è riuscita.
	 */
	private boolean rimuoviPropostaTesi(int proposta_id){
		ManagerFactory mf=new ManagerFactory();
		PropostaTesiManager ptm=(PropostaTesiManager) mf.createPropostaTesiManager();
		boolean b = false;
		try {
			b = ptm.rimuoviPropostaTesi(proposta_id);
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return b;
		
	}
}
