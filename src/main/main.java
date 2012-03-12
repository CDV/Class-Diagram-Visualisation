package main;

import vue.Fenetre;
import modele.Attribut;
import modele.Classe;
import modele.Diagramme;
import modele.Methode;
import modele.Relation;

public class main {

	public static void main (String[] args){
		
		
		Diagramme monDiag = new Diagramme("Mon super diagramme");
		
		Classe c2 = new Classe("Source", false, false);
		c2.ajouterAttribut(new Attribut("int", "nb1","private",false));
		c2.ajouterAttribut(new Attribut("int", "nb2","private",false));
		c2.ajouterAttribut(new Attribut("int", "nb3","private",false));
		
		Methode maMethode1 = new Methode("maMethode1", "int", "public", false);
		maMethode1.ajouterParametre(new Attribut("String", "Chaine","private",false));
		c2.ajouterMethode(maMethode1);
		
		System.out.println(c2);
		
		Classe c3 = new Classe("Cible", false, false);
		c3.ajouterMethode(maMethode1);
		
		Relation rel = new Relation(1, c2,c3);
		monDiag.ajouterClasse(c2);
		monDiag.ajouterClasse(c3);
		monDiag.ajouterRelation(rel);
		
		for(int i=0;i<10;i++){
			Classe c1 = new Classe("Classe "+1, false, false);
			monDiag.ajouterClasse(c1);
		}
			
		Fenetre f = new Fenetre(monDiag, monDiag.getVueDiagramme());
		f.setVisible(true);
		monDiag.getVueDiagramme().disposer();
	}
}
