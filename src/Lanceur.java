import java.util.Random;
import java.util.Scanner;

public class Lanceur {
	private int nbJoueur;
	private boolean FinDeJeu;
	private Plateau j1;
	private Plateau j2;
	private Plateau j3;
	private Plateau j4;
	private Jeu partie;
	Scanner sc = new Scanner(System.in);
	
	public Lanceur() {
		this.nbJoueur = 0;
		try {
			System.out.println("Choisissez le nombre de joueur.");
			int nj = Integer.parseInt(sc.nextLine());
			if (nj >= 2 && nj <=4) {
				this.nbJoueur = nj;
			}
		} catch (Exception e) {
			System.out.println("Entrée incorrecte : Nombre entre 2 et 4 (inclus) attendu, relancez le jeu.");
		}
		if(nbJoueur == 2) {
			this.partie = new Jeu(5);
			this.j1 = new Plateau("Joueur 1");
			this.j2 = new Plateau("Joueur 2");
			this.j3 = null;
			this.j4 = null;
		}
		if(nbJoueur == 3) {
			this.partie = new Jeu(7);
			this.j1 = new Plateau("Joueur 1");
			this.j2 = new Plateau("Joueur 2");
			this.j3 = new Plateau("Joueur 3");
			this.j4 = null;
		}
		if(nbJoueur == 4) {
			this.partie = new Jeu(9);
			this.j1 = new Plateau("Joueur 1");
			this.j2 = new Plateau("Joueur 2");
			this.j3 = new Plateau("Joueur 3");
			this.j4 = new Plateau("Joueur 4");
		}
		this.FinDeJeu = false;
	}
	
