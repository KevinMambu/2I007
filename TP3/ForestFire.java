
public class ForestFire extends CAtoolbox {


	public static void main(String[] args) {

		int dx = 50;
		int dy = 50;

		int[][] tableauCourant = new int[dx][dy];
		int[][] nouveauTableau = new int[dx][dy];

		int delai = 500;//100;

		int nombreDePasMaximum = 10000;//1000;
		int it = 0;

		double densite = 0.55; //0.55; // seuil de percolation 0.55


		// optionnel: initialise la visualisation dans une fenetre

		CAImageBuffer image = new CAImageBuffer(dx,dy);
	    ImageFrame imageFrame =	ImageFrame.makeFrame( "Forest fire", image, delai, 200, 200 );

		// initialisation (peuple la foret)

	    for ( int x = 0 ; x != dx ; x++ )
	    	for ( int y = 0 ; y != dy ; y++ )
	    		if ( densite >= Math.random() )
	    			tableauCourant[(int)x][(int)y]=1; // tree

	    tableauCourant[dx/2][dy/2] = 2; // burning tree

		// on fait tourner l'automate

		while ( it != nombreDePasMaximum )
		{
			// 1a - affiche de l'etat courant dans la fenetre graphique (toutes les cellules)
			image.updateForest(tableauCourant);

			// 1 - mise a jour de l'automate (dans le tableau en tampon)
			for ( int x = 0 ; x != tableauCourant.length ; x++ )
				for ( int y = 0 ; y != tableauCourant[0].length ; y++ )
				{

					if()

				}

			// 2 - met a jour le tableau affichable

			for ( int x = 0 ; x != tableauCourant.length ; x++ )
				for ( int y = 0 ; y != tableauCourant[0].length ; y++ )
					tableauCourant[x][y] = nouveauTableau[x][y];

			it++;

			// ne va pas trop vite...

			try {
				Thread.sleep(delai);
			} catch (InterruptedException e)
			{
			}
		}

	}

    public static int surroundings(int x, int y, int[][] tab) {
        if(x > 0 && x < tab.length) {
            if(tab[x - 1][y] == )
        }
    }
}
