public abstract class Player {

    //instance vars
    protected int _numShips;
    protected boolean _isTurn;
    protected Tiles _board;

    public boolean hasShips() {
	return numShips > 0;
    }
    
    public abstract void attack(Player opp, int x, int y) {}
}