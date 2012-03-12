package vue;

import modele.Classe;
import modele.Diagramme;

public class LayoutGraphique {

	private Diagramme modeleDiagramme;
	private DiagrammeGraphique vueDiagramme;
	
	
	public LayoutGraphique(Diagramme modeleDiagramme,
			DiagrammeGraphique vueDiagramme) {
		super();
		this.modeleDiagramme = modeleDiagramme;
		this.vueDiagramme = vueDiagramme;
	}
	
	
	public void appliquerLayout(){
		int x = 0;
		for(Classe modeleClasse : modeleDiagramme.getClasses())
			{
			if(modeleClasse.getHauteur()==0)
				{
				modeleClasse.getVueClasse().repositionner(x, 0);
				x=x+50;
				}
			else
				{
				modeleClasse.getVueClasse().repositionner(x, 100);
				x=x+50;
				}
			}
		
		
	}
	
	
}
