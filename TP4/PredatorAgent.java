 class PredatorAgent extends Agent {

	boolean _predator;
	int death_it;
	int reproduce_it;
	int cpt_d;
	int cpt_r;
	public PredatorAgent( int __x, int __y, World __w, int __r, int __d )
	{
		super(__x,__y,__w);
		death_it = 11; //number of iteration before death
		death_it = __d;
		reproduce_it = __r;
		cpt_d = 1;
		cpt_r = 1;
		_predator = true;
		_alive = true;
	}
	
	public void step( )
	{
		if(_alive) {
			int cellColor[] = _world.getCellState(_x, _y);		
			cellColor[redId] = 255;
			cellColor[greenId] = 240;
			cellColor[blueId] = 225;

			cpt_d += 1;
			cpt_r += 1;

			boolean test = false;
			_world.setCellState(_x, _y, cellColor);
			for(int i = 0; i != _world.agents.size() && !test; i += 1) {
				Agent a = _world.agents.get(i);
				if((a._x == _x) && (a._y == _y) && (a instanceof PreyAgent) ) {
					((PreyAgent)a)._alive =false;
					test = true;
				}
			}
			if(test=true)
				cpt_d = 1;
			if(cpt_d == death_it)
				_alive = false;

			if ( Math.random() > 0.5 ) // au hasard
				_orient = (_orient+1+4) %4;
			else
				_orient = (_orient-1+4) %4;
		

			if(cpt_r == reproduce_it) {
				 test = false;
				for(int i = 0; (i < _world.agents.size() && !test); i += 1) {
					Agent a = _world.agents.get(i);
					if((a instanceof PreyAgent) && !a._alive)
						a = new PredatorAgent(_x,_y,_world,reproduce_it,death_it);
				}
				if(!test)
					_world.add(new PredatorAgent(_x,_y,_world,reproduce_it,death_it));
			}

			//Changemant d'orientation selon l'entourage de VonNeumann
			for(int i = 0; i != _world.agents.size(); i += 1) {
				Agent a = _world.agents.get(i);
				if((a instanceof PredatorAgent) && (a._x == _x && a._y == _y -1))
					_orient = 0;
				if((a instanceof PredatorAgent) && (a._x == _x && a._y == _y +1))
					_orient = 2;
				if((a instanceof PredatorAgent) && (a._x == _x -1 && a._y == _y))
					_orient = 1;
				if((a instanceof PredatorAgent) && (a._x == _x +1 && a._y == _y))
					_orient = 3;
			}
	
	
			// met a jour: la position de l'agent (depend de l'orientation)
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

		else if(_alive == false) {	
			_redValue = 0;
			_greenValue = 0;
			_blueValue = 0;
		}
	}

}
