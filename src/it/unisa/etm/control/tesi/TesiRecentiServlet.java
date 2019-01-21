package it.unisa.etm.control.tesi;

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
 *  Estende HttpServlet fornisce la funzionalita di visualizzazione
 *  delle ultime 8 tesi recenti all'interno della home page.
 */
@WebServlet("/TesiRecentiServlet")
public class TesiRecentiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public TesiRecentiServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    response.setContentType("text/plain");
    ManagerFactory factory = new ManagerFactory();
    PropostaTesiManager pt = (PropostaTesiManager)factory.createPropostaTesiManager();
    ArrayList<PropostaTesi> list = pt.getTesiRecenti();
    StringBuffer html = new StringBuffer();
    if (list != null) {
      html.append("<table class=\"table table-striped\">");
      html.append("<thead>\n" 
          +
          "<tr>\n"
          +
          "<th scope=\"col\">#</th>\n" 
          +
          "<th scope=\"col\">Titolo Proposta Tesi</th>\n"
          +  
          "</tr>\n" 
          + 
          "</thead>");
      for (int i = 0; i < list.size(); i++) {
        html.append("<tbody>");
        html.append("<tr>");
        html.append("<td>" + (i + 1) + "</td>");
        html.append("<td><a href=\"VisualizzaDettagliTesiServlet?propostatesi_id=" + list.get(i).getId() + "\">" + list.get(i).getTitolo() + "</a></td>");
        html.append("</tr>");
        html.append("</tbody>");
      }
      html.append("</table>");
      response.getWriter().write(html.toString());
    } else {
      response.getWriter().write("Non ci sono tesi");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}