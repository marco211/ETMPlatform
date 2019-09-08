package it.unisa.etm.control.notifiche;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.unisa.etm.model.bean.Attivita;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;

/**
 * Servlet implementation class VisualizzaNotificheServlet
 */
@WebServlet("/CaricaNotificheServlet")
public class CaricaNotificheServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CaricaNotificheServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Utente utente = (Utente) request.getSession().getAttribute("utente");
    response.setContentType("application/json;charset=UTF-8");
    /*int propostaTesiId;
	    if (utente.getTipo().equals("d")) {
	      propostaTesiId = (int) request.getSession().getAttribute("numeroTesiDocente");
	    } else {
	      propostaTesiId = Integer.parseInt(request.getParameter("propostaTesiId"));
	    }
	    if (propostaTesiId != 0) {*/
    ManagerFactory em = new ManagerFactory();
    AttivitaManager attivitaManager = (AttivitaManager) em.createAttivitaManager();

    ArrayList<String> notifiche = new ArrayList<>();
    ArrayList<Attivita> atts = attivitaManager.getNotifiche(utente.getEmail());

    int countNonLetti = 0;

    if(atts != null) {
      for (Attivita at : atts) {
        notifiche.add(at.toString());
        notifiche.add(at.getLetto() == false? "0" : "1");

        if(!at.getLetto()) countNonLetti++;
      }
    }

    if(notifiche.isEmpty()) {
      response.getWriter().write(new Gson().toJson("no"));
    } else {
      notifiche.add(0, Integer.toString(countNonLetti));
      response.getWriter().write(new Gson().toJson(notifiche));
    }
    //}



  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
