import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JeuInterface extends JFrame{
	
	private PlateauInterface player1; 
	private PlateauInterface player2; 
	private PlateauInterface player3; 
	private PlateauInterface player4; 
	private MilieuInterface milieu;
	private Sac sac = new Sac();
	private ArrayList<TuileInterface> defausse = new ArrayList<TuileInterface>();
	private TuileInterface PJ;
	
	// ATTRIBUTS DE GESTION
	private PlateauInterface joueurActuel; // FAIRE METHODE RANDOM
	private FabriqueInterface cliquee = null; // MEMOIRE DE LA FABRIQUE DANS LAQUELLE ON A PIOCHE
	private ArrayList<TuileInterface> gardeCentre = new ArrayList<TuileInterface>(); // SE SOUVIENT DES TUILES NONCHOISIES, APPELLé QUAND LE joueurActuel A JOUé POUR REMPLIR CENTRE
	private boolean PJexists;
	
	
	
	
	public JeuInterface(int nbJoueurs, String joueur1, String joueur2, String joueur3, String joueur4) {
		if (nbJoueurs == 4) {
			milieu = new MilieuInterface(9);
			player1 = new PlateauInterface(joueur1);
			player2 = new PlateauInterface(joueur2);
			player3 = new PlateauInterface(joueur3);
			player4 = new PlateauInterface(joueur4);
			player1.setJoueurSuivant(player2);
			player2.setJoueurSuivant(player3);
			player3.setJoueurSuivant(player4);
			player4.setJoueurSuivant(player1);
			joueurActuel = this.player1;
			joueurActuel.atoi = "*";
			joueurActuel.scor.setText(joueurActuel.atoi + joueurActuel.name + joueurActuel.atoi + " : " + joueurActuel.score);
			joueurActuel.updateUI();
			
			PJexists = false;
			PJ = new TuileInterface(Color.green);
			PJ.add(new JLabel("-PJ-"));
			
			this.setTitle("Plateau Azul");
			this.setLayout(new GridLayout(3,1));
			
			JPanel top = new JPanel(new GridLayout(1,2));
			JPanel mid = new JPanel(new GridLayout(1,1));
			JPanel bot = new JPanel(new GridLayout(1,2));
			
			JPanel vide = new JPanel();
			JPanel vide2 = new JPanel();
			vide.setBackground(Color.black);
			vide2.setBackground(Color.black);
			
			top.add(player1);
			top.add(player2);
			
			mid.add(milieu);
			
			bot.add(player3);
			bot.add(player4);
			
			this.add(top);
			this.add(mid);
			this.add(bot);
		}
		if (nbJoueurs == 3) {
			milieu = new MilieuInterface(7); 
			player1 = new PlateauInterface(joueur1);
			player2 = new PlateauInterface(joueur2);
			player3 = new PlateauInterface(joueur3);
			player4 = new PlateauInterface(joueur4);
			player1.setJoueurSuivant(player2);
			player2.setJoueurSuivant(player3);
			player3.setJoueurSuivant(player1);
			joueurActuel = this.player1;
			joueurActuel.atoi = "*";
			joueurActuel.scor.setText(joueurActuel.atoi + joueurActuel.name + joueurActuel.atoi + " : " + joueurActuel.score);
			joueurActuel.updateUI();
			JPanel videAzul = new JPanel();
			
			PJexists = false;
			PJ = new TuileInterface(Color.green);
			PJ.add(new JLabel("-PJ-"));
			
			this.setTitle("Plateau Azul");
			this.setLayout(new GridLayout(3,1));
			
			JPanel top = new JPanel(new GridLayout(1,2));
			JPanel mid = new JPanel(new GridLayout(1,1));
			JPanel bot = new JPanel(new GridLayout(1,2));
			
			JPanel vide = new JPanel();
			JPanel vide2 = new JPanel();
			vide.setBackground(Color.black);
			vide2.setBackground(Color.black);
			
			top.add(player1);
			top.add(player2);
			
			mid.add(milieu);
			
			bot.add(player3);
			bot.add(videAzul);
			
			this.add(top);
			this.add(mid);
			this.add(bot);
		}
		if (nbJoueurs == 2) {
			milieu = new MilieuInterface(5); 
			player1 = new PlateauInterface(joueur1);
			player2 = new PlateauInterface(joueur2);
			player3 = new PlateauInterface(joueur3);
			player4 = new PlateauInterface(joueur4); 
			player1.setJoueurSuivant(player2);
			player2.setJoueurSuivant(player1);
			joueurActuel = this.player1;
			joueurActuel.atoi = "*";
			joueurActuel.scor.setText(joueurActuel.atoi + joueurActuel.name + joueurActuel.atoi + " : " + joueurActuel.score);
			joueurActuel.updateUI();
			
			PJexists = false;
			PJ = new TuileInterface(Color.green);
			PJ.add(new JLabel("-PJ-"));
			
			this.setTitle("Plateau Azul");
			this.setLayout(new GridLayout(2,1));
			
			JPanel top = new JPanel(new GridLayout(1,2));
			JPanel mid = new JPanel(new GridLayout(1,1));
			
			JPanel vide = new JPanel();
			JPanel vide2 = new JPanel();
			vide.setBackground(Color.black);
			vide2.setBackground(Color.black);
			
			top.add(player1);
			top.add(player2);
			
			mid.add(milieu);
			
			this.add(top);
			this.add(mid);
		}
		this.addMouseListener(new MouseAdapter() { // GERE LES TOURS DES JOUEURS ET LA PARTIE DE MANIERE GENERALE
			public void mouseClicked(MouseEvent me) { 
				//INTERACTIONS
				gestionTour();
			} 
		});
	}
	// METHODES DE GESTION DE LA PARTIE
	public boolean gestionTour() { // VERIFIE CONSTAMMENT L'ETAT DE LA PARTIE POUR CHANGER DE PHASES		
		if (MancheCheck()) {
			if (GameCheck()) {
				if(joueurActuel.AJoué) { // ON PASSE AU JOUEUR SUIVANT
					gardeCentre.forEach((TuileInterface t) -> milieu.getCentre().remplir(t));
					gardeCentre.clear();
					joueurActuel.memocentre.clear();
					joueurActuel.memotuile.clear();
					joueurActuel.atoi = "";
					joueurActuel.scor.setText( joueurActuel.atoi + joueurActuel.name + joueurActuel.atoi + " : " + joueurActuel.score);
					joueurActuel.updateUI();
					joueurActuel.setTour();
					joueurActuel = joueurActuel.joueursuivant;
					joueurActuel.memocentre.clear();
					joueurActuel.memotuile.clear();
					joueurActuel.atoi = "*";
					joueurActuel.scor.setText( joueurActuel.atoi + joueurActuel.name + joueurActuel.atoi + " : " + joueurActuel.score);
					joueurActuel.updateUI();
					return true;
				}
			} else {
				if (player1.score > player2.score && player1.score > player3.score && player1.score > player4.score) {
					joueurActuel.setTour();
					joueurActuel = player1;
					joueurActuel.scor.setText(joueurActuel.name + "WINNER");
					joueurActuel.updateUI();
					return true;
				}
				if (player2.score > player1.score && player2.score > player3.score && player2.score > player4.score) {
					joueurActuel.setTour();
					joueurActuel = player2;
					joueurActuel.scor.setText(joueurActuel.name + "WINNER");
					joueurActuel.updateUI();
					return true;

				}
				if (player3.score > player2.score && player3.score > player1.score && player3.score > player4.score) {
					joueurActuel.setTour();
					joueurActuel = player3;
					joueurActuel.scor.setText(joueurActuel.name + "WINNER");
					joueurActuel.updateUI();
					return true;

				}
				if (player4.score > player2.score && player4.score > player3.score && player4.score > player1.score) {
					joueurActuel.setTour();
					joueurActuel = player4;
					joueurActuel.scor.setText(joueurActuel.name + "WINNER");
					joueurActuel.updateUI();
					return true;
				}
			}	
		} else {
			return false;
		}return false;
	}
	
	public PlateauInterface nextPJ() {
		if (player1.nextPJ) return player1;
		if (player2.nextPJ) return player2;
		if (player3.nextPJ) return player3;
		if (player4.nextPJ) return player4;
		return player1; // JAMAIS (APPELE LORSQU'IL Y A UN NEXTPJ)
	}
	

	
	public void finDeManche() {
		player1.surplus.forEach((TuileInterface t) -> defausse.add(t));
		player2.surplus.forEach((TuileInterface t) -> defausse.add(t));
		player3.surplus.forEach((TuileInterface t) -> defausse.add(t));
		player4.surplus.forEach((TuileInterface t) -> defausse.add(t));
		player1.finDeManche();
		player2.finDeManche();
		player3.finDeManche();
		player4.finDeManche();
		
	}
	
	public boolean MancheCheck() { // RETURN FALSE POUR UNE NOUVELLE MANCHE
		if (milieu.fabriquesVides() && milieu.getCentre().isEmpty()) {
			
			finDeManche();
			joueurActuel.setTour();
			joueurActuel = nextPJ();
			player1.nextPJ = false;
			player2.nextPJ = false;
			player3.nextPJ = false;
			player4.nextPJ = false;
			milieu.remplirFabriques();
			PJexists = false;
			joueurActuel.atoi = "*";
			joueurActuel.scor.setText( joueurActuel.atoi + joueurActuel.name + joueurActuel.atoi + " : " + joueurActuel.score);
			joueurActuel.updateUI();
			return false;
		}
		return true;
	}
	
	public boolean GameCheck() { // RETURN FALSE SI LA PARTIE EST FINIE
		for (int i = 0; i < 5; i++) {// CONDITIONS DE FIN DE PARTIE
			if (player1.ligneComplete(i)) return false; 
			if (player2.ligneComplete(i)) return false; 
			if (player3.ligneComplete(i)) return false; 
			if (player4.ligneComplete(i)) return false; 
		}
		return true;
	}
	// FIN DES METHODES DE GESTION DE LA PARTIE
	
	// CLASSES ET METHODES DE JEU
	public class Sac {
		private ArrayList<TuileInterface> deck;
		private int nbTuiles;
		
		public Sac() {
			this.deck = new ArrayList<TuileInterface>();
			for (int i = 0; i< 20; i++) {
				this.deck.add(new TuileInterface(1));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new TuileInterface(2));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new TuileInterface(3));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new TuileInterface(4));
			}
			for (int i = 0; i< 20; i++) {
				this.deck.add(new TuileInterface(5));
			}
			this.nbTuiles = 100;
		}
		
		public TuileInterface piocher() {
			if (this.deck.isEmpty()) {
				defausse.forEach((TuileInterface tui) -> deck.add(tui));
			}
			int r = (int) (Math.random()*nbTuiles);
			TuileInterface t = deck.get(r);
			deck.remove(r);
			nbTuiles--;
			return t;
		}
		
	}
	

	public class FabriqueInterface extends JPanel{
		private CaseInterface hg;
		private CaseInterface hd;
		private CaseInterface bg;
		private CaseInterface bd;
		public FabriqueInterface() {
			FabriqueInterface ref = this;
			this.setLayout(new GridLayout(2,2));
			
			hg = new CaseInterface(); // haut gauche
			hg.remplir(3);
			hg.vider();
	
			hd = new CaseInterface(); // haut droite
			//hd.remplir(1);
	
			bg = new CaseInterface(); // bas gauche
	
			bd = new CaseInterface(); // bas droite
		
			this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,8));
			this.add(hg);
			this.add(hd);
			this.add(bg);
			this.add(bd);
			
			hg.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
		              //INTERACTIONS
					if (!gestionTour()) {
						if (hg.isRempli()) {
							if (cliquee != null) {
				        	  if (!joueurActuel.getMemotuile().isEmpty()) {
				        		  cliquee.reremplir(joueurActuel.getMemotuile());
				        		  cliquee.updateUI();
				        		  
				        	  }
				        	  if (!gardeCentre.isEmpty()) {
									cliquee.reremplir(gardeCentre);
									gardeCentre.clear();
									cliquee.updateUI();
				        	  }
				        	  cliquee = null;
							} 
							
			        	  joueurActuel.getMemotuile().clear();
			        	  ArrayList<TuileInterface> choix = prendre(hg);
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  
			        	  joueurActuel.getMemotuile().clear();
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  cliquee = ref;
			        	  ref.updateUI();
			        	  cliquee.updateUI();
			            } 
					}
				}
			}); 
			
			hd.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
		              //INTERACTIONS
					if (!gestionTour()) {
						if (hd.isRempli()) {
							if (cliquee != null) {
				        	  if (!joueurActuel.getMemotuile().isEmpty()) {
				        		  cliquee.reremplir(joueurActuel.getMemotuile());
				        		  cliquee.updateUI();
				        		  
				        	  }
				        	  if (!gardeCentre.isEmpty()) {
									cliquee.reremplir(gardeCentre);
									gardeCentre.clear();
									cliquee.updateUI();
				        	  }
				        	  cliquee = null;
							} 
							
			        	  joueurActuel.getMemotuile().clear();
			        	  ArrayList<TuileInterface> choix = prendre(hd);
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  
			        	  joueurActuel.getMemotuile().clear();
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  cliquee = ref;
			        	  ref.updateUI();
			        	  cliquee.updateUI();
			            } 
					}
				}
			}); 
			
			bg.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
		              //INTERACTIONS
					if (!gestionTour()) {
						if (bg.isRempli()) {
							if (cliquee != null) {
				        	  if (!joueurActuel.getMemotuile().isEmpty()) {
				        		  cliquee.reremplir(joueurActuel.getMemotuile());
				        		  cliquee.updateUI();
				        		  
				        	  }
				        	  if (!gardeCentre.isEmpty()) {
									cliquee.reremplir(gardeCentre);
									gardeCentre.clear();
									cliquee.updateUI();
				        	  }
				        	  cliquee = null;
							} 
							
			        	  joueurActuel.getMemotuile().clear();
			        	  ArrayList<TuileInterface> choix = prendre(bg);
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  
			        	  joueurActuel.getMemotuile().clear();
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  cliquee = ref;
			        	  ref.updateUI();
			        	  cliquee.updateUI();
			            } 
					}
				}
			}); 
			
			bd.addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent me) { 
		              //INTERACTIONS
					if (!gestionTour()) {
						if (bd.isRempli()) {
							if (cliquee != null) {
				        	  if (!joueurActuel.getMemotuile().isEmpty()) {
				        		  cliquee.reremplir(joueurActuel.getMemotuile());
				        		  cliquee.updateUI();
				        		  
				        	  }
				        	  if (!gardeCentre.isEmpty()) {
									cliquee.reremplir(gardeCentre);
									gardeCentre.clear();
									cliquee.updateUI();
				        	  }
				        	  cliquee = null;
							} 
							
			        	  joueurActuel.getMemotuile().clear();
			        	  ArrayList<TuileInterface> choix = prendre(bd);
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  
			        	  joueurActuel.getMemotuile().clear();
			        	  choix.forEach((TuileInterface t) -> joueurActuel.getMemotuile().add(t)); 
			        	  cliquee = ref;
			        	  ref.updateUI();
			        	  cliquee.updateUI();
			            } 
					}
				}
			}); 
		}
		
		public boolean remplir() {
				hg.remplir(sac.piocher());
				hd.remplir(sac.piocher());
				bg.remplir(sac.piocher());
				bd.remplir(sac.piocher());
				this.updateUI();
				return true;
		}
		
		public void reremplir(ArrayList<TuileInterface> t) {
			t.forEach((TuileInterface tui) -> {
				if (!hg.isRempli()) hg.remplir(tui);
				else if (!hd.isRempli()) hd.remplir(tui);
				else if (!bg.isRempli()) bg.remplir(tui);
				else if (!bd.isRempli()) bd.remplir(tui);
			});
		}
		
		public boolean isEmpty() {
			if (!hg.isRempli() && !hd.isRempli() && !bg.isRempli() && !bd.isRempli()) {
				return true;
			}return false;
		}
		
	
		public ArrayList<TuileInterface> prendre(CaseInterface c) { // A ENVOYER DANS AJOUTER()
			ArrayList<TuileInterface> choisies = new ArrayList<TuileInterface>();
			ArrayList<TuileInterface> nonchoisies = new ArrayList<TuileInterface>();
			int i = 0;
			if (!joueurActuel.memocentre.isEmpty()) {
				milieu.getCentre().resetCasesRemplies();
				joueurActuel.memocentre.forEach((TuileInterface t) -> milieu.getCentre().remplir(t));
				joueurActuel.memocentre.clear();
				milieu.getCentre().updateUI();
			}
			
			if (hg.getTuile().getCouleur() == c.getTuile().getCouleur()) {
				choisies.add(hg.getTuile());
				hg.vider();
				this.updateUI();
				i++;
			} else {
				nonchoisies.add(hg.getTuile());
				hg.vider();
			}
			if (hd.getTuile().getCouleur() == c.getTuile().getCouleur()) {
				choisies.add(hd.getTuile());
				hd.vider();
				i++;
			} else {
				nonchoisies.add(hd.getTuile());
				hd.vider();
			}

			if (bg.getTuile().getCouleur() == c.getTuile().getCouleur()) {
				choisies.add(bg.getTuile());
				bg.vider();
				i++;
			} else {
				nonchoisies.add(bg.getTuile());
				bg.vider();
			}

			if (bd.getTuile().getCouleur() == c.getTuile().getCouleur()) {
				choisies.add(bd.getTuile());
				bd.vider();
				i++;
			} else {
				nonchoisies.add(bd.getTuile());
				bd.vider();
			}
			nonchoisies.forEach((TuileInterface t) -> gardeCentre.add(t));
			this.updateUI();
			return choisies;
		}
	
	}
	
	public class MilieuInterface extends JPanel { // PLUS MILIEUINTERFACE QUE FABRIQUEINTERFACE
		private JPanel Fabriques;
		FabriqueInterface[] fabriquetab;
		private Centre Centre;
		public MilieuInterface(int nb) {  // 9 FABRIQUES + CENTRE
			
			this.Fabriques = new JPanel();
			this.fabriquetab = new FabriqueInterface[nb];
			for (int i = 0; i < fabriquetab.length; i++) {
				fabriquetab[i] = new FabriqueInterface();
			}
			JPanel Fabrique1 = new FabriqueInterface();
			JPanel Fabrique2 = new FabriqueInterface();
			JPanel Fabrique3 = new FabriqueInterface();
			JPanel Fabrique4 = new FabriqueInterface();
			JPanel Fabrique5 = new FabriqueInterface();
			JPanel Fabrique6 = new FabriqueInterface();
			JPanel Fabrique7 = new FabriqueInterface();
			JPanel Fabrique8 = new FabriqueInterface();
			JPanel Fabrique9 = new FabriqueInterface();
			Fabriques.setLayout(new GridLayout(1,9)); // groupe de 3 fabriques
			for (int i = 0; i < fabriquetab.length; i++) {
				Fabriques.add(fabriquetab[i]);
			}
			
			
			Centre = new Centre();
			

			this.setLayout(new GridLayout(2,1));
			this.add(Fabriques);
			this.add(Centre);

		}
		
		public void remplirFabriques() {
			for (int i = 0; i < fabriquetab.length;i++) {
				fabriquetab[i].remplir();
			}
		}
		
		public boolean fabriquesVides() {
			for (int i = 0; i < fabriquetab.length; i++) {
				if (!fabriquetab[i].isEmpty()) {
					return false;
				}
			} return true;
		}
		
		public Centre getCentre() {
			return this.Centre;
		}
		
	}
	
	public class Centre extends JPanel {
		private int casesRemplies;
		private CaseInterface[] lecentre;
		public Centre() {
			casesRemplies = 0;
			CaseInterface c1 = new CaseInterface();
			CaseInterface c2 = new CaseInterface();
			CaseInterface c3 = new CaseInterface();
			CaseInterface c4 = new CaseInterface();
			CaseInterface c5 = new CaseInterface();
			CaseInterface c6 = new CaseInterface();
			CaseInterface c7 = new CaseInterface();
			CaseInterface c8 = new CaseInterface();
			CaseInterface c9 = new CaseInterface();
			CaseInterface c10 = new CaseInterface();
			CaseInterface c11 = new CaseInterface();
			CaseInterface c12 = new CaseInterface();
			CaseInterface c13 = new CaseInterface();
			CaseInterface c14 = new CaseInterface();
			CaseInterface c15 = new CaseInterface();
			CaseInterface c16 = new CaseInterface();
			CaseInterface c17 = new CaseInterface();
			CaseInterface c18 = new CaseInterface();
			CaseInterface c19 = new CaseInterface();
			CaseInterface c20 = new CaseInterface();
			CaseInterface c21 = new CaseInterface();
			CaseInterface c22 = new CaseInterface();
			CaseInterface c23 = new CaseInterface();
			CaseInterface c24 = new CaseInterface();
			CaseInterface c25 = new CaseInterface();
			CaseInterface c26 = new CaseInterface();
			CaseInterface c27 = new CaseInterface();
			CaseInterface c28 = new CaseInterface();
			CaseInterface c29 = new CaseInterface();
			CaseInterface c30 = new CaseInterface();
			
			CaseInterface[] lec = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30};
			this.lecentre = lec;

			this.setLayout(new GridLayout(2,15));
			this.setBorder(BorderFactory.createLineBorder(Color.gray,2));
			
			this.add(c1);
			this.add(c2);
			this.add(c3);
			this.add(c4);
			this.add(c5);
			this.add(c6);
			this.add(c7);
			this.add(c8);
			this.add(c9);
			this.add(c10);
			this.add(c11);
			this.add(c12);
			this.add(c13);
			this.add(c14);
			this.add(c15);
			this.add(c16);
			this.add(c17);
			this.add(c18);
			this.add(c19);
			this.add(c20);
			this.add(c21);
			this.add(c22);
			this.add(c23);
			this.add(c24);
			this.add(c25);
			this.add(c26);
			this.add(c27);
			this.add(c28);
			this.add(c29);
			this.add(c30);
			
			for (int i = 0 ; i < lecentre.length; i++) {
				int index = i;
				lecentre[i].addMouseListener(new MouseAdapter() { 
					public void mouseClicked(MouseEvent me) { 
						//INTERACTIONS
						if (!gestionTour()) {
							if (cliquee != null) {
					        	  if (!joueurActuel.getMemotuile().isEmpty()) {
					        		  cliquee.reremplir(joueurActuel.getMemotuile());
					        		  cliquee.updateUI();
					        		  
					        	  }
					        	  if (!gardeCentre.isEmpty()) {
										cliquee.reremplir(gardeCentre);
										gardeCentre.clear();
										cliquee.updateUI();
					        	  }
					        	  cliquee = null;
							} 
				        	 if(lecentre[index].isRempli()) { 
				        	  gardeCentre.clear();
				        	  ArrayList<TuileInterface> choix = prendre(lecentre[index]);
				        	  choix.forEach((TuileInterface t) -> joueurActuel.memocentre.add(t));
				        	  milieu.getCentre().updateUI();
				            }  
						}
					} 
				});
			}
		}
		
		public boolean isEmpty() {
			for (int i = 0 ; i < lecentre.length; i++) {
				if (lecentre[i].isRempli()) return false;
			} return true;
		}
		
		public CaseInterface[] getCentre() {
			return lecentre;
		}
		
		public CaseInterface getCase(int index) {
			Component[] list = this.getComponents();
			return  (CaseInterface) list[index];
		}
		
		public void remplir(TuileInterface t) {
			if (milieu.getCentre().isEmpty() && !PJexists) {
				lecentre[casesRemplies].remplir(PJ);
				casesRemplies++;
				PJexists = true;
			}
			lecentre[casesRemplies].remplir(t);
			casesRemplies++;
		}
		
		public void reremplir(ArrayList<TuileInterface> t) {
			t.forEach((TuileInterface tui) -> {
				milieu.getCentre().remplir(tui);
			});
		}
		
		public ArrayList<TuileInterface> prendre(CaseInterface c) {
			ArrayList<TuileInterface> choisies = new ArrayList<TuileInterface>();
			ArrayList<TuileInterface> nonchoisies = new ArrayList<TuileInterface>();
			if (!joueurActuel.memocentre.isEmpty()) {
				joueurActuel.memocentre.forEach((TuileInterface t) -> nonchoisies.add(t));
				joueurActuel.memocentre.clear();
			}
			for(int i = 0; i < lecentre.length; i++) {
				if (lecentre[i].isRempli()) {
					if (lecentre[i].getTuile().getCouleur().equals(PJ.getCouleur())) {
						choisies.add(lecentre[i].getTuile());
						lecentre[i].vider();
					} else if (lecentre[i].getTuile().getCouleur().equals(c.getTuile().getCouleur())) {
						choisies.add(lecentre[i].getTuile());
						lecentre[i].vider();
					} else {
						nonchoisies.add(lecentre[i].getTuile());
						lecentre[i].vider();
					}
				} else {
					lecentre[i].vider();
				}
			}
			casesRemplies = 0;
			nonchoisies.forEach((TuileInterface t) -> milieu.getCentre().remplir(t));
			return choisies;
		}
		
		public void resetCasesRemplies() {
			int x = 0;
			for (int i = 0; i < lecentre.length; i++) {
				if(lecentre[i].isRempli()) {
					x++;
				}
			}
			casesRemplies = x;
		}
		
	}
	
	
	public MilieuInterface getMilieu() {
		return this.milieu;
	}

}
