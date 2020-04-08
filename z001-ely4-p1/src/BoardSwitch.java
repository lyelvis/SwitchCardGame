/**************************************************************************
 * @author Elvis Ly
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: BoardSwitch.java
 *
 * Description: This class will have a generic type that extends the abstract class Card.
 * which extends the Board class with a generic type as well. both will be type
 * <CardSwitch>. The BoardSwitch will allow us to generate the Board game for which
 * we will get all the players set up with their cards in hand.
 * 
 ***************************************************************************/
public class BoardSwitch<T extends Card> extends Board<T>{
	
	// TO DO: add your implementation and JavaDoc
	
	/**
	 * Constructor 
	 * @param deck must pass in a Deck<T> type. 
	 * a Deck<T> will have set of cards in Hand<T>.
	 */
	public BoardSwitch(Deck<T> deck){
		//constructor
		//start with zero players
		super(deck); //call parent constructor from Board class.
	}

	
	/**
	 * @return returns the current player.
	 */
	@Override
	public Player<T> getCurrentPlayer() {
		// return the current player
		// O(1)
		return currentPlayer;
	}

	
	/**
	 * @return returns the number of players on the board.
	 */
	@Override
	public int getNumPlayers() {
		// return how many players 
		// O(1)
		return this.numPlayer;
	}
	
	
	/**
	 * @return returns a Deck<T> with generic parameter in this case will be a <cardSwitch> which is a card.
	 */
	@Override
	public Deck<T> getDeck(){
		//return the current deck
		// O(1)
		return this.deck;
	}

	
	/**
	 * @return must be a boolean statement (true or false).
	 */
	@Override
	public boolean changeTurn() {
		// Change current player to the next player in the circular linked list. Return true if successful
		// move the current player to the next one in the linked list
		// return false if cannot change
		// O(1)
		boolean nextPlayer = true;

		if(currentPlayer == null) {
			nextPlayer = false;
			return nextPlayer;
		}
		currentPlayer = currentPlayer.getNext(); 
		return nextPlayer;
	}
	
	
	/**
	 * @param x must be a Player class with CardSwitch type.
	 */
	@Override
	public void addPlayer(Player<T> x) {
		// add another player in the linked list
		// should add to the left of currentPlayer
		// O(N)
		Player<T> temp = currentPlayer;
		numPlayer+=1;
		if(currentPlayer == null) {
			currentPlayer = x; 
			this.currentPlayer.setNext(x);
		}
		else {
			if(currentPlayer.getNext() != temp) {
				//System.out.println("testing1");
			
				while(currentPlayer.getNext()!=temp) {
					//System.out.println("testing2");
					currentPlayer = currentPlayer.getNext();
				}
				currentPlayer.setNext(x);
				x.setNext(temp);
				
				currentPlayer = temp;
			}
			else {
				//System.out.println("testing3");
				currentPlayer.setNext(x);
				x.setNext(temp);	
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Player<T> findWinner(){
		// return the player with the highest point
		// O(N)
		//System.out.println("current player is "+currentPlayer.getName() + " their points are "+currentPlayer.getPoints());
		int temp = currentPlayer.getPoints(); //on current player, get their points. 
		Player<T> firstPlayer = currentPlayer;  
		Player<T> winner = currentPlayer;  //return this player with highest points. 
		currentPlayer = currentPlayer.getNext(); //changes to player2.
		
		while(currentPlayer != firstPlayer) {
			if(currentPlayer.getPoints()>temp) { //getting player 2's points, comparing it to first player's point stored in temp
				temp = currentPlayer.getPoints();
				winner = currentPlayer;
			}
			else if(currentPlayer.getPoints()==temp && (currentPlayer.getName().charAt(0) < winner.getName().charAt(0)) ) {
				winner = currentPlayer;
			}
			currentPlayer = currentPlayer.getNext();
		}
		return winner;
	}
	
	
	public String toString() {
		String returnThis = "";
		for(int i=0; i<numPlayer; i++) {
			currentPlayer = currentPlayer.getNext();
			returnThis += (currentPlayer.getName() + " ");
		}
		
		return returnThis;
	}

	//-----------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need working CardSwitch, Hand, Player, Deck and PlaySwitch classes to run the given code
	
	public static void main(String[] args) {
		Deck<CardSwitch> deck = new Deck<CardSwitch>();
		PlaySwitch.init_deck(deck);
			
		BoardSwitch<CardSwitch> myBoard = new BoardSwitch<CardSwitch>(deck);
		Player<CardSwitch> player1 = new Player<CardSwitch>("Rachel");
		Player<CardSwitch> player2 = new Player<CardSwitch>("Chandler");
		Player<CardSwitch> player3 = new Player<CardSwitch>("Ross");
		Player<CardSwitch> player4 = new Player<CardSwitch>("Pheobe");
		Player<CardSwitch> player5 = new Player<CardSwitch>("Joey");
		Player<CardSwitch> player6 = new Player<CardSwitch>("Monica");

		
		myBoard.addPlayer(player1);
		myBoard.addPlayer(player2);
		myBoard.addPlayer(player3);
		//System.out.println(myBoard.getCurrentPlayer());
		//myBoard.addPlayer(player4);
		//myBoard.addPlayer(player5);
		//myBoard.addPlayer(player6);
		
		//System.out.println(myBoard.getNumPlayers());
		/*if (myBoard.getNumPlayers() ==1  && myBoard.getCurrentPlayer() == player1
			&& player1.getNext() == player1){
			System.out.println("Yay 1");
		}*/
		

		//myBoard.addPlayer(player2);
		System.out.println(myBoard);
		//System.out.println(myBoard.getNumPlayers());
		
		/*if (myBoard.getNumPlayers() ==2  && myBoard.getCurrentPlayer() == player1
			&& (myBoard.changeTurn()==true) && myBoard.getCurrentPlayer() == player2){
			System.out.println("Yay 2");
		}*/
		
	
		
		player1.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES));
		player1.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.CLUBS));
		player2.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.HEARTS));
		player2.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES));
		player3.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.CLUBS));
		player3.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.HEARTS));
		/*player4.receiveCard(new CardSwitch(Card.Rank.NINE, Card.Suit.DIAMONDS));
		player4.receiveCard(new CardSwitch(Card.Rank.EIGHT, Card.Suit.SPADES));
		player5.receiveCard(new CardSwitch(Card.Rank.KING, Card.Suit.HEARTS));
		player5.receiveCard(new CardSwitch(Card.Rank.QUEEN, Card.Suit.CLUBS));
		player6.receiveCard(new CardSwitch(Card.Rank.FOUR, Card.Suit.DIAMONDS));
		player6.receiveCard(new CardSwitch(Card.Rank.EIGHT, Card.Suit.SPADES));*/

		
		/*System.out.println("current "+player1);
		myBoard.changeTurn();
		myBoard.changeTurn();
		myBoard.changeTurn();
		if(myBoard.getCurrentPlayer() == player3) {
			System.out.println("current "+player3);
		}*/
		
		/*if (player1.getNext() == player2 && player2.getNext() == player1
			&& myBoard.findWinner() == player2){
			System.out.println("Yay 3");
		}*/
		
		//System.out.println(myBoard.findWinner());
		System.out.println("these are "+player1.getName()+"'s points "+player1.getPoints()); //1+10
		System.out.println("these are "+player2.getName()+"'s points "+player2.getPoints()); //9+3
		System.out.println("these are "+player3.getName()+"'s points "+player3.getPoints()); //5+6
		/*System.out.println("these are "+player4.getName()+"'s points "+player4.getPoints()); //9+8
		System.out.println("these are "+player5.getName()+"'s points "+player5.getPoints()); //10+10
		System.out.println("these are "+player6.getName()+"'s points "+player6.getPoints()); //4+8*/
		
		System.out.println("The Winner is!! " +myBoard.findWinner());
		
		
		
	
	}
	

}
