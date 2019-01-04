package it.unisa.etm.testing.areacondivisa;

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
	
	public String testGetNome() {
		return file.getNome();
	}

	public void testSetNome(String nome) {
		file.setNome(nome);
	}

	public String testGetEmail() {
		return file.getEmail();
	}

	public void testSetEmail(String email) {
		file.setEmail(email);
	}

	public int testGetVoto() {
		return file.getVoto();
	}

	public void testSetVoto(int voto) {
		file.setVoto(voto);
	}
	
	public String testGetDescrizione() {
		return file.getDescrizione();
	}

	public void testSetDescrizione(String descrizione) {
		file.setDescrizione(descrizione);
	}

	public String testGetDescrizioneVoto() {
		return file.getDescrizioneVoto();
	}

	public void testSetDescrizioneVoto(String descrizioneVoto) {
		file.setDescrizioneVoto(descrizioneVoto);
	}
	
	public int testGetPropostaTesiId() {
		return file.getPropostaTesiId();
	}

	public void testSetPropostaTesiId(int propostaTesiId) {
		file.setPropostaTesiId(propostaTesiId);
	}
	
	public Part testGetFilePart() {
		return file.getFilePart();
	}

	public void testSetFilePart(Part filePart) {
		file.setFilePart(filePart);
	}

	public InputStream testGetInputStream() {
		return file.getInputStream();
	}

	public void testSetInputStream(InputStream stream) {
		file.setInputStream(stream);
	}
}
