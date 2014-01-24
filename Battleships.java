/*===================================================
  class Battleships -- Driver file for Battleships game
  Players attack each other's ships through three world wars
  ===================================================*/

import cs1.Keyboard;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Battleships extends JFrame {

    //========== Instance Variables ==========//
    public final static int MAX_ROUNDS = 3;

    private Player player1, player2;
    private String type, nation;
    private String winner;

    private String difficulty; //Applies only against the computer
    private boolean gameOver;

    private JLabel s, s2;
    private JButton b1, b2, b3, b4;
    private JTextField t1;


    //========== Default Constructor ==========//
    public Battleships() {
	setTitle( "Battleships Game" );
	setSize( 800, 500 );
	setLocation( 100, 100 );
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setLayout( new FlowLayout() );

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

	eventHandler event = new eventHandler();

	s = new JLabel("Welcome to Battleships!");
	add(s);
	s2 = new JLabel("Who do you want to play with?");
	add(s2);
	b1 = new JButton("2 players");
	add(b1);
	b2 = new JButton("Computer");
	add(b2);
	b1.addActionListener(event);
	b2.addActionListener(event);

	s2 = new JLabel("Choose a side, Player 1.");
	add(s2);
	t1 = new JTextField("Nation");
	add(t1);
	t1.addActionListener(event);

	player1 = new Human(nation);

	if( type.equals("2 players") ) {
	    s2 = new JLabel("Choose a side, Player 2.");
	    add(s2);
	    t1 = new JTextField("Nation");
	    add(t1);
	    t1.addActionListener(event);

	    player2 = new Human(nation);
	}
	else if( type.equals("Computer") ) {
	    s2 = new JLabel("Choose your difficulty.");
	    add(s2);
	    b3 = new JButton("Easy");
	    b3.setToolTipText("Computers are blind");
	    add(b3);
	    b4 = new JButton("Hard");
	    b4.setToolTipText("Computers can be smart too");
	    add(b4);
	    b1.addActionListener(event);
	    b2.addActionListener(event);

	    player2 = new Computer(difficulty);
	}
	
    }


    /*==========================================
      boolean playTurn() -- simulates a round of battle
      pre: A Human or a Computer has been initialized
      post: Returns true if one player wins and 
      the other player loses (all ships have been sunk)
      ==========================================*/
    public void play() {

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


    private class eventHandler implements ActionListener {

	public void actionPerformed( ActionEvent event ) {

	    if( event.getSource() == b1 )
		type = String.format("%s", event.getActionCommand() );
	    else if( event.getSource() == b2 )
		type = String.format("%s", event.getActionCommand() );

	    if( event.getSource() == t1 )
		nation = String.format("%s", event.getActionCommand() );

	    if( event.getSource() == b3 )
		difficulty = String.format("%s", event.getActionCommand() );
	    else if( event.getSource() == b4 )
		difficulty = String.format("%s", event.getActionCommand() );

	}

    }


    public static void main( String[] args ) {
    
	Battleships game = new Battleships();

	game.setVisible( true );
    	
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
