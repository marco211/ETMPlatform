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
 * Estende HttpServlet fornisce la funzionalita 
 * di modificare una consegna dell'area privata condivisa.
 */

@WebServlet("/ModificaConsegnaServlet")
public class ModificaConsegnaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  
  public ModificaConsegnaServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("idConsegna"));
    String scadenza = request.getParameter("scadenzaConsegna");
    String nome = request.getParameter("nomeConsegna");
    String descrizione = request.getParameter("descrizioneConsegna");
    Consegna consegna = new Consegna();
    consegna.setId(id);
    consegna.setDescrzione(descrizione);
    consegna.setNome(nome);
    consegna.setScadenza(scadenza);
    ManagerFactory em = new ManagerFactory();
    ConsegnaManager um = (ConsegnaManager) em.createConsegnaManager();
    um.modificaConsegna(scadenza, id);
    request.setAttribute("infoConsegna", consegna);
    RequestDispatcher view = 
        getServletContext().getRequestDispatcher("/visualizzaInfoConsegna.jsp");
    view.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
