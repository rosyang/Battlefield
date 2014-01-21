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
	_isFaceUp = false;//true when not water & not hit? clarify 
    }

<<<<<<< HEAD

    //========== Constructor ==========//
    public Tiles( String type, int length, String value ) {
=======
    //Constructor
    public Tile( String type, int length, String value ) {
>>>>>>> 942a62026b3417227270b81112ad4b717185979a
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
	if( isFaceUp() )
	    return _face;
	else
	    return "-W-";
    }

<<<<<<< HEAD

    public boolean equals( Object rightSide ) {
	
	return ( this == rightSide ) || ( rightSide instanceof Tile 
					  && this._face == ((Tile)rightSide)._face
					  && this._isFaceUp == ((Tile)rightSide)._isFaceUp );
	
    }

=======
>>>>>>> 942a62026b3417227270b81112ad4b717185979a
}
