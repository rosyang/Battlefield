/*==============================================
  class Player -- superclass for the players of Battleships
  ==============================================*/

public abstract class Player {

    //========== Instance Variables ==========//
    protected String _nation;
    protected Board _battlefield;
    protected boolean _isTurn;
    protected int _numShips;
    protected int _shields;

    //something
    Tile s0 = new Tile ("boat # 1", 2 , "-X-");
    Tile s1 = new Tile ("boat # 2", 2,"-X-");
    Tile s2 = new Tile ("submarine", 3, "-X-");
    Tile s3 = new Tile ("destroyer", 3, "-X-");
    Tile s4 = new Tile ("battleship", 4, "-X-");
    Tile s5 = new Tile ("aircraft carrier", 5, "-X-");
    protected Tile[] ships = {s0, s1, s2, s3, s4, s5};
    //========== Default Constructor =========//
    public Player () {
	_numShips = 5;
	_isTurn = false;
	_battlefield = new Board();
    }

    //========== Constructor =========//
    public Player( String nation ){
	this();
	_nation = nation;
    }


    //========== METHODS ==========//
    
    //Accessors
    public Board getBattlefield() {
	return _battlefield;
    }
    public String getNation() {
	return _nation;
    }
    public boolean getTurn() {
	return _isTurn;
    }
    public void flipTurn() {
	_isTurn = ! _isTurn;
    }

    //Instantiates new board
    public void setBattlefield() {
	_battlefield = new Board();
    }

    public String toString() {
	return _nation + "'s Board\n" + _battlefield;
    }


    public boolean hasShips() {
	return _battlefield.numShips() > 0;
    }

    public boolean hit (Player opp, int r, int c) {
	Tile t = opp._battlefield.get(r,c);
	if (t.isFaceUp() ) {
	    if (! t.getType().equals("water") || ! t.getType().equals("axis")) {
		if (opp._shields > 0) {
		    opp._shields--;
		    System.out.println("blocked\n");
		    flipTurn();
		}
		else {
		    opp._battlefield.flip(r,c);
		    System.out.println("Yay, a hit\n");
		}
	    }
	    else if (t.getType().equals("bonus")) {
		opp._battlefield.flip(r,c);
		opp._shields++;
		System.out.println("gained a bonus, +1 shield\n");
		flipTurn();
	    }
	}
	else {
	    flipTurn();
	    System.out.println("no luck\n");
	}
	return _isTurn;
    }

    //abstract 
    public abstract void attack(Player opp);
    public abstract void setBoard ();
    public static void main (String[] args) {
	Player p = new Human();
	Tile[] a = p.ships;
	for (Tile t : a) {
	    System.out.println(t._face);
	}
    }
}
