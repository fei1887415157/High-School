package cards;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import cards.Card.Suit;
import cards.Card.Value;

public class Deck implements Pile {
	
	ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>(52);
		for(Suit s : Suit.values()) {
			for(Value v : Value.values()) {
				cards.add(new Card(s,v));
			}
		}
		shuffle();
	}
	
	private void shuffle() {
		ArrayList<Card> newList = new ArrayList<Card>(52);
		Random rand = new Random();
		while(!cards.isEmpty()) {
			newList.add(cards.remove(rand.nextInt(cards.size())));
		}
		cards = newList;
	}
	
	@Override
	public Card draw() {
		return cards.remove(0);
	}
	
	public Card[] drawThree() {
		return null;
	}

	@Override
	public void add(Card c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
