package it.unisa.etm.control.user;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Estende la casse HttpServlet e fornisce all'utente 
 * la funzionalit� di poter modificare il proprio profilo.
 */
@WebServlet("/ModificaProfiloUtenteServlet")
public class ModificaProfiloUtenteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public ModificaProfiloUtenteServlet() {
    super();
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    //utente.setNome( request.getParameter("nome"));
    //utente.setCognome( request.getParameter("cognome"));
    //utente.setDataDiNascita(request.getParameter("data"));
    if (utente.getTipo().equals("s")) {
      utente.setMatricola(request.getParameter("matricola"));
    } else {
      utente.setUfficio(request.getParameter("ufficio"));
    }
    if (modificaProfiloUtente(utente) == true) {
      RequestDispatcher requestDispatcher = 
          getServletContext().getRequestDispatcher("/visualizzaProfiloUtente.jsp");
      requestDispatcher.forward(request, response);
    } else {
      response.sendRedirect(
          request.getContextPath() + "/registrazioneFallita.jsp");
    }
  }
  /**
   * Riceve le modifiche effettuate dall'utente e le appliche al profilo di quest'ultimo.
   * @param utente rappresenta il profilo modificato dall'utente
   * @return boolean true se le modifiche sono andate a buon fine;
   *         false in caso contrario.
   */

  private boolean modificaProfiloUtente(Utente utente) {
    ManagerFactory mf = new ManagerFactory();
    UtenteManager um = (UtenteManager) mf.createUtenteManager();
    return um.modificaUtente(utente);
  }

}
