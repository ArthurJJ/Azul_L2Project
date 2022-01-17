import java.util.ArrayList;

public class Plateau { //création du plateau individuel
	protected Plancher p;
	protected String name;
	protected Mur m;
	protected Escalier e;
	protected int score;
	private ArrayList<Tuile> surplus;
	
	public class LigneMur {
		
		protected CaseMur[] line;
		
		public LigneMur(CaseMur c1,CaseMur c2,CaseMur c3,CaseMur c4,CaseMur c5) {
			CaseMur[] cm = {c1,c2,c3,c4,c5};
			this.line = cm;
		}
		
		public boolean isRempli() {
		// true si la ligne est pleine
			for (int i = 0; i < this.line.length; i++) {
				if (this.line[i].isEmpty()) {
					return false;
				}
			}return true;
		}
		
		public String toString() throws NullPointerException {
			String s = "";
			try {
				for (int i = 0; i < this.line.length; i++) {
					s += this.line[i].toString() + " ";
				}
				return s;
			}catch(NullPointerException a) {
				return ("Ligne Vide");
			}
		}
	}
	
	public class LigneMotif extends Ligne{ // création d'une ligne de l'escalier
		private int couleur; //change quand une tuile est mise sur la ligne et défini la couleur de la ligne
		private boolean rempli;
		
		public LigneMotif(int taille) {
			super(taille);
			this.couleur = ' ';
			this.rempli = false;
		}
		
		public boolean isEmpty() {
			for (int i = 0; i < this.line.length; i++) {
				if (!this.line[i].isEmpty()) {
					return false;
				}
			}
			return true;
		}
		
		public String toString(){
			String s = " ";
			try {
				for (int i = 0; i < this.line.length; i++) {
					s += this.line[i].toString() +" ";
				}
				return s;
			}catch(NullPointerException e) {
				return "La Ligne est vide.";
			}
		}
		
		public boolean isRempli() throws NullPointerException{
			try {
				this.rempli = (!this.line[this.line.length-1].isEmpty());
				return this.rempli;
			}catch(NullPointerException e) {
				return false;
			}
			//return true si la ligne est pleine
		}
		
		public boolean remplir(Tuile t) { //remplir une LigneMotif avec une tuile 
			if (this.isEmpty()) { // = cas où la ligneMotif est complètement vide
				this.line[0].remplir(t);
				this.couleur = t.getCouleur();
				return true;
			}
			if (this.isRempli()) { // = cas où la ligneMotif est complétement remplie ou tuile premier joueur
				p.remplir(t); // on remplie donc le plancher avec la tuile en trop
				return true;
			}
			// dernier cas = il y a de la place dans la ligneMotif
			for (int i = 0; i < this.line.length;i++) {
				if ((this.couleur == t.getCouleur()) && (this.line[i].isEmpty())) {
					this.line[i].remplir(t);
					return true;
				} 
			}
			return false;
		}
		
		public void vider() {
			for (int i = 0; i < this.line.length; i++) {
				this.line[i].vider();
			}
		}
	}
		
	public class Mur {
		protected LigneMur[] mur;
				
