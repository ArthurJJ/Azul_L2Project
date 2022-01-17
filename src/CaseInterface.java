import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CaseInterface extends JPanel{
	private boolean rempli;
	private Color couleur;
	private TuileInterface tuile;
	
	public CaseInterface() {
		this.rempli = false;
		this.setBackground(Color.lightGray);
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createLineBorder(Color.black,1));
	}
	
	
	public CaseInterface(int color) { // OBSELETE, ON LA GARDE POUR CREER LES CASES GRIS FONCE
		couleur = Color.darkGray;
		if (color == -1) {
			couleur = Color.green;
		}
		/*if (color == 1) {
			couleur = Color.blue;
		} else if (color == 2) {
			couleur = Color.yellow;
		} else if (color == 3) {
			couleur = Color.red;
		} else if (color == 4) {
			couleur = Color.black;
		} else if (color == 5) {
			couleur = Color.white;
		}*/
		this.rempli = false;
		this.setBackground(couleur);
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createLineBorder(Color.black,1));
	}
	
	
	public CaseInterface(Color color) { // POUR LE MUR
		this.couleur = color;
		this.rempli = false;
		this.setBackground(couleur);
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createLineBorder(Color.black,1));
	}
	
	public boolean isRempli() {
		return this.rempli;
	}
	
	public void remplir() { // POUR REMPLIR LE MUR SI LIGNEREMPLIE() = TRUE
		this.rempli = true;
		this.removeAll();
		this.tuile = new TuileInterface(couleur);
		this.add(tuile);
		//this.setBackground(couleur);
	}
	
	public void remplir(TuileInterface t) { // POUR REMPLIR LE MUR SI LIGNEREMPLIE() = TRUE
		this.rempli = true;
		this.removeAll();
		this.tuile = t;
		this.add(tuile);
		//this.setBackground(couleur);
	}
	
	public void remplir(int color) { // POUR REMPLIR L'ESCALIER SELON LES TUILES CHOISIES
		if (color == 1) {
			couleur = Color.blue;
		} else if (color == 2) {
			couleur = Color.yellow;
		} else if (color == 3) {
			couleur = Color.red;
		} else if (color == 4) {
			couleur = Color.black;
		} else if (color == 5) {
			couleur = Color.white;
		}
		this.rempli = true;
		this.tuile = new TuileInterface(couleur);
		this.add(tuile);
	}
	
	public void vider() { // POUR VIDER L'ESCALIER 
		this.rempli = false;
		this.removeAll();
		//this.setBackground(couleur);
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
	
	public TuileInterface getTuile() {
		return this.tuile;
	}
}


