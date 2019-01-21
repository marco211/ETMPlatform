package it.unisa.etm.control.areacondivisa;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;
import it.unisa.etm.model.manager.FileManager;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet e fornisce all'utente registrato come docente
 * la funzionalit� di poter valutare un file presente nell'area privata condivisa.
 */
@WebServlet("/ValutaFileServlet")
public class ValutaFileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public ValutaFileServlet() {
    super();
  }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("idTesi"));
    String nomeFile = request.getParameter("nomeFile");
    int voto = Integer.parseInt(request.getParameter("voto"));
    String descrizione = request.getParameter("descrizione");
    ManagerFactory em = new ManagerFactory();
    FileManager um = (FileManager) em.createFileManager();
    LocalDate data = LocalDate.now();
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    Attivita attivita = new Attivita(utente.getEmail(), nomeFile, data, "v", id);
    AttivitaManager am = (AttivitaManager) em.createAttivitaManager();
    um.modificaFile(id, nomeFile, voto, descrizione);
    am.aggiungiAttivita(attivita);

    RequestDispatcher view = 
        getServletContext().getRequestDispatcher("/VisualizzaListaFileServlet?idTesi=" + id);
    view.forward(request, response);
  }

}
