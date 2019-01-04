package it.unisa.etm.testing.admin;

import it.unisa.etm.bean.Amministratore;

public class TestAmministratore {

	private Amministratore admin;
	
	public TestAmministratore() {
		
	}
	
	public TestAmministratore(Amministratore admin) {
		this.admin=admin;
	}
	
	public String testGetPassword(){
		return admin.getPassword();
	}
	
	public void testSetPassword(String password) {
		admin.setPassword(password);
	}
	
	public String testGetNome() {
		return admin.getNome();
	}

	public void testSetNome(String nome) {
		this.admin.setNome(nome);
	}

	public String testGetCognome() {
		return admin.getCognome();
	}

	public void testSetCognome(String cognome) {
		this.admin.setCognome(cognome);
	}

	public String testGetEmail() {
		return admin.getEmail();
	}

	public void testSetEmail(String email) {
		this.admin.setEmail(email);
	}
	
	
	
	
	
	
	
	
	
}

