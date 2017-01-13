import java.util.Scanner; 

public class Main2048 {

	public static void main(String[] args) {
		
		
		Grille grille = new Grille(4,4);

		grille.ajoutAleatoire(grille.getMatrice());
		
		
		while(grille.estVide(grille.getMatrice())) {
			
			
			System.out.println("HAUT = h");
			System.out.println("BAS = b");
			System.out.println("DROITE = d");
			System.out.println("GAUCHE = g");
			System.out.println("Score = " + grille.score(grille.getMatrice()));
			if(grille.success(grille.getMatrice()))
				System.out.println("Vous avez atteint 2048 ! vous avez gagnez !");
			
			grille.ajoutAleatoire(grille.getMatrice());
			System.out.println(grille.toString(grille.getMatrice()));
			
			
			System.out.println("Votre choix : ");
			Scanner entree = new Scanner(System.in);
			String choix = entree.next();
			
			switch(choix) {
				case "h" :
					grille.haut(grille.getMatrice());
					break;
				case "b" :
					grille.bas(grille.getMatrice());
					break;
				case "d" :
					grille.droite(grille.getMatrice());
					break;
				case "g" :
					grille.gauche(grille.getMatrice());
					break;
				default :
					System.out.println("Mauvaise saisie");
			}
			
		}
		System.out.println("Vous avez perdu !!!");
	}

}
