package it.unisa.etm.autenticazione;
//prova

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
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

import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AutenticazioneManager;


/**
 * Estende la classe HttpServlet e fornisce all'utente la funzionalità di poter recuperare la sua password.
 */
@WebServlet("/RecuperaPasswordServlet")
public class RecuperaPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		if(this.inviaPassword(email))
		{
			response.sendRedirect(request.getContextPath()+"/recuperoPasswordRiuscito.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/recuperoPasswordNonRiuscito.jsp");
		}
	}
	
	/**
	 * Permette il recupero della password dell'utente prendendo in input la mail di quest'ultimo
	 * @param email dell'utente registrato
	 * @return boolean true se il rest è riuscito;
	 * <p>
	 * false se non è riusito.
	 */
	private boolean inviaPassword(String email){
		ManagerFactory mf=new ManagerFactory();
		AutenticazioneManager am=(AutenticazioneManager) mf.createAutenticazioneManager();
		String password=am.getPassword(email);
		if(password==null)
			return false;
		if(send(email, password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean send(String ricevente, String testo) {
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
			addForm = new InternetAddress("emtplatform@gmail.com", "ETM-Platform");
			msg.setFrom(addForm);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
        

        InternetAddress addTo;
		try {
			addTo = new InternetAddress(ricevente);
	        msg.setRecipient(Message.RecipientType.TO, addTo);
	        msg.setSubject("Recupero password"); 
	        msg.setContent("<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>ETM Platform</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<h1>Benvenuto su ETM-Platform</h1>" +
					"Gentile utente,<br>" +
					"abbiamo ricevuto la vostra richiesta di recupero password. <br>" +
					"Password: \"" + testo + "\".<br>" +
					"Le ricordiamo che è possibile cambiare la password una volta effettuato l'accesso con il vostro account all'apposita sezione.<br>" +
					"Cordiali saluti.<br>" +
					"\r\n" + 
					"</body>\r\n" + 
					"</html>", "text/html"); 
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}


        
        
        Transport transport;
		try {
			transport = session.getTransport();
	        transport.connect("smtp.gmail.com", "etmplatform@gmail.com", "Prova1234"); 
	        transport.sendMessage(msg, msg.getAllRecipients());
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }
	
}
