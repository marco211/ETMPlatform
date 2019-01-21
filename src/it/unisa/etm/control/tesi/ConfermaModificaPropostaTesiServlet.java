package it.unisa.etm.control.tesi;

import it.unisa.etm.model.bean.PropostaTesi;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Estende HttpServlet fornisce la funzionalita di 
 * confermare la modifica di una nuova proposta di tesi.
 */
@WebServlet("/ConfermaModificaPropostaTesiServlet")
public class ConfermaModificaPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConfermaModificaPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    int id = Integer.parseInt(request.getParameter("proposta_id"));
    String titolo = request.getParameter("titolo");
    String ambito = request.getParameter("ambito");
    int tempo = Integer.parseInt(request.getParameter("tempo"));
    String descrizione = request.getParameter("descrizione");
    String materia = request.getParameter("materia");
    Utente utente = (Utente) session.getAttribute("utente");
    String utenteEmail = utente.getEmail();
    PropostaTesi tesi = new PropostaTesi(titolo, ambito, tempo, materia, 
        descrizione, utenteEmail, false, false);
    tesi.setId(id);
    if (this.modificaPropostaTesi(tesi)) {
      response.sendRedirect(request.getContextPath() + "/ListaProposteTesiAttiveServlet");
    } else {
      int count = 3;
      request.setAttribute("count", count);
      request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
    }
  }

  /**
   * Modifica la proposta di tesi selezionata dall'utente registrato 
   * come docente con i cambiamenti apportati da quest'ultimo.
   * @param tesi rappresenta la proposta di tesi che il docene vuole modificare.
   * @return boolean: se la modifica ha avuto successo allora torna true.
   *         altrimenti torna false.
   */
  private boolean modificaPropostaTesi(PropostaTesi tesi) {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    return ptm.modificaPropostaTesi(tesi);
  }
}