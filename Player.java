/*==============================================
  class Player -- superclass for the players of Battleships
  ==============================================*/

import java.util.ArrayList;

public abstract class Player {

    //========== Instance Variables ==========//
    protected String _nation;
    protected Board _battlefield;
    protected int _numShips;
    protected boolean _isTurn;
<<<<<<< HEAD
    

    //========== Default Constructor =========//
    public Player() {
	_numShips = 5;
	_isTurn = false;
    }


    //========== Constructor ==========//
    public Player( String nation ){
	this();
	_nation = nation;
    }


    //========== METHODS ==========//
    
    //Accessors
    public String getNation() {
	return _nation;
=======
    protected  Tile[][] _board;
    protected String _name;

    //constructor (can't be instantiated b/c abstract)
    public Player () {
	_numShips = 10;
	_board = new Tile[10][10];
	_isTurn = false;
	//by default, an empty board
        for (int r = 1; r <= _board.length; r++) {
	    //can't be _board[r].length b/c _board[10] is out of bounds
	    for (int c = 1; c <= 10; c++) {
		place(r,c, new Tile());
	    }
	}
>>>>>>> 942a62026b3417227270b81112ad4b717185979a
    }
    public String getBattlefield() {
	return _battlefield;
    }
    public void setBattlefield() {
	_battlefield = new Board();
    }
    

    //accessors & mutators
    public void setName (String name) {
	_name = name;
    }
    public String getName () {
	return _name;
    }
    public boolean hasShips() {
	return _numShips > 0;
    }
    
<<<<<<< HEAD

    public abstract void normalAttack(Player opp, int x, int y);

    public abstract void specialAttack (Player opp, int x, int y);

    /*
    public void place (int r, int c) {
	_board[r][c] = new Tile( );
    }
    */
=======
    //methods
    public boolean attack(Player opp, int r, int c) {
	Tile  t = opp._board[r - 1][c - 1];
	if (! t._type.equals("water")) {
	    opp._board[r-1][c-1].flip();
	    return true;
	}
        return false;
    }
    public String toString () {
	String ret = "   1   2   3   4   5   6   7   8   9   10\n";
	for (int x = 0; x < _board.length; x++ ) {
	    ret += x + 1 + " ";
	    for (Tile t : _board[x]) {
		ret += t + " " ;
	    }
	    ret += "\n";
	}
	return ret;
    }
    public void place (int r, int c, Tile piece) {
	_board[r-1][c-1] = piece;
    }

    /*
    public static void main (String[] args) {
	Player trial = new Player();//won't work, abstract can't be instantiated
	System.out.println(trial);
	}*/

>>>>>>> 942a62026b3417227270b81112ad4b717185979a
}
