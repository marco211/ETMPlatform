package it.unisa.etm.control.admin;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.manager.AmministratoreManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet fornisce all'amministratore 
 * la funzionalita di visualizzare gli utenti registrati.
 */
@WebServlet("/ListaUtentiServlet")
public class ListaUtentiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  
  public ListaUtentiServlet() {
    super();
  }

 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      AmministratoreManager am = new AmministratoreManager();
      ArrayList<Utente> utenti = (ArrayList<Utente>) am.getListaUtenti();
      request.setAttribute("utenti", utenti);
      request.getRequestDispatcher("visualizzaListaUtenti.jsp").forward(request, response);
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
