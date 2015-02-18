
public class LangtonAnt extends Agent {
 	public LangtonAnt( int __x, int __y, World __w )
	{
		super(__x,__y,__w);
	}
	
	public void step( )
	{
		// met a jour: (1) la couleur du sol (2) l'orientation de l'agent
		System.out.println("arrivee dans step()");	
		int cellColor[] = _world.getCellState(_x, _y);
		int h = cellColor[redId];
		if(h == 128) {
			for(int i = 0; i < cellColor.length; i ++) {
				cellColor[i] = 255;
			}
		}

		else {
			for(int i = 0; i < cellColor.length; i += 1) {
				cellColor[i] = 128;
			}
		}		
		
		if(h == 128) {
			_orient = (_orient + 1 + 4) % 4;
		}

		else {
			_orient = (_orient - 1 + 4) % 4;
		}
		// met a jour: la position de l'agent (depend de l'orientation)
		System.out.println(_orient); 
		
		_world.setCellState(_x, _y, cellColor);
		switch ( _orient ) 
		 {
         	case 0: // nord	
         		_y = ( _y - 1 + _world.getHeight() ) % _world.getHeight();
         		break;
         	case 1:	// est
         		_x = ( _x + 1 + _world.getWidth() ) % _world.getWidth();
 				break;
         	case 2:	// sud
         		_y = ( _y + 1 + _world.getHeight() ) % _world.getHeight();
 				break;
         	case 3:	// ouest
         		_x = ( _x - 1 + _world.getWidth() ) % _world.getWidth();
 				break;
		 }
	}
}
