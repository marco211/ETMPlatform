package it.unisa.etm.control.tesi;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Estende HttpServlet fornisce la funzionalita di confermare 
 * l'aggiunta di una nuova proposta di tesi.
 */
@WebServlet("/ConfermaAggiungiPropostaTesiServlet")
public class ConfermaAggiungiPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConfermaAggiungiPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String titolo = request.getParameter("titolo");
    String ambito = request.getParameter("ambito");
    int tempo = Integer.parseInt(request.getParameter("tempo"));
    String descrizione = request.getParameter("descrizione");
    String materia = request.getParameter("materia");
    Utente utente = (Utente) session.getAttribute("utente");
    String utenteEmail = utente.getEmail();
    PropostaTesi tesi = new PropostaTesi(titolo, ambito, tempo, materia, 
        descrizione, utenteEmail, false, false);
    
    Attivita aggTesi = new Attivita(utenteEmail, titolo, LocalDate.now(), "at", -10);
    ManagerFactory mf = new ManagerFactory();
    AttivitaManager am = (AttivitaManager) mf.createAttivitaManager();
    
    if (aggiungiPropostatesi(tesi) && am.aggiungiAttivita(aggTesi)) {
      response.sendRedirect(request.getContextPath() + "/ListaProposteTesiAttiveServlet");
    } else {
      int count = 1;
      request.setAttribute("count", count);
      request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
    }
  }

  /**
   * Aggiunge alla lista delle proposte di tesi, una nuova proposta creata dal docente.
   * @param tesi rappresenta la proposta di tesi che il docente vuole aggiungere.
   * @return boolean true se l'aggiunta e avvenuta con successo.
   *         false in caso contrario.
   */
  private boolean aggiungiPropostatesi(PropostaTesi tesi) {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    return ptm.inserisciPropostaTesi(tesi);
  }
}