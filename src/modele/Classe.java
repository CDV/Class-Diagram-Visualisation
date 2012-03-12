package modele;

import java.util.LinkedList;
import java.util.List;

import vue.ClasseGraphique;


public class Classe {

	private List<Attribut> attributs;
	private List<Methode> methodes;
	private String nom;
	
	private Boolean estAbstrait;
	private Boolean estInterface; 
	
	private List<Relation> source;
	private List<Relation> cible;
	
	private ClasseGraphique vueClasse;
	
	public Classe(String nom, Boolean estAbstrait, Boolean estInterface) {
		super();
		this.nom = nom;
		this.estAbstrait = estAbstrait;
		this.estInterface = estInterface;
		attributs = new LinkedList<Attribut>();
		methodes = new LinkedList<Methode>();
		source = new LinkedList<Relation>();
		cible = new LinkedList<Relation>();
		vueClasse = new ClasseGraphique(this);
	}
	
	public void ajouterAttribut(Attribut attrib){
		attributs.add(attrib);
	}

	public void ajouterMethode(Methode methode){
		methodes.add(methode);
	}
	
	public void estSourceDe(Relation relation){
		source.add(relation);
	}

	public void estCibleDe(Relation relation){
		cible.add(relation);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getEstAbstrait() {
		return estAbstrait;
	}

	public void setEstAbstrait(Boolean estAbstrait) {
		this.estAbstrait = estAbstrait;
	}

	public Boolean getEstInterface() {
		return estInterface;
	}

	public void setEstInterface(Boolean estInterface) {
		this.estInterface = estInterface;
	}

	public ClasseGraphique getVueClasse() {
		return vueClasse;
	}

	public void setVueClasse(ClasseGraphique vueClasse) {
		this.vueClasse = vueClasse;
	}

	public int getHauteur(){
		if(estInterface)
			return 0;
		
		int haut = 0;
		for(Relation relation : cible)
			if(relation.getTypeRelation() == 1)
				{
				haut = Math.max(haut, relation.getOrigine().getHauteur()+1);
				}
		
		return haut;
	}

	public List<Attribut> getAttributs() {
		return attributs;
	}

	public List<Methode> getMethodes() {
		return methodes;
	}
	
	public String toString(){
		String ret = "Classe ";
		ret += nom + "\n ATTRIBUTS \n";
		for(Attribut att : attributs)
			ret += " "+att;
		ret += "\n METHODES \n";
		for(Methode met : methodes)
			ret += " "+met;
		return ret;
	}
}

