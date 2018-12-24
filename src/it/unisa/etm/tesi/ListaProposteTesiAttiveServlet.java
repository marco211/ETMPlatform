package it.unisa.etm.tesi;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.etm.model.interfaces.*;
import it.unisa.etm.model.manager.*;
import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.bean.RichiestaPartecipazione;
import it.unisa.etm.bean.Utente;

/**
 * Servlet implementation class ListaProposteTesiAttive
 */
@WebServlet("/ListaProposteTesiAttiveServlet")
public class ListaProposteTesiAttiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PropostaTesiManager  propostamanager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProposteTesiAttiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try {
			System.out.println("Mammtaaaaaaaaaaaaaaaaaaaa");
			propostamanager = new PropostaTesiManager();
			ArrayList<PropostaTesi> proposte = propostamanager.getProposteTesiAttive();
			Utente utente = (Utente) session.getAttribute("utente");
			request.setAttribute("proposte", proposte);
			if(utente.getTipo().equals("d")) {
				ArrayList<RichiestaPartecipazione> richieste= propostamanager.cercaRichiestePartecipazione(utente.getEmail());
				request.setAttribute("richieste", richieste);
			}
			
			request.getRequestDispatcher("listaProposteTesiAttive.jsp").forward(request, response);
		}catch(SQLException e){
			request.getRequestDispatcher("index.jsp").forward(request, response);
			e.printStackTrace();
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
