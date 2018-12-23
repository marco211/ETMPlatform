package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.etm.bean.File;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.FileManager;


/**
 * Estende HttpServlet fornisce la funzionalit� di caricare un file nell'area privata condivisa.
 */
@WebServlet("/CaricaFileServlet")
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
		File file=new File();
		file.setDescrizione("mammt");
		file.setEmail("a@unisa.it");
		Part filePart=request.getPart("uploafile");
		if(filePart!=null) {
			file.setNome(filePart.getName());
		}
		
		file.setPropostaTesiId(1);
		ManagerFactory mf=new ManagerFactory();
		FileManager fm= (FileManager) mf.createFileManager();
		try {
			fm.aggiungiFile(file,filePart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("./caricaFile.jsp").forward(request, response);
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
