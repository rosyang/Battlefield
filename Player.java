//import java.util.ArrayList;
import cs1.Keyboard;
public abstract class Player {

    //instance vars
    protected int _numShips;
    protected boolean _isTurn;
    protected  Tile[][] _battleField;
    protected String _nation;
    protected int _shields;

    //constructor (can't be instantiated b/c abstract)
    public Player () {
	_numShips = 5;
	_battlefield = new Board();
	_isTurn = false;
    }

    /*accessors & mutators
    public void setName (String name) {
	_name = name;
    }
    public String getName () {
	return _name;
	}*/
    public boolean hasShips() {
	return _numShips > 0;
    }
    public boolean Turn () {
	return _isTurn;
    }
    
    //methods
    public abstract void attack (Player opp);
    public void hit (Player opp, int r, int c) {
	Tile  t = opp._board[r - 1][c - 1];
	if (t._isFaceUp) {
	    if (! t._type.equals("water")) {
		opp._board[r-1][c-1].flip();
		numShips--;
		_isTurn = true;
	    }
	    else if (t._type.equals("bonus")) {
		opp._board[r-1][c-1].flip();
	    }
	}
        _isTurn = false;
    }
    public String toString () {
	return nation + "\n" + _battleField.toString();
    }
}
