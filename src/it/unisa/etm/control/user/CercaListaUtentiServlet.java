package it.unisa.etm.control.user;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Estende HttpServlet fornisce la funzionalita di 
 * effettuare una ricerca di un utente indicando il nome ed il cognome di questo.
 */
@WebServlet("/CercaListaUtentiServlet")
public class CercaListaUtentiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public CercaListaUtentiServlet() {
    super();
    // TODO Auto-generated constructor stub
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String cerca = request.getParameter("cerca");
    String option = request.getParameter("option");
    ManagerFactory factory = new ManagerFactory();
    UtenteManager um = (UtenteManager)factory.createUtenteManager();
    ArrayList<Utente> list = null;
    if (option.equals("nome")) {
      list = um.cercaListaUtenteNome(cerca);
    } else if (option.equals("cognome")) {
      list = um.cercaListaUtenteCognome(cerca);
    }
    if (list == null) {
      RequestDispatcher requestDispatcher =
          getServletContext().getRequestDispatcher("/homePage.jsp");
      requestDispatcher.forward(request, response);
    } else {
      request.setAttribute("listaUtenti",list);
      RequestDispatcher requestDispatcher =
          getServletContext().getRequestDispatcher("/cercaUtente.jsp");
      requestDispatcher.forward(request, response);
    }
  }

}
