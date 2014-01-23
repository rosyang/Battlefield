import cs1.Keyboard;
/*================================
  class Human -- subclass of Player
  ================================*/

public class Human extends Player {

    //========== Instance Variables ==========//


    //========== Default Constructor ==========//
    public Human () {
	super();
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
    public static void main (String[] args) {
	Player person = new Human("name");
	//System.out.println(person);
	//person._board[1][2] = new Tile("ship" , 1, "-x-");
	person._battleField.set(1,2,new Tile("ship", 1, "-x-"));
	person._battleField.flip(1,2);
	System.out.println("before");
	System.out.println(person);
        Player opp = new Human();
	opp.hit(person, 1, 2);
	System.out.println("after");
	System.out.println(person);
    }
}
