package it.unisa.etm.bean;

public class Insegna {

	public Insegna() {

	}

	public Insegna(String utenteEmail, String insegnamentoNome) {
		super();
		this.utenteEmail = utenteEmail;
		this.insegnamentoNome = insegnamentoNome;
	}

	public 	String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	public String getInsegnamentoNome() {
		return insegnamentoNome;
	}

	public void setInsegnamentoNome(String insegnamentoNome) {
		this.insegnamentoNome = insegnamentoNome;
	}

	private String utenteEmail;
	private String insegnamentoNome;
}
