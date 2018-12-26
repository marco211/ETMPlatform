package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

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
/*@MultipartConfig(maxFileSize = 16177215)*/
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB after which the file will be 
//temporarily stored on disk
maxFileSize = 1024 * 1024 * 100, // 10MB maximum size allowed for uploaded files
maxRequestSize = 1024 * 1024 * 100) // 50MB overall size of all uploaded files

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
		file.setDescrizione(descrizione);
		file.setNome(nome);
		file.setEmail(utente.getEmail());
		Part filePart=request.getPart("uploadFile");
		file.setFilePart(filePart);
		if(utente.getTipo().equals("s")) {
			file.setPropostaTesiId(utente.getPropostaTesi_ID());
		}
		else {
			int tesi=(int)request.getSession().getAttribute("numeroTesiDocente");
			file.setPropostaTesiId(tesi);
		}
		LocalDate data = LocalDate.now();
		Attivita attivita = new Attivita(file.getEmail(), file.getNome(), data ,"c",file.getPropostaTesiId());
		ManagerFactory mf=new ManagerFactory();
		FileManager fm= (FileManager) mf.createFileManager();
		AttivitaManager am=(AttivitaManager)mf.createAttivitaManager();
		try {
			fm.aggiungiFile(file);
			am.aggiungiAttivita(attivita);
		} catch (SQLException e) {
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
