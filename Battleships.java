/*===================================================
  class Battleships -- Driver file for Battleships game
  Players attack each other's ships through three world wars
  ===================================================*/

import cs1.Keyboard;

public class Battleships {

    //========== Instance Variables ==========//
    public final static int MAX_ROUNDS = 3;

    private Player player1, player2;
    private String type, nation;

    private String difficulty; //Applies only against the computer
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

	s = "Welcome to Battleships!\n";
	s+= "\nWho do you want to play with?\n";
	s+= "\t2 players\n";
	s+= "\tComputer\n";
	s+= "Choice: ";
	System.out.print(s);

	type = Keyboard.readString();

	s = "\nChoose a side, Player 1. Nation: ";
	System.out.print(s);
	nation = Keyboard.readString();
	player1 = new Human(nation);

	if( type.equals("2 Players") ) {
	    s = "\nChoose a side, Player 2. Nation: ";
	    System.out.print(s);
	    nation = Keyboard.readString();
	    player2 = new Human(nation);
	}
	else if( type.equals("Computer") ) {
	    s = "\nChoose your difficulty:\n";
	    s+= "\tEasy (Computers are blind)\n";
	    s+= "\tHard (Computers can be smart too)\n";
	    s+= "Choice: ";
	    System.out.print(s);

	    difficulty = Keyboard.readString();	

	    player2 = new Computer(difficulty);
	}

    }
 

    /*=========================================
      void newBoard() -- sets up a new board
      pre: A Human or a Computer has been initialized
      post: 5 ships are placed on each player's board
      =========================================*/
    public void newBoard() {

	player1.setBattlefield();
	player2.setBattlefield();

	System.out.println();
	System.out.println( player1.getNation() + ", place your ships!" );
	System.out.println( "\nYou have 2 boats (-X--X-), 1 submarine(-X--X--X-), 1 battleship (-X--X--X--X-), and 1 aircraft carrier (-X--X--X--X--X-)." );

	System.out.println( "\nWhere do you want to place your first boat?\n" );
	System.out.println( player1 );
	player1.placeShip( new Tile("boat 1", 2, "-X-") );

	System.out.println( "\nWhere do you want to place your second boat?\n" );
	System.out.println( player1 );
	player1.placeShip( new Tile("boat 2", 2, "-X-") );

	System.out.println( "\nWhere do you want to place your submarine?\n" );
	System.out.println( player1 );
	player1.placeShip( new Tile("submarine", 3, "-X-") );

	System.out.println( "\nWhere do you want to place your battleship?\n" );
	System.out.println( player1 );
	player1.placeShip( new Tile("battleship", 4, "-X-") );

	System.out.println( "\nWhere do you want to place your aircraft carrier?\n" );
	System.out.println( player1 );
	player1.placeShip( new Tile("aircraft carrier", 5, "-X-") );

        player1.getBattlefield().faceDown();

	if( type.equals("2 Players") ) {
	    System.out.println();
	    System.out.println( player2.getNation() + ", place your ships!" );
	    System.out.println( "\nYou have 2 boats (-X--X-), 1 submarine(-X--X--X-), 1 battleship (-X--X--X--X-), and 1 aircraft carrier (-X--X--X--X--X-)." );
	    
	    System.out.println( "\nWhere do you want to place your first boat?\n" );
	    System.out.println( player2 );
	    player2.placeShip( new Tile("boat 1", 2, "-X-") );
	    
	    System.out.println( "\nWhere do you want to place your second boat?\n" );
	    System.out.println( player2 );
	    player2.placeShip( new Tile("boat 2", 2, "-X-") );
	    
	    System.out.println( "\nWhere do you want to place your submarine?\n" );
	    System.out.println( player2 );
	    player2.placeShip( new Tile("submarine", 3, "-X-") );
	    
	    System.out.println( "\nWhere do you want to place your battleship?\n" );
	    System.out.println( player2 );
	    player2.placeShip( new Tile("battleship", 4, "-X-") );
	    
	    System.out.println( "\nWhere do you want to place your aircraft carrier?\n" );
	    System.out.println( player2 );
	    player2.placeShip( new Tile("aircraft carrier", 5, "-X-") );

	    player2.getBattlefield().faceDown();
	}
	else if( type.equals("Computer") ) {
	    player2.placeShip( new Tile("boat 1", 2, "-X-") );
	    player2.placeShip( new Tile("boat 2", 2, "-X-") );
	    player2.placeShip( new Tile("submarine", 2, "-X-") );
	    player2.placeShip( new Tile("battleship", 2, "-X-") );
	    player2.placeShip( new Tile("aircraft carrier", 2, "-X-") );
	}

    }

   
    /*==========================================
      boolean playTurn() -- simulates a round of battle
      pre: A Human or a Computer has been initialized
      post: Returns true if one player wins and 
      the other player loses (all ships have been sunk)
      ==========================================*/
    public boolean playTurn() {

	newBoard();
	
        while (player1.hasShips() && player2.hasShips()) {
	   
	    while (player1.getTurn()) {
		player1.attack(player2);		
	    }
	    while (player2.getTurn()) {
		player2.attack(player1);
	    }

	}

	if( !player1.hasShips() )
	    System.out.println( "All of " + player1.getNation() + "'s ships have sunk. The winner of this war is " + player2.getNation() + "!" );
	else if( !player2.hasShips() )
	    System.out.println( "All of " + player2.getNation() + "'s ships have sunk. The winner of this war is " + player1.getNation() + "!" );

	return true;
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

	System.out.println( "\nThe game is over!" );
  
    }

}
