import java.awt.*;
import java.util.ArrayList;

public class DeckPile implements Pile {

	private ArrayList<Card> cards = new ArrayList<>();


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
