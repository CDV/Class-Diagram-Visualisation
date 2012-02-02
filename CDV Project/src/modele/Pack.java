package modele;

import java.util.List;

import vue.PackageGraphique;

public class Pack {

	private List<Classe> classes;
	private String nomPackage;

	private PackageGraphique vuePackage;
	
	public Pack(String nomPackage) {
		super();
		this.nomPackage = nomPackage;
		vuePackage = new PackageGraphique(this);
	}

	public PackageGraphique getVuePackage() {
		return vuePackage;
	}
	
	
}
