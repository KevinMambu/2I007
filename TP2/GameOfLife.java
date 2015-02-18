public class GameOfLife {
	private boolean[][] tab;
	private int dX;
	private int dY;
	public int getDX() {
		return dX;
	}
	public int getDY() {
		return dY;
	}
	public GameOfLife(int x, int y, double rand) {
		tab = new boolean[x][];
		for(int i = 0; i < x; i += 1) {
			tab[i] = new boolean[y];
		}
		dX = x;
		dY = y;
		for(int i = 0; i < dX; i += 1) {
			for(int j = 0; j < dY; j += 1) {
				tab[i][j] = (Math.random() >= rand? false : true);
			}
		}
	}
	public GameOfLife(int x, int y) {
		this(x, y, -1.);
	}
	public int surroundings(int x, int y) {
		int cpt = 0;
		for( int i = x - 1; i < x + 2; i += 1 ) {
			cpt += (tab[(i + dX) % dX][(y - 1 + dY) % dY] == true? 1 : 0);
			cpt += (tab[(i + dX) % dX][(y + 1 + dY) % dY] == true? 1 : 0);
		}
		if( tab[(x - 1 + dX) % dX][(y + dY) % dY] == true )
			cpt += 1;
		if( tab[(x + 1 + dX) % dX][(y + dY) % dY] == true )
			cpt += 1;
		return cpt;
	}
	public void modifyNode( int x, int y, boolean state ) {
		tab[x][y] = state;
	}

	public void display() {
		for( int i = 0; i < dX; i += 1 ) {
			for(int j = 0; j < dY; j += 1) {
				System.out.print( (tab[i][j] == true? "* " : "  " ) );
			}
            System.out.println("");
		}
	}

	public void upload() {
		boolean[][] tmp = new boolean[dX][];
		for(int i = 0; i < dX; i += 1) {
			tmp[i] = new boolean[dY];
		}
		for(int i = 0; i < dX; i += 1) {
			for(int j = 0; j < dY; j += 1) {
				if((tab[i][j] == true) && surroundings(i,j) < 2)
					tmp[i][j] = false;
				if((tab[i][j] == true) && surroundings(i,j) > 3)
					tmp[i][j] = false;
				if((tab[i][j] == true) && ((surroundings(i,j) == 2) || surroundings(i,j) == 3))
					tmp[i][j] = true;
				if((tab[i][j] == false) && surroundings(i,j) == 3)
					tmp[i][j] = true;
			}
		}
		for(int i = 0; i < dX; i += 1) {
			for(int j = 0; j < dY; j += 1) {
				tab[i][j] = tmp[i][j];
			}
		}

	}

	public void addPattern(int c, int x, int y) {
		switch(c) {
			case 1:
				modifyNode((x + dX) % dX,(y + dY) % dY,true);
				modifyNode((x + dX) % dX,(y + 1 + dY) % dY,true);
				modifyNode((x + dX) % dX,(y + 2 + dY) % dY,true);
				modifyNode((x + 1 + dX) % dX,(y + dY) % dY,true);
				modifyNode((x + 2 + dX) % dX,(y + 1 + dY) % dY,true);
				break;
		}
	}
}
