import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.WindowConstants;

public class LanceurInterface {
	Scanner sc = new Scanner(System.in);
	JeuInterface a;
	public LanceurInterface() {
		System.out.println("Indiquez le nombre de Joueurs (2 à 4)");
		int nb = Integer.parseInt(sc.nextLine());
		while (nb != 2 && nb != 3 && nb != 4) {
			System.out.println("Valeur Incorrecte! Indiquez le nombre de Joueurs (2 à 4)");
			nb = Integer.parseInt(sc.nextLine());
		}
		if (nb == 4) {
			System.out.println("Donnez le pseudo du Joueur 1, il débutera la partie");
			String j1 = sc.nextLine();
			System.out.println("Donnez le pseudo du Joueur 2");
			String j2 = sc.nextLine();
			System.out.println("Donnez le pseudo du Joueur 3");
			String j3 = sc.nextLine();
			System.out.println("Donnez le pseudo du joueur 4");
			String j4 = sc.nextLine();
			a = new JeuInterface(4,j1,j2,j3,j4);
		}
		if (nb == 3) {
			System.out.println("Donnez le pseudo du Joueur 1, il débutera la partie");
			String j1 = sc.nextLine();
			System.out.println("Donnez le pseudo du Joueur 2");
			String j2 = sc.nextLine();
			System.out.println("Donnez le pseudo du Joueur 3");
			String j3 = sc.nextLine();
			a = new JeuInterface(3,j1,j2,j3,"none");
		}
		if (nb == 2) {
			System.out.println("Donnez le pseudo du Joueur 1, il débutera la partie");
			String j1 = sc.nextLine();
			System.out.println("Donnez le pseudo du Joueur 2");
			String j2 = sc.nextLine();
			a = new JeuInterface(2,j1,j2,"none","none");
		}
		//PlateauInterface a = new PlateauInterface();
		
		a.getMilieu().remplirFabriques();
		a.setSize(1000,1000);
		a.setVisible(true);
		a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	
	
}