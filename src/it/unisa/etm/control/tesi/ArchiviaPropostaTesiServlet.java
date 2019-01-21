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
 * Estende la classe HttpServlet ed offre all'utente registrato 
 * come docente la possibilita di archiviare una propria proposta di tesi.
 */
@WebServlet("/ArchiviaPropostaTesiServlet")
public class ArchiviaPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ArchiviaPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int propostaTesiId = Integer.parseInt(request.getParameter("propostatesi_id"));
    if (this.archiviaPropostaTesi(propostaTesiId)) {
      response.sendRedirect(request.getContextPath() + "/ListaProposteTesiAttiveServlet");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * Archivia la proposta di tesi scelta dall'utente registrato come docente, 
   * aggiungendola alla lista di quelle archiviate.
   * @param propostaTesiId rappresenta 'identificativo della proposta di tesi 
   *        scelta dall'utente registrato come docente.
   * @return boolean true se l'archiviazione e avvenuta con successo.
   *         false in caso di fallimento.
   */
  
  private boolean archiviaPropostaTesi(int propostaTesiId) {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    return ptm.archiviaPropostaTesi(propostaTesiId);
  }
}
