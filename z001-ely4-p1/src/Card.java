
/**************************************************************************
 * @author Yutao Zhong and Jitin Krishnan
 * CS310 Spring 2018
 * Project 1
 * George Mason University
 * 
 * File Name: Card.java
 *
 * Description: Abstract Card class from which a card class specific to
 * any game can be constructed. This file SHOULD NOT be modified.
 * 
 ***************************************************************************/

public abstract class Card {
	/**
	 * @author ElvisLy
	 * These are the ranks that a card can have (the value of the card)
	 */
	enum Rank{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	/**
	 * @author ElvisLy
	 * These are the suits that a card can have (shape that the card carries)
	 */
	enum Suit{
		HEARTS, CLUBS, DIAMONDS, SPADES;
	}
	
	protected Rank rank;// Declare instance variable of type Rank
	protected Suit suit;// Declare instance variable of type Suit
	/**
	 * Constructor
	 * @param r - pass in one of the Rank enum values (ACE, TWO, THREE, ... TEN, JACK, QUEEN, KING)
	 * @param s - pass in one of the suit enum values (HEARTS, CLUBS, DIAMONDS, SPADES)
	 */
	public Card(Rank r, Suit s){
		rank = r;
		suit = s;
	}

	public Rank getRank(){
		return rank;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	abstract boolean equals(Card c);
    
    abstract int getPoints();
		
	@Override
	public abstract String toString();

}
