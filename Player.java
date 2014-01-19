//import java.util.ArrayList;
public abstract class Player {

    //instance vars
    protected int _numShips;
    protected boolean _isTurn;
    protected  Tile[][] _board;
    
    public Player () {
	_numShips = 10;
	_board = new Tile[10][10];/*
	for (int x = 1; x < _board[1].length; x++) {
	    _board[1][x] = x;
	}
	for (int x = 1; x < _board.length; x++) {
	    _board[x][1] = x;
	    }*/
    }

    public boolean hasShips() {
	return _numShips > 0;
    }
    
    public abstract void attack(Player opp, int x, int y);

    public String toString () {
	String ret = "  1 2 3 4 5 6 7 8 9 10\n";
	for (int x = 0; x < _board.length; x++ ) {
	    ret += x + 1 + " ";
	    for (Tile t : _board[x]) {
		ret += t + " " ;
	    }
	    ret += "\n";
	}
	return ret;
    }
    public void place (int r, int c) {
	_board[r][c] = new Tile( );
    }
    /*
    public static void main (String[] args) {
	Player trial = new Player();//won't work, abstract can't be instantiated
	System.out.println(trial);
	}*/

}