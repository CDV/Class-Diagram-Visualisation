package vue;

import java.awt.Graphics;

import modele.Relation;

public class RelationGraphique {

	Relation modeleRelation;

	public RelationGraphique(Relation modeleRelation) {
		super();
		this.modeleRelation = modeleRelation;
	}
	
	public void redessiner(Graphics g){
		
		int xSource,ySource;
		int xCible,yCible;
		
		ClasseGraphique c1 = modeleRelation.getOrigine().getVueClasse();
		ClasseGraphique c2 = modeleRelation.getCible().getVueClasse();
		
		xSource = c1.getX() > c2.getX() ? c1.getX() : c1.getX()+c1.getLargeur();
		ySource = c1.getY() > c2.getY() ? c1.getY() : c1.getY()+c1.getHauteur();
		
		xCible = c1.getX() > c2.getX() ? c2.getX()+c2.getLargeur() : c2.getX();
		yCible = c1.getY() > c2.getY() ? c2.getY()+c2.getHauteur() : c2.getY();
		
		/*xSource = c1.x+c1.largeur/2;
		ySource = c1.y+c1.hauteur/2;
		
		xCible = c2.x+c2.largeur/2;
		yCible = c2.y+c2.hauteur/2;*/
		
		g.drawLine(xSource, ySource, xCible, yCible);
	}
}
