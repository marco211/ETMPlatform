package it.unisa.etm.factory;

import it.unisa.etm.model.interfaces.AmministratoreModelInterface;
import it.unisa.etm.model.interfaces.AreaCondivisaModelInterface;
import it.unisa.etm.model.interfaces.AttivitaModelInterface;
import it.unisa.etm.model.interfaces.AutenticazioneModelInterface;
import it.unisa.etm.model.interfaces.ConsegnaModelInterface;
import it.unisa.etm.model.interfaces.FileModelInterface;
import it.unisa.etm.model.interfaces.HaModelInterface;
import it.unisa.etm.model.interfaces.PartecipaModelInterface;
import it.unisa.etm.model.interfaces.PropostaTesiModelInterface;
import it.unisa.etm.model.interfaces.UtenteModelInterface;

public interface AbstractFactory {
	public AmministratoreModelInterface createAmministratoreManager();
	public AreaCondivisaModelInterface createAreaCondivisaManager();
	public AutenticazioneModelInterface createAutenticazioneManager();
	public ConsegnaModelInterface createConsegnaManager();
	public PropostaTesiModelInterface createPropostaTesiManager();
	public UtenteModelInterface createUtenteManager();
	public FileModelInterface createFileManager();
	public PartecipaModelInterface createPartecipaManager();
	public AttivitaModelInterface createAttivitaManager();
	public HaModelInterface createHaManager();
}
