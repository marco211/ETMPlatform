package it.unisa.etm.autenticazione;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.UtenteManager;

/**
 * Estende HttpServlet e fornisce la funzionalit� di registrazione.
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String password=request.getParameter("password");
		String data=request.getParameter("data");
		String tipo=request.getParameter("tipo");
		String validazione=UUID.randomUUID().toString();
		Utente utente;
		if(tipo.equals("s"))
		{
			long matricola=Long.parseLong(request.getParameter("matricola"));
			utente=new Utente(cognome, data, nome, tipo, email, password, matricola, validazione);
		}
		else
		{
			String insegnamento=request.getParameter("insegnamento").toLowerCase();
			String ufficio=request.getParameter("ufficio");
			utente=new Utente(cognome, data, ufficio, tipo, nome, email, password, insegnamento, validazione);
		}
		String testo="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>ETM Platform</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"copia il link in descrizione ed aprilo per confermare registrazione <br>" +
				"\"localhost:8080/ETMPlatform/ConfermaMailServlet?validazione=" + validazione + "\"" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		if(registrazioneControl(utente))
		{
			try {
				send(email, testo);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}



	/**
	 * Effettua la registrazione di un utente.
	 * @param utente non ancora registrato, ma che ha inserito gi� i parametri si registrazione.
	 * @return boolean true se la registrazione � andata a buono fine;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean registrazioneControl(Utente utente){
		ManagerFactory mf=new ManagerFactory();
		UtenteManager um=(UtenteManager) mf.createUtenteManager();
		try {
			um.registraUtente(utente);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public static void send(String ricevente, String testo) throws AddressException, MessagingException {
        Properties prop = System.getProperties();
        
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(prop, null);
        Message msg = new MimeMessage(session);
        InternetAddress addForm;
		try {
			addForm = new InternetAddress("emtplatform@gmail.com", "etm platform");
			msg.setFrom(addForm);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        InternetAddress addTo = new InternetAddress(ricevente);

        msg.setRecipient(Message.RecipientType.TO, addTo);
        msg.setSubject("Conferma registrazione"); 
        msg.setContent(testo, "text/html"); 
        
        
        Transport transport=session.getTransport();
        transport.connect("smtp.gmail.com", "etmplatform@gmail.com", "Prova1234"); 
        transport.sendMessage(msg, msg.getAllRecipients());
    }
	
}
