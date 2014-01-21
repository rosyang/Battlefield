/*================================
  class Human -- subclass of Player
  ================================*/

public class Human extends Player {

    //========== Instance Variables ==========//


    //========== Default Constructor ==========//
    public Human () {
<<<<<<< HEAD
	_battlefield = new Board();
	_numShip = 5;
	_isTurn = false;
    }

    //========== Constructor ==========//
    public Human (String nation) {
	this();
	_nation = nation;
    }


    //========= METHODS ==========//

    public void normalAttack (Player opp, int r, int c) {
	
	Tile  t = opp._board[r + 1][c + 1]; /*
	if ( instanceOf Ships) {
	    .remove(
	}
	else if ( instance of ) {
	}
	else {
	}*/
    }


    public void specialAttack (Player opp, int x, int y) {}

=======
	super();
    }
    public Human (String name) {
        this();
	_name = name;
    }
   
>>>>>>> 942a62026b3417227270b81112ad4b717185979a
    public static void main (String[] args) {
	Player person = new Human();
	//System.out.println(person);
	//person._board[1][2] = new Tile("ship" , 1, "-x-");
	person.place(1,2,new Tile("ship", 1, "-x-"));
	person._board[0][1].flip();
	System.out.println("before");
	System.out.println(person);
        Player opp = new Human();
	opp.attack(person, 1, 2);
	System.out.println("after");
	System.out.println(person);
    }
}
