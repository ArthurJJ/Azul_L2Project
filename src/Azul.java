import java.awt.EventQueue;
import java.util.Scanner;

public class Azul {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
		System.out.println("Indiquez le mode de Jeu : 1 = Graphique - 2 = Textuel");
		String choice = sc.nextLine();
		while (!choice.equals("1") && !choice.equals("2")) {
			System.out.println("Valeur Incorrecte, Indiquez le mode de Jeu : 1 = Graphique - 2 = Textuel");
			choice = sc.nextLine();
		}
		if (choice.equals("1")) {
			EventQueue.invokeLater( () ->
			{
				new LanceurInterface();
			});
		}
		if (choice.equals("2")) {
			Lanceur test = new Lanceur();
			test.Game();
		}
	}
}
