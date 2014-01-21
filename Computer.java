/*==================================
  class Computer -- subclass of Player
  
  ==================================*/

public class Computer extends Player {
    
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

}
