package it.unisa.etm.control.areacondivisa;

import it.unisa.etm.model.bean.File;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet fornisce la funzionalita di visualizzare tutti i file 
 * presenti nell'area privata condivisa.
 */
@WebServlet("/VisualizzaListaFileServlet")
public class VisualizzaListaFileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public VisualizzaListaFileServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("idTesi"));
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    ManagerFactory em = new ManagerFactory();
    FileManager um = (FileManager) em.createFileManager();
    ArrayList<File> lista;

    lista = um.getListaFile(id);
    request.getSession().setAttribute("listaFile", lista);
    if (utente.getTipo().equals("d")) {
      request.getSession().setAttribute("numeroTesiDocente", id);
      request.getSession().setAttribute("disabilita", true);
    }
    RequestDispatcher requestDispatcher = 
        getServletContext().getRequestDispatcher("/areaPrivataCondivisaStudente.jsp");
    requestDispatcher.forward(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
