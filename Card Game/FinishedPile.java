import java.awt.*;
import java.util.ArrayList;

public class FinishedPile implements Pile {
	private ArrayList<Card> cards = new ArrayList<>();






	public ArrayList<Card> getList() {
		return cards;
	}




	public Card getCard(int i) {
		return cards.get(i);
	}









	public Card deal() {
		return cards.remove(cards.size() - 1);
	}


	public int cardsLeft() {
		return cards.size();
	}










	@Override
	public Card update() {
		return null;
	}

	@Override
	public void add(Card c) {
		cards.add(c);
	}

	@Override
	public void paint(Graphics g) {

	}

	@Override
	public Rectangle getRectangle() {
		return null;
	}
}
