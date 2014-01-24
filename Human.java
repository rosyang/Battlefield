/*================================
  class Human -- subclass of Player
  ================================*/

import cs1.Keyboard;

public class Human extends Player {

    //========== Default Constructor ==========//
    public Human () {
	super();
    }

    public Human (String nation) {
        this();
	_nation = nation;
    }
   
    //========= METHODS ==========//

    //procedure for placing ships on board
    public void placeShip( Tile ship ) {
	int row;
	int column;
	String direction;

	System.out.println("\nStarting point:");
	System.out.print( "\nRow: " );
	row = Keyboard.readInt();
	System.out.print( "\nColumn: " );
	column = Keyboard.readInt();

	System.out.println("\nIn which direction is it facing?");
	System.out.print( "\nNorth, East, South, West: " );
	direction = Keyboard.readString();

	for( int i = 0; i < ship.getLength(); i++ ) {
	    if( direction.equals("North") ) {
		_battlefield.set(row, column, ship);
		row--;
	    }
	    else if( direction.equals("East") ) {
		_battlefield.set(row, column, ship);
		column++;
	    }
	    else if( direction.equals("South") ) {
		_battlefield.set(row, column, ship);
		row++;
	    }
	    else if( direction.equals("West") ) {
		_battlefield.set(row, column, ship);
		column--;
	    }
	}

    }
    
	    
    public void attack (Player opp) {
	int r, c;
	System.out.print("Choose a row: ");
	r = Keyboard.readInt();
	System.out.print("Choose a column: ");
	c = Keyboard.readInt();
	hit(opp, r, c);
    }
    

    public static void main (String[] args) {
	Player person = new Human("name");
	//System.out.println(person);
	//person._board[1][2] = new Tile("ship" , 1, "-x-");
	person._battlefield.set(1,2,new Tile("ship", 1, "-x-"));
	person._battlefield.flip(1,2);
	System.out.println("before");
	System.out.println(person);
        Player opp = new Human();
	opp.hit(person, 1, 2);
	System.out.println("after");
	System.out.println(person);
    }
}
