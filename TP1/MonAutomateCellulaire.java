public class MonAutomateCellulaire extends CAtoolbox {


	 public static void main(String[] args) { 
	 	 
	 	 int tailleTableau = 100; 
	 	 
	 	 boolean[] tableauCourant = new boolean[tailleTableau]; 
	 	 boolean[] nouveauTableau = new boolean[tailleTableau]; 
	 	 
	 	 boolean[][] regles = initialiseRegles(90); 
	 	 // * initialisation 
	 	 
	 	 // initialise les paramètres de simulation (ex. le nombre de pas de la simulation) 
	 	 
	 	 int nombreDePasMaximum = 80; 
	 	 int it = 0; 
	 	 
	 	 
	 	 // * on fait tourner l'automate 
	 	 
	 	 while ( it < nombreDePasMaximum ) 
	 	 { 
	 	 	 for ( int i = 0 ; i != tableauCourant.length ; i++ ) 
	 	 	 { 
	 	 	 	 // 1 - affiche etat courant 
	 	 	 	 
	 	 	 	 //...affichage de la ligne contenu dans tableauCourant[] 
	 	 	 	 
	 	 	 	 // 2 - met a jour l'automate cellulaire (pour la prochaine etape) 
	 	 	 	 //...mise à jour des états des cellules dans nouveauTableau[] 
	 	 	 } 
	 	 	 
	 	 	 // 3 - passe a la ligne suivante 
	 	 	 
	 	 	 //...on recopie le contenu de nouveauTableau[] dans tableauCourant[] 
			 
			 it++;
	 	 } 

		 System.out.println("\nFin.");

	 } 

	 
}
