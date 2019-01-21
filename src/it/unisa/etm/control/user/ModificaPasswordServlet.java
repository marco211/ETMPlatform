package it.unisa.etm.control.user;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende a classe HttpServlet e fornisce 
 * all'utente la funzionalita di poter modificare la password precedente.
 */
@WebServlet("/ModificaPasswordServlet")
public class ModificaPasswordServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  
  public ModificaPasswordServlet() {
    super();
  }

 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    utente.setPassword(request.getParameter("password"));
    if (modificaPasswordUtente(utente) == true) {
      response.sendRedirect(request.getContextPath() + "/homePage.jsp");
    } else {
      response.sendRedirect(request.getContextPath() + "/registrazioneFallita.jsp");
    } 
  }

  /**
   * Modifica la password precedentemente settata con quella nuova digitata dall'utente.
   * @param password stringa che rappresenta la password digitata dall'utente
   * @return boolean true se la modifica e andata a buon fine;
   *         false in caso contrario
   */
  private boolean modificaPasswordUtente(Utente utente) {
    ManagerFactory mf = new ManagerFactory();
    UtenteManager um = (UtenteManager) mf.createUtenteManager();
    return um.modificaPassword(utente);
  }
}
