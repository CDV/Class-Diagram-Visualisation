package vue;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.EcouteurDragNDrop;

import modele.Classe;
import modele.Diagramme;
import modele.Pack;
import modele.Relation;

public class Fenetre extends JFrame{

	Diagramme modeleDiagramme;
	DiagrammeGraphique vueDiagramme;
	ZoneGraphique centre;
	
	public Fenetre(Diagramme modeleDiagramme, DiagrammeGraphique vueDiagramme)
			throws HeadlessException {
		super(modeleDiagramme.getNom());
		this.modeleDiagramme = modeleDiagramme;
		this.vueDiagramme = vueDiagramme;
		
		setLayout(new BorderLayout());
		centre = new ZoneGraphique(modeleDiagramme, vueDiagramme);
		
		EcouteurDragNDrop ecout = new EcouteurDragNDrop(modeleDiagramme, vueDiagramme, this);
		centre.addMouseListener(ecout);
		centre.addMouseMotionListener(ecout);
		add(centre,BorderLayout.CENTER);
		
		setSize(600,600);
		repaint();
	}

	
}
