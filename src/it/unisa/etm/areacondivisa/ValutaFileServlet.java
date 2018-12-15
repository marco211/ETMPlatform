package it.unisa.etm.areacondivisa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.etm.bean.File;

/**
 * Estende HttpServlet, fornisce all'utente registrato come docente la funzionalità di poter valutare un file presente nell'area privata condivisa
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Esegue il controllo sui parametri di valutazione che deve ricevere un file presente nell'area privata condivisa.
	 * @param valutazione intero che rappresenta il voto che deve ricevere un file.
	 * @param descrizione stringa che rappresenta la descrizione che deve ricevere un file.
	 * @return boolean true se la valutazione è stata data ed è tra 1 e 10;
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
	 * 0 se il file non è stato valutato.
	 */
	private int getValutazione(File file){
		return 0;
		
	}
}
