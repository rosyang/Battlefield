/*=================================
  class Battleships
  Driver file for Battleships game
  ================================*/

import cs1.Keyboard;

public class Battleships {

    //Instance Variables
    private Player player1, player2;
    private boolean gameOver;

    //Default Constructor
    public Battleships() {
	gameOver = false;
	newGame();
    }

    //Methods
    public void newGame() {

	String s = "Welcome to Battleships!\n";
	s+= "Who is your enemy?";
	System.out.print(s);
	String typed = Keyboard.readString();

	//at least one person has to be human
	player1 = new Human();
	System.out.print("Player 1, what is your name? ");
	String name = Keyboard.readString();
	player1.setName(name);
	player1.turn();//method changing _isTurn back and form still has to be created

	//initialize the 2nd player based on the choice
	if( typed.equals( "2 players" ) ) {
	    System.out.print("Player 2, what is your name? ");
	    name = Keyboard.readString();
	    player2 = new Human(name);
	}
	else if( typed.equals("Computer") ) {
	    player2 = new Computer();
	}
	else 
	    System.out.println("Sorry, please type either Human or Computer");
	
    }

 
    public void play () {
	player1.setTurn();
	int r, c;
	while (player1.hasShips && player2.hasShips) {
	    while (player1.Turn()) {
		player1.attack(player2);
	    }
	    while (player2.Turn()) {
		player2.attack(player1);
	    }
	}
    }

    public static void main( String[] args ) {
    
	Battleships game = new Battleships();

	if( !(game.playTurn()) ) {
	    break;
	    System.out.println( "Game is over!" );
	}

    }


}
