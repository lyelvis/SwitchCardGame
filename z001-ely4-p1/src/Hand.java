/**************************************************************************
 * @author Elvis Ly
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Hand.java
 *
 * Description: Hand holds an array of cards that can be expanded. Implement the required methods
 * and make sure their big-O value is as required.
 * 
 ***************************************************************************/

public class Hand<T extends Card>{

	// TO DO: add your implementation and JavaDoc
	
	/**
	 * private fields.
	 */
	private T[] cards;
	private int numCards;
	
	
	
	
	/**
	 * Constructor - initialize size of cards array, and numCards. 
	 */
	@SuppressWarnings("unchecked")
	public Hand(){
		// constructor
		// initial size of cards must be no greater than 5
		numCards = 0; //initialize numCards in hand to be zero.
		cards = (T[]) new Card[5]; //cast generic T type array to Object Array size 5.
	}
	
	
	
	/**
	 * 
	 * @return a integer, the instance variable numCards.
	 */
	public int numCards(){
		// return the number of cards
		// O(1)
		return (numCards);
	}	
	
	
	
	/**
	 * 
	 * @param index, a integer that is within the range of 0 and numCards. 
	 * @return must return a generic Type (card in this case).
	 */
	public T getCard(int index){
		// return card at index 
		// throw RuntimeException for invalid index
		// O(1)
		if(index>numCards || index<0) { //if index is greater than the length of the array, or less than zero.
			throw new RuntimeException(); //throw Run Time Exception.
		}
		else {
			return(cards[index]);
		}
	}
	
	
	
	/**
	 * 
	 * @param index , integer that is within the range of the array length where we can set the card given to us.
	 * @param c - type card that is passed in. will be using this to set the card at the index that is given.
	 * @return must be void, we return nothing.
	 */
	public void setCard(int index, T c){
		// change the card at index to be c	
		// throw RuntimeException for invalid index
		// O(1)
		if(index>cards.length || index<0) { //if index is greater than the length of the array or index is less than zero
			throw new RuntimeException(); //throw RunTime Exception.
		}
		else {
			cards[index] = c; //set at array index spot to Type c (card).
		}
	}
	
	
	
	/**
	 * 
	 * @param c - a card type is passed in, and we are adding this type to the end of the list. 
	 * @return must be void, does not return anything.
	 */
	public void addCard(T c){
		// add card c at the end 
		// O(N)
		cards[numCards] = c;
		numCards++;
		if(numCards>=cards.length) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Card[2*cards.length];
			for(int i=0; i<cards.length; i++) {
				temp[i] = cards[i];
			}
			cards = temp;
		}
	}
	
	
	
	/**
	 * 
	 * @param c - c is a generic type (card in this case) that is passed in to find the index of.
	 * @return must a integer (the index in this case) of the card that is passed in. 
	 */
	public int indexOf(T c){
		 // find the index of a given card c, 
		 // returns -1 if not found	
		 // O(N) 
		int index = -1;
		for(int i = 0; i<cards.length; i++) {
			if(c == cards[i]) 
				index = i;
			}
		return index;
		}

	
		
	/**
	 *  
	 * @param must be a index number value within the range of the array cards. we will remove this index spot from the array.
	 * @return must return a generic type (CardSwitch in this case).
	 */
	public T removeCard(int index){
		// remove the card at index, 
		// throw RuntimeException for invalid index
		// O(N)
		if(index>=0 || index<numCards) {//check if index is greater than -1, or if index is in range of how many cards we have.
			T temp = cards[index];
			//loop through array, and replace values since we are removing a card from the array.
			for(int i=index; i<numCards-1; i++) {
				//shift from the index spot, replacing that spot with the value next of it. 
				cards[i] = cards[i+1];
			}
			numCards--;
			return temp;
		}
		//throw RuntimeException for invalid index.
		else {
			throw new RuntimeException();
		}
	}
	
	
	
	/**
	 * remove a card given method.
	 * @param c , value of a particular type (card type in this case) that you want to remove from array.
	 * @return must return a boolean statement (true or false).
	 */
	public boolean removeCard(T c){
		// remove card c, 
		// returns false if no such card
		// O(N)
		boolean foundcard = false;
		for(int i=0; i<numCards; i++) {
			if(cards[i] == c) 
				return true;
		}
		return foundcard;
	}
	
	
	public int arraySize() {
		return cards.length; 
	}
  
	// --------------------------------------------------------
	// example test code... edit this as much as you want!
	// you will need a working CardSwitch class to run the given code


	// Not required, update for your testing purpose
	@Override
	public String toString(){
		// return string representation of hand
		// update if you want to include information for all cards in hand
		return "Hand with "+numCards+" cards";
  	}


	public static void main(String[] args) {
	
		CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		CardSwitch card4 = new CardSwitch(Card.Rank.EIGHT, Card.Suit.DIAMONDS);
		CardSwitch card5 = new CardSwitch(Card.Rank.SEVEN, Card.Suit.HEARTS);
		CardSwitch card6 = new CardSwitch(Card.Rank.FIVE, Card.Suit.SPADES);
		//CardSwitch card7 = new CardSwitch(Card.Rank.QUEEN, Card.Suit.CLUBS);
		//CardSwitch card8 = new CardSwitch(Card.Rank.KING, Card.Suit.CLUBS);
		//CardSwitch card9 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card12 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
		CardSwitch card13 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
		CardSwitch card14 = new CardSwitch(Card.Rank.EIGHT, Card.Suit.DIAMONDS);
		CardSwitch card15 = new CardSwitch(Card.Rank.SEVEN, Card.Suit.HEARTS);
		CardSwitch card16 = new CardSwitch(Card.Rank.FIVE, Card.Suit.SPADES);
		//CardSwitch card17 = new CardSwitch(Card.Rank.QUEEN, Card.Suit.CLUBS);
		//CardSwitch card18 = new CardSwitch(Card.Rank.KING, Card.Suit.CLUBS);
		
		Hand<CardSwitch> myHand = new Hand<CardSwitch>();
		myHand.addCard(card1);
		myHand.addCard(card2);
		myHand.addCard(card3);
		myHand.addCard(card4);
		myHand.addCard(card5);
		myHand.addCard(card6);
		myHand.addCard(card12);
		myHand.addCard(card13);
		myHand.addCard(card14);
		myHand.addCard(card15);
		myHand.addCard(card16);
		
		
		System.out.println(myHand.numCards);
		System.out.println(myHand.arraySize());
		
		if ((myHand.numCards() == 6) && (myHand.getCard(0).equals(card1))){
			System.out.println("Yay 1");
		}
		
		myHand.addCard(card3);
		
		if ( card2.equals(myHand.removeCard(1)) && myHand.getCard(1).equals(card3)){
			System.out.println("Yay 2");
		}
		

		if ((myHand.indexOf(card1)==0) && (myHand.indexOf(card2) == -1 )){
			System.out.println("Yay 3");
		}

	}


}