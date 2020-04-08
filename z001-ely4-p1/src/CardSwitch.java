/**************************************************************************
 * @author Elvis Ly
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: CardSwitch.java
 *
 * Description: CardSwitch class extends the abstract class Card. This class is
 * how we will be declaring our cards (making them, CardSwitch card1 = new CardSwitch(Rank, Suit);
 * in this class we will override the abstract class method and the class itself. Will also create
 * the ranking points that are derived from the enum's that we have created from the Card class.
 * 
 ***************************************************************************/

public class CardSwitch extends Card{

	// TO DO: fill the code below and add JavaDoc
	
	/**
	 * Constructor method to create a card to switch.
	 * @param r - must pass in enum values from class card, (ACE, TWO, THREE, ... TEN, JACK, QUEEN, KING)
	 * @param s - must pass in enum values from class card, (HEARTS, CLUBS, DIAMONDS, SPADES)
	 * these @param are extended enum's in superclass "Card".
	 */
	public CardSwitch(Rank r, Suit s){
		// constructor to create card for the game Switch
		super(r,s);//calls the parent constructor. Passes in parameter's Rank r, and Suit s. 
	}
	
	/**
	 * @return returns a boolean statement (true or false). 
	 */
	@Override
	public boolean equals(Card anotherCard){
		// checks if two cards equals and returns a boolean
		if((this.rank == anotherCard.rank)  && (this.suit == anotherCard.suit)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return returns an integer which is given by switch cases, switch case will determine which number we will assign to points.
	 */
	@Override
    public int getPoints(){
	    // return points of the card.
		int points = 0;
		switch (this.rank) {
			case ACE : points = 1;
				break;
			case TWO : points = 2;
				break;
			case THREE : points = 3;
				break;
			case FOUR : points = 4;
				break;
			case FIVE : points = 5;
				break;
			case SIX : points = 6;
				break;
			case SEVEN : points = 7;
				break;
			case EIGHT : points = 8;
				break;
			case NINE : points = 9;
				break;
			case TEN : points = 10;
				break;
			case JACK : points = 10;
				break;
			case QUEEN : points = 10;
				break;
			case KING : points = 10;
				break;
		}
		return points;
    }
	
	/**
	 * @return returns a line of String that is compiled from user's rank and suit.
	 */
	@Override
	public String toString(){
		// convert card to string consisting of as "(rank,suit)"
		// see examples below for format
		String line = "("+this.rank+","+this.suit+")";
		return(line);
	}
	
	//----------------------------------------------------
	//example test code... edit this as much as you want!
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		CardSwitch card = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card2 = new CardSwitch(Card.Rank.THREE, Card.Suit.HEARTS);
		CardSwitch card3 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
		CardSwitch card4 = new CardSwitch(Card.Rank.ACE, Card.Suit.DIAMONDS);
		CardSwitch card5 = new CardSwitch(Card.Rank.THREE, Card.Suit.HEARTS);
		
		System.out.println(card5.toString());
		
		
		System.out.println(card);
		boolean whatIsit = card2.equals(card);
		boolean whatIsit1 = card.equals(card3);
		boolean whatIsit2 = card.equals(card4);
		System.out.println(whatIsit);
		System.out.println(whatIsit1);
		System.out.println(whatIsit2);
		System.out.println(card2.equals(card5));
		
		System.out.println(card5);
		
		
		if (card.getRank().equals(Card.Rank.ACE)){
			System.out.println("Yay 1");
		}
		
		if (card.toString().equals("(ACE,SPADES)")){
			System.out.println("Yay 2");
		}

		if (card.getPoints()==1){
			System.out.println("Yay 3");
		}
		//test the run time in nano seconds. 
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

}