/**************************************************************************
 * @author Elvis Ly
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Player.java
 *
 * Description: <INSERT DESCRIPTION>
 * 
 ***************************************************************************/
class Player <T extends Card> {
	
	// required fields
	private String name;
	private int points;
	private Hand<T> hand;	
	private Player<T> next;
	
	// TO DO: add your implementation and JavaDoc
	
	/**
	 * Constructor
	 * @param name is a String, will be used to assign to Player's name.
	 */
	public Player(String name){
		this.name = name;
		this.points = 0;
		this.hand = new Hand<T>();
		this.next = null;
	}
		
	/**
	 * setter.
	 * @param p must be a Player node with the same generic as this node.
	 */
	public void setNext(Player<T> p){
		//set next player. i.e., connect the linked list node to its next
		this.next = p;
	}
	
	/**
	 * getter.
	 * @return returns a Player node.
	 */
	public Player<T> getNext(){
		//return next player
		Player<T> current =  this.next;
		return current;
	}
	
	/**
	 * check to see if there is a next value.
	 * @return
	 */
	public boolean hasNext() {
		// whether there is a player after me
		boolean isThereNext = true;
		if(this.next == null) {
			isThereNext = false;
		}
		return isThereNext;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPoints(){
		// return points of this player
		// determined by cards in hand
		int playerpoints=0;
		T temp;
		for(int i=0; i<hand.numCards(); i++) {
			temp = hand.getCard(i);
			playerpoints += temp.getPoints();
		}
		return playerpoints;
	}
		
	/**
	 * 
	 * @return
	 */
	public String getName(){
		// return name of the player
		return this.name;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean receiveCard(T c){
		// receive a card and add it to hand
		// return?
		boolean haveCard = true;
		for(int i=0; i<hand.numCards(); i++) {
			if(this.hand.getCard(i) == c) {
				haveCard = false;
				return haveCard;
			}
		}
		this.hand.addCard(c);
		this.points += c.getPoints();
		
		return haveCard;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean hasCard(T c){
		// return checking: whether we have the card in hand
		boolean alreadyHave = false;
		for(int i=0; i<hand.numCards(); i++) {
			if(this.hand.getCard(i) == c) {
				alreadyHave = true;
				return alreadyHave;
			}
		}
		return alreadyHave;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean playCard(T c){
		// give away one card from hand
		// return false if card not present
		boolean cardRemoved = false;
		for(int i=0; i<hand.numCards(); i++) {
			if(hand.getCard(i) == c) {
				T temp = hand.getCard(i);
				points -= temp.getPoints();
				hand.removeCard(i);
				cardRemoved = true;
				return cardRemoved;
			}		
		}
		return cardRemoved;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public T playCard(int index){
		// give away the card at index
		// throw RuntimeException for invalid index
		if(index>hand.numCards() || index<0) {
			throw new RuntimeException();
		}
		T temp = this.hand.getCard(index);
		this.hand.removeCard(index);
		return temp;
	}
	
	

	//---------------------------------------------------
	//example test code... edit this as much as you want!
	// you will need working CardSwitch and Hand classes to run the given code
	
	
	public String toString(){
		// Not required; edit for your own testing 
		return "Player "+ name;
	}


	public static void main(String[] args) {
		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
		Player<CardSwitch> player2 = new Player<CardSwitch>("Jerry");

		player1.receiveCard(card2);
		player1.receiveCard(card3);
		player2.receiveCard(card1);
		player1.setNext(player2);
		
		System.out.println(player2.getNext());

		if (player1.getName().equals("Tom") && player1.getNext() == player2){
			System.out.println("Yay 1");
		}
		
		if (player1.hasCard(card2) == true && player1.getPoints() == 19){
			System.out.println("Yay 2");
		}
		
		System.out.println(player1.getPoints());
		
		if (player1.hasCard(card2) == true){
			System.out.println("Yay 2");
		}
		
		if ((player2.hasNext()==false) && player1.playCard(0) == card2){
			System.out.println("Yay 3");
		}
	
	}


}