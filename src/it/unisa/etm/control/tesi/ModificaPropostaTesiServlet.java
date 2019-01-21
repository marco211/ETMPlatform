package it.unisa.etm.control.tesi;

import it.unisa.etm.model.bean.Insegnamento;
import it.unisa.etm.model.bean.PropostaTesi;
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
 * Estende la classe HttpServlet e fornisce all'utente registrato 
 * come docente la possibilita di aggiungere una nuova proposta di tesi.
 */
@WebServlet("/ModificaPropostaTesiServlet")
public class ModificaPropostaTesiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ModificaPropostaTesiServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    PropostaTesi p = new PropostaTesi();
    p.setTitolo(request.getParameter("propostatesi_titolo"));
    p.setAmbito(request.getParameter("propostatesi_ambito"));
    p.setTempoDiSviluppo(Integer.parseInt(request.getParameter("propostatesi_tempo")));
    p.setDecrizione(request.getParameter("propostatesi_descrizione"));
    p.setMaterie(request.getParameter("propostatesi_materia"));
    int id = Integer.parseInt(request.getParameter("propostatesi_id"));
    p.setId(id);
    request.setAttribute("propostacorrente", p);
    ArrayList<Insegnamento> insegnamenti = this.getInsegnamenti();
    request.setAttribute("insegnamenti", insegnamenti);
    request.getRequestDispatcher("modificaPropostaTesi.jsp").forward(request, response);
  }



  /**
   * Ritorna la lista degli insegnamenti dei docenti.
   */
  private ArrayList<Insegnamento> getInsegnamenti() {
    ManagerFactory mf = new ManagerFactory();
    PropostaTesiManager ptm = (PropostaTesiManager) mf.createPropostaTesiManager();
    ArrayList<Insegnamento> insegnamenti = new ArrayList<Insegnamento>();
    insegnamenti = ptm.getInsegnamenti();
    return insegnamenti;
  }
}
