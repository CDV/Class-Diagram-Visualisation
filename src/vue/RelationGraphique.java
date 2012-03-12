package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modele.Constante;
import modele.Droite;
import modele.Point;

import fr.inria.zvtm.engine.LongPoint;
import fr.inria.zvtm.glyphs.Composite;
import fr.inria.zvtm.glyphs.VPolygon;
import fr.inria.zvtm.glyphs.VRectangle;
import fr.inria.zvtm.glyphs.VSegment;

import modele.Classe;
import modele.Relation;

public class RelationGraphique extends Composite {

	Relation modeleRelation;
	Classe source;
    Classe dest;
    VSegment s;
    VPolygon poly;
    ArrayList<VSegment> fleche;
    
	final static float ALPHA = (float) (Math.PI - Math.PI / 6); // 5PI/6

    
	public RelationGraphique(Relation modeleRelation) {
		super();
	    this.modeleRelation = modeleRelation;
	    source=this.modeleRelation.getOrigine();
	    dest=this.modeleRelation.getCible();
	    s=null;
	    fleche=null;
	    poly=null;
	}
	
	public void redessiner(){
		switch(modeleRelation.getTypeRelation()){
			case Constante.HERITAGE:
				tracerRelationHeritage();
				break;
			case Constante.AGREGATION:
				tracerRelationAgregation();
				break;
			case Constante.COMPOSITION:
				tracerRelationComposition();
				break;
			case Constante.ASSOCIATION:
				tracerRelationAssociation();
				break;
			case Constante.ASSOCIATIONNAVIGABLE:
				tracerRelationAssociationNavigable();
				break;
				
		}
	}
	
	private void tracerRelationAssociationNavigable() {
		// TODO Auto-generated method stub
		Point p_centreR1 = new Point(source.getVueClasse().getX(),source.getVueClasse().getY());
		Point p_centreR2 = new Point(dest.getVueClasse().getX(),dest.getVueClasse().getY());
		Droite d_p_centreR1_p_centreR2=calculEquation(p_centreR1,p_centreR2);
		 
		Point startPoint=affinerAncrage(source,dest, d_p_centreR1_p_centreR2);
		Point endPoint=affinerAncrage(dest,source, d_p_centreR1_p_centreR2);
		
		s= new VSegment(startPoint.x, startPoint.y, 0, Color.BLACK, endPoint.x, endPoint.y);
		ZoneGraphique.vs.addGlyph(s);
		
		tracerFleche(startPoint, endPoint);
		
	}

	private void tracerRelationAssociation() {
		// TODO Auto-generated method stub
		Point p_centreR1 = new Point(source.getVueClasse().getX(),source.getVueClasse().getY());
		Point p_centreR2 = new Point(dest.getVueClasse().getX(),dest.getVueClasse().getY());
		Droite d_p_centreR1_p_centreR2=calculEquation(p_centreR1,p_centreR2);
		 
		Point startPoint=affinerAncrage(source,dest, d_p_centreR1_p_centreR2);
		Point endPoint=affinerAncrage(dest,source, d_p_centreR1_p_centreR2);
		
		s= new VSegment(startPoint.x, startPoint.y, 0, Color.BLACK, endPoint.x, endPoint.y);
		ZoneGraphique.vs.addGlyph(s);
	}

	public void tracerRelationHeritage() {
		// TODO Auto-generated method stub
		
		Point p_centreR1 = new Point(source.getVueClasse().getX(),source.getVueClasse().getY());
		Point p_centreR2 = new Point(dest.getVueClasse().getX(),dest.getVueClasse().getY());
		Droite d_p_centreR1_p_centreR2=calculEquation(p_centreR1,p_centreR2);
		 
		Point startPoint=affinerAncrage(source,dest, d_p_centreR1_p_centreR2);
		Point endPoint=affinerAncrage(dest,source, d_p_centreR1_p_centreR2);
		
		s= new VSegment(startPoint.x, startPoint.y, 0, Color.BLACK, endPoint.x, endPoint.y);
		ZoneGraphique.vs.addGlyph(s);
		
		tracerFlecheHeritage(startPoint,endPoint);
		
	}
	
