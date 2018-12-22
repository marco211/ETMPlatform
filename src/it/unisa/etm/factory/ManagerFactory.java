package it.unisa.etm.factory;

import it.unisa.etm.model.interfaces.AmministratoreModelInterface;
import it.unisa.etm.model.interfaces.AreaCondivisaModelInterface;
import it.unisa.etm.model.interfaces.AutenticazioneModelInterface;
import it.unisa.etm.model.interfaces.ConsegnaModelInterface;
import it.unisa.etm.model.interfaces.FileModelInterface;
import it.unisa.etm.model.interfaces.PartecipaModelInterface;
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;
import it.unisa.etm.model.interfaces.UtenteModelInterface;
import it.unisa.etm.model.manager.AmministratoreManager;
import it.unisa.etm.model.manager.AreaCondivisaManager;
import it.unisa.etm.model.manager.AutenticazioneManager;
import it.unisa.etm.model.manager.ConsegnaManager;
import it.unisa.etm.model.manager.FileManager;
import it.unisa.etm.model.manager.PartecipaManager;
import it.unisa.etm.model.manager.PropostaTesiManager;
import it.unisa.etm.model.manager.UtenteManager;

public class ManagerFactory implements AbstractFactory{

	@Override
	public AmministratoreModelInterface createAmministratoreManager() {
		return new AmministratoreManager();
	}

	@Override
	public AreaCondivisaModelInterface createAreaCondivisaManager() {
		return new AreaCondivisaManager();
	}

	@Override
	public AutenticazioneModelInterface createAutenticazioneManager() {
		return new AutenticazioneManager();
	}

	@Override
	public ConsegnaModelInterface createConsegnaManager() {
		return new ConsegnaManager();
	}

	@Override
	public PropostaTesiModelInterface createPropostaTesiManager() {
		return new PropostaTesiManager();
	}

	@Override
	public UtenteModelInterface createUtenteManager() {
		return new UtenteManager();
	}

	@Override
	public FileModelInterface createFileManager() {
		return new FileManager();
	}

	@Override
	public PartecipaModelInterface createPartecipaManager() {
		return new PartecipaManager();
	}

}
