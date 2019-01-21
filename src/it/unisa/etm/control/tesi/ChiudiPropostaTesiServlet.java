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
 * Estende la classe HttpServlet ed offre all'utente registrato come 
 * docente la funzionalita di poter chiudere una propria proposta di tesi.
 */
@WebServlet("/ChiudiPropostaTesiServlet")
public class ChiudiPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ChiudiPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int propostaTesiId = Integer.parseInt(request.getParameter("propostatesi_id"));
    if (this.chiudiPropostaTesi(propostaTesiId)) {
      response.sendRedirect(request.getContextPath() + "/ListaProposteTesiAttiveServlet");
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * Chiude la proposta di tesi presa in input ritornado.
   * @param propostaTesiId rappresenta l'identificativo della proposta 
   *        di tesi che si vuole chiusere.
   * @return boolean true se la proposta e stata chiusa con successo.
   *         false se la proposta non e stata chiusa.
   */
  private boolean chiudiPropostaTesi(int propostaTesiId) {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    return ptm.chiudiPropostaTesi(propostaTesiId);
  }

}
