package modele;

import java.util.LinkedList;
import java.util.List;

public class Methode {

	private Code code;
	private String typeReturn;
	private String nom;
	private List<Attribut> parametres;
	
	public Methode(String nom, String typeReturn, List<Attribut> parametres) {
		super();
		this.typeReturn = typeReturn;
		this.parametres = parametres;
		this.nom=nom;
	}
	
	public Methode(String nom, String typeReturn) {
		super();
		this.typeReturn = typeReturn;
		parametres=new LinkedList<Attribut>();
		this.nom=nom;
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
