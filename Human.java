public class Human extends Player {

    public Human () {
	super();
    }
    public Human (String name) {
        this();
	_name = name;
    }
   
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
