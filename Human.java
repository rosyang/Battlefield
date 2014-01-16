public class Human extends Player {
    private String _name;

    public Human () {
	_numShips = 10;
	_board = new Tiles();
    }
    public Human (String name) {
	this;
	_name = name;
    }

    public void attack (Player opp, int x, int y) {
	System.out.print();
	Comparaable square = opp._board.get(x,y);
	if ( instanceOf Ships) {

	}
	else if ( instance of ) {
	}
    }
}