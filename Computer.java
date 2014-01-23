import cs1.keyboard;
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
	if (_difficulty.equals("difficlut") && _prevR != 100) {
	    return _prevR + 3*(int) Math.random() - 1;
	}
	else //otherwise just pic a random # from 1 to 11
	    return 1+ 10 * (int)Math.random();
    }
    public int guessC() {
	if (_difficulty.equals("difficlut") && _prevC != 100) {
	    return _prevC + 3*(int) Math.random() - 1;
	}
	else 
	    return 1+ 10 * (int)Math.random();
    }

    public void attack (Player opp) {
	
	int r = guessR();
	int c = guessC();
	if (hit (opp, r, c)) {
	    _prevR = r;
	    _prevC = c;
	}
    }

}
