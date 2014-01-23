public class Board {
    //instance vars
    private int size = 10;
    private Tile[][] _board;
    //constructor
    public Board () {
	board = new Tile[size][size];
	for (int r = 1; r <= size; r ++) {
	    for (int c = 1; c <= size; c++) {
		place(r,c, new Tile());
	    }
	}
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

    public void place (int r, int c, Tile t) {
	_board[r-1][c-1] = t;
    }
    public void flip (int r, int c) {
	_board[r-1][c-1].flip();
    }
    public Tile get (int r, int c) {
	return _board[r-1][c-1];
    }
    public getShips () {



}
