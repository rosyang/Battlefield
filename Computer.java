/*==================================
  class Computer -- subclass of Player
  ==================================*/

public class Computer extends Player {
    
    private int _prevR, _prevC;
    private String _difficulty;

    //========== Default Constructor ==========//
    
    public Computer() {
	super();
	_nation = "Computerland";
	_difficulty = "easy";
	_prevR = 100;
	_prevC = 100;
	setBoard();
	_battlefield.sprinkle();
    }
    public Computer (String diff) {
	this();
	_nation = "Computerland";
	_difficulty = diff;
    }

    //========== METHODS ==========//

    public int guessR() {
	//comp uses prev guess (if there was 1) to make an educauted guess
	//will add a rand # from the range [-1,1]
	if (_difficulty.equals("difficult") && _prevR != 100) {
	    return _prevR + (int)(3 * Math.random()) - 1;
	}
	else //otherwise just pic a random # from 1 to 11
	    return 1+ (int) (10 * Math.random());
    }
    public int guessC() {
	if (_difficulty.equals("difficult") && _prevC != 100) {
	    return _prevC + (int) (3 * Math.random()) - 1;
	}
	else 
	    return 1 + (int) (10 * Math.random());
    }

    public void attack (Player opp) {
	
	int r = guessR();
	int c = guessC();
	if (hit (opp, r, c)) {
	    _prevR = r;
	    _prevC = c;
	}
    }

    public void setBoard() {
	int r, c, i;
	String dir;
	String[] compass = {"north", "south", "east", "west"};
	i = 0;
	while (i < ships.length) {
	    r = guessR();
	    c = guessC();
	    dir = compass[(int)( 4 * Math.random())];
	    if (_battlefield.place(r,c,dir, ships[i]))
		i++;
	}
    }

    public void setPrevC (int c) {
        _prevC = c;
    }
    public static void main (String[] args) {
        Player pc = new Computer("difficult");
        Human h = new Human("human");
	Tile t = new Tile("destroyer", 3, "-x-");
	//t.flip();
	pc._battlefield.set(3,1,t);
	System.out.println(pc);
	//System.out.println(h);
	h.attack(pc);
	System.out.println(pc);

	/*
        ((Computer)pc).setPrevC(0);
        System.out.println(((Computer)pc).guessC());*/

    }


}
