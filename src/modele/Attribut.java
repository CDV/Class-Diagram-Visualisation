package modele;

public class Attribut {

	
	
	private String type;
	private String nom;
	private String visibilite;
	private Boolean estStatic;
	
	public Attribut(String type, String nom, String visibilite, Boolean estStatic) {
		super();
		this.type = type;
		this.nom = nom;
		this.visibilite = visibilite;
		this.estStatic = estStatic;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}

	public Boolean getEstStatic() {
		return estStatic;
	}

	public void setEstStatic(Boolean estStatic) {
		this.estStatic = estStatic;
	}
	
	public String toString(){
		return type + " " + nom;
	}
}
