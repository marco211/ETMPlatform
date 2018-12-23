package it.unisa.etm.bean;

import java.io.*;
import java.io.Serializable;
import javax.servlet.http.*;
public class File implements Serializable	 {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public File() {
		
	}

	public File(String nome, int propostaId, String descrizione, int voto, String descrizioneVoto, String email) {
		super();
		
		this.nome = nome;
		this.email = email;
		this.descrizione = descrizione;
		this.descrizioneVoto = descrizioneVoto;
		this.voto = voto;
		this.setPropostaTesiId(propostaId);
	}
	

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getVoto() {
		return voto;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizioneVoto() {
		return descrizioneVoto;
	}

	public void setDescrizioneVoto(String descrizioneVoto) {
		this.descrizioneVoto = descrizioneVoto;
	}
	
	public int getPropostaTesiId() {
		return propostaTesiId;
	}

	public void setPropostaTesiId(int propostaTesiId) {
		this.propostaTesiId = propostaTesiId;
	}
	
	public Part getFilePart() {
		return filePart;
	}

	public void setFilePart(Part filePart) {
		this.filePart = filePart;
	}




	private int voto;
	private int propostaTesiId;
	private String descrizioneVoto;
	private String descrizione;
	private String email;
	private String nome;
	private Part filePart;
	
}