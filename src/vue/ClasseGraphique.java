package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import fr.inria.zvtm.glyphs.Composite;
import fr.inria.zvtm.glyphs.Glyph;
import fr.inria.zvtm.glyphs.VRectangle;

import modele.Attribut;
import modele.Classe;
import modele.Methode;

public class ClasseGraphique{

	Classe modeleClasse;
	int x;
	int y;
	int largeur;
	int hauteur;
	Boolean afficherNom;
	int haut1;
	Boolean afficherAttributs;
	int haut2;
	Boolean afficherMethodes;
	int haut3;
	
	int echelle;
	
	public Composite composite;
	
	public ClasseGraphique(Classe modeleClasse) {
		super();
		
		this.modeleClasse = modeleClasse;
		x = 0;
		y = 0;
		afficherNom = true;
		afficherAttributs = true;
		afficherMethodes = true;
		
		composite = new Composite();
		setEchelle(30);
		redessiner();
	}
	
	public void repositionner(int x, int y){
		composite.vx = x;
		composite.vy = y;
		this.x=x;
		this.y=y;
	}
	
	public void setEchelle(int val){
		int nbligne = 0;
		int max = 0;
		if(afficherNom)
			{
			nbligne++;
			haut1 = val;
			max = modeleClasse.getNom().length();
			}
		if(afficherAttributs)
			{
			System.out.println("PLUS "+modeleClasse.getAttributs().size());
			nbligne += modeleClasse.getAttributs().size();
			haut2 = modeleClasse.getAttributs().size()*val;
			
			for(Attribut attr : modeleClasse.getAttributs())
				if(attr.toString().length()>max)
					max = attr.toString().length();
			}
		if(afficherMethodes)
			{
			System.out.println("PLUS "+modeleClasse.getMethodes().size());
			nbligne += modeleClasse.getMethodes().size();
			haut3 = modeleClasse.getMethodes().size()*val;
			for(Methode met : modeleClasse.getMethodes())
				if(met.toString().length()>max)
					max = met.toString().length();
			}
		System.out.println("NBLIGNE "+nbligne);
		hauteur = val*nbligne;
		largeur = (val/2)*max;
		this.echelle = val;
	}
	
	public void redessiner(){
		
		composite.addChild(new VRectangle(x+largeur/2, y+hauteur/2, 0, largeur, hauteur, new Color(210,226,226)));
		
		int haut=0;
		if(afficherNom)
			{
			haut+=haut1;
			composite.addChild(new VRectangle(x+largeur/2, y+haut/2, 0, largeur, haut, new Color(210,226,226)));
			
			}
		if(afficherAttributs)
			{
			haut+=haut2;
			composite.addChild(new VRectangle(x+largeur/2, y+haut/2, 0, largeur, haut, new Color(210,226,226)));
			
			}
		if(afficherMethodes)
			{
			haut+=haut3;
			composite.addChild(new VRectangle(x+largeur/2, y+haut/2, 0, largeur, haut, new Color(210,226,226)));
			
			}
		
		//this.largeur=composite.
	
		/*
		//Cadres
		g.setColor(new Color(210,226,226));
		g.fillRoundRect(x, y, largeur, hauteur, 5, 5);
		g.setColor(Color.BLACK);
		g.drawRoundRect(x, y, largeur, hauteur, 5, 5);
		
		int haut=0;
		
		if(afficherNom)
			{
			haut+=haut1;
			g.drawRoundRect(x, y, largeur, haut, 2, 2);
			}
		if(afficherAttributs)
			{
			haut+=haut2;
			g.drawRoundRect(x, y, largeur, haut, 2, 2);
			}
		if(afficherMethodes)
			{
			haut+=haut3;
			g.drawRoundRect(x, y, largeur, haut, 2, 2);
			}
		
		
		g.setFont(new Font("Courier New", Font.BOLD, (14*echelle) / 20));
		haut = 0;
		if(afficherNom)
			{
			g.drawString(modeleClasse.getNom(), Math.max(x-modeleClasse.getNom().length()*echelle/4+largeur/2,x+5), y+haut1*8/10);
			haut+=haut1;
			}
		g.setFont(new Font("Courier New", 0, (14*echelle) / 20));
		if(afficherAttributs)
			{
			int yEcriture = haut;
			for(Attribut attr : modeleClasse.getAttributs())
				{
				g.drawString(attr.toString(), Math.min(x+largeur/10,x+5), y+yEcriture+haut1*8/10);
				yEcriture+= echelle;
				}
			haut+=haut2;
			}
		if(afficherMethodes)
			{
			int yEcriture = haut;
			for(Methode met : modeleClasse.getMethodes())
				{
				g.drawString(met.toString(), Math.min(x+largeur/10,x+5), y+yEcriture+haut1*8/10);
				yEcriture+= echelle;
				}
			haut+=haut3;
			}
			*/
	}

	public Classe getModeleClasse() {
		return modeleClasse;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
	
	
	
}
