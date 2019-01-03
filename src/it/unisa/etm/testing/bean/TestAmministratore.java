package it.unisa.etm.testing.bean;

import it.unisa.etm.bean.Amministratore;

public class TestAmministratore {

	private Amministratore admin;
	
	public TestAmministratore() {
		
	}
	
	public TestAmministratore(Amministratore admin) {
		this.admin=admin;
	}
	
	public String TestGetPassword(){
		return admin.getPassword();
	}
	
	public void TestsetPassword(String password) {
		admin.setPassword(password);
	}
	
	public String TestGetNome() {
		return admin.getNome();
	}

	public void TestSetNome(String nome) {
		this.admin.setNome(nome);
	}

	public String TestGetCognome() {
		return admin.getCognome();
	}

	public void TestSetCognome(String cognome) {
		this.admin.setCognome(cognome);
	}

	public String TestGetEmail() {
		return admin.getEmail();
	}

	public void TestSetEmail(String email) {
		this.admin.setEmail(email);
	}
	
	
	
	
	
	
	
	
	
}

