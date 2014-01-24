/*======================================
  class Board
  Instantiates a player's board of Tiles
  ======================================*/

public class Board {

    //========== Instance Variables ==========//
    private static final int DEFAULT_SIZE = 11;
    private Tile[][] _board;


    //========== Default Constructor ==========//
    public Board() {
	_board = new Tile[DEFAULT_SIZE][DEFAULT_SIZE];

	for( int r = 0; r < _board.length; r++ )
	    for( int c = 0; c < _board[r].length; c++ ) {
		if( r == 0 )
		    set( r, c, new Tile("axis", 1, " " + c + " " ));
		else if( c == 0 )
		    set( r, c, new Tile("axis", 1, " " + r + " "  ));
		else {
		    set( r, c, new Tile() );
                }
	    }
    }


    //========== METHODS ==========//

    public String toString() {
	String output = "";

	for( Tile[] r: _board ) {
	    for( Tile c: r )
		output += c + " ";
	    output += "\n";
	}

	return output;
    }


    public Tile set( int r, int c, Tile newVal ) {
	Tile oldValue = get(r,c);
	_board[r][c] = newVal;
	return oldValue;
    }


    public Tile get( int r, int c ) {
	return _board[r][c];
    }

    public void flip (int r, int c) {
	_board[r][c].flip();
    }

    //Flips all tiles of the board that are facing up
    public void faceDown() {
	for( Tile[] r: _board )
	    for( Tile c: r )
		if( c.isFaceUp() )
		    c.flip();
    }


    public int numShips () {
	int total = 0;
	for (Tile[] r : _board) {
	    for (Tile t : r) {
		if (t.getType().equals("ship")) {
		    total ++;
		}
	    }
	}
	return total;
    }

    public static void main (String[] args) {
	Board b = new Board();
	System.out.println(b);
    }

}
