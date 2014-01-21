/*======================================
  class Board
  Instantiates a player's board of Tiles
  ======================================*/

import java.util.ArrayList;

public class Board {

    //========== Instance Variables ==========//
    private static final int DEFAULT_SIZE = 11;
    private Object[][] _board;


    //========== Default Constructor ==========//
    public Board() {
	_board = new Object[DEFAULT_SIZE][DEFAULT_SIZE];

	for( int r = 0; r < _board.length; r++ )
	    for( int c = 0; c < _board[r].length; c++ ) {
		if( r == 0 )
		    _board.set( r, c, c );
		else if( c == 0 )
		    _board.set( r, c, r );
		else
		    _board.set( r, c, new Tile() );
	    }
    }


    //========== METHODS ==========//

    public String toString() {
	String output = "";

	for( Object[] r: _board ) {
	    for( Object c: r )
		output += c + " ";
	    output += "\n";
	}

	return output;
    }


    private Object set( int r, int c, Object newVal ) {
	Object oldValue = _board[r][c];
	_board[r][c] = newVal;
	return oldValue;
    }


    private Object get( int r, int c ) {
	return _board[r][c];
    }

}
