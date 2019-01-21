package it.unisa.etm.control.autenticazione;

import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AutenticazioneManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Estende HttpServlet permette all'utente di 
 * confermare la propria registrazione inviando una mail alla sua posta elettronica.
 */
@WebServlet("/ConfermaMailServlet")
public class ConfermaMailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

 
  public ConfermaMailServlet() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String validazione = request.getParameter("validazione");
    ManagerFactory mf = new ManagerFactory();
    AutenticazioneManager am = (AutenticazioneManager) mf.createAutenticazioneManager();
    if (am.setValidazione(validazione)) {
      response.sendRedirect(request.getContextPath() + "/confermaRegistrazioneRiuscita.jsp");
    } else {
      response.sendRedirect(request.getContextPath() + "/confermaRegistrazioneNonRiuscita.jsp");
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
