package it.unisa.etm.control.tesi;

import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet fornisce la funzionalita di rifiutare una richiesta 
 * di un untente registrato come studente da parte di un utente registrato come docente.
 */
@WebServlet("/RifiutaRichiestaServlet")
public class RifiutaRichiestaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RifiutaRichiestaServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int propostaTesiId = Integer.parseInt(request.getParameter("richiesta_id"));
    if (this.rifiutaRichiestaPropostaTesi(propostaTesiId)) {
      response.sendRedirect(request.getContextPath() + "/ListaProposteTesiAttiveServlet");
    } else {
      int count = 5;
      request.setAttribute("count", count);
      request.getRequestDispatcher("aggiungiPropostaTesiFail.jsp").forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
  
  /**
   * Permette all'utente registrato come docente di 
   * rifiutare una richiesta di partecipazione per una proposta di tesi.
   * @param id che identifica la proposta di tesi alla 
   *        quale l'utente registrato come studente vuole partecipare
   * @return booleano che e true se il rifiuto della richiesta e andato a buon fine
   *         false altrimenti;
   */
  private boolean rifiutaRichiestaPropostaTesi(int id) {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    return ptm.rifiutaRichiestaPartecipazione(id);
  }
}