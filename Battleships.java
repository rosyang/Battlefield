/*===================================================
  class Battleships -- Driver file for Battleships game
  Players attack each other's ships through three world wars
  ===================================================*/

import cs1.Keyboard;

public class Battleships {

    //========== Instance Variables ==========//
    public final static int MAX_ROUNDS = 3;

    private Player player1, player2;
    private String type;
    private String winner;

    private int difficulty; //Applies only against the computer
    private boolean gameOver;


    //========== Default Constructor ==========//
    public Battleships() {
	gameOver = false;
	newGame();
    }


    //========== METHODS ==========//

    /*================================================
      void newGame() -- gathers information to begin a new game
      pre:
      post: instantiates a Human or a Computer, sets a difficulty
      ================================================*/
    public void newGame() {

	String s;
	String nation;

	s = "Welcome to Battleships!\n";
	s+= "\nWho do you want to play with?\n";
	s+= "\t1: 2 players\n";
	s+= "\t2: Computer\n";
	s+= "Number of Choice: ";
	System.out.print(s);

	type = Keyboard.readInt();

	s = "\nChoose a side, Player 1. Nation: ";
	System.out.print(s);
	nation = Keyboard.readString();
	player1 = new Human(nation);

	if( type == 1 ) {
	    s = "\nChoose a side, Player 2. Nation: ";
	    System.out.print(s);
	    nation = Keyboard.readString();
	    player2 = new Human(nation);
	}
	else if( type == 2 ) {
	    player2 = new Computer("Computerland");

	    s = "\nChoose your difficulty:\n";
	    s+= "\t1: Easy (Computers are blind)\n";
	    s+= "\t2: Hard (Computers can be smart too)\n";
	    s+= "Number of Choice: ";
	    System.out.print(s);

	    difficulty = Keyboard.readInt();
	}
	
    }

    /*=========================================
      void newBoard() -- sets up a new board
      pre: A Human or a Computer has been initialized
      post: 6 ships are placed on each player's board
      =========================================*/
    public void newBoard() {

	int row;
	int column;
	String direction;

	player1.setBattlefield();
	player2.setBattlefield();

	System.out.println( player1.getNation() + ", place your ships!" );
	System.out.println( "You have 2 boats (-X--X-), 1 submarine(-X--X--X-), 1 destroyer (-X--X--X-), 1 battleship (-X--X--X--X-), and 1 aircraft carrier (-X--X--X--X--X-)." );

	System.out.println( "Where do you want to place your two boats?" );
	System.out.println( player1.getBattlefield() );
	System.out.println( "Row: " );
	row = Keyboard.readInt();
	System.out.println( "Column: " );
	column = Keyboard.readInt();
	System.out.println( "Direction (NESW): " );
	direction = Keyboard.readString();

	if( type == 1 ) {	    
	}
	else if( type == 2 ) {

	    

	}

    }


    /*==========================================
      boolean playTurn() -- simulates a round of battle
      pre: A Human or a Computer has been initialized
      post: Returns true if one player wins and 
      the other player loses (all ships have been sunk)
      ==========================================*/
    public boolean playTurn() {

	int wins = 0;

	newBoard();
	player1.setTurn();
	
        while (player1.hasShips() && player2.hasShips()) {
	   
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
	
	int rounds = 0;

	while( rounds < MAX_ROUNDS ) {
	    rounds++;
	    System.out.println( "~~~~~~~ WORLD WAR " + rounds + " ~~~~~~~" );

	    if( !(game.playTurn()) )
		break;
	}

	System.out.println( "The game is over!\nThe winner is " + winner + "!" );

    }

}