		public Mur() {
		// crétion du mur du plateau
			this.mur = new LigneMur[5];
				
			CaseMur a1 = new CaseMur(1);
			CaseMur a2 = new CaseMur(1);
			CaseMur a3 = new CaseMur(1);
			CaseMur a4 = new CaseMur(1);
			CaseMur a5 = new CaseMur(1);
			CaseMur b1 = new CaseMur(2);
			CaseMur b2 = new CaseMur(2);
			CaseMur b3 = new CaseMur(2);
			CaseMur b4 = new CaseMur(2);
			CaseMur b5 = new CaseMur(2);
			CaseMur c1 = new CaseMur(3);
			CaseMur c2 = new CaseMur(3);
			CaseMur c3 = new CaseMur(3);
			CaseMur c4 = new CaseMur(3);
			CaseMur c5 = new CaseMur(3);
			CaseMur d1 = new CaseMur(4);
			CaseMur d2 = new CaseMur(4);
			CaseMur d3 = new CaseMur(4);
			CaseMur d4 = new CaseMur(4);
			CaseMur d5 = new CaseMur(4);
			CaseMur e1 = new CaseMur(5);
			CaseMur e2 = new CaseMur(5);
			CaseMur e3 = new CaseMur(5);
			CaseMur e4 = new CaseMur(5);
			CaseMur e5 = new CaseMur(5);
			
			mur[0] = new LigneMur(a1,b1,c1,d1,e1);		
			mur[1] = new LigneMur(e2,a2,b2,c2,d2);		
			mur[2] = new LigneMur(d3,e3,a3,b3,c3);
			mur[3] = new LigneMur(c4,d4,e4,a4,b4);
			mur[4] = new LigneMur(b5,c5,d5,e5,a5);
		}
				
		public void remplirMur() {
		// quand ligneMotif pleine, une tuile va dans le mur, le reste dans le surplus puis dans la défausse
			for (int j = 0; j < 5; j++) {
				if (e.motifs[j].isRempli()) {
					for (int i = 0; i < 5; i++) {
						if (!e.motifs[j].line[e.motifs[j].line.length - 1].isEmpty() && e.motifs[j].line[e.motifs[j].line.length-1].getTuile().getCouleur() == this.mur[j].line[i].getCouleur() && this.mur[j].line[i].isEmpty()) {
						//cherche la case de la bonne couleur dans le mur et vérifie si elle est vide
							this.mur[j].line[i].remplir(e.motifs[j].line[e.motifs[j].line.length -1].getTuile());
							// rempli le mur avec la dernière tuile de la ligneMotif pleine
							setScore();
							// Le score est modifié dès qu'une tuile est placée dans le mur
							e.motifs[j].line[e.motifs[j].line.length -1].vider();
							// enlève la tuile rajoutée au mur de la ligne Motif
						}
					}
					for (int i = 0; i < e.motifs[j].line.length; i++) {
						if (!e.motifs[j].line[i].isEmpty()) {
							surplus.add(e.motifs[j].line[i].getTuile());
							// ajoute le reste de la ligneMotif au surplus qui sera ajouté à la défausse
						}
					}
				e.motifs[j].vider();
				}
			}
		}
		
		public boolean uneLignePleine() {
		// true si au moins une ligne est pleine
			for (int i = 0; i < this.mur.length; i++) {
				if (this.mur[i].isRempli()) {
					return true;
				}
			}return false;
		}
		
		public String uneLignetoString(int numL) { //test d'une idée pour le toString final du plateau
			String s = "";
			for (int i = 0; i < this.mur.length; i++) {
				if (!this.mur[numL].line[i].isEmpty()) {
					s += "# ";
				}else {
					s += Integer.toString(this.mur[numL].line[i].getCouleur()) +" ";
				}
			}
			return s;
		}
			
		public String toString() {
			String s = "";
			for (int i = 0; i < this.mur.length; i++) {
				for (int j = 0; j < this.mur[i].line.length; j++) {
					if (!this.mur[i].line[j].isEmpty()) {
						s += "# ";
					}else {						
						s += Integer.toString(this.mur[i].line[j].getCouleur()) +" ";
					}
				}
				s+="\n";
			}
			return s;
		}
		
		public boolean couleurPleine(int nbLigne, int c) {
			for (int i = 0; i < 5; i++) {
				if (!this.mur[nbLigne].line[i].isEmpty() && this.mur[nbLigne].line[i].getCouleur() == c) {
					return true;
				}
			}
			return false;
		}
	}
	
	public class Plancher extends Ligne{
		protected boolean vide;
			
		public Plancher() {
			super(7);
			this.vide = true;
		}
		