	public void tracerRelationAgregation() {
		// TODO Auto-generated method stub
		Point p_centreR1 = new Point(source.getVueClasse().getX(),source.getVueClasse().getY());
		Point p_centreR2 = new Point(dest.getVueClasse().getX(),dest.getVueClasse().getY());
		Droite d_p_centreR1_p_centreR2=calculEquation(p_centreR1,p_centreR2);
		 
		Point startPoint=affinerAncrage(source,dest, d_p_centreR1_p_centreR2);
		Point endPoint=affinerAncrage(dest,source, d_p_centreR1_p_centreR2);

		s = new VSegment(startPoint.x, startPoint.y, 0, Color.BLACK, endPoint.x, endPoint.y);
		ZoneGraphique.vs.addGlyph(s);
		
		tracerLosangeComposition(endPoint,startPoint,Color.WHITE);
		
	}
	public void tracerRelationComposition() {
		// TODO Auto-generated method stub
		Point p_centreR1 = new Point(source.getVueClasse().getX(),source.getVueClasse().getY());
		Point p_centreR2 = new Point(dest.getVueClasse().getX(),dest.getVueClasse().getY());
		Droite d_p_centreR1_p_centreR2=calculEquation(p_centreR1,p_centreR2);
		 
		Point startPoint=affinerAncrage(source,dest, d_p_centreR1_p_centreR2);
		Point endPoint=affinerAncrage(dest,source, d_p_centreR1_p_centreR2);

		s = new VSegment(startPoint.x, startPoint.y, 0, Color.BLACK, endPoint.x, endPoint.y);
		ZoneGraphique.vs.addGlyph(s);
		
		tracerLosangeComposition(endPoint,startPoint,Color.BLACK);
		
	}
	public void tracerFleche(Point startPoint, Point endPoint) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			
			double xvect1 = (endPoint.x - startPoint.x) * Math.cos(-ALPHA) - (endPoint.y - startPoint.y) * Math.sin(-ALPHA);
			double yvect1 = (endPoint.x - startPoint.x) * Math.sin(-ALPHA) + (endPoint.y - startPoint.y) * Math.cos(-ALPHA);

			double xvect2 = (endPoint.x - startPoint.x) * Math.cos(ALPHA) - (endPoint.y - startPoint.y) * Math.sin(ALPHA);
			double yvect2 = (endPoint.x - startPoint.x) * Math.sin(ALPHA) + (endPoint.y - startPoint.y) * Math.cos(ALPHA);

			Point p1 = new Point(0,0); 
			Point p2 = new Point(0,0); 

			p1.x = (long) (endPoint.x + xvect1 * 20	/ Math.sqrt(xvect1 * xvect1 + yvect1 * yvect1));
			p2.x = (long) (endPoint.x + xvect2 * 20	/ Math.sqrt(xvect2 * xvect2 + yvect2 * yvect2));
			p1.y = (long) (endPoint.y + yvect1 * 20	/ Math.sqrt(xvect1 * xvect1 + yvect1 * yvect1));
			p2.y = (long) (endPoint.y + yvect2 * 20	/ Math.sqrt(xvect2 * xvect2 + yvect2 * yvect2));
			
