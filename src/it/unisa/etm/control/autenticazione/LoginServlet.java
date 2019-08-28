package it.unisa.etm.control.autenticazione;

import it.unisa.etm.model.bean.Amministratore;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;
import it.unisa.etm.model.manager.AutenticazioneManager;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Estende la classe HttpServlet e fonisce la funzionalita di login.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public LoginServlet() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String password = request.getParameter("passwordLogin");
    String email = request.getParameter("emailLogin");
    ManagerFactory em = new ManagerFactory();
    AutenticazioneManager am = (AutenticazioneManager) em.createAutenticazioneManager();
    Amministratore admin = am.getAdmin(email, password);
    AttivitaManager attivita = new AttivitaManager();
    if (admin != null) {
      HttpSession session = request.getSession();
      ArrayList<String> listaSeguaci = attivita.getListaSeguaci(admin.getEmail());
      session.setAttribute("admin", admin);
      session.setAttribute("listSeguaci", listaSeguaci);
      response.sendRedirect(request.getContextPath() + "/homePage.jsp");
    } else {
      Utente utente = am.getUtente(email, password);
      if (utente != null) {
        if (utente.getValidazione().equals("valido")) {
          
          ArrayList<String> listaSeguaci = attivita.getListaSeguaci(utente.getEmail());
          HttpSession session = request.getSession();
          session.setAttribute("utente", utente);
          session.setAttribute("listSeguaci", listaSeguaci);
          response.sendRedirect(request.getContextPath() + "/homePage.jsp");
        } else {
          response.sendRedirect(request.getContextPath() + "/login"
              + "FallitoRegistrazioneNonConfermata.jsp");
        }
      } else {
        response.sendRedirect(request.getContextPath() + "/loginFallitoAccountInesistente.jsp");
      }
    }
  }

}
