/*==================================
  class Computer -- subclass of Player
  ==================================*/

public class Computer extends Player {
    

    //========== Instance Variables ==========//
    private int _prevR, _prevC;
    private String _difficulty;


    //========== Default Constructor ==========//    
    public Computer() {
	super();
	_nation = "Computerland";
	_prevR = 100;
	_prevC = 100;
    }
    public Computer (String diff) {
	this();
	_nation = "Computerland";
	_difficulty = diff;
    }

    //========== METHODS ==========//

    public int guessR() {
	//Computer uses previous guess (if there was one) to make an educauted guess
	//Will add a random number from the range [-1,1]
	if (_difficulty.equals("Hard") && _prevR != 100) {
	    return _prevR + (int)(3 * Math.random()) - 1;
	}
	//Otherwise just pick a random # from 1 to 11
	else 
	    return 1 + (int) (10 * Math.random());
    }

    public int guessC() {
	if (_difficulty.equals("Hard") && _prevC != 100) {
	    return _prevC + (int) (3 * Math.random()) - 1;
	}
	else 
	    return 1 + (int) (10 * Math.random());
    }


    public void attack (Player opp) {
	
	int r = guessR();
	int c = guessC();
	if (hit (opp, r, c)) {
	    _prevR = r;
	    _prevC = c;
	}
    }

    public void setPrevC (int c) {
        _prevC = c;
    }


    //procedure for placing ships on board
    public void placeShip( Tile ship ) {
	int length = ship.getLength();
	int randRow = (int)(Math.random()*10);
	int randCol = (int)(Math.random()*10);
	String direction = "";
	
	if( _battlefield.get(randRow, randCol).getFace().equals("-X-") )
	    placeShip(ship);
	else {
	    if( length > randRow ) {
		if( length > randCol )
		    direction = "East";
		else if( length < randCol )
		    direction = "South";
	    }
	    else if( length < randRow ) {
		if( length > randCol )
		    direction = "North";
		else if( length < randCol )
		    direction = "West";
	    }

	    for( int i = 0; i < length; i++ ) {
		if( direction.equals("North") ) {
		    _battlefield.set(randRow, randCol, ship);
		    randRow--;
		}
		else if( direction.equals("East") ) {
		    _battlefield.set(randRow, randCol, ship);
		    randCol++;
		}
		else if( direction.equals("South") ) {
		    _battlefield.set(randRow, randCol, ship);
		    randRow++;
		}
		else if( direction.equals("West") ) {
		    _battlefield.set(randRow, randCol, ship);
		    randCol--;
		}
	    }
	}
    }


    public static void main (String[] args) {
        Player pc = new Computer("difficult");
        Human h = new Human("human");
	Tile t = new Tile("destroyer", 3, "-x-");
	//t.flip();
	pc._battlefield.set(3,1,t);
	System.out.println(pc);
	//System.out.println(h);
	h.attack(pc);
	System.out.println(pc);

	/*
        ((Computer)pc).setPrevC(0);
        System.out.println(((Computer)pc).guessC());*/

    }


}
