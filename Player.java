

import cs1.Keyboard;

/*==============================================
  class Player -- superclass for the players of Battleships
  ==============================================*/
//import java.util.ArrayList;

public abstract class Player {

    //========== Instance Variables ==========//
    protected String _nation;
    protected Board _battleField;
    protected boolean _isTurn;
    protected int _numShips;
    protected int _shields;

    //========== Default Constructor =========//
    //constructor (can't be instantiated b/c abstract)
    public Player () {
	_numShips = 5;
	_battleField = new Board();
	_isTurn = false;
    }

    public Player( String nation ){
	this();
	_nation = nation;
    }


    //========== METHODS ==========//
    
    //Accessors
    public String getNation() {
	return _nation;
    }
    public String getBattlefield() {
	return _battleField.toString();
    }
    public void setBattlefield() {
	_battleField = new Board();
    }
    
    public boolean hasShips() {
	return _battleField.numShips() > 0;
    }
    public boolean Turn () {
	return _isTurn;
    }

    public abstract void attack (Player opp);
    public boolean hit (Player opp, int r, int c) {
	Tile  t = opp._battleField.get(r,c);
	if (t._isFaceUp) {
	    if (! t._type.equals("water") || ! t._type.equals("axis")) {
		if (opp._shields > 0) {
		    opp._shields--;
		}
		else {
		opp._battleField.flip(r,c);
		
		_isTurn = true;
		}
	    }
	    else if (t._type.equals("bonus")) {
		opp._battleField.flip(r,c);
		opp._shields++;
	    }
	}
        _isTurn = false;
	return _isTurn;
    }

    public String toString () {
	return _nation + "\n" + _battleField;
    }

}
