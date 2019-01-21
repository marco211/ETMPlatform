package it.unisa.etm.control.user;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.manager.UtenteManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende la classe HttpServlet e fornisce 
 * ad un utente la funzionalita di poter cercare un altro utente.
 */
@WebServlet("/CercaUtenteServlet")
public class CercaUtenteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public CercaUtenteServlet() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String email = request.getParameter("cerca");
    try {
      UtenteManager um = new UtenteManager();
      Utente utenti = (Utente) um.cercaUtente(email);
      request.setAttribute("utenti", utenti);
      request.getRequestDispatcher("visualizzaProfiloUtente.jsp").forward(request, response);
    } catch (Exception e) {
      request.getRequestDispatcher("index.jsp").forward(request, response);
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
