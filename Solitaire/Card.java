package cards;

public class Card {
	
	public enum Suit {
		Hearts(true), Spades(false), Diamonds(true), Clubs(false);
		
		boolean red;
		private Suit(boolean red) {
			this.red = red;
		}
	}
		
	public enum Value {
		Ace(1),
		Two(2),
		Three(3),
		Four(4),
		Five(5),
		Six(6),
		Seven(7),
		Eight(8),
		Nine(9),
		Ten(10),
		Jack(11),
		Queen(12),
		King(13);
		
		int number;
		private Value(int number) {
			this.number = number;
		}
	}
	
	public final Suit suit;
	public final Value value;
	
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public String toString() {
		return value + " of " + suit;
	}
	
}
