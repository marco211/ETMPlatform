package it.unisa.etm.control.admin;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/VisualizzaDettagliUtenteServlet")
public class VisualizzaDettagliUtenteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VisualizzaDettagliUtenteServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String email = (String) request.getParameter("utente_email");
    Utente utenteEmail = (Utente) visualizzaDettagliUtente(email);
    HttpSession session = request.getSession();
    session.setAttribute("utenteemail", utenteEmail);
    request.getRequestDispatcher("visualizzaDettagliUtente.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * Torna le informazioni generali dell'utente desiderato.
   * @param email rappresenta l'email dell'utente per il quale si vogliono conoscere le informazioni
   * @return Utente oggetto che rappresenta l'utente per il 
   *         quale si vogliono conoscere le informaioni, in caso di successo
   *         null in caso contrario.
   */
  private Utente visualizzaDettagliUtente(String email) {
    ManagerFactory em = new ManagerFactory();
    AmministratoreManager am = (AmministratoreManager) em.createAmministratoreManager();
    Utente utente = null;
    try {
      utente = am.getUtente(email);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return utente;
  }

}
