import javax.swing.*;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlateauInterface extends JPanel {
	
	private Escalier Escalier;
	private Mur Mur;
	private Plancher Plancher;
	protected ArrayList<TuileInterface> surplus = new ArrayList<TuileInterface>(); // VA DANS LA DEFAUSSE A CHAQUE TOUR
	protected int score;
	protected int malus;
	protected JPanel Scor;
	protected JLabel scor;
	protected String name;
	protected String atoi;
	
	protected ArrayList<TuileInterface> memotuile = new ArrayList<TuileInterface>(); // GARDE LA/LES TUILE(S) DE LA FABRIQUE CLIQUEE EN MEMOIRE 
	protected ArrayList<TuileInterface> memocentre = new ArrayList<TuileInterface>(); // TUILES DU CENTRE CHOISIES POUR REMPLIR LES LIGNESMOTIFS
	protected boolean AJoué; // INDIQUE QUE LE JOUEUR A JOUé SON COUP, ACTIVE DES METHODES DE GESTION
	protected PlateauInterface joueursuivant; // INDIQUE QUI EST LE JOUEUR D'APRES
	protected boolean nextPJ; // INDIQUE SI LE JOUEUR A EU LE JETON PJ
	
	public PlateauInterface(String player) {
		this.nextPJ = false;
		this.atoi = "";
		this.AJoué = false;
		this.name = player;
		this.score = 0;
		setLayout(new GridLayout(2,2));
		
		this.Escalier = new Escalier();
		this.add(this.Escalier);
		
		this.Mur = new Mur();
		this.add(Mur);
		
		this.Plancher = new Plancher();
		this.add(Plancher);	
		
		this.Scor = new JPanel();
		this.scor = new JLabel(atoi + name + atoi + " : " + this.score);
		Font font = new Font("Arial",Font.BOLD, 26);
		scor.setFont(font);
		Scor.setLayout(new BorderLayout());
		Scor.add(scor, BorderLayout.CENTER);
		this.add(Scor);
		this.setBorder(BorderFactory.createLineBorder(Color.black,4));
	}
	
	public class Escalier extends JPanel {

		private JPanel B1;
		private JPanel B2;
		private JPanel B3;
		private JPanel B4;
		private JPanel B5;
		private JPanel B6;
		private JPanel B7;
		private JPanel B8;
		private JPanel B9;
		private JPanel B10;
		private CaseInterface GC1; // 0.0
		private CaseInterface GC2; // 1.0
		private CaseInterface GC3; // 2.0
		private CaseInterface GC4; // 2.2
		private CaseInterface GC5; // 3.0
		private CaseInterface GC6; // 3.2
		private CaseInterface GC7; // 4.0
		private CaseInterface GC8; // 4.2
		private CaseInterface GC9; // 4.4
		private CaseInterface GF1; // 1.1
		private CaseInterface GF2; // 2.1
		private CaseInterface GF3; // 3.1
		private CaseInterface GF4; // 3.3
		private CaseInterface GF5; // 4.1
		private CaseInterface GF6; // 4.3

		
		public Escalier() {
			Escalier ref = this;
			this.setLayout(new GridLayout(5,5));
			//LIGNE 1
			this.B1 = new JPanel();
			this.B2 = new JPanel();
			this.B3 = new JPanel();
			//JLabel m = new JLabel("Escalier");
			//m.setHorizontalAlignment(0);
			//B3.add(m);
			this.B4 = new JPanel();
			this.GC1 = new CaseInterface();
			this.GC1.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC1,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC1,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.add(B1);
			this.add(B2);
			this.add(B3);
			this.add(B4);
			this.add(GC1);
			
			//LIGNE 2
			this.B5 = new JPanel();
			this.B6 = new JPanel();
			this.B7 = new JPanel();
			this.GF1 = new CaseInterface(0);
			this.GF1.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GF1,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GF1,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GC2 = new CaseInterface();
			this.GC2.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC2,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC2,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.add(B5);
			this.add(B6);
			this.add(B7);
			this.add(GC2);
			this.add(GF1);
			
			//LIGNE 3
			this.B8 = new JPanel();
			this.B9 = new JPanel();
			this.GC3 = new CaseInterface();
			this.GC3.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC3,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC3,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GF2 = new CaseInterface(0);
			this.GF2.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GF2,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GF2,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GC4 = new CaseInterface();
			this.GC4.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC4,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC4,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.add(B8);
			this.add(B9);
			this.add(GC3);
			this.add(GF2);
			this.add(GC4);
			
			//LIGNE 4
			this.B10 = new JPanel();
			this.GF3= new CaseInterface(0);
			this.GF3.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GF3,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GF3,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GC5 = new CaseInterface();
			this.GC5.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC5,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC5,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GF4 = new CaseInterface(0);
			this.GF4.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GF4,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GF4,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GC6 = new CaseInterface();
			this.GC6.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC6,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC6,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.add(B10);
			this.add(GC5);
			this.add(GF3);
			this.add(GC6);
			this.add(GF4);
			
			//LIGNE 5
			this.GC7 = new CaseInterface();
			this.GC7.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC7,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC7,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GF5= new CaseInterface(0);
			this.GF5.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GF5,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GF5,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GC8 = new CaseInterface();
			this.GC8.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC8,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC8,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GF6 = new CaseInterface(0);
			this.GF6.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GF6,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GF6,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.GC9 = new CaseInterface();
			this.GC9.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
					//INTERACTIONS
					if (memotuile.isEmpty() && memocentre.isEmpty()) {
						// MESSAGE ?
					}
					if (!memotuile.isEmpty()) {
						memotuile.forEach((TuileInterface t) -> remplirLigne(GC9,t)); 
						memotuile.clear();
						joué();	
					}
					if (!memocentre.isEmpty()) {
						memocentre.forEach((TuileInterface t) -> remplirLigne(GC9,t)); 
						memocentre.clear();
						joué();	
					}
					ref.updateUI();
					Plancher.updateUI();
						     
				} 
		    });
			this.add(GC7);
			this.add(GF5);
			this.add(GC8);
			this.add(GF6);
			this.add(GC9);
		}
		
		public boolean ligneRemplie(int ligne) { // REGARDER SI LES LIGNES D'ESCALIER SONT REMPLIES EN FIN DE TOUR
			if (ligne == 1) {
				if (this.GC1.isRempli()) return true;
			}
			if (ligne == 2) {
				if (this.GC2.isRempli() && this.GF1.isRempli()) return true;
			}
			if (ligne == 3) {
				if (this.GC3.isRempli() && this.GF2.isRempli() && this.GC4.isRempli()) return true;
			}
			if (ligne == 4) {
				if (this.GC5.isRempli() && this.GF3.isRempli() && this.GC6.isRempli() && this.GF4.isRempli()) return true;
			}
			if (ligne == 5) {
				if (this.GC7.isRempli() && this.GF5.isRempli() && this.GC8.isRempli() && this.GF6.isRempli() && this.GC9.isRempli()) return true;
			} return false;
		}
		
		public boolean remplirCase(CaseInterface c, TuileInterface t) { // SIMPLIFIE REMPLIR LIGNE
			if (!c.isRempli()) {
				c.remplir(t);
				c.updateUI();
				return true;
			}
			
			return false;
		}
		
		public boolean remplirLigne(CaseInterface c, TuileInterface t) { // REMPLIT LA LIGNE MOTIF DE LA CASE C AVEC T
			// LIGNE 1
			if (c == this.GC1) {
				if (t.getCouleur().equals(Color.green)) { // PREMIER JOUEUR
					Plancher.remplir(t); // REMPLIT PLANCHER OU ENVOIE DANS SURPLUS
					return true;
				} else if (!this.GC1.isRempli()) {
					return remplirCase(this.GC1,t);
				} else { // LIGNE PLEINE
					Plancher.remplir(t);
					return true;
				}
			}
			// LIGNE 2
			if (c == this.GC2 || c == this.GF1) {
				if (t.getCouleur().equals(Color.green)) { // PREMIER JOUEUR
					Plancher.remplir(t); // REMPLIT PLANCHER OU ENVOIE DANS SURPLUS
					return true;
				} else if (!this.GC2.isRempli()) {
					return remplirCase(this.GC2,t);
				} else if (!this.GF1.isRempli() && t.getCouleur().equals(this.GC2.getTuile().getCouleur())) {
					return remplirCase(this.GF1,t);
				} else { // LIGNE PLEINE
					Plancher.remplir(t);
					return true;
				}
			}
			// LIGNE 3
			if (c == this.GC3 || c == this.GF2 || c == this.GC4) {
				if (t.getCouleur().equals(Color.green)) { // PREMIER JOUEUR
					Plancher.remplir(t); // REMPLIT PLANCHER OU ENVOIE DANS SURPLUS
					return true;
				} else if (!this.GC3.isRempli()) {
					return remplirCase(this.GC3,t);
				} else if (!this.GF2.isRempli() && t.getCouleur().equals(this.GC3.getTuile().getCouleur())) {
					return remplirCase(this.GF2,t);
				} else if (!this.GC4.isRempli() && t.getCouleur().equals(this.GC3.getTuile().getCouleur())) {
					return remplirCase(this.GC4,t);
				} else { // LIGNE PLEINE
					Plancher.remplir(t);
					return true;
				}
			}
			// LIGNE 4
			if (c == this.GC5 || c == this.GF3 || c == this.GC6 || c == this.GF4) {
				if (t.getCouleur().equals(Color.green)) { // PREMIER JOUEUR
					Plancher.remplir(t); // REMPLIT PLANCHER OU ENVOIE DANS SURPLUS
					return true;
				} else if (!this.GC5.isRempli()) {
					return remplirCase(this.GC5,t);
				} else if (!this.GF3.isRempli() && t.getCouleur().equals(this.GC5.getTuile().getCouleur())) {
					return remplirCase(this.GF3,t);
				} else if (!this.GC6.isRempli() && t.getCouleur().equals(this.GC5.getTuile().getCouleur())) {
					return remplirCase(this.GC6,t);
				} else if (!this.GF4.isRempli() && t.getCouleur().equals(this.GC5.getTuile().getCouleur())) {
					return remplirCase(this.GF4,t);
				} else { // LIGNE PLEINE
					Plancher.remplir(t);
					return true;
				}
			}
			// LIGNE 5
			if (c == this.GC7 || c == this.GF5 || c == this.GC8 || c == this.GF6 || c == this.GC9) {
				if (t.getCouleur().equals(Color.green)) { // PREMIER JOUEUR
					Plancher.remplir(t); // REMPLIT PLANCHER OU ENVOIE DANS SURPLUS
					return true;
				} else if (!this.GC7.isRempli()) {
					return remplirCase(this.GC7,t);
				} else if (!this.GF5.isRempli() && t.getCouleur().equals(this.GC7.getTuile().getCouleur())) {
					return remplirCase(this.GF5,t);
				} else if (!this.GC8.isRempli() && t.getCouleur().equals(this.GC7.getTuile().getCouleur())) {
					return remplirCase(this.GC8,t);
				} else if (!this.GF6.isRempli() && t.getCouleur().equals(this.GC7.getTuile().getCouleur())) {
					return remplirCase(this.GF6,t);
				} else if (!this.GC9.isRempli() && t.getCouleur().equals(this.GC7.getTuile().getCouleur())) {
					return remplirCase(this.GC9,t);
				} else { // LIGNE PLEINE
					Plancher.remplir(t);
					return true;
				}
			} this.updateUI();
			return false;
		}
		
		public void viderLigne(int ligne) {
			if (ligne == 1) {
				if (this.GC1.isRempli()) {
					surplus.add(this.GC1.getTuile());
					this.GC1.vider();
				}
			}
			if (ligne == 2) {
				if (this.GC2.isRempli()) {
					surplus.add(this.GC2.getTuile());
					this.GC2.vider();
				}
				if (this.GF1.isRempli()) {
					surplus.add(this.GF1.getTuile());
					this.GF1.vider();
				}
			}
			if (ligne == 3) {
				if (this.GC3.isRempli()) {
					surplus.add(this.GC3.getTuile());
					this.GC3.vider();
				}
				if (this.GF2.isRempli()) {
					surplus.add(this.GF2.getTuile());
					this.GF2.vider();
				}
				if (this.GC4.isRempli()) {
					surplus.add(this.GC4.getTuile());
					this.GC4.vider();
				}
			}
			if (ligne == 4) {
				if (this.GC5.isRempli()) {
					surplus.add(this.GC5.getTuile());
					this.GC5.vider();
				}
				if (this.GF3.isRempli()) {
					surplus.add(this.GF3.getTuile());
					this.GF3.vider();
				}
				if (this.GC6.isRempli()) {
					surplus.add(this.GC6.getTuile());
					this.GC6.vider();
				}
				if (this.GF4.isRempli()) {
					surplus.add(this.GF4.getTuile());
					this.GF4.vider();
				}
			}
			if (ligne == 5) {
				if (this.GC7.isRempli()) {
					surplus.add(this.GC7.getTuile());
					this.GC7.vider();
				}
				if (this.GF5.isRempli()) {
					surplus.add(this.GF5.getTuile());
					this.GF5.vider();
				}
				if (this.GC8.isRempli()) {
					surplus.add(this.GC8.getTuile());
					this.GC8.vider();
				}
				if (this.GF6.isRempli()) {
					surplus.add(this.GF6.getTuile());
					this.GF6.vider();
				}
				if (this.GC9.isRempli()) {
					surplus.add(this.GC9.getTuile());
					this.GC9.vider();
				}
				
			}
		}
		
		public void vider() { // A APPELER EN FIN DE TOUR
			if (this.ligneRemplie(1)) {
				Mur.remplir(this.GC1.getTuile(),1,this.GC1.getTuile().getCouleur());
				this.GC1.vider();		
			} else {
				viderLigne(1);
			}
			if (this.ligneRemplie(2)) {
				Mur.remplir(this.GC2.getTuile(),2,this.GC2.getTuile().getCouleur());
				this.GC2.vider();
				surplus.add(this.GF1.getTuile());
				this.GF1.vider();
			} else {
				viderLigne(2);
			}
			if (this.ligneRemplie(3)) {
				Mur.remplir(this.GC3.getTuile(),3,this.GC3.getTuile().getCouleur());
				this.GC3.vider();
				surplus.add(this.GF2.getTuile());
				this.GF2.vider();
				surplus.add(this.GC4.getTuile());
				this.GC4.vider();
			} else {
				viderLigne(3);
			}
			if (this.ligneRemplie(4)) {
				Mur.remplir(this.GC5.getTuile(),4,this.GC5.getTuile().getCouleur());
				this.GC5.vider();
				surplus.add(this.GF3.getTuile());
				this.GF3.vider();
				surplus.add(this.GC6.getTuile());
				this.GC6.vider();
				surplus.add(this.GF4.getTuile());
				this.GF4.vider();
			} else {
				viderLigne(4);
			}
			if (this.ligneRemplie(5)) {
				Mur.remplir(this.GC7.getTuile(),5,this.GC7.getTuile().getCouleur());
				this.GC7.vider();
				surplus.add(this.GF5.getTuile());
				this.GF5.vider();
				surplus.add(this.GC8.getTuile());
				this.GC8.vider();
				surplus.add(this.GF6.getTuile());
				this.GF6.vider();
				surplus.add(this.GC9.getTuile());
				this.GC9.vider();
			} else {
				viderLigne(5);
			}
		}
		
	}
	
	public class Mur extends JPanel{
		
		private CaseInterface[][] mur = new CaseInterface[5][5]; // IDEE TARDIVE POUR MANIPULER LES INTERFACES FACILEMENT
		private CaseInterface B1;
		private CaseInterface B2;
		private CaseInterface B3;
		private CaseInterface B4;
		private CaseInterface B5;
		private CaseInterface J1;
		private CaseInterface J2;
		private CaseInterface J3;
		private CaseInterface J4;
		private CaseInterface J5;
		private CaseInterface R1;
		private CaseInterface R2;
		private CaseInterface R3;
		private CaseInterface R4;
		private CaseInterface R5;
		private CaseInterface N1;
		private CaseInterface N2;
		private CaseInterface N3;
		private CaseInterface N4;
		private CaseInterface N5;
		private CaseInterface W1;
		private CaseInterface W2;
		private CaseInterface W3;
		private CaseInterface W4;
		private CaseInterface W5;
		
		public Mur() {
			
			this.setLayout(new GridLayout(5,5));
			
			this.B1 = new CaseInterface(new Color(190,190,250));
			this.J1 = new CaseInterface(new Color(235,255,135));
			this.R1 = new CaseInterface(new Color(255,125,125));
			this.N1 = new CaseInterface(new Color(70,70,70));
			this.W1 = new CaseInterface(new Color(210,210,210));
			this.add(B1);
			this.add(J1);
			this.add(R1);
			this.add(N1);
			this.add(W1);
			CaseInterface[] l1 = {B1,J1,R1,N1,W1};
			this.mur[0] = l1;
			
			this.B2 = new CaseInterface(new Color(190,190,250));
			this.J2 = new CaseInterface(new Color(235,255,135));
			this.R2 = new CaseInterface(new Color(255,125,125));
			this.N2 = new CaseInterface(new Color(70,70,70));
			this.W2 = new CaseInterface(new Color(210,210,210));
			this.add(W2);
			this.add(B2);
			this.add(J2);
			this.add(R2);
			this.add(N2);
			CaseInterface[] l2 = {B2,J2,R2,N2,W2};
			this.mur[1] = l2;
			
			this.B3 = new CaseInterface(new Color(190,190,250));
			this.J3 = new CaseInterface(new Color(235,255,135));
			this.R3 = new CaseInterface(new Color(255,125,125));
			this.N3 = new CaseInterface(new Color(70,70,70));
			this.W3 = new CaseInterface(new Color(210,210,210));
			this.add(N3);
			this.add(W3);
			this.add(B3);
			this.add(J3);
			this.add(R3);
			CaseInterface[] l3 = {B3,J3,R3,N3,W3};
			this.mur[2] = l3;
			
			this.B4 = new CaseInterface(new Color(190,190,250));
			this.J4 = new CaseInterface(new Color(235,255,135));
			this.R4 = new CaseInterface(new Color(255,125,125));
			this.N4 = new CaseInterface(new Color(70,70,70));
			this.W4 = new CaseInterface(new Color(210,210,210));
			this.add(R4);
			this.add(N4);
			this.add(W4);
			this.add(B4);
			this.add(J4);
			CaseInterface[] l4 = {B4,J4,R4,N4,W4};
			this.mur[3] = l4;
			
			this.B5 = new CaseInterface(new Color(190,190,250));
			this.J5 = new CaseInterface(new Color(235,255,135));
			this.R5 = new CaseInterface(new Color(255,125,125));
			this.N5 = new CaseInterface(new Color(70,70,70));
			this.W5 = new CaseInterface(new Color(210,210,210));
			this.add(J5);
			this.add(R5);
			this.add(N5);
			this.add(W5);
			this.add(B5);
			CaseInterface[] l5 = {B5,J5,R5,N5,W5};
			this.mur[4] = l5;
			
		}
		
		public CaseInterface[][] getMur(){
			return this.mur;
		}
		
		public void remplir(TuileInterface t,int ligne, Color couleur) { // T EST LA TUILE DE LA LIGNE ALLANT DANS MUR
			if (ligne == 1) {
				if (couleur.equals(Color.blue)) {
					B1.remplir(t);
				}
				if (couleur.equals(Color.yellow)) {
					J1.remplir(t);
				}
				if (couleur.equals(Color.red)) {
					R1.remplir(t);
				}
				if (couleur.equals(Color.black)) {
					N1.remplir(t);
				}
				if (couleur.equals(Color.white)) {
					W1.remplir(t);
				}
			}
			if (ligne == 2) {
				if (couleur.equals(Color.blue)) {
					B2.remplir(t);
				}
				if (couleur.equals(Color.yellow)) {
					J2.remplir(t);
				}
				if (couleur.equals(Color.red)) {
					R2.remplir(t);
				}
				if (couleur.equals(Color.black)) {
					N2.remplir(t);
				}
				if (couleur.equals(Color.white)) {
					W2.remplir(t);
				}
			}
			if (ligne == 3) {
				if (couleur.equals(Color.blue)) {
					B3.remplir(t);
				}
				if (couleur.equals(Color.yellow)) {
					J3.remplir(t);
				}
				if (couleur.equals(Color.red)) {
					R3.remplir(t);
				}
				if (couleur.equals(Color.black)) {
					N3.remplir(t);
				}
				if (couleur.equals(Color.white)) {
					W3.remplir(t);
				}
			}
			if (ligne == 4) {
				if (couleur.equals(Color.blue)) {
					B4.remplir(t);
				}
				if (couleur.equals(Color.yellow)) {
					J4.remplir(t);
				}
				if (couleur.equals(Color.red)) {
					R4.remplir(t);
				}
				if (couleur.equals(Color.black)) {
					N4.remplir(t);
				}
				if (couleur.equals(Color.white)) {
					W4.remplir(t);
				}
			}
			if (ligne == 5) {
				if (couleur.equals(Color.blue)) {
					B5.remplir(t);
				}
				if (couleur.equals(Color.yellow)) {
					J5.remplir(t);
				}
				if (couleur.equals(Color.red)) {
					R5.remplir(t);
				}
				if (couleur.equals(Color.black)) {
					N5.remplir(t);
				}
				if (couleur.equals(Color.white)) {
					W5.remplir(t);
				}
			}
		}
		
	}
	
	public class Plancher extends JPanel{

		private JPanel b1;
		private JPanel b2;
		private JPanel b3;
		private JPanel b4;
		private JPanel b5;
		private JPanel b6;
		private JPanel b7;
		private CaseInterface gc1;
		private CaseInterface gc2;
		private CaseInterface gc3;
		private CaseInterface gc4;
		private CaseInterface gf1;
		private CaseInterface gf2;
		private CaseInterface gf3;
		
		public Plancher() {

			this.setLayout(new GridLayout(2,1));
			this.b1 = new JPanel();
			JLabel m1 = new JLabel("-1");
			m1.setHorizontalAlignment(0);
			b1.setLayout(new BorderLayout());
			b1.add(m1, BorderLayout.SOUTH);
			this.b2 = new JPanel();
			JLabel M1 = new JLabel("-1");
			M1.setHorizontalAlignment(0);
			b2.setLayout(new BorderLayout());
			b2.add(M1, BorderLayout.SOUTH);
			this.b3 = new JPanel();
			JLabel m2 = new JLabel("-2");
			m2.setHorizontalAlignment(0);
			b3.setLayout(new BorderLayout());
			b3.add(m2, BorderLayout.SOUTH);
			this.b4 = new JPanel();
			JLabel M2 = new JLabel("-2");
			M2.setHorizontalAlignment(0);
			b4.setLayout(new BorderLayout());
			b4.add(M2, BorderLayout.SOUTH);
			this.b5 = new JPanel();
			JLabel mm2 = new JLabel("-2");
			mm2.setHorizontalAlignment(0);
			b5.setLayout(new BorderLayout());
			b5.add(mm2, BorderLayout.SOUTH);
			this.b6 = new JPanel();
			JLabel m3 = new JLabel("-3");
			m3.setHorizontalAlignment(0);
			b6.setLayout(new BorderLayout());
			b6.add(m3, BorderLayout.SOUTH);
			this.b7 = new JPanel();
			JLabel M3 = new JLabel("-3");
			M3.setHorizontalAlignment(0);
			b7.setLayout(new BorderLayout());
			b7.add(M3, BorderLayout.SOUTH);
			this.add(b1);
			this.add(b2);
			this.add(b3);
			this.add(b4);
			this.add(b5);
			this.add(b6);
			this.add(b7);
			
			this.gc1 = new CaseInterface();
			gc1.setBackground(new Color(204,204,204));
			this.gf1 = new CaseInterface();
			gf1.setBackground(new Color(102,102,102));
			this.gc2 = new CaseInterface();
			gc2.setBackground(new Color(204,204,204));
			this.gf2 = new CaseInterface();
			gf2.setBackground(new Color(102,102,102));
			this.gc3 = new CaseInterface();
			gc3.setBackground(new Color(204,204,204));
			this.gf3 = new CaseInterface();
			gf3.setBackground(new Color(102,102,102));
			this.gc4 = new CaseInterface();
			gc4.setBackground(new Color(204,204,204));
			this.add(gc1);
			this.add(gf1);
			this.add(gc2);
			this.add(gf2);
			this.add(gc3);
			this.add(gf3);
			this.add(gc4);
			
		}
		
		public boolean remplir(TuileInterface t) {
			if (!this.gc1.isRempli()) {
				this.gc1.remplir(t);
				this.gc1.updateUI();
				return true;
			} else if (!this.gf1.isRempli()){
				this.gf1.remplir(t);
				this.gf1.updateUI();
				return true;
			} else if (!this.gc2.isRempli()){
				this.gc2.remplir(t);
				this.gc2.updateUI();
				return true;
			} else if (!this.gf2.isRempli()){
				this.gf2.remplir(t);
				this.gf2.updateUI();
				return true;
			} else if (!this.gc3.isRempli()){
				this.gc3.remplir(t);
				this.gc3.updateUI();
				return true;
			} else if (!this.gf3.isRempli()){
				this.gf3.remplir(t);
				this.gf3.updateUI();
				return true;
			} else if (!this.gc4.isRempli()){
				this.gc4.remplir(t);
				this.gc4.updateUI();
				return true;
			} else {
				surplus.add(t);
				//System.out.println("dans surplus"); // POUR VERIF
				return true;
			}
		}
		
		public int vider() {
			int malus = 0;
			if (this.gc1.isRempli()) {
				if (this.gc1.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gc1.getTuile());
				this.gc1.vider();
				malus = malus + 1;
			}
			if (this.gf1.isRempli()) {
				if (this.gf1.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gf1.getTuile());
				this.gf1.vider();
				malus = malus + 1;
			}
			if (this.gc2.isRempli()) {
				if (this.gc2.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gc2.getTuile());
				this.gc2.vider();
				malus = malus + 2;
			}
			if (this.gf2.isRempli()) {
				if (this.gf2.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gf2.getTuile());
				this.gf2.vider();
				malus = malus + 2;
			}
			if (this.gc3.isRempli()) {
				if (this.gc3.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gc3.getTuile());
				this.gc3.vider();
				malus = malus + 2;
			}
			if (this.gf3.isRempli()) {
				if (this.gf3.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gf3.getTuile());
				this.gf3.vider();
				malus = malus + 3;
			}
			if (this.gc4.isRempli()) {
				if (this.gc4.getTuile().getCouleur().equals(Color.green)) {
					nextPJ = true;
				}
				surplus.add(this.gc4.getTuile());
				this.gc4.vider();
				malus = malus + 3;
			}
			return malus;
		}

	}
	
	// METHODES SCORE
	public void setScore() { // METHODE PRINCIPALE DU SCORE a appeler pour mettre a jour le score du plateau
		this.score = 0;
		malus += this.Plancher.vider();
		for (int i = 0; i < this.Mur.mur.length; i++) {
			for (int j = 0; j < this.Mur.mur[0].length; j++) {
				addscore(i,j);
			}
		}
		for (int i = 0; i < this.Mur.mur[0].length; i++) {
			if (colonneComplete(i)) score += 7;
		}
		for (int i = 0; i < this.Mur.mur.length; i++) {
			if (ligneComplete(i)) score += 2;
		}
		for(int i = 1; i < 6 ;i++) {
			if (couleurComplete(i)) score += 10;
		}
		this.score = (this.score - malus);
		this.scor.setText(this.name + " : " + this.score);
		this.Scor.updateUI();
	}
	
	public void addscore(int i, int j) { //case (i,j) remplie = +1 , case adjacente remplie = +1 
		if(this.Mur.mur[i][j].isRempli()) {
			this.score++;
			if(i+1 < this.Mur.mur.length) {
				if(this.Mur.mur[i+1][j].isRempli()) this.score++;
				
			}
			if (j+1 < this.Mur.mur[0].length) {
				if(this.Mur.mur[i][j+1].isRempli()) this.score++;
			}	
		}
	}
	
	public boolean colonneComplete(int index) {
		for (int i = 0; i < this.Mur.mur.length; i++) {
			if(!this.Mur.mur[i][index].isRempli()) return false;
		}return true;
	}
	
	public boolean ligneComplete(int index) {
		for (int i = 0; i < this.Mur.mur.length; i++) {
			if(!this.Mur.mur[index][i].isRempli()) return false;
		}return true;
	}
	
	public boolean couleurComplete(int color) {
		Color couleur = Color.PINK; // JAMAIS
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
		int r = 0; // nombre de tuile de couleur color remplies
		for (int i = 0; i < this.Mur.mur.length; i++) {
			for (int j = 0; j < this.Mur.mur[0].length; j++) {
				if(this.Mur.mur[i][j].isRempli() && this.Mur.mur[i][j].getTuile().getCouleur() == couleur) {
					r++;
				}
			}
		} if (r == 5)return true;
		return false;
	}
	
	// FIN DES METHODES SCORE
	
	public ArrayList<TuileInterface> getMemotuile() {
		return this.memotuile;
	}
	
	public void setJoueurSuivant(PlateauInterface joueur) {
		this.joueursuivant = joueur;
	}
	
	public void setTour() {
		this.AJoué = false;
	}
	
	public void joué() {
		this.AJoué = true;
	}
	
	
	public void finDeManche() {
		surplus.clear();
		this.Escalier.vider();
		this.setScore();
		this.updateUI();
	}

}

