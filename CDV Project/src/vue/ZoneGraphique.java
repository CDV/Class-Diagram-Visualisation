package vue;

import java.awt.Graphics;

import javax.swing.JPanel;

import modele.Classe;
import modele.Diagramme;
import modele.Pack;
import modele.Relation;

public class ZoneGraphique extends JPanel{
	
	Diagramme modeleDiagramme;
	DiagrammeGraphique vueDiagramme;
	
	
	public ZoneGraphique(Diagramme modeleDiagramme,
			DiagrammeGraphique vueDiagramme) {
		this.modeleDiagramme = modeleDiagramme;
		this.vueDiagramme = vueDiagramme;
	}

	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		for(Pack modelePackage : modeleDiagramme.getPackages())
			modelePackage.getVuePackage().redessiner(g);
		
		for(Relation modeleRelation : modeleDiagramme.getRelations())
			modeleRelation.getVueRelation().redessiner(g);
		
		for(Classe modeleClasse : modeleDiagramme.getClasses())
			{
			modeleClasse.getVueClasse().setEchelle(30);
			modeleClasse.getVueClasse().redessiner(g);
			}
		
		
	}
}
