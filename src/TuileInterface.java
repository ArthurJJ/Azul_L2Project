import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TuileInterface extends JPanel	{
	private Color couleur;

	public TuileInterface(int color) {
		couleur = Color.darkGray;
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
		this.setBackground(couleur);
		this.setLayout(new GridLayout(1,1));
	}
	
	
	public TuileInterface(Color color) {
		this.couleur = color;
		this.setBackground(couleur);
		this.setLayout(new GridLayout(1,1));
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
}
