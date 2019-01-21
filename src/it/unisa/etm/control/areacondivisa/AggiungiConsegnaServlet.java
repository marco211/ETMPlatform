package it.unisa.etm.control.areacondivisa;

import it.unisa.etm.model.bean.Consegna;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  Estende HttpServlet fornisce la funzionalita 
 *  di aggiungere una consegna nell'area privata condivisa.
 */
@WebServlet("/AggiungiConsegnaServlet")
public class AggiungiConsegnaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public AggiungiConsegnaServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    int idTesi = (int) request.getSession().getAttribute("numeroTesiDocente");
    ManagerFactory mf = new ManagerFactory();
    ConsegnaManager cm = (ConsegnaManager) mf.createConsegnaManager();
    if (action == null) {
      String nome = request.getParameter("nomeConsegna");
      String descrizione = request.getParameter("descrizioneConsegna");
      String dataScadenza = request.getParameter("scadenzaConsegna");
      Consegna consegna = new Consegna();
      consegna.setNome(nome);
      consegna.setDescrzione(descrizione);
      consegna.setPropostaTesiId(idTesi);
      consegna.setScadenza(dataScadenza);
      cm.aggiungiConsegna(consegna);
      RequestDispatcher requestDispatcher = 
          getServletContext().getRequestDispatcher("/areaPrivataCondivisaDocente.jsp");
      requestDispatcher.forward(request, response);
    } else {
      request.getSession().setAttribute("listaConsegne", cm.getListaConsegne(idTesi));
      RequestDispatcher requestDispatcher = 
          getServletContext().getRequestDispatcher("/caricaConsegna.jsp");
      requestDispatcher.forward(request, response);
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
