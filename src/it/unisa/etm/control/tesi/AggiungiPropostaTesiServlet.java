package it.unisa.etm.control.tesi;

import it.unisa.etm.model.bean.Insegnamento;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende la classe HttpServlet e fonisce all'utente registrato come 
 * docente la possibilita di aggiungere una nuova proposta di tesi.
 */
@WebServlet("/AggiungiPropostaTesiServlet")
public class AggiungiPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AggiungiPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    ArrayList<Insegnamento> insegnamenti = this.getInsegnamenti();
    request.setAttribute("insegnamenti", insegnamenti);
    request.getRequestDispatcher("aggiungiPropostaTesi.jsp").forward(request, response);
  }


  /**
   * Ritorna la lista degli insegnamenti dei docenti.
   * @return lista degli insegnamenti
   *         null in caso di errore o che non sono prensenti insegnamenti.
   */
  
  private ArrayList<Insegnamento> getInsegnamenti() {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    ArrayList<Insegnamento> insegnamenti = new ArrayList<Insegnamento>();
    insegnamenti = ptm.getInsegnamenti();
    return insegnamenti;
  }
}
