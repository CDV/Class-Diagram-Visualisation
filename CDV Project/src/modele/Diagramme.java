package modele;

import java.util.LinkedList;
import java.util.List;

import vue.DiagrammeGraphique;

import controleur.Controleur;

public class Diagramme {

	private String nom;
	private List<Pack> packages;
	private List<Classe> classes;
	private List<Relation> relations;
	private Controleur controleur;
	private DiagrammeGraphique vueDiagramme;
	
	public Diagramme(String nom){
		this.nom = nom;
		packages = new LinkedList<Pack>();
		classes = new LinkedList<Classe>();
		relations = new LinkedList<Relation>();	
		vueDiagramme = new DiagrammeGraphique(this);
		controleur = new Controleur(this, vueDiagramme);
	}
	
	public void ajouterRelation(Relation relation){
		relations.add(relation);
		relation.getOrigine().estSourceDe(relation);
		relation.getCible().estCibleDe(relation);		
	}
	
	public void ajouterClasse(Classe classe){
		classes.add(classe);		
	}
	
	public void ajouterPackage(Pack pack){
		packages.add(pack);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Pack> getPackages() {
		return packages;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public DiagrammeGraphique getVueDiagramme() {
		return vueDiagramme;
	}
	
	
	
	
}
