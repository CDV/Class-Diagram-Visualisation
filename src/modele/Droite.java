package modele;

public class Droite {
	
	public float a;
	public float b;
	public float c;
	
	public Droite(float a, float b, float c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public String toString() {
		return "Equation de la droite "+a+"x+"+b+"y+"+c+"=0";
	}
}
