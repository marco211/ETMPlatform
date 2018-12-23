package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unisa.etm.bean.File;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.FileManager;

/**
 * Servlet implementation class VisualizzaListaFileServlet
 */
@WebServlet("/VisualizzaListaFileServlet")
public class VisualizzaListaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaListaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idTesi"));
		String email=request.getParameter("emailUtente");
		ManagerFactory em = new ManagerFactory();
		FileManager um = (FileManager) em.createFileManager();
		try {
			ArrayList<File> lista=um.getListaFile(id, email);
			request.getSession().setAttribute("listaFile", lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		if(utente.getTipo().equals("d")) {
			request.getSession().setAttribute("numeroTesiDocente", id);
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/areaPrivataCondivisaStudente.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
