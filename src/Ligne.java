
public abstract class Ligne {
	
	protected Case[] line;
	
	public Ligne(int a) {
		this.line = new Case[a];
		for (int i = 0; i < this.line.length; i++) {
			this.line[i] = new Case();
		}
	}
	
	public abstract boolean remplir(Tuile t);
	
	public abstract String toString() throws NullPointerException;
		
}
