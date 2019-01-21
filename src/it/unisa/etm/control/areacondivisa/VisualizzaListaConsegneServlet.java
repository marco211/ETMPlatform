package it.unisa.etm.control.areacondivisa;

import it.unisa.etm.model.bean.Consegna;
import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.ConsegnaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Estende HttpServlet fornisce la funzionalita 
 * di visualizzare tutte le consegne dell'area privata condivisa.
 */
@WebServlet("/VisualizzaListaConsegneServlet")
public class VisualizzaListaConsegneServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VisualizzaListaConsegneServlet() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Utente utente = (Utente)request.getSession().getAttribute("utente");
    int propostaTesiId = utente.getPropostaTesi_Id();
    ManagerFactory em = new ManagerFactory();
    ConsegnaManager consegna = (ConsegnaManager) em.createConsegnaManager();
    PropostaTesiManager tesi = (PropostaTesiManager) em.createPropostaTesiManager();

    PropostaTesi propostaTesi = tesi.getPropostaTesi(propostaTesiId);
    request.getSession().setAttribute("propostaTesi", propostaTesi);
    ArrayList<Consegna> consegne = consegna.getListaConsegne(propostaTesiId);
    request.getSession().setAttribute("listaConsegne", consegne);
    response.sendRedirect(request.getContextPath() + "/VisualizzaListaFileServlet?"
        + "idTesi=" + utente.getPropostaTesi_Id() + "&utenteEmail=" + utente.getEmail());
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
