package it.unisa.etm.tesi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.PropostaTesi;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.PropostaTesiManager;

/**
 * Servlet implementation class TesiRecentiServlet
 */
@WebServlet("/TesiRecentiServlet")
public class TesiRecentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesiRecentiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		ManagerFactory factory=new ManagerFactory();
		PropostaTesiManager pt=(PropostaTesiManager)factory.createPropostaTesiManager();
		ArrayList<PropostaTesi>list=pt.getTesiRecenti();
		StringBuffer html=new StringBuffer();
		if(list!=null) {
		html.append("<table class=\"table table-striped\">");
		html.append("<thead>\n" + 
				"			<tr>\n" + 
				"				<th scope=\"col\">#</th>\n" + 
				"				<th scope=\"col\">Titolo Proposta Tesi</th>\n" +  
				"			</tr>\n" + 
				"		</thead>");
		for (int i = 0; i < list.size(); i++) {
		html.append("<tbody>");
		html.append("<tr>");
		html.append("<td>"+(i+1)+"</td>");
		html.append("<td><a href=\"VisualizzaDettagliTesiServlet?propostatesi_id="+list.get(i).getId()+"\">"+list.get(i).getTitolo()+"</a></td>");
		html.append("</tr>");
		html.append("</tbody>");
		}
		html.append("</table>");
		response.getWriter().write(html.toString());
		}
		else {
			response.getWriter().write("Non ci sono tesi");
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
