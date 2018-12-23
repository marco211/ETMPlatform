package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javax.servlet.annotation.*;

import it.unisa.etm.bean.Attivita;
import it.unisa.etm.bean.File;
import it.unisa.etm.bean.Utente;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AttivitaManager;
import it.unisa.etm.model.manager.FileManager;
import it.unisa.etm.tesi.ArchiviaPropostaTesiServlet;


/**
 * Estende HttpServlet fornisce la funzionalit� di caricare un file nell'area privata condivisa.
 */
@WebServlet("/CaricaFileServlet")
@MultipartConfig(maxFileSize = 16177215)

public class CaricaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaricaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("nomeFile");
		String descrizione=request.getParameter("descrizioneFile");
		Utente utente=(Utente)request.getSession().getAttribute("utente");
		File file=new File();
		file.setDescrizione("adhsjadgs");
		file.setNome(nome);
		file.setEmail(utente.getEmail());
		Part filePart=request.getPart("uploadFile");
		file.setFilePart(filePart);
		Attivita attivita=new Attivita();
		attivita.setNomeFile(nome);
		attivita.setTipo("c");
		attivita.setUtente_Email(utente.getEmail());
		attivita.setData(new Date(11,11,2011));
		if(utente.getTipo().equals("s")) {
			attivita.setId(utente.getPropostaTesi_ID());
			file.setPropostaTesiId(utente.getPropostaTesi_ID());
			System.out.println(utente.getPropostaTesi_ID());
	}
		else {
			int tesi=(int)request.getSession().getAttribute("numeroTesiDocente");
			file.setPropostaTesiId(tesi);
		}
		
		ManagerFactory mf=new ManagerFactory();
		FileManager fm= (FileManager) mf.createFileManager();
		AttivitaManager am=(AttivitaManager)mf.createAttivitaManager();
		try {
			fm.aggiungiFile(file);
			am.aggiungiAttivita(attivita);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/homePage.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * Aggiunge un file all'area privata condivisa
	 * @param file caricato dall'utente 
	 * @return boolean true se il caricamento � avvenuto con successo;
	 * <p>
	 * false in caso di insuccesso.
	 */
	private boolean uploadFileControl(File file){
		

		return true;
	}
}
