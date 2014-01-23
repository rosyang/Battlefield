/*=====================================
  class Tiles
  Represents each tile of the game board
  =====================================*/

public class Tile {

    //========== Instance Variables ==========//
    protected String _type;
    protected int _length;
    protected String _face;
    protected boolean _isFaceUp;

    
    //========== Default constructor ==========//
    //default tile on a board represents water
    public Tile() {
	_type = "water";
	_length = 1;
	_face = "-W-";
	_isFaceUp = false;
	//Imagine water as the back of a tile. Tile flips when theres a ship/box
    }


    //========== Constructor ==========//
    public Tile( String type, int length, String value ) {
	this();
	_type = type;
	_length = length;
	_face = value;
    }


    //========== METHODS ==========//

    public boolean isFaceUp() {
	return _isFaceUp;
    }


    public void flip() {
	_isFaceUp = !_isFaceUp;
    }


    public String toString() {
	if( _type.equals("axis") || isFaceUp() )
	    return _face;
	else
	    return "-W-";
    }


    public boolean equals( Object rightSide ) {
	
	return ( this == rightSide ) || ( rightSide instanceof Tile 
					  && this._face == ((Tile)rightSide)._face
					  && this._isFaceUp == ((Tile)rightSide)._isFaceUp );
	
    }

}
