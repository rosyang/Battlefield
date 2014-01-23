/*==============================================
  class Player -- superclass for the players of Battleships
  ==============================================*/

public abstract class Player {

    //========== Instance Variables ==========//
    protected String _nation;
    protected Board _battlefield;
    protected boolean _isTurn;
    protected int _numShips;
    protected int _shields;


    //========== Default Constructor =========//
    public Player () {
	_numShips = 5;
	_isTurn = false;
	setBattlefield();
    }

    //========== Constructor =========//
    public Player( String nation ){
	this();
	_nation = nation;
    }


    //========== METHODS ==========//
    
    //Accessors
    public String getNation() {
	return _nation;
    }
    public boolean getTurn() {
	return _isTurn;
    }


    //Instantiates new board
    public void setBattlefield() {
	_battlefield = new Board();
    }


    public String toString() {
	return _nation + " 's Board\n" + _battlefield;
    }


    public boolean hasShips() {
	return _numShips > 0;
    }

    public abstract void attack(Player opp);
    public boolean hit (Player opp, int r, int c) {
	Tile t = opp._battlefield.get(r,c);
	if (t._isFaceUp) {
	    if (! t._type.equals("water") || ! t._type.equals("axis")) {
		if (opp._shields > 0) {
		    opp._shields--;
		}
		else {
		    opp._battlefield.flip(r,c);
		
		_isTurn = true;
		}
	    }
	    else if (t._type.equals("bonus")) {
		opp._battlefield.flip(r,c);
		opp._shields++;
	    }
	}
        _isTurn = false;
	return _isTurn;
    }


}
