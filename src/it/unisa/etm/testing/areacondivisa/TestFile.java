package it.unisa.etm.testing.bean;

import java.io.InputStream;

import javax.servlet.http.Part;

import it.unisa.etm.bean.File;

public class TestFile {
	private File file;
	
	public TestFile() {
		
	}
	
	public TestFile(File file) {
		this.file=file;
	}
	
	public String TestGetNome() {
		return file.getNome();
	}

	public void TestSetNome(String nome) {
		file.setNome(nome);
	}

	public String TestGetEmail() {
		return file.getEmail();
	}

	public void TestSetEmail(String email) {
		file.setEmail(email);
	}

	public int TestGetVoto() {
		return file.getVoto();
	}

	public void TestSetVoto(int voto) {
		file.setVoto(voto);
	}
	
	public String TestGetDescrizione() {
		return file.getDescrizione();
	}

	public void TestSetDescrizione(String descrizione) {
		file.setDescrizione(descrizione);
	}

	public String TestGetDescrizioneVoto() {
		return file.getDescrizioneVoto();
	}

	public void TestSetDescrizioneVoto(String descrizioneVoto) {
		file.setDescrizioneVoto(descrizioneVoto);
	}
	
	public int TestGetPropostaTesiId() {
		return file.getPropostaTesiId();
	}

	public void TestSetPropostaTesiId(int propostaTesiId) {
		file.setPropostaTesiId(propostaTesiId);
	}
	
	public Part TestGetFilePart() {
		return file.getFilePart();
	}

	public void TestSetFilePart(Part filePart) {
		file.setFilePart(filePart);
	}

	public InputStream TestGetInputStream() {
		return file.getInputStream();
	}

	public void TestSetInputStream(InputStream stream) {
		file.setInputStream(stream);
	}
}
