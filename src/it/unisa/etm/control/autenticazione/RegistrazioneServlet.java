package it.unisa.etm.control.autenticazione;

import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.AutenticazioneManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Estende HttpServlet e fornisce la funzionalit� di registrazione.
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public RegistrazioneServlet() {
    super();
  }



  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String nome = request.getParameter("nome");
    String cognome = request.getParameter("cognome");
    String password = request.getParameter("password");
    String data =  request.getParameter("data");
    String tipo = request.getParameter("tipo");
    String validazione = UUID.randomUUID().toString();
    Utente utente = null;
    if (tipo.equals("s")) {
      String matricola = request.getParameter("matricola");
      utente = new Utente(cognome, data, nome, tipo, email, password, matricola, validazione);
    } else {
      String insegnamento = request.getParameter("insegnamento").toLowerCase();
      String ufficio = request.getParameter("ufficio");
      utente = new Utente(cognome, data, 
          ufficio, tipo, nome, email, password, insegnamento, validazione);
    }
    String testo = "<html>\r\n" 
        + "<head>\r\n" 
        + "<meta charset=\"ISO-8859-1\">\r\n" 
        + "<title>ETM Platform</title>\r\n" 
        + "</head>\r\n" 
        + "<body>\r\n" 
        + "\r\n" 
        + "<h1>Benvenuto su ETM-Platform</h1>" 
        + "Gentile utente,<br>" 
        + "abbiamo ricevuto la vostra richiesta di registrazione ed "
        + "e richiesta la vostra conferma per completare la procedura. <br>" 
        + "La invitiamo a cliccare sul link in basso "
        + "per confermare la registrazione ad ETM-Platform:<br>" 
        + "<a href=\"http://localhost:8080/ETMPlatform/ConfermaMailServlet?validazione=" + validazione + "\"" + ">Conferma registrazione</a> <br>" 
        + "Cordiali saluti.<br>"
        + "\r\n"
        + "</body>\r\n" 
        + "</html>";
    if (registrazioneControl(utente)) {
      if (sendEmail(email, testo)) {
        response.sendRedirect(request.getContextPath() + "/registrazioneRiuscita.jsp");
      } else {
        response.sendRedirect(request.getContextPath() + "/registrazioneFallita.jsp");
      }
    } else {
      response.sendRedirect(request.getContextPath() + "/registrazioneFallita.jsp");
    }
  }

  /**
   * Effettua la registrazione di un utente.
   * @param utente non ancora registrato, ma che ha inserito gi� i parametri si registrazione.
   * @return boolean true se la registrazione � andata a buono fine;
   *         false in caso di insuccesso.
   */
  private boolean registrazioneControl(Utente utente) {
    ManagerFactory mf = new ManagerFactory();
    AutenticazioneManager am = (AutenticazioneManager) mf.createAutenticazioneManager();
    if (am.registraUtente(utente)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Metodo sendEmail.
   */

  public static boolean sendEmail(String ricevente, String testo) {
    Properties prop = System.getProperties();
    prop.setProperty("mail.transport.protocol", "smtp");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    Session session = Session.getDefaultInstance(prop, null);
    Message msg = new MimeMessage(session);
    InternetAddress sender = null;
    InternetAddress receiver = null;
    try {
      sender = new InternetAddress("emtplatform@gmail.com", "ETM-Platform");
      receiver = new InternetAddress(ricevente, "Email ricevente");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return false;
    }
    try {
      msg.setFrom(sender);
      msg.setRecipient(Message.RecipientType.TO, receiver);
      msg.setSubject("Conferma registrazione"); 
      msg.setContent(testo, "text/html"); 
    } catch (MessagingException e) {
      e.printStackTrace();
      return false;
    }
    try {
      Transport transport = session.getTransport();
      transport.connect("smtp.gmail.com", "etmplatform@gmail.com", "Prova1234");
      transport.sendMessage(msg, msg.getAllRecipients());
    } catch (MessagingException e) {
      e.printStackTrace();
      return false;
    } 
    return true;
  }

}
