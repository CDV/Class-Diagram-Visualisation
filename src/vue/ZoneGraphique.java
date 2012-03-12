package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import fr.inria.zvtm.engine.Camera;
import fr.inria.zvtm.engine.CameraPortal;
import fr.inria.zvtm.engine.Portal;
import fr.inria.zvtm.engine.View;
import fr.inria.zvtm.engine.VirtualSpace;
import fr.inria.zvtm.engine.VirtualSpaceManager;
import fr.inria.zvtm.glyphs.Composite;
import fr.inria.zvtm.glyphs.VCircle;
import fr.inria.zvtm.glyphs.VRectangle;

import modele.Attribut;
import modele.Classe;
import modele.Diagramme;
import modele.Pack;
import modele.Relation;

public class ZoneGraphique extends JPanel{
	
	Diagramme modeleDiagramme;
	DiagrammeGraphique vueDiagramme;
	public static VirtualSpace vs;
	
	
	public ZoneGraphique(Diagramme modeleDiagramme,
			DiagrammeGraphique vueDiagramme) {
		this.modeleDiagramme = modeleDiagramme;
		this.vueDiagramme = vueDiagramme;
		setLayout(new BorderLayout());
		
		VirtualSpaceManager vsm = VirtualSpaceManager.INSTANCE;
        vs = vsm.addVirtualSpace("screen");

        
        
        VCircle c = new VCircle(0, 0, 0, 10, Color.BLUE);
        VCircle c2 = new VCircle(100, 100, 0, 10, Color.RED);
        VCircle c3 = new VCircle(-100, -100, 0, 10, Color.GREEN);
        
        //VRectangle r = new VRectangle(-50, -50, 0, 10,20, Color.GREEN);
        VRectangle background = new VRectangle(-50, -50, 0, 20000,20000, Color.WHITE);
        VRectangle rright = new VRectangle(500, -50, 0, 100,20, Color.GREEN);
       
        vs.addGlyph(background);
        
        vs.addGlyph(c);
        vs.addGlyph(c2);
        vs.addGlyph(c3);
        //vs.addGlyph(r);
        vs.addGlyph(rright);
        
        Classe cla2 = new Classe("Source", false, false);
		cla2.ajouterAttribut(new Attribut("int", "nb1","private",false));
		cla2.ajouterAttribut(new Attribut("int", "nb2","private",false));
		cla2.ajouterAttribut(new Attribut("int", "nb3","private",false));
		
		//vs.addGlyph(cla2.getVueClasse());
        
		Composite com = new Composite();
		VRectangle g = new VRectangle(0, 0, 0, 10, 10, Color.RED);
		com.addChild(g);
		com.addChild(new VRectangle(0, 0, 0, 5, 5, Color.BLUE));
        
        vs.addGlyph(cla2.getVueClasse().composite);

        
		com.moveTo(10, 100);
        //Camera overviewcam = vs.addCamera();
        Camera cam2 = vs.addCamera();
        
        //overviewcam.altitude=448;
        Vector<Camera> cameras = new Vector<Camera>();
        cameras.add(cam2);
       
        View v = vsm.addFrameView(cameras, "test", View.OPENGL_VIEW, getHeight(), getWidth(), false, false);
        //Portal p = new CameraPortal(0, 0, 300, 300, overviewcam);
       
        //((CameraPortal)p).setBorder(Color.BLACK);
        //vsm.addPortal(p, v);
        //Enul enul1 = new Enul();
        //v.setEventHandler(new Enul(overviewcam,cam2));
        //p.setPortalEventHandler(new PortalInt());
        
        add(v.getPanel(), BorderLayout.CENTER);
	}

	
	/*
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		for(Pack modelePackage : modeleDiagramme.getPackages())
			modelePackage.getVuePackage().redessiner(g);
		
		for(Relation modeleRelation : modeleDiagramme.getRelations())
			modeleRelation.getVueRelation().redessiner(g);
		
		for(Classe modeleClasse : modeleDiagramme.getClasses())
			{
			modeleClasse.getVueClasse().setEchelle(30);
			modeleClasse.getVueClasse().redessiner(g);
			}
		
		
	}
	*/
}
