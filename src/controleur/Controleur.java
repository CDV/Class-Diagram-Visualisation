package controleur;

import modele.Diagramme;
import vue.DiagrammeGraphique;

public class Controleur {

	private Diagramme diagramme;
	private DiagrammeGraphique diagrammeGraphique;
	
	
	public Controleur(Diagramme diagramme, DiagrammeGraphique diagrammeGraphique) {
		super();
		this.diagramme = diagramme;
		this.diagrammeGraphique = diagrammeGraphique;
	}
	
	
}