			if(fleche==null){
			    fleche=new ArrayList<VSegment>();
		        fleche.add(new VSegment(endPoint.x,endPoint.y,0, Color.BLACK, p1.x,p1.y));
		        fleche.add(new VSegment(endPoint.x,endPoint.y,0, Color.BLACK, p2.x,p2.y));
		        ZoneGraphique.vs.addGlyph(fleche.get(0));
		        ZoneGraphique.vs.addGlyph(fleche.get(1));
			}else{
				fleche.get(0).setEndPoints(endPoint.x,endPoint.y, p1.x,p1.y);
				fleche.get(1).setEndPoints(endPoint.x,endPoint.y, p2.x,p2.y);
			}

		
	}
	public void tracerLosangeComposition(Point startPoint, Point endPoint, Color co) {
		// TODO Auto-generated method stub
		
		double xvect = (endPoint.x - startPoint.x);
		double yvect = (endPoint.y - startPoint.y);
		
		double xvect1 = (endPoint.x - startPoint.x) * Math.cos(-ALPHA) - (endPoint.y - startPoint.y) * Math.sin(-ALPHA);
		double yvect1 = (endPoint.x - startPoint.x) * Math.sin(-ALPHA) + (endPoint.y - startPoint.y) * Math.cos(-ALPHA);

		double xvect2 = (endPoint.x - startPoint.x) * Math.cos(ALPHA) - (endPoint.y - startPoint.y) * Math.sin(ALPHA);
		double yvect2 = (endPoint.x - startPoint.x) * Math.sin(ALPHA) + (endPoint.y - startPoint.y) * Math.cos(ALPHA);

		double x = (endPoint.x + xvect1 * 20	/ Math.sqrt(xvect1 * xvect1 + yvect1 * yvect1));
		double y =  (endPoint.y + yvect1 * 20	/ Math.sqrt(xvect1 * xvect1 + yvect1 * yvect1));
		LongPoint p1 = new LongPoint(x, y);
		x =  (endPoint.x + xvect2 * 20	/ Math.sqrt(xvect2 * xvect2 + yvect2 * yvect2));
		y = (endPoint.y + yvect2 * 20	/ Math.sqrt(xvect2 * xvect2 + yvect2 * yvect2));
		LongPoint p2 = new LongPoint(x, y);
		x =  (endPoint.x + xvect * 40 * Math.cos(ALPHA) / Math.sqrt(xvect * xvect + yvect * yvect));
		y =  (endPoint.y + yvect * 40 * Math.cos(ALPHA) / Math.sqrt(xvect * xvect + yvect * yvect));
		LongPoint p3 = new LongPoint(x, y);
		LongPoint p4 = new LongPoint(endPoint.x,endPoint.y);
		LongPoint[] pp = {p1,p4,p2,p3};

		
		if(poly==null)
			poly = new VPolygon(pp, 0, co);

		else if(poly!=null){
			ZoneGraphique.vs.removeGlyph(poly,true);
			poly = new VPolygon(pp, 0, co);
		}
		ZoneGraphique.vs.addGlyph(poly,true);
		
	}
	public void tracerFlecheHeritage(Point startPoint, Point endPoint) {
		// TODO Auto-generated method stub

		
		double xvect1 = (endPoint.x - startPoint.x) * Math.cos(-ALPHA) - (endPoint.y - startPoint.y) * Math.sin(-ALPHA);
		double yvect1 = (endPoint.x - startPoint.x) * Math.sin(-ALPHA) + (endPoint.y - startPoint.y) * Math.cos(-ALPHA);

		double xvect2 = (endPoint.x - startPoint.x) * Math.cos(ALPHA) - (endPoint.y - startPoint.y) * Math.sin(ALPHA);
		double yvect2 = (endPoint.x - startPoint.x) * Math.sin(ALPHA) + (endPoint.y - startPoint.y) * Math.cos(ALPHA);


		double x =  (endPoint.x + xvect1 * 20	/ Math.sqrt(xvect1 * xvect1 + yvect1 * yvect1));
		double y =  (endPoint.y + yvect1 * 20	/ Math.sqrt(xvect1 * xvect1 + yvect1 * yvect1));
		LongPoint p1 = new LongPoint(x,y);
		
		x =  (endPoint.x + xvect2 * 20	/ Math.sqrt(xvect2 * xvect2 + yvect2 * yvect2));
		y =  (endPoint.y + yvect2 * 20	/ Math.sqrt(xvect2 * xvect2 + yvect2 * yvect2));
		LongPoint p2 = new LongPoint(x,y);
		LongPoint p3 = new LongPoint(endPoint.x,endPoint.y);
		LongPoint[] pp={p1,p2,p3};
        
		if(poly==null)
			poly = new VPolygon(pp, 0, Color.WHITE);

		else if(poly!=null){
			ZoneGraphique.vs.removeGlyph(poly,true);
			poly = new VPolygon(pp, 0, Color.WHITE);
		}
		ZoneGraphique.vs.addGlyph(poly,true);
	}
	private static Point affinerAncrage(Classe c, Classe c2,Droite coef) {
		// TODO Auto-generated method stub
		Point p1Max = new Point(c.getVueClasse().getX(),c.getVueClasse().getY());
		Point p2Max = new Point(c.getVueClasse().getX()+c.getVueClasse().getLargeur(),c.getVueClasse().getY()+c.getVueClasse().getHauteur());
		Droite coefMax=calculEquation(p1Max,p2Max);
		
		Point p1Min = new Point(c.getVueClasse().getX(),c.getVueClasse().getY());
		Point p2Min = new Point(c.getVueClasse().getX()+c.getVueClasse().getLargeur(),c.getVueClasse().getY()-c.getVueClasse().getHauteur());
		Droite coefMin=calculEquation(p1Min,p2Min);
		 
		 
		if(c2.getVueClasse().getY()<=(c2.getVueClasse().getX()*coefMax.a+coefMax.c) && c2.getVueClasse().getY()>=(c2.getVueClasse().getX()*coefMin.a+coefMin.c))
			 return affinerAncrageDroit(coef,c);		 
		else if(c2.getVueClasse().getY()<=(c2.getVueClasse().getX()*coefMin.a+coefMin.c) && c2.getVueClasse().getY()>=(c2.getVueClasse().getX()*coefMax.a+coefMax.c))
			return affinerAncrageGauche(coef,c);
		else if(c2.getVueClasse().getY()>c.getVueClasse().getY())
			 return affinerAncrageHaut(coef,c);
		else
			 return affinerAncrageBas(coef,c); 
	}
	private static Point affinerAncrageGauche(Droite coef, Classe c) {
		// TODO Auto-generated method stub
		Droite droite1=new Droite(1,0,c.getVueClasse().getX()-c.getVueClasse().getLargeur());
	    Droite droite2=coef;
	    
	    return calculPointInter(droite1,droite2);		
	}
	private static Point affinerAncrageDroit(Droite coef, Classe c) {
		// TODO Auto-generated method stub
	    Droite droite1= new Droite(1,0,c.getVueClasse().getX()+c.getVueClasse().getLargeur());
	    Droite droite2=coef;
	    
	    return calculPointInter(droite1,droite2);
	}
	private static Point affinerAncrageHaut(Droite coef, Classe c) {
		// TODO Auto-generated method stub
		Droite droite1=new Droite(0,1,c.getVueClasse().getY()+c.getVueClasse().getHauteur());
		Droite droite2=coef;
		
	    return calculPointInter(droite1,droite2);
	}
	private static Point affinerAncrageBas(Droite coef, Classe c) {
		// TODO Auto-generated method stub
		Droite droite1=new Droite(0,1,c.getVueClasse().getY()-c.getVueClasse().getHauteur());
		Droite droite2=coef;

	    return calculPointInter(droite1,droite2);
	}
	private static Point calculPointInter(Droite droite1, Droite droite2) {
		// TODO Auto-generated method stub
		Point p = new Point(0,0);
		float tmp=droite1.c;
		
		if(droite1.a==0){			
			p.y=(long)tmp;
			p.x=(long)((tmp-droite2.c)/(droite2.a));	
		}
		else{
			p.x=(long)tmp;
			p.y=(long)(droite2.a*p.x+droite2.c);
		}
	
		return p;
	}
	
	static Droite calculEquation(Point p1,Point p2){	
		Droite d = new Droite(0,0,0); 

		d.a=((float)p2.y-(float)p1.y)/((float)p2.x-(float)p1.x);
		d.c=(float)p1.y-(d.a*(float)p1.x);
		d.b=1;

		return d;
	}
}
