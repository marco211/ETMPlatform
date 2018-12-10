package it.unisa.etm.bean;

import java.io.Serializable;

public class File implements Serializable	 {
	
	public File() {
		
	}

	public File(String nome, int propostatesi_id, String descrizione, int voto, String descrizione_voto, String email) {
		super();
		this.propostatesi_id = propostatesi_id;
		this.nome = nome;
		this.email = email;
		this.descrizione = descrizione;
		this.descrizione_voto = descrizione_voto;
		this.voto = voto;
	}


	public int getPropostatesi_id() {
		return propostatesi_id;
	}


	public void setPropostatesi_id(int propostatesi_id) {
		this.propostatesi_id = propostatesi_id;
		
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

	public String getDescrizione_voto() {
		return descrizione_voto;
	}

	public void setDescrizione_voto(String descrizione_voto) {
		this.descrizione_voto = descrizione_voto;
	}
	private int voto;
	private int propostatesi_id;
	private String descrizione_voto;
	private String descrizione;
	private String email;
	private String nome;
	
}