import cs1.Keyboard;
/*================================
  class Human -- subclass of Player
  ================================*/

public class Human extends Player {

    //========== Instance Variables ==========//


    //========== Default Constructor ==========//
    public Human () {
	super();
	setBoard();
	_battlefield.sprinkle();
    }

    public Human (String nation) {
        this();
	_nation = nation;
    }
   
    //========= METHODS ==========//

    
    public void attack (Player opp) {
	int r, c;
	System.out.print("Choose a row: ");
	r = Keyboard.readInt();
	System.out.print("Choose a column: ");
	c = Keyboard.readInt();
	hit(opp, r, c);
    }

    public void setBoard() {
	int r, c;
	String dir;
	int i = 0;
	System.out.println(_nation + ", place your ships!" );
	System.out.println("You have :");
	for (Tile s : ships) {
	    System.out.println("\t" + s._type);
	}
	while (i < ships.length) {
	    System.out.println("Where do you want to place the " + s._type + "?");
	    System.out.print("Choose a row: ");
	    r = Keyboard.readInt();
	    System.out.print("Choose a column: ");
	    c = Keyboard.readInt();
	    System.out.print("Choose a direction (north, south, east, west): ");
	    dir = Keyboard.readString();
	    if (_battlefield.place(r,c,dir, ships[i])) 
		i++;
	}
	System.out.println("Here's your board:");
	System.out.println(_battlefield.cheat());
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
