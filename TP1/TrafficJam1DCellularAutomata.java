


public class TrafficJam1DCellularAutomata extends CAtoolbox {


	public static void main(String[] args) {
		
		int tailleTableau = 40;//160;
		int tailleHistorique = tailleTableau; // visualisation
		
		boolean[] tableauCourant = new boolean[tailleTableau];
		boolean[] nouveauTableau = new boolean[tailleTableau];
		
		int nombreDePasMaximum = 10000;//1000;
		int it = 0;
		
		// on initialise la premiere ligne
		
		boolean randomInit = false;
		
		if ( randomInit == true )
		{
			for ( int i = 0 ; i != tailleTableau ; i++ )
			{
				if ( Math.random() < 0.5 )
					tableauCourant[i] = false;
				else
					tableauCourant[i] = true;
			}
		}
		else
		{
			for ( int i = 0 ; i != tailleTableau ; i++ )
				tableauCourant[i] = false;
			tableauCourant[0] = true;
			tableauCourant[1] = true;
			tableauCourant[4] = true;
			tableauCourant[9] = true;
			tableauCourant[11] = true;
			tableauCourant[12] = true;
			tableauCourant[13] = true;
			tableauCourant[14] = true;
			tableauCourant[16] = true;
			tableauCourant[17] = true;
			tableauCourant[19] = true;
		}
		
		double Pmove = 0.5; // Probabilite d'avancer si personne devant 
		
		int delai = 100; // ralenti l'affichage 

		
		// on fait tourner l'automate
		
		boolean[][] regles = initialiseRegles(90);
		
		for ( int i = 0; i != 8; i += 1 )
		{
			for( int j = 0; j != 3; j += 1 )
			{
				print( regles[i][j] + "\t" );
			}
			print( " ->" + regles[i][3] + "\n" );
		}
		
		while ( it != nombreDePasMaximum )
		{
			// affiche de l'etat courant dans la fenetre graphique (toutes les cellules)
			for ( int i = 0 ; i != tableauCourant.length ; i++ )
			{
				if ( tableauCourant[i] == true )
					System.out.print("o");
				else
					System.out.print("_");
			}
			System.out.println("");

			// nettoie nouveauTableau
			for ( int i = 0 ; i != nouveauTableau.length ; i++ )
			{
				nouveauTableau[i] = false;
			}
								
			for ( int x = 0; x != nouveauTableau.length; x ++ )
			{
				int i = 0;
				while( (tableauCourant[(x - 1 + tailleTableau) % tailleTableau] != regles[i][0]) || (tableauCourant[(x + tailleTableau) % tailleTableau] != regles[i][1]) || (tableauCourant[(x + 1 + tailleTableau) % tailleTableau] != regles[i][2]) )
				{
					i ++;
				}
				nouveauTableau[x] = regles[i][3];
			}
	
			
			
			// passe a la ligne suivante
			
			for ( int j = 0 ; j != tableauCourant.length ; j++ )
				tableauCourant[j] = nouveauTableau[j];
			it++;
			
			// ne va pas trop vite...
			
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) 
			{
			}
		}

	}

}


