package it.unisa.etm.tesi;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.model.interfaces.*;
import it.unisa.etm.model.manager.*;
import it.unisa.etm.bean.PropostaTesi;

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
		// TODO Auto-generated method stub
		try {
			System.out.println("Mammt");
			propostamanager = new PropostaTesiManager();
			ArrayList<PropostaTesi> proposte = propostamanager.getProposteTesiAttive();
			request.setAttribute("proposte", proposte);
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