		public boolean remplir(Tuile t) {
			for (int i = 0; i < this.line.length; i++) {
				if (this.line[i].isEmpty()) {
					this.line[i].remplir(t);
					this.vide = false;
					return true;
				}
			}
			if ( !this.line[this.line.length-1].isEmpty()) {
			// Cas où le placher est plein
				surplus.add(t);
				return true;
			}
			return false;
		}
			
		public int vider() {
		//renvoie la valeur de la case si elle est pleine sinon ajoute 0	
			int nb = 0;
			for (int i = 0; i < this.line.length; i++) {
				if (this.line[i].rempli) {
				//compte le nombre de tuile dans le plancher
					nb++;
				}
				if ( this.line[i].rempli && this.line[i].getTuile().getCouleur() == -1 ) {
					//vérifie qu'il y a la tuile -1 dans le plancher, l'ajoute au surplus et quand le surplus sera ajouté on mettra la tuile -1 dans le centre
						surplus.add(this.line[i].getTuile());
				}
				if (this.line[i].rempli && this.line[i].getTuile().getCouleur() != -1) {
					surplus.add(this.line[i].getTuile());
				}
				this.line[i].vider();
			}
			this.vide = true;
			if (nb == 1) {
				return -1;
			}
			if (nb == 2) {
				return -2;
			}
			if (nb == 3) {
				return -4;
			}
			if (nb == 4) {
				return -6;
			}
			if (nb == 5) {
				return -8;
			}
			if (nb == 6) {
				return -11;
			}
			if (nb == 7) {
				return -14;
			}
			return 0;
		}
		
		public boolean PremiereTuilePresente() {
			if (this.vide) {
				return false;
			}
			for (int i = 0; i < this.line.length; i++) {
				if ( this.line[i].rempli && this.line[i].getTuile().getCouleur() == -1) {
					return true;
				}
			}
			return false;
		}
			
		public String toString() throws NullPointerException{
			String s="";
			try {
				for (int i = 0; i < this.line.length; i++) {
					s += this.line[i].toString() +" ";
				}
				return s;
			}catch(NullPointerException e) {
				return ("Plancher vide");
			}
		}
	}
	
	public class Escalier {
		public LigneMotif[] motifs;
		
		public Escalier() {
			this.motifs = new LigneMotif[5];
			LigneMotif a = new LigneMotif(1);
			LigneMotif b = new LigneMotif(2);
			LigneMotif c = new LigneMotif(3);
			LigneMotif d = new LigneMotif(4);
			LigneMotif e = new LigneMotif(5);
			this.motifs[0] = a;
			this.motifs[1] = b;
			this.motifs[2] = c;
			this.motifs[3] = d;
			this.motifs[4] = e;
		}
		
