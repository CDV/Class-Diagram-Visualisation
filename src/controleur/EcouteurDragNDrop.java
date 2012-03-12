package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modele.Classe;
import modele.Diagramme;

import vue.ClasseGraphique;
import vue.DiagrammeGraphique;
import vue.Fenetre;

public class EcouteurDragNDrop implements MouseListener,MouseMotionListener{

	Diagramme modeleDiagramme;
	DiagrammeGraphique vueDiagramme;
	ClasseGraphique classeSelectionnee;
	int x;
	int y;
	
	Fenetre fenetre;
	
	public EcouteurDragNDrop(Diagramme modeleDiagramme,
			DiagrammeGraphique vueDiagramme, Fenetre fenetre) {
		super();
		this.modeleDiagramme = modeleDiagramme;
		this.vueDiagramme = vueDiagramme;
		this.fenetre = fenetre;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(classeSelectionnee == null)
			for(Classe classe : modeleDiagramme.getClasses())
			{
				ClasseGraphique classeG = classe.getVueClasse();
				if(e.getX()>=classeG.getX() && e.getX()<=classeG.getX()+classeG.getLargeur() && e.getY()>=classeG.getY() && e.getY()<=classeG.getY()+classeG.getHauteur())
					{
					classeSelectionnee = classeG;
					x=e.getX();
					y=e.getY();
					}
			}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		classeSelectionnee = null;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(!(classeSelectionnee == null))
			{
			
			classeSelectionnee.repositionner(classeSelectionnee.getX()+(e.getX()-x), classeSelectionnee.getY()+(e.getY()-y));
			x=e.getX();
			y=e.getY();
			fenetre.repaint();
			}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
