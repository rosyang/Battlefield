public class Human extends Player {
    private String _name;

    public Human () {
	super();
    }
    public Human (String name) {
	this();
	_name = name;
    }

    public boolean attack (Player opp, int r, int c) {
	
	Tile  t = opp._board[r + 1][c + 1];
	if (! t._type.equals("water")) {
	    opp._board[r+1][c+1].flip();
	    return true;
	}
        return false;
    }
    public static void main (String[] args) {
	Human person = new Human();
	System.out.println(person);
	//person.place(10,10,new Tile());
	//person._board[1][2] = new Tile("ship", 1, "-x-");
	//person._board[1][2].flip();
	//System.out.println(person);
    }
}
