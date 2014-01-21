/*================================
  class Human -- subclass of Player
  ================================*/

public class Human extends Player {

    //========== Instance Variables ==========//


    //========== Default Constructor ==========//
    public Human () {
	_battlefield = new Board();
	_numShip = 5;
	_isTurn = false;
    }

    //========== Constructor ==========//
    public Human (String nation) {
	this();
	_nation = nation;
    }


    //========= METHODS ==========//

    public void normalAttack (Player opp, int r, int c) {
	
	Tile  t = opp._board[r + 1][c + 1]; /*
	if ( instanceOf Ships) {
	    .remove(
	}
	else if ( instance of ) {
	}
	else {
	}*/
    }


    public void specialAttack (Player opp, int x, int y) {}

    public static void main (String[] args) {
	Human person = new Human();
	System.out.println(person);
    }
}
