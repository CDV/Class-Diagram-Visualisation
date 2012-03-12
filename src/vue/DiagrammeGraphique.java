package vue;

import java.awt.Graphics;

import modele.Diagramme;

public class DiagrammeGraphique {

	Diagramme modeleDiagramme;
	LayoutGraphique layout;
	
	public DiagrammeGraphique(Diagramme modeleDiagramme) {
		super();
		this.modeleDiagramme = modeleDiagramme;
		layout = new LayoutGraphique(modeleDiagramme, this);
		layout.appliquerLayout();
	}

	public Diagramme getModeleDiagramme() {
		return modeleDiagramme;
	}

	public LayoutGraphique getLayout() {
		return layout;
	}
	
	public void disposer(){
		layout.appliquerLayout();
	}
	
	
	
}
