public class Human extends Player {
    private String _name;

    public Human () {
	super();
	//_numShips = 10;
	//_board = new Tile[10][10];
    }
    public Human (String name) {
	this();
	_name = name;
    }

    public void attack (Player opp, int r, int c) {
	
	Tile  t = opp._board[r + 1][c + 1]; /*
	if ( instanceOf Ships) {
	    .remove(
	}
	else if ( instance of ) {
	}
	else {
	}*/
    }
    public static void main (String[] args) {
	Human person = new Human();
	System.out.println(person);
    }
}