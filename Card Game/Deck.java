import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Deck implements Pile {


	private int x, y;

	private Rectangle rectangle;


	private ArrayList<Card> deck = new ArrayList<>();

	Image img;

	{
		try {
			img = ImageIO.read(new File(("res/cards_png/DeckBackSide.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





	public Deck(int x, int y) {

		this.x = x;
		this.y = y;

		rectangle = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));


		for (int i = 0; i < 4; i++) {
			String suit;
			switch (i) {
				case 0:
					suit = "h";
					break;
				case 1:
					suit = "s";
					break;
				case 2:
					suit = "c";
					break;
				case 3:
					suit = "d";
					break;
				default:
					suit = "ERROR";
					System.out.println("ERROR");
					break;
			}
			for (int j = 1; j < 14; j++) {
				Card c = new Card(j, suit);
				deck.add(c);
			}

		}

	}












	public void shuffle() {
		ArrayList<Card> newCards = new ArrayList<>();
		while (deck.size() > 0) {
			int random = (int)(Math.random() * deck.size() / 4);
			newCards.add(deck.get(random));
			deck.remove(random);
		}


		secondShuffle();

		deck = newCards;
	}


	//make the deck "red, black..."
	private void secondShuffle() {
		ArrayList<Card> newCards = new ArrayList<>();
		int index = 0;
		for(int i = 0; i < deck.size(); i++) {
			index = i;
			if (! (deck.get(i).isRed() && ! deck.get(i + 1).isRed())) {


			}
		}
		deck = newCards;
	}





	@Override
	public Card update() {
		return null;
	}

	@Override
	public void add(Card c) {

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, x, y, null);
	}



	public Rectangle getRectangle() {
		return rectangle;
	}



	public Card getACard(int i) {
		return deck.get(i);
	}

	public void removeACard(int i) {
		deck.remove(i);
	}



	public int getSize() {
		return deck.size();
	}
}
