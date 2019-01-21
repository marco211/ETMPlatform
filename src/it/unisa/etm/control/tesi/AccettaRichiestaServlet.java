package it.unisa.etm.control.tesi;

import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PartecipaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet fornisce la funzionalita di accettazione di una richiesta di un untente 
 * registrato come studente da parte di un utente registrato come docente.
 */
@WebServlet("/AccettaRichiestaServlet")
public class AccettaRichiestaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AccettaRichiestaServlet() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int propostaTesiId = Integer.parseInt(request.getParameter("richiesta_id"));
    String utenteEmail = request.getParameter("utente_email");
    if (this.accettaRichiestaPropostaTesi(propostaTesiId,utenteEmail)) {
      request.getSession().removeAttribute("listaPartecipazione");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
      int count = 2;
      request.setAttribute("count", count);
      request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

  private boolean accettaRichiestaPropostaTesi(int id, String utenteEmail) { 
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    PartecipaManager pm = (PartecipaManager) mf.createPartecipaManager();
    boolean i = pm.inserisciPartecipazione(id, utenteEmail);
    boolean a = ptm.accettaRichiestaPartecipazione(id);
    if (a == i) {
      return true;
    } else {
      return false;
    }
  }
}