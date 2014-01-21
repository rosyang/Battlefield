/*==============================================
  class Player -- superclass for the players of Battleships
  ==============================================*/

import java.util.ArrayList;

public abstract class Player {

    //========== Instance Variables ==========//
    protected String _nation;
    protected Board _battlefield;
    protected int _numShips;
    protected boolean _isTurn;
    

    //========== Default Constructor =========//
    public Player() {
	_numShips = 5;
	_isTurn = false;
    }


    //========== Constructor ==========//
    public Player( String nation ){
	this();
	_nation = nation;
    }


    //========== METHODS ==========//
    
    //Accessors
    public String getNation() {
	return _nation;
    }
    public String getBattlefield() {
	return _battlefield;
    }
    public void setBattlefield() {
	_battlefield = new Board();
    }
    

    public boolean hasShips() {
	return _numShips > 0;
    }
    

    public abstract void normalAttack(Player opp, int x, int y);

    public abstract void specialAttack (Player opp, int x, int y);

    /*
    public void place (int r, int c) {
	_board[r][c] = new Tile( );
    }
    */
}
