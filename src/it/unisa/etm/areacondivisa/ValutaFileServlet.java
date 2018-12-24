package it.unisa.etm.areacondivisa;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.File;
import it.unisa.etm.factory.ManagerFactory;
import it.unisa.etm.model.manager.AreaCondivisaManager;
import it.unisa.etm.model.manager.FileManager;

/**
 * Estende HttpServlet, fornisce all'utente registrato come docente la funzionalit� di poter valutare un file presente nell'area privata condivisa
 */
@WebServlet("/ValutaFileServlet")
public class ValutaFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValutaFileServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int id=Integer.parseInt(request.getParameter("idTesi"));
		String nomeFile=request.getParameter("nomeFile");
		int voto=Integer.parseInt(request.getParameter("voto"));
		String descrizione=request.getParameter("descrizione");
		ManagerFactory em = new ManagerFactory();
		FileManager um = (FileManager) em.createFileManager();
		try {
			um.modificaFile(id, nomeFile, voto, descrizione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view=getServletContext().getRequestDispatcher("/areaPrivataCondivisaDocente.jsp");
		view.forward(request, response);
		
	}

	private boolean inserisciValutazione(int voto, String descrizione) {
		ManagerFactory mf=new ManagerFactory();
		AreaCondivisaManager fm= (AreaCondivisaManager) mf.createAreaCondivisaManager();
		return true;
		
	}
	
	/**
	 * Esegue il controllo sui parametri di valutazione che deve ricevere un file presente nell'area privata condivisa.
	 * @param valutazione intero che rappresenta il voto che deve ricevere un file.
	 * @param descrizione stringa che rappresenta la descrizione che deve ricevere un file.
	 * @return boolean true se la valutazione � stata data ed � tra 1 e 10;
	 * <p>
	 * false se la valutazione non rispetta i parametri.
	 */
	private boolean isValid(int valutazione, String descrizione){
		return false;
		
	}
	
	/**
	 * Torna la valutazione di un determinato file presente nell'area privata condivisa e preso in input.
	 * @param file presente nell'area condivisa.
	 * @return int che rappresenta la valutazione del file
	 * <p>
	 * 0 se il file non � stato valutato.
	 */
	private int getValutazione(File file){
		return 0;
		
	}
}
