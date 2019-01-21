package it.unisa.etm.control.areacondivisa;

import it.unisa.etm.model.bean.File;
import it.unisa.etm.model.factory.ManagerFactory;
import it.unisa.etm.model.manager.FileManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Estende HttpServlet e fornisce all'utente 
 * la funzionalit� di poter scaricare un file presente nell'area privata condivisa.
 */
@WebServlet("/ScaricaFileServlet")
public class ScaricaFileServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

 
  public ScaricaFileServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String nome = request.getParameter("nomeFile");
    int id = Integer.parseInt(request.getParameter("tesiID"));
    ManagerFactory mf = new ManagerFactory();
    FileManager fm = (FileManager) mf.createFileManager();
    File file = fm.scaricaFile(id, nome);
    InputStream stream = file.getInputStream();
    int fileLength = stream.available();
    ServletContext context = getServletContext();
    String mimeType = context.getMimeType(file.getNome());
    if (mimeType == null) {        
      mimeType = "application/octet-stream";
    }     
    response.setContentType(mimeType);
    response.setContentLength(fileLength);
    String headerKey = "Content-Disposition";
    String headerValue = String.format("attachment; filename=\"%s\"", file.getNome());
    response.setHeader(headerKey, headerValue);
    OutputStream outStream = response.getOutputStream();   
    int bufferSize = 4096;
    byte[] buffer = new byte[bufferSize];
    int bytesRead = -1;
    while ((bytesRead = stream.read(buffer)) != -1) {
      outStream.write(buffer, 0, bytesRead);
    }
    stream.close();
    outStream.close();
  }

}
