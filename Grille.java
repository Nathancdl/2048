import java.util.Random;

public class Grille {
	
	
	private int ligne;
	private int colonne;
	private int[][] matrice;
	
	
	public Grille(int ligne, int colonne) 
	{
		this.ligne = ligne;
		this.colonne = colonne;
		matrice = new int[ligne][colonne];
	}
	
	
	public int getLigne() 
	{
		return this.ligne;
	}

	
	public void setLigne(int value) 
	{
		this.ligne = value;
	}
	
	
	public int getColonne() 
	{
		return this.colonne;
	}
	
	
	public void setColonne(int value) 
	{
		this.colonne = value;
	}
	
	
	public int[][] getMatrice() 
	{
		return this.matrice;
	}
	
	
	public void setMatrice (int[][] matrice) 
	{
		this.matrice = matrice;
	}
	
	
	public boolean estVide(int[][] matrice) 
	{
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++) {
				if(matrice[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
	
	public class RandArray {
	    private int[] items = new int[]{2,4};

	    private Random rand = new Random();

	    public int getRandArrayElement(){
	        return items[rand.nextInt(items.length)];
	    }
	}
	public void ajoutAleatoire(int[][] matrice) 
	{
		Random r = new Random();
		int ligne = r.nextInt(4);
		int colonne = r.nextInt(4);
		int ajoute = 1;
		
	     
	     
		while(ajoute > 0) {
			if(matrice[ligne][colonne] == 0) {
				matrice[ligne][colonne] =  Math.random() < 0.9 ? 2 : 4 ;;
				ajoute = -1;
			}
			else {
				ligne = r.nextInt(4);
				colonne = r.nextInt(4);
				ajoute++;
			}
		}
	}
	
	
	public void gauche(int[][] matrice) 
	{
		for(int k = 0 ; k < this.colonne ; k++) {
			for(int i = 0 ; i < this.ligne ; i++) {
				for(int j = 0 ; j < this.colonne - 1 ; j++) {
					if(matrice[i][j] == matrice[i][j+1] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i][j+1] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i][j+1];
						matrice[i][j+1] = 0;
					}
				}
			}
		}
	}

	
	public void droite(int[][] matrice) 
	{
		for(int k = 0 ; k < this.colonne ; k++) {
			for(int i = 0 ; i < this.ligne ; i++) {
				for(int j = this.colonne - 1 ; j > 0 ; j--) {
					if(matrice[i][j] == matrice[i][j-1] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i][j-1] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i][j-1];
						matrice[i][j-1] = 0;
					}
				}
			}
		}
	}

	
	public void bas(int[][] matrice) 
	{
		for(int k = 0 ; k < this.ligne ; k++) {
			for(int i = this.ligne - 1 ; i > 0 ; i--) {
				for(int j = 0 ; j < this.colonne ; j++) {
					if(matrice[i][j] == matrice[i-1][j] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i-1][j] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i-1][j];
						matrice[i-1][j] = 0;
					}
				}
			}
		}
	}

	
	public void haut(int[][] matrice) {
		for(int k = 0 ; k < this.ligne ; k++) {
			for(int i = 0 ; i < this.ligne - 1 ; i++) {
				for(int j = 0 ; j < this.colonne ; j++) {
					if(matrice[i][j] == matrice[i+1][j] && matrice[i][j] != 0) {
						matrice[i][j] = matrice[i][j] * 2;
						matrice[i+1][j] = 0;					
					}
					if(matrice[i][j] == 0) {
						matrice[i][j] = matrice[i+1][j];
						matrice[i+1][j] = 0;
					}
				}
			}
		}
	}
	
	
	public String toString(int[][] matrice) 
	{
		String temp ="";
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++) {
				if(matrice[i][j] == 0)
					temp += " | " + " ";
				if(matrice[i][j] != 0)
					temp += " | " + matrice[i][j];
			}
			temp += " | \n";
		}
		return temp;
	}
	
	
	public int score(int[][] matrice) 
	{
		int somme = 0;
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++)
				somme += matrice[i][j];
		}
		return somme;
	}
	
	
	public boolean success(int[][] matrice) 
	{
		for(int i = 0 ; i < this.ligne ; i++) {
			for(int j = 0 ; j < this.colonne ; j++) {
				if(matrice[i][j] == 2048)
					return true;
			}
		}
		return false;
	}
	
}
