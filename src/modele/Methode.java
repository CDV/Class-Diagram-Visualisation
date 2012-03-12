package modele;

import java.util.LinkedList;
import java.util.List;

public class Methode {

	private Code code;
	private String typeReturn;
	private String nom;
	private List<Attribut> parametres;
	private String visibilite;
	private Boolean estStatic;
	
	
	public Methode(String nom, String typeReturn, List<Attribut> parametres, String visibilite, Boolean estStatic) {
		super();
		this.typeReturn = typeReturn;
		this.parametres = parametres;
		this.nom=nom;
		this.visibilite = visibilite;
		this.estStatic = estStatic;
	}
	
	public Methode(String nom, String typeReturn, String visibilite, Boolean estStatic) {
		super();
		this.typeReturn = typeReturn;
		parametres=new LinkedList<Attribut>();
		this.nom=nom;
		this.visibilite = visibilite;
		this.estStatic = estStatic;		
	}
	
	public void ajouterParametre(Attribut parametre){
		parametres.add(parametre);
	}
	
	public String toString(){
		String ret = typeReturn + " " + nom + " (";
		for(Attribut att : parametres)
			ret += " "+att;
		ret+=" )";
		return ret;
	}
}
