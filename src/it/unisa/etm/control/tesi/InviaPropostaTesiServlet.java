package it.unisa.etm.control.tesi;

import it.unisa.etm.model.bean.RichiestaPartecipazione;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Estende la classe HttpServlet ed offre all'utente registrato come studente 
 * la funzionalita di poter inviare all'utente registrato come docente una 
 * richiesta di tesi per una determinata proposta tesi.
 */
@WebServlet("/InviaPropostaTesiServlet")
public class InviaPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public InviaPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    LocalDate data = LocalDate.now();
    int propostaTesiId = Integer.parseInt(request.getParameter("propostatesi_id"));
    Utente utente = (Utente) session.getAttribute("utente");
    String utenteEmail = utente.getEmail();
    RichiestaPartecipazione richiesta = 
        new RichiestaPartecipazione(data, propostaTesiId, utenteEmail);
    if (this.inviaRichiestaPropostaTesi(richiesta)) {
      session.setAttribute("richiesta", richiesta);
      response.sendRedirect(request.getContextPath() + "/ListaProposteTesiAttiveServlet");
    } else {
      int count = 4;
      request.setAttribute("count", count);
      request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * Invia al docente la richiesta di proposta tesi fatta dall'utente 
   * registrato come studente e passata come input al metodo.
   * @param richiesta rappresenta la richesta per la proposta di tesi 
   *        effettuata dall'utente registrato come studente.
   * @return boolean true se l'invio e avvenuto con successo.
   *         false se non e avvenuto con successo.
   */
  private boolean inviaRichiestaPropostaTesi(RichiestaPartecipazione richiesta) {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    return ptm.inserisciRichiestaPartecipazione(richiesta);
  }
}
