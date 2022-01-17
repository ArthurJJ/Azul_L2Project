
public class Tuile {
	int couleur; // 1=bleue, 2=jaune, 3=rouge, 4=noire, 5=blanche, -1=PremierJ
	
	public Tuile(int c) {
		this.couleur = c;
	}
	
	public boolean isPremierJ() { // true si la tuile est celle -1
		if (this.couleur == -1) {
			return true;
		}
		return false;
	}
	
	public int getCouleur() {
		return this.couleur;
	}
	
	public String toString() {
		return Integer.toString(this.couleur);
	}
}
