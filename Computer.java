import cs1.Keyboard;
/*==================================
  class Computer -- subclass of Player
  
  ==================================*/

public class Computer extends Player {
    
    private int _prevR, _prevC;
    private String _nation, _difficulty;//diff decided in driver file & affects how comp attacks

    //========== Default Constructor ==========//
    
    public Computer() {
	super();
	_nation = "Computerland";
	_difficulty = "easy";
	_prevR = 100;
	_prevC = 100;
    }
    public Computer (String diff) {
	this();
	_difficulty = diff;
    }

    //========== METHODS ==========//
    public void setDiff (String d) {
	_difficulty = d;
    }

    public int guessR() {
	//comp uses prev guess (if there was 1) to make an educauted guess
	//will add a rand # from the range [-1,1]
	if (_difficulty.equals("difficult") && _prevR != 100) {
	    return _prevR + (int)(3 * Math.random()) - 1;
	}
	else //otherwise just pic a random # from 1 to 11 inclusive
	    return 1+ (int)(10 * Math.random());
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

    public void setPrevC (int c) {
	_prevC = c;
    }
    public static void main (String[] args) {
	Player pc = new Computer("difficult");
	//--> typecasting might be issue in driver file
	((Computer)pc).setPrevC(0);
	System.out.println(((Computer)pc).guessC());
    }
}
