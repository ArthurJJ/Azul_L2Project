
public class Case {
	protected Tuile tuile;
	protected boolean rempli;
	
	public Case() {
		this.tuile = null;
		this.rempli = false; // initialiser à vide
	}
	
	public boolean isEmpty() { //renvoie true si la case est vide
		if (this.rempli) {
			return false;
		}
		return true;
	}
	
	
	public void remplir(Tuile t) { //rempli la case d'une tuile
		this.rempli = true;
		setTuile(t);
	}
	
	public void vider() { // vide la case
		this.rempli = false;
		this.tuile = null;
	}
	
	public Tuile getTuile() { 
		return this.tuile;
	}
	
	public void setTuile(Tuile a) {
		this.tuile = a;
	}
	
	public String toString() throws NullPointerException {
		try {
			return this.tuile.toString();
		} catch (NullPointerException a) {
			return("/");
		}
	}
	
	/*public static void main(String[]args) {
		Tuile a = new Tuile (1);
		Case c = new Case();
		System.out.println(c.toString());
		System.out.println(c.isEmpty());
		c.remplir(a);
		System.out.println(c.toString());
		c.vider();
		System.out.println(c.toString());
		System.out.println(c.isEmpty());
	}*/
	
}
