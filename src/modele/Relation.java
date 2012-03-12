package modele;

import vue.RelationGraphique;

public class Relation {

	private int typeRelation;
	private int cardInf;
	private int cardSup;
	private String texteRelation;
	
	private Classe origine;
	private Classe cible;

	private RelationGraphique vueRelation;
	
	public Relation(int typeRelation, int cardInf, int cardSup,
			String texteRelation, Classe origine, Classe cible) {
		super();
		this.typeRelation = typeRelation;
		this.cardInf = cardInf;
		this.cardSup = cardSup;
		this.texteRelation = texteRelation;
		this.origine = origine;
		this.cible = cible;
		vueRelation = new RelationGraphique(this);
	}

	public Relation(int typeRelation, Classe origine, Classe cible) {
		super();
		this.typeRelation = typeRelation;
		this.origine = origine;
		this.cible = cible;
		vueRelation = new RelationGraphique(this);
	}

	public int getTypeRelation() {
		return typeRelation;
	}

	public void setTypeRelation(int typeRelation) {
		this.typeRelation = typeRelation;
	}

	public int getCardInf() {
		return cardInf;
	}

	public void setCardInf(int cardInf) {
		this.cardInf = cardInf;
	}

	public int getCardSup() {
		return cardSup;
	}

	public void setCardSup(int cardSup) {
		this.cardSup = cardSup;
	}

	public String getTexteRelation() {
		return texteRelation;
	}

	public void setTexteRelation(String texteRelation) {
		this.texteRelation = texteRelation;
	}

	public Classe getOrigine() {
		return origine;
	}

	public void setOrigine(Classe origine) {
		this.origine = origine;
	}

	public Classe getCible() {
		return cible;
	}

	public void setCible(Classe cible) {
		this.cible = cible;
	}

	public RelationGraphique getVueRelation() {
		return vueRelation;
	}
	
	
	
	
}