		public String uneLignetoString(int numL) throws ArrayIndexOutOfBoundsException{ // test d'une idée pour toString de plateau
			String s = "";
			try {
				for (int i = 0; i<this.motifs.length; i++) {
					if (this.motifs[numL].line[i].isEmpty()) {
						
						s += "| ";
					}else {
						s += this.motifs[numL].line[i].toString() +" ";
					}
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			return s;
		}
		
		public String toString() {
			String s = "";
			for (int i = 0; i < this.motifs.length; i++) {
				for (int j = 0; j < this.motifs[i].line.length; j++) {
					if (this.motifs[i].line[j].isEmpty()) {
						s += "| ";
					}else {
						s += this.motifs[i].line[j].toString() +" ";
					}
				}
				s+="\n";
			}
			return s;
		}
		
		public boolean LignePleine(int nbL) {
		//renvoie true si la ligne est pleine -> utile pour le lanceur et savoir quand remplir le mur
			if (this.motifs[nbL].rempli) {
				return true;
			}return false;
		}
	}
	
	public Plateau(String nom) { // constructeur de plateau = inituialisation escalier, mur, plancher et score
		this.e = new Escalier();
		this.m = new Mur();
		this.p = new Plancher();
		this.score = 0;
		this.surplus = new ArrayList<Tuile>();
		this.name = nom;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String emtoString() throws ArrayIndexOutOfBoundsException{
		String s = "";
		String t = "";
		String f = "";
		String g = "";
		
		for (int i = 0; i < this.m.mur.length; i++) {
			s = this.e.uneLignetoString(i);
			t = this.m.uneLignetoString(i);
			int h = this.e.motifs[i].line.length;
				if (h == 1) {
					f = "         ";
				}if (h == 2) {
					f = "       ";
				}if (h == 3) {
					f = "     ";
				}if (h == 4) {
					f = "   ";
				}if (h == 5) {
					f = " ";
				}
			g += (s+f+t) + "\n";
		} 
		return g ;
	}
	
	
	public String toString() {
		String s = "";
		s += this.emtoString()+"\n";
		s += this.p.toString() + "   " + this.score;
		return s;
	}
	
	// METHODES SCORE
	public void setScore() { // METHODE PRINCIPALE DU SCORE a appeler pour mettre a jour le score du plateau
		this.score = 0;
		for (int i = 0; i < this.m.mur.length; i++) {
			for (int j = 0; j < this.m.mur[0].line.length; j++) {
				addscore(i,j);
				}
		}
		for (int i = 0; i < this.m.mur[0].line.length; i++) {
			if (colonneComplete(i)) score += 7;
		}
		for (int i = 0; i < this.m.mur.length; i++) {
			if (ligneComplete(i)) score += 2;
		}
		for(int i = 1; i < 6 ;i++) {
			if (couleurComplete(i)) score += 10;
		}
		this.score += this.p.vider();
	}
		
	public void addscore(int i, int j) { //case (i,j) remplie = +1 , case adjacente remplie = +1
		if(!this.m.mur[i].line[j].isEmpty()) {
			this.score++;
			if(i+1 < this.m.mur.length) {
				if(!this.m.mur[i+1].line[j].isEmpty())this.score++;
			}
			if (j+1 < this.m.mur[0].line.length) {
				if(!this.m.mur[i].line[j+1].isEmpty()) this.score++;
			}	
		}
	}
	
	public boolean colonneComplete(int index) {
		for (int i = 0; i < this.m.mur.length; i++) {
			if(this.m.mur[i].line[index].isEmpty()) return false;
		}return true;
	}
		
	public boolean ligneComplete(int index) {
		for (int i = 0; i < this.m.mur.length; i++) {
			if(this.m.mur[index].line[i].isEmpty()) return false;
		}return true;
	}
		
	public boolean couleurComplete(int color) {
		int r = 0; // nombre de tuile de couleur color remplies
		for (int i = 0; i < this.m.mur.length; i++) {
			for (int j = 0; j < this.m.mur[0].line.length; j++) {
				if(this.m.mur[i].line[j].getCouleur() == color && !this.m.mur[i].line[j].isEmpty()) {
					r++;
				}
			}
		} if (r == 5)return true;
		return false;
	}
	// FIN METHODES SCORE
	
	public ArrayList<Tuile> getSurplus(){
		return this.surplus;
	}
	
	public void Decoration() {
		this.m.remplirMur();
	}
	
	public void remplir(Tuile t, int ligne) {
		this.e.motifs[ligne].remplir(t);
	}
	
	
	public static void main(String[]args) {
		Plateau test = new Plateau("Joueur 1");
		//System.out.println(test);
		Tuile a = new Tuile(1);
		Tuile b = new Tuile(5);
		Tuile c = new Tuile(5);
		System.out.println(test.e.motifs[0].remplir(a));
		//System.out.println(test);
		System.out.println(test.e.motifs[1].remplir(b));
		test.e.motifs[1].remplir(c);
		//System.out.println(test);
		System.out.println(test.getSurplus());
		test.Decoration();
		System.out.println(test);
		System.out.println(test.getSurplus());
		//System.out.println(test.p.remplir(b));
		//System.out.println(test);
		
	}
}