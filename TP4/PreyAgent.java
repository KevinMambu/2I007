
public class PreyAgent extends Agent {

	int cpt;
	int reproduce_it;
	public PreyAgent( int __x, int __y, World __w, int __r )
	{
		super(__x,__y,__w);
		
		_redValue = 0;
		reproduce_it = __r;
		_greenValue = 128;
		_blueValue = 255;
		_alive = true;
		cpt = 1;
	}
	
	public void step( )
	{
				
		if(_alive == true) {
			int cellColor[] = _world.getCellState(_x, _y);
	
			cellColor[redId]   = 205;
			cellColor[greenId] = 255;
			cellColor[blueId]  = 255;
	
			_world.setCellState(_x, _y, cellColor);
	
			if (Math.random() > 0.5) // au hasard
				_orient = (_orient + 1) % 4;
			else
				_orient = (_orient - 1 + 4) % 4;
	
		//Changemant d'orientation selon l'entourage de VonNeumann
		for(int i = 0; i != _world.agents.size(); i += 1) {
			Agent a = _world.agents.get(i);
			if((a instanceof PredatorAgent) && (a._x == _x && a._y == _y -1))
				_orient = 2;
			if((a instanceof PredatorAgent) && (a._x == _x && a._y == _y +1))
				_orient = 0;
			if((a instanceof PredatorAgent) && (a._x == _x -1 && a._y == _y))
				_orient = 3;
			if((a instanceof PredatorAgent) && (a._x == _x +1 && a._y == _y))
				_orient = 1;
		}
			// met a jour: la position de l'agent (depend de l'orientation)
			switch (_orient) {
			case 0: // nord	
				_y = (_y - 1 + _world.getHeight()) % _world.getHeight();
				break;
			case 1: // est
				_x = (_x + 1 + _world.getWidth()) % _world.getWidth();
				break;
			case 2: // sud
				_y = (_y + 1 + _world.getHeight()) % _world.getHeight();
				break;
			case 3: // ouest
				_x = (_x - 1 + _world.getWidth()) % _world.getWidth();
				break;
			}

			cpt += 1;
			if(cpt == reproduce_it) {
				boolean test = false;
				for(int i = 0; (i < _world.agents.size() && !test); i += 1) {
					Agent a = _world.agents.get(i);
					if((a instanceof PreyAgent) && !a._alive) {
						a._alive = true;
						a._x = _x;
						a._y = _y;
						test = true;
					}
					else if(!a._alive)
						a = new PreyAgent(_x,_y,_world,reproduce_it);
				}
				if(!test)
					_world.add(new PreyAgent(_x,_y,_world,reproduce_it));
			}
		}

		else if(_alive == false) {	
			_redValue = 0;
			_greenValue = 0;
			_blueValue = 0;
		}

	}
}
