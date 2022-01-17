import java.util.*;

public class Jeu {
	
	private static Fabrique[] fabriques; // tableau des fabriques qui seront dans le jeu
	
	protected Plateau joueurActuel; // joueur qui change à chaque tour
	public Sac sac;
	public Defausse def;
	public Centre centre;
	
	Scanner sc = new Scanner(System.in); //demande le nombre de joueurs et définit le nombre de fabriques ?
	
	public Jeu(int nfabrique) {
		Jeu.fabriques = new Fabrique[nfabrique];
		for (int i = 0; i < Jeu.fabriques.length; i++) {
			Jeu.fabriques[i] = new Fabrique();
		}
		
		this.joueurActuel = null;
		this.sac = new Sac();
		this.def = new Defausse();
		this.centre = new Centre();
	}
	
	public Fabrique[] getFabriques() {
		return Jeu.fabriques;
	}
	
	public Plateau getJoueurActuel() {
		return this.joueurActuel;
	}
	
	public void setJoueurActuel(Plateau ja) {
		this.joueurActuel = ja;
	}
	
	public Centre getCentre() {
		return this.centre;
	}
	
	public class Sac {
		private ArrayList<Tuile> deck;
		private int nbTuiles;
		
		public Sac() { // le constructeur rempli le sac à sa construction par 20 tuiles de chaque couleur
			this.deck = new ArrayList<Tuile>();
			for (int i = 0; i< 20; i++) {
				this.deck.add(new Tuile(1));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new Tuile(2));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new Tuile(3));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new Tuile(4));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new Tuile(5));
			}
			this.nbTuiles = 100;
		}
		
		public Tuile piocher() { 
		// enlève une tuile au hasard, baisse le nombre de tuiles du sac et renvoie la tuile retirée
			try {
				int r = (int) (Math.random()*nbTuiles);
				Tuile t = deck.get(r);
				deck.remove(r);
				nbTuiles--;
				return t;
			}catch(IndexOutOfBoundsException e) {
				piocher();
			}
			return null;
		}
	}
	
	public class Fabrique extends Ligne{

		public Fabrique() {
			super(4);
		}
		
		public boolean isEmpty() {
			for (int i = 0; i < this.line.length; i++) {
				if (!this.line[i].isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		public String premiereLigneToString() {
			String s = "";
			s += this.line[0].toString() + " ";
			s += this.line[1].toString();
			return s;	
		}
		
		public String deuxiemeLigneToString() {
			String s = "";
			s += this.line[2].toString() + " ";
			s += this.line[3].toString();
			return s;	
		}
		
		public String toString() {
			String s = "";
			for (int i = 0; i < this.line.length; i++) {
				if ( i == 2) {
					s += "\n";
				}
				s += this.line[i].toString() +" ";
			}
			return s;
		}
		
		public boolean remplir() {
		// rempli toute la fabrique avec les tuiles piocher au hasard du sac
			for (int i = 0; i < 4 ; i++) {
				if (sac.deck.isEmpty() && def.defausse.isEmpty()) {
				//si le sac et la défausse sont vide, on arrête de remplir la fabrique
					return false;
				}
				if (sac.deck.isEmpty()) {
				//si le sac est vide, on le rempli de la défausse et on continue à remplir les fabriques
					sac.deck = def.defausse;
				}
				this.line[i].remplir(sac.piocher());
			}return true;
		}
		
		public boolean CouleurDansFab(int c) {
		// vérifie que la couleur est bien dans la ligne
			for (int i= 0; i < this.line.length; i++) {
				if (this.line[i].getTuile().getCouleur() == c) {
					return true;
					//true si la couleur est bien dans la ligne
				}
			}
			return false;
			//false si la couleur n'est pas dans la ligne
		}
		
		public boolean piocher(int c) {
			//Piocher (renvoie une liste des tuiles qui n'ont pas été choisies, remplit un escalier)
			ArrayList<Tuile> choisies = new ArrayList<Tuile>();
			ArrayList<Tuile> nonChoisies = new ArrayList<Tuile>();
			if (!CouleurDansFab(c)) {
				System.out.println("La couleur demandée n'est pas dans la fabrique.");
				System.out.println();
				return false;
			}
			for (int i = 0; i < this.line.length; i++) {
				if (this.line[i].getTuile().getCouleur() == c) {
					choisies.add(this.line[i].getTuile());
				}else {
					nonChoisies.add(this.line[i].getTuile());
				}
			}//la fabrique choisie est vide mais les deux listes sont pleines
			System.out.println("Voulez vous remplir l'escalier ou le plancher ( Tapez 1 pour l'escalier, 2 pour le plancher)? ");
			String choice = sc.nextLine();
			final int j = Integer.parseInt(choice);
			if (j == 1) {
			// choix de remplir l'escalier
				System.out.println("Quelle ligne voulez-vous remplir ? (Valeur entre 0 et 4");
				String choix = sc.nextLine();
				try {
					final int i = Integer.parseInt(choix);
					for (int a = 0; a < choisies.size(); a++) {
						if (joueurActuel.m.couleurPleine(i,choisies.get(a).getCouleur())) {
							System.out.println("Case du mur de cette couleur déjà pleine");
							return false;
						}else {
							joueurActuel.e.motifs[i].remplir(choisies.get(a));
						}
					}
					for (int m = 0; m < this.line.length; m++) {
						this.line[m].vider();
					}
					centre.remplir(nonChoisies);
					return true;
				}catch( Exception e) {
					System.out.println("Valeur incorrecte");
					return false;
				}
				
			}if (j == 2) {
			//choix de remplir le plancher
				for (int b = 0; b < choisies.size(); b++) {
					joueurActuel.p.remplir(choisies.get(b));	
				}
				centre.remplir(nonChoisies);
				for (int m = 0; m < this.line.length; m++) {
					this.line[m].vider();
				}
				return true;
			}
			else {
				System.out.println("Ne correspond ni à l'escalier ni au plancher, réessayez.");
				System.out.println();
				return false;
			}
		}
		
		public boolean remplir(Tuile t) {
			// TODO Auto-generated method stub
			return false;
		}
	}
	
	public class Defausse {
		protected ArrayList<Tuile> defausse;
			
		public Defausse() {
			this.defausse = new ArrayList<Tuile>();
		}
		
		public void remplir(ArrayList<Tuile> a) {
			try {
				this.defausse.addAll(a);
			}catch(Exception e) {
				System.out.println("Erreur");
			}
		}
			
		public void vider() {
			this.defausse = null;
		}
		
		public String toString() {
			String s = "";
			for (int i = 0; i < defausse.size(); i++) {
				s += String.valueOf(this.defausse.get(i)) + " ";
			}
			return s;
		}
	}
	
	public class Centre {
		protected ArrayList<Tuile> c;
		
		public Centre() {
			this.c = new ArrayList<Tuile>();
			this.c.add(new Tuile(-1));
		}
		
		public void remplir(ArrayList<Tuile> l) {
			this.c.addAll(l);
		}
		
		public String toString() {
			if (this.c.isEmpty()) {
				return "Centre vide";
			}
			String s = "";
			for (Tuile t : this.c) {
				s = s + t.toString() + "|";
			}return s;
		}
		
		public void remplir(Tuile t) {
			this.c.add(t);
		}
		
		public boolean CouleurDansLeCentre(int color) {
		// vérfie si la couleur demandée est bien dans le centre
			for (int i = 0; i < this.c.size(); i++) {
				if (this.c.get(i).getCouleur() == color) {
					return true;
				}
			}
			return false;
		}
		
		public boolean piocher(int color) {
			ArrayList<Tuile> choisies = new ArrayList<Tuile>();
			ArrayList<Tuile> nonchoisies = new ArrayList<Tuile>();
			if (!CouleurDansLeCentre(color)) {
				System.out.println("La couleur demandée n'est pas dans le centre.");
				System.out.println();
				return false;
			}
			for (int i = 0; i < this.c.size(); i++) {
				if (this.c.get(i).getCouleur() == -1) {
				//ajoute la tuile -1 au plancher si elle est dans le centre
					joueurActuel.p.remplir(this.c.get(i));
					this.c.remove(i);
				}
				if (this.c.get(i).getCouleur() == color) {
					choisies.add(this.c.get(i));
				}else {
					nonchoisies.add(this.c.get(i));
				}
			}
			 
			System.out.println("Voulez vous remplir l'escalier ou le plancher (Tapez 1 pour l'escalier, 2 pour le plancher) ?");
			String choice = sc.nextLine();
			final int j = Integer.parseInt(choice);
			if (j == 1) {
				System.out.println("Quelle ligne voulez-vous remplir ? (Valeur entre 0 et 4)");
				String choix = sc.nextLine();
				try {
					final int i = Integer.parseInt(choix);
					for (int a = 0; a < choisies.size(); a++) {
						if (joueurActuel.m.couleurPleine(i,choisies.get(a).getCouleur())) {
							System.out.println("Case du mur de cette couleur déjà pleine");
							return false;		
						}else {
							joueurActuel.e.motifs[i].remplir(choisies.get(a));
						}
					}
					this.c = nonchoisies;
					return true;
				}catch (Exception e) {
					System.out.println("Valeur incorrecte");
					return false;
				}
			}
			if (j == 2) {
				for (int b = 0; b < choisies.size(); b++) {
					joueurActuel.p.remplir(choisies.get(b));
				}
				this.c = nonchoisies;
				joueurActuel.getSurplus().addAll(choisies);
				return true;
			}
			else {
				System.out.println("Ne correspond ni à l'escalier ni au plancher, réessayez.");
				System.out.println();
				return false;
			}
		}
		
		public boolean isEmpty() {
			return this.c.isEmpty();
		}
	}
	
	public void remplirDefausse(ArrayList<Tuile> a) {
		try {
			System.out.println(a);
			for (int i = 0; i < a.size(); i++) {
			//regarde si la tuile -1 est dans le surplus et la remet dans le centre 
				if (a.get(i).getCouleur() == -1) {
					centre.remplir(a.get(i));
					System.out.println("-1 ajouté");
					a.remove(a.get(i));
					System.out.println("-1 supprimé du surplus");
				}
			}
			System.out.println(a);
			this.def.remplir(a);
		}catch(NullPointerException e) {
			System.out.println("Surplus vide.");
		}
	}
	
	public void remplirFabrique() {
		for (int i = 0; i < Jeu.fabriques.length; i++) {
			Jeu.fabriques[i].remplir();
		}
	}
	
	public boolean fabriquesVides() {
	//Pour les méthodes du lanceur = vérification de fin de manche
		for (int i = 0; i < fabriques.length; i++) {
			if (! fabriques[i].isEmpty()) {
				return false;
				//false si au moins une des fabriques n'est pas vide
			}
		}return true;
	}
	
	public String fabriquestoString() {
		String s = "";
		for (int i = 0; i < Jeu.fabriques.length; i++) {
			s += this.getFabriques()[i].premiereLigneToString()+"   ";
		}
		s += "\n";
		
		for (int i = 0; i < Jeu.fabriques.length; i++) {
			s += this.getFabriques()[i].deuxiemeLigneToString()+"   ";
		}
		return s;
	}
	
	public String toString() throws NullPointerException {
		String s = "";
		try {
			s += this.fabriquestoString()+"\n"+ "\n"+ this.centre.toString() +"\n";
			s+= "\n";
			s +=  this.joueurActuel.toString();
		}catch(NullPointerException e) {
			s = "Joueur actuel pas initialisé.";
		}
		return s;
	}
	
	public void Initialisation() {
		for (int i = 0; i < this.getFabriques().length; i++) {
			this.getFabriques()[i].remplir();
		}
	}
	
	public boolean FinDeJeu() {
		try {
			if (this.joueurActuel.m.uneLignePleine()) {
				return true;
			}
			return false;
		}catch(NullPointerException e) {
			return false;
		}
	}
	
	
	public static void main(String[]args) {
		Jeu a = new Jeu(5);
		Plateau test = new Plateau("Joueur 1");
		a.setJoueurActuel(test);
		a.remplirFabrique();
		System.out.println(a);
		a.getFabriques()[0].piocher(1);
		System.out.println(a);
		
		
	}
	
}
