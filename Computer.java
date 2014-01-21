/*==================================
  class Computer -- subclass of Player
  
  ==================================*/

public class Computer extends Player {
    
<<<<<<< HEAD
    //private _guess;


    //========== Default Constructor ==========//
    public Human () {
	_battlefield = new Board();
	_numShip = 6;
	_isTurn = false;
    }

    //========== Constructor ==========//
    public Human (String nation) {
	this();
	_nation = nation;
    }


    //========== METHODS ==========//
    public void normalAttack (Player opp, int x, int y) {}
    public void specialAttack (Player opp, int x, int y) {}

=======
    //private _guess; possibly get all coords & guess by chance?
    

    public Computer() {
	super();
	_name = "Computer";
    }

    public int guessR () {
	return 10 + (int) Math.random();
    }
    public int guessC () {
	return 10 + (int) Math.random();
    }
>>>>>>> 942a62026b3417227270b81112ad4b717185979a
}
