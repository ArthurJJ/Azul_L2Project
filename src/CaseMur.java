
public class CaseMur extends Case { // = une case avec un attribut couleur en plus
	
	protected final int c; //la couleur de la case
	
	public CaseMur(int c) {
		super();
		this.c = c;
	}
	
	public int getCouleur() {
		return this.c;
	}
	
	public boolean isEmpty() { // retourne true si la caseMur est vide
		return super.isEmpty();
	}
	
	public void remplir(Tuile a) { // rempli la case avec une nouvelle tuile cr�ee avec la couleur de la case 
		this.rempli = true;
		setTuile(a);
	}
	
	public void remplir() {
		this.rempli = true;
		Tuile a = new Tuile(this.c);
		setTuile(a);
	}
	
	public void vider() { // n�cessaire pour la r�initialisation du plateau � la fin du jeu
		this.rempli = false;
		this.tuile = null;
	}
	
	public String toString() throws NullPointerException{
		try {
			return this.tuile.toString();
		}catch(NullPointerException a) {
			return ("Vide");
		}
	}

}

