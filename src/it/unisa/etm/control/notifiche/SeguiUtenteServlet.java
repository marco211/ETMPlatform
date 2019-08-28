package it.unisa.etm.control.notifiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.google.gson.Gson;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;

/**
 * Servlet implementation class SeguiUtenteServlet
 */
@WebServlet("/SeguiUtenteServlet")
public class SeguiUtenteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SeguiUtenteServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ManagerFactory em = new ManagerFactory();
    AttivitaManager attivitaManager = (AttivitaManager) em.createAttivitaManager();

    String tipoOp = (String) request.getParameter("tipoop");

    String emailFollower = (String) request.getParameter("follower");
    String emailToFollow = (String) request.getParameter("toFollow");
    boolean addPropTesi = "true".equals(request.getParameter("addprop")) ? true : false;
    boolean changePropTesi = "true".equals(request.getParameter("changeprop")) ? true : false;
    boolean disabilitaPropTesi = "true".equals(request.getParameter("disprop")) ? true : false;

    response.setContentType("application/json;charset=UTF-8");

    if("delete".equals(tipoOp)) {
      if(attivitaManager.unfollow(emailFollower, emailToFollow)) {

        response.getWriter().write(new Gson().toJson("ok"));
      } else {

        response.getWriter().write(new Gson().toJson("error"));
      }
    } else if(attivitaManager.seguiUtente(emailFollower, emailToFollow, addPropTesi, changePropTesi, disabilitaPropTesi)) {

      response.getWriter().write(new Gson().toJson("ok"));
    } else {
      response.getWriter().write(new Gson().toJson("error"));

    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
