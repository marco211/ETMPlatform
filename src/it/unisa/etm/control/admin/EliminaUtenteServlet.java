package it.unisa.etm.control.admin;

import java.io.IOException;
import java.sql.SQLException;

import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AmministratoreManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet fornisce all'amministratore la possibilita di eliminare un utente.
 */
@WebServlet("/EliminaUtenteServlet")
public class EliminaUtenteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;       
    

 
  public EliminaUtenteServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String email = (String) request.getParameter("utente_email");
    try {
      if (this.eliminaUtente(email)) {
        response.sendRedirect(request.getContextPath() + "/ListaUtentiServlet");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

 /**
* Accede all'elenco di utenti ed elimina l'utente preso in input;
* Il metodo ritorna un booleano.
* @param utente da cercare
* @return boolean: true se l'eliminazione viene eliminata con success, false altrimenti
* @throws SQLException exception
 */

  private boolean eliminaUtente(String email) 
      throws SQLException {
    ManagerFactory mf = new ManagerFactory();
    AmministratoreManager am = (AmministratoreManager) mf.createAmministratoreManager();
    if(!email.equals("")) 
			return am.eliminaUtente(email);
		else 
			return false;
	}

}

