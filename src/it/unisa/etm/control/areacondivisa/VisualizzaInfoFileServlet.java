package it.unisa.etm.control.areacondivisa;

import it.unisa.etm.model.bean.File;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.FileManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet fornisce all'utente la funzionalita 
 * di visualizzare le informazioni di un file presente nell'area privata condivisa.
 */
@WebServlet("/VisualizzaInfoFileServlet")
public class VisualizzaInfoFileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public VisualizzaInfoFileServlet() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("idTesi"));
    String nomeFile = request.getParameter("nomeFile");
    ManagerFactory em = new ManagerFactory();
    FileManager um = (FileManager) em.createFileManager();

    File file = um.getFile(id, nomeFile);
    request.getSession().setAttribute("infoFile", file);

    RequestDispatcher view = 
        getServletContext().getRequestDispatcher("/visualizzaInfoFile.jsp");
    view.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
