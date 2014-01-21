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

	String s;
	String type;
	String name;

	s = "Welcome to Battleships!\n";
	s+= "Do you want to play with 2 players or against the computer?";
	System.out.print(s);

	type = Keyboard.readString();

	if( type.equals( "2 players" ) ) {
	    s = "Player 1, what is your name?";
	    System.out.print(s);
	    name = Keyboard.readString();
	    player1 = new Human(name);

	    s = "Player 2, what is your name?";
	    System.out.print(s);
	    name = Keyboard.readString();
	    player2 = new Human(name);
	}
	else if( type.equals("Computer") ) {
	    s = "Player 1, what is your name?";
	    System.out.print(s);
	    name = Keyboard.readString();
	    player1 = new Human(name);
	    player2 = new Computer("Computer");
	}
	
    }

    public boolean playTurn() {



    }

    public static void main( String[] args ) {
    
	Battleships game = new Battleships();

	if( !(game.playTurn()) ) {
	    break;
	    System.out.println( "Game is over!" );
	}

    }


}