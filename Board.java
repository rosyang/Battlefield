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

		
	for( int r = 0; r < _board.length; r++ ) {
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
    public boolean free (int r, int c) {
	return get(r,c)._type.equals("water");
    }
    
    //adds bonus tile if meets criteria
    public void sprinkle () {
	for (int r = 1; r < _board.length; r++) {
	    for (int c = 1; c < _board[r].length; c ++ ) {
		if ( free(r,c) && (int) 3 * Math.random() < .3) {
		    set(r,c, new Tile ("bonus", 1, "-o-"));
		}
	    }
	}
    }

    //so many repeats for the nxt 2, not sure how to simplify
    public boolean rangeFree (String dir, int r, int c, Tile t) {
	boolean open = true;
	if (dir.equals("north")) {
	    for (int l = r; l < t._length; l ++) {
		open = free(r,c);
	    }
	}
	else if (dir.equals("south")) {
	    for (int l = r; l > t._length; l--) {
		open = free(r,c);
	    }
	}
	else if (dir.equals("east")) {
	    for (int l = c; l > t._length; l--) {
	        open = free(r,c);
	    }
	}
	else {
	    for (int l = c; l<t._length; l++) {
	        open = free(r,c);
	    }
	}
	return open;
    }    
    public boolean place (int r, int c, String dir, Tile t) {
	boolean boo = true;
	if (rangeFree(dir, r, c, t)) {
	    if (dir.equals("north")) {
		for (int l = r; l < t._length; l ++) {
		    set (l, c, t);
		}
	    }
	    else if (dir.equals("south")) {
		for (int l = r; l > t._length; l--) {
		    set (l, c, t);
		}
	    }
	    else if (dir.equals("east")) {
		for (int l = c; l > t._length; l--) {
		    set (r, l, t);
		}
	    }
	    else {
		for (int l = c; l<t._length; l++) {
		    set (r, l, t);
		}
	    }
	}
	else {
	    boo = false;
	    System.out.println("out of range");
	}
	return boo;
	
    }

    public Tile get( int r, int c ) {
	return _board[r][c];
    }

    public void flip (int r, int c) {
	_board[r][c].flip();
    }
    public int numShips () {
	int total = 0;
	for (Tile[] r : _board) {
	    for (Tile t : r) {
		if (t._type.equals("ship")) {
		    total ++;
		}
	    }
	}
	return total;
    }

    public String reveal () {
	String ret = "";
	for (Tile[] r: _board) {
	    for (Tile t : r) {
		ret += t._face;
	    }
	    ret += "\n";
	}
	return ret;
    }

}