	public void ChoixCouleurEtLigneA2(int opt) {
		if (opt == 0) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getCentre().piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA2(opt);
			}
		}
		if (opt == 1) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[0].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA2(opt);
			}
		}
		if (opt == 2) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[1].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA2(opt);
			}
		}
		if (opt == 3) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[2].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}	
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA2(opt);
			}
		}
		if (opt == 4) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[3].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA2(opt);
			}
		}	
		if (opt == 5) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[4].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA2(opt);
			}
		}
	}
	
	public void ChoixCouleurEtLigneA3(int opt) {
		if (opt == 0) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getCentre().piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		if (opt == 1) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[0].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		if (opt == 2) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[1].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		if (opt == 3) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[2].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}	
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		if (opt == 4) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[3].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}	
		if (opt == 5) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[4].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		if (opt == 6) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[5].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		if (opt == 7) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[6].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA3(opt);
			}
		}
		
	}
	
	public void ChoixCouleurEtLigneA4(int opt) {
		if (opt == 0) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getCentre().piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 1) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[0].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 2) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[1].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 3) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[2].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}	
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 4) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[3].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}	
		if (opt == 5) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[4].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 6) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[5].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 7) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[6].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 8) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[7].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
		if (opt == 9) {
			System.out.println("Quelle couleur choisissez-vous? (bleu = 1 - jaune = 2 - rouge = 3 - noir = 4 - blanc = 5");
			try {
				int col = Integer.parseInt(sc.nextLine());
				if (col < 1 || col > 5) {
					System.out.println("Couleur Innexistante, réessayez.");
					System.out.println();
					ChoixCouleurEtLigneA4(opt);
				}
				if (this.partie.getFabriques()[8].piocher(col) == false) {
					Tour(this.partie.getJoueurActuel());
				}
				System.out.println(this.partie.getJoueurActuel());
				System.out.println("Fin du tour de "+ this.partie.getJoueurActuel().getName()+"\n");
				return;
			}catch(NumberFormatException e) {
				System.out.println("Valeur incorrecte, réessayez.");
				System.out.println();
				ChoixCouleurEtLigneA4(opt);
			}
		}
	}
	
	public void Tour(Plateau joueur) { // TOUR POUR UN JOUEUR |  RAJOUTER D'EVENTUELLES EXCEPTION POUR LES MAUVAIS INPUTS

		this.partie.setJoueurActuel(joueur);
		
		System.out.println("Début du tour de "+this.partie.getJoueurActuel().getName()+ "\n");
		System.out.println(this.partie);
		
		
		System.out.println("Choix du lieu de pioche : Donner le numero de la fabrique, 0 correspond au centre");
		try {
			int opt = Integer.parseInt(sc.nextLine());
			if (nbJoueur == 2) {
				if (!(opt < 0) && !(opt > 5)) {
					this.ChoixCouleurEtLigneA2(opt);
				}else {
					System.out.println("Lieux de pioche inexistant.");
					System.out.println();
					Tour(this.partie.getJoueurActuel());
				}
			}
			
			if (this.nbJoueur == 3) {
				if (!(opt < 0) && !(opt > 7)) {
					this.ChoixCouleurEtLigneA3(opt);
				}else {
					System.out.println("Lieux de pioche inexistant.");
					System.out.println();
					Tour(this.partie.getJoueurActuel());
				}
			}
			if (this.nbJoueur == 4) {
				if (!(opt < 0) && !(opt > 9)) {
					this.ChoixCouleurEtLigneA4(opt);
				}else {
					System.out.println("Lieux de pioche inexistant.");
					System.out.println();
					Tour(this.partie.getJoueurActuel());
				}
			}
		}catch(NumberFormatException e) {
			System.out.println("Valeur incorrecte, réessayez.");
			System.out.println();
			Tour(this.partie.getJoueurActuel());
		}
	}

	public Plateau PremierJoueurPremiereManche() { //Premier Joueur de la premiere manche
	// choisi au hasard un joueur et retourne le joueur correspondant
		if (nbJoueur == 2) {
			Random r = new Random();
        	int n = r.nextInt(2);
        	if (n == 0) {
        		return this.j1;
        	}
        	if (n == 1) {
        		return this.j2;
        	}
        }
		if (nbJoueur == 3) {
			Random r = new Random();
        	int n = r.nextInt(3);
        	if (n == 0) {
        		return this.j1;
        	}
        	if (n == 1) {
        		return this.j2;
        	}
        	if (n == 2) {
        		return this.j3;
        	}
		}
		if (nbJoueur == 4) {
			Random r = new Random();
        	int n = r.nextInt(4);
        	if (n == 0) {
        		return this.j1;
        	}
        	if (n == 1) {
        		return this.j2;
        	}
        	if (n == 2) {
        		return this.j3;
        	}
        	if (n == 4) {
        		return this.j4;
        	}
		}
		return null;
	}
	
	public Plateau PremierJoueurMancheSuivante() {
	// vérifie si la tuile premierJoueur est dans le plancher et renvoie le joueur correspondant -> sera le premier joueur de la prochaine manche
		if (nbJoueur == 2) {
			if (this.j1.p.PremiereTuilePresente()) {
				return this.j1;
			}
			if (this.j2.p.PremiereTuilePresente()) {
				return this.j2;
			}
		}if (nbJoueur ==3) {
			if (this.j1.p.PremiereTuilePresente()) {
				return this.j1;
			}
			if (this.j2.p.PremiereTuilePresente()) {
				return this.j2;
			}
			if (this.j3.p.PremiereTuilePresente()) {
				return this.j3;
			}
		}if (nbJoueur == 4) {
			if (this.j1.p.PremiereTuilePresente()) {
				return this.j1;
			}
			if (this.j2.p.PremiereTuilePresente()) {
				return this.j2;
			}
			if (this.j3.p.PremiereTuilePresente()) {
				return this.j3;
			}
			if (this.j4.p.PremiereTuilePresente()) {
				return this.j4;
			}
		}
		return null;
	}
	
	public void TourDeTableA2() {
	// Pour que le joueur actuel puisse jouer il faut qu'il y ai des tuiles dans le centre et les fabriques
		
		if (this.partie.getJoueurActuel() == this.j1) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			this.partie.setJoueurActuel(this.j1);
		}
		if (this.partie.getJoueurActuel() == this.j2) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			this.partie.setJoueurActuel(this.j2);
		}
	}
	
	public void TourDeTableA3() {
		// Pour que le joueur actuel puisse jouer il faut qu'il y ai des tuiles dans le centre et les fabriques
		
		if (this.partie.getJoueurActuel() == this.j1) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j3);
			}
			this.partie.setJoueurActuel(this.j1);
		}
		if (this.partie.getJoueurActuel() == this.j2) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j3);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			this.partie.setJoueurActuel(this.j2);
		}
		if (this.partie.getJoueurActuel() == this.j3) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j3);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			this.partie.setJoueurActuel(this.j3);
		}
	}
	
	public void TourDeTableA4() {
		// Pour que le joueur actuel puisse jouer il faut qu'il y ai des tuiles dans le centre et les fabriques
		if (this.partie.getJoueurActuel() == this.j1) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){	
				this.Tour(this.j3);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j4);
			}
			this.partie.setJoueurActuel(this.j1);
		}
		if (this.partie.getJoueurActuel() == this.j2) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j3);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j4);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			this.partie.setJoueurActuel(this.j2);
		}
		if (this.partie.getJoueurActuel() == this.j3) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j3);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j4);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			this.partie.setJoueurActuel(this.j3);
		}
		if (this.partie.getJoueurActuel() == this.j4) {
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j4);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j1);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j2);
			}
			if (!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()){
				this.Tour(this.j3);
			}
			this.partie.setJoueurActuel(this.j4);
		}
	}
	
	public void PremiereManche() {
		this.partie.Initialisation();
		
		this.partie.setJoueurActuel(PremierJoueurPremiereManche());
		
		while ((!this.partie.getCentre().isEmpty()) || (!this.partie.fabriquesVides())) {
			if (this.nbJoueur == 2) {
				this.TourDeTableA2();
			}
			if (this.nbJoueur == 3) {
				this.TourDeTableA3();
			}
			if (this.nbJoueur == 4) {
				this.TourDeTableA4();
			}
		}
		System.out.println("Sortie");
		this.partie.setJoueurActuel(PremierJoueurMancheSuivante());
		if (this.nbJoueur == 2) {
			this.j1.Decoration();
			this.partie.remplirDefausse(this.j1.getSurplus());
			this.j2.Decoration();
			this.partie.remplirDefausse(this.j2.getSurplus());
		}
		if (this.nbJoueur == 3) {
			this.j1.Decoration();
			this.partie.remplirDefausse(this.j1.getSurplus());
			this.j2.Decoration();
			this.partie.remplirDefausse(this.j2.getSurplus());
			this.j3.Decoration();
			this.partie.remplirDefausse(this.j3.getSurplus());
		}
		if (this.nbJoueur == 4) {
			this.j1.Decoration();
			this.partie.remplirDefausse(this.j1.getSurplus());
			this.j2.Decoration();
			this.partie.remplirDefausse(this.j2.getSurplus());
			this.j3.Decoration();
			this.partie.remplirDefausse(this.j3.getSurplus());
			this.j4.Decoration();
			this.partie.remplirDefausse(this.j4.getSurplus());
		}
	}
	
	public void Manche() {
		//phase de préparation
		this.partie.Initialisation();
		
		//phase d'offre
		while(!this.partie.getCentre().isEmpty() || !this.partie.fabriquesVides()) {
			System.out.println("Dans Manche");
			if (this.nbJoueur == 2) {
				this.TourDeTableA2();
			}
			if (this.nbJoueur == 3) {
				this.TourDeTableA3();
			}
			if (this.nbJoueur == 4) {
				this.TourDeTableA4();
			}	
		}
		this.partie.setJoueurActuel(PremierJoueurMancheSuivante());
		
		//phase de décration + vérification qu'une ligne du mur n'est pas pleine sinon fin de jeu.
		if (this.nbJoueur == 2) {
			j1.Decoration();
			this.partie.remplirDefausse(this.j1.getSurplus());
			if (j1.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
			j2.Decoration();
			this.partie.remplirDefausse(this.j2.getSurplus());
			if (j2.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
		}
		if (this.nbJoueur == 3) {
			j1.Decoration();
			this.partie.remplirDefausse(this.j1.getSurplus());
			if (j1.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
			j2.Decoration();
			this.partie.remplirDefausse(this.j2.getSurplus());
			if (j2.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
			j3.Decoration();
			this.partie.remplirDefausse(this.j3.getSurplus());
			if (j3.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
		}
		if (this.nbJoueur == 4) {
			j1.Decoration();
			this.partie.remplirDefausse(this.j1.getSurplus());
			if (j1.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
			j2.Decoration();
			this.partie.remplirDefausse(this.j2.getSurplus());
			if (j2.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
			j3.Decoration();
			this.partie.remplirDefausse(this.j3.getSurplus());
			if (j3.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
			j4.Decoration();
			this.partie.remplirDefausse(this.j4.getSurplus());
			if (j3.m.uneLignePleine()) {
				this.FinDeJeu = true;
			}
		}
	}
	
	public void Game() {
		PremiereManche();
		while (!this.FinDeJeu) {
			Manche();
		}	
		if (nbJoueur == 2) {
			if (this.j1.getScore() > this.j2.getScore()) {
				System.out.println("Le gagnant est "+ this.j1.getName()+" avec un score de "+ this.j1.getScore());
			}
			if (this.j1.getScore() < this.j2.getScore()) {
				System.out.println("Le gagnant est "+ this.j2.getName()+" avec un score de "+ this.j2.getScore());
			}
			if (this.j1.getScore() == this.j2.getScore()) {
				System.out.println("Egalité");
			}
		}
	
		if (nbJoueur == 3) {
			if (this.j1.getScore() > this.j2.getScore() && this.j1.getScore() > this.j3.getScore()) {
				System.out.println("Le gagnant est "+ this.j1.getName()+" avec un score de "+ this.j1.getScore());
			}
			if (this.j2.getScore() > this.j1.getScore() && this.j2.getScore() > this.j3.getScore()) {
				System.out.println("Le gagnant est "+ this.j2.getName()+" avec un score de "+ this.j2.getScore());
			}
			if (this.j3.getScore() > this.j1.getScore() && this.j3.getScore() > this.j2.getScore()) {
				System.out.println("Le gagnant est "+ this.j3.getName()+" avec un score de "+ this.j3.getScore());
			}
		}
		if (nbJoueur == 4) {
			if (this.j1.getScore() > this.j2.getScore() && this.j1.getScore() > this.j3.getScore() && this.j1.getScore() > this.j4.getScore()) {
				System.out.println("Le gagnant est "+ this.j1.getName()+" avec un score de "+ this.j1.getScore());
			}
			if (this.j2.getScore() > this.j1.getScore() && this.j2.getScore() > this.j3.getScore() && this.j2.getScore() > this.j4.getScore()) {
				System.out.println("Le gagnant est "+ this.j2.getName()+" avec un score de "+ this.j2.getScore());
			}
			if (this.j3.getScore() > this.j1.getScore() && this.j3.getScore() > this.j2.getScore() && this.j3.getScore() > this.j4.getScore()) {
				System.out.println("Le gagnant est "+ this.j3.getName()+" avec un score de "+ this.j3.getScore());
			}
			if (this.j4.getScore() > this.j1.getScore() && this.j4.getScore() > this.j2.getScore() && this.j4.getScore() > this.j3.getScore()) {
				System.out.println("Le gagnant est "+ this.j4.getName()+" avec un score de "+ this.j4.getScore());
			}
		}
	}
	
	
}

