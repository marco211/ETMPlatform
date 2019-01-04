package it.unisa.etm.areacondivisa;

import java.io.IOException;
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


/**
 * Estende HttpServlet fornisce la funzionalità di caricare un file nell'area privata condivisa.
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
		file.setEmail(utente.getEmail());
		Part filePart=request.getPart("uploadFile");
		String fileName = extractFileName(filePart);
		String estensione=extractExtension(fileName);
		file.setNome(nome+"."+estensione);
		file.setFilePart(filePart);
		int tesi=0;
		if(utente.getTipo().equals("s")) {
			file.setPropostaTesiId(utente.getPropostaTesi_ID());
		}
		else {
			tesi=(int)request.getSession().getAttribute("numeroTesiDocente");
			file.setPropostaTesiId(tesi);
		}
		LocalDate data=LocalDate.now();
		Attivita attivita=new Attivita(file.getEmail(), file.getNome(), data ,"c",file.getPropostaTesiId());
		ManagerFactory mf=new ManagerFactory();
		FileManager fm=(FileManager) mf.createFileManager();
		AttivitaManager am=(AttivitaManager)mf.createAttivitaManager();
			if(fm.aggiungiFile(file)&&am.aggiungiAttivita(attivita)) {
			
			if(utente.getTipo().equals("d")) {
				RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/VisualizzaListaFileServlet?idTesi="+tesi);
				requestDispatcher.forward(request, response);
			}
			else {
				RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/VisualizzaListaFileServlet?idTesi="+utente.getPropostaTesi_ID());
				requestDispatcher.forward(request, response);
			}
			}
			else {
			request.setAttribute("carica", "Errore nel caricamento, riprova");
			RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/caricaFile.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	
	private String extractFileName(Part part) {
		//content-disposition: form-data; name="file"; filename="file.txt"
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
	
	private String extractExtension(String name) {
		int i=name.indexOf(".");
		String temp=name.substring(i+1, name.length());
		return temp;
	}
}
