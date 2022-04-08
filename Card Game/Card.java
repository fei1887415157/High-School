import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;




//how to read image with this.class.getResource
//current way will not work in exe jar







public class Card implements Comparable<Card>{



	private Rectangle rectangle;


	private int x, y, width, height;

	private int num;
	private String suit;
	private boolean isRed, isFaceUp = true;
	private Image img;
	private static Image backsideImageBlack;
	private static Image backsideImageRed;
	private static Image backsideImage;

	static {
		try {
			backsideImageBlack = ImageIO.read(new File("res/cards_png/b1fv.png"));
			backsideImageRed = ImageIO.read(new File("res/cards_png/b2fv.png"));
			backsideImage = ImageIO.read(new File("res/cards_png/DeckBackSide.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public Card(int num, String suit) {
		new Card(num, suit, 999, 999);
	}



	public Card(int num, String suit, int x, int y) {
		try {


			rectangle = new Rectangle(x, y, width, height);

			if (! suit.equals("j")) {
				img = ImageIO.read(new File("res/cards_png/" + suit + num + ".png"));
			} else {
				//joker
				int random = (int) (Math.random() * 2 + 1);
				img = ImageIO.read(new File("res/cards_png/" + suit + random + ".png"));
				if (random == 2) {
					this.isRed = true;
				}
			}

			this.num = num;
			this.suit = suit;




			if (this.suit.equals("h") || this.suit.equals("d")) {
				isRed = true;
			}


			width = img.getWidth(null);
			height = img.getHeight(null);






		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public boolean isFaceUp() {
		return isFaceUp;
	}


	public void flip() {
		isFaceUp = !isFaceUp;
	}


	public void draw(Graphics g, boolean isFaceUp) {
		if (isFaceUp)
			g.drawImage(img, x, y, null);
		else

			g.drawImage(backsideImage, x, y, null);


	}



	public void draw(Graphics g, int deckBackSide) {
		try {
			Image img = ImageIO.read(new File("res/cards_png/DeckBackSide.jpg"));

			//img = img.getScaledInstance(50, 50, null);

			g.drawImage(img, 50, 50, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toString(){
		return num + " of " + suit;
	}


	@Override
	public int compareTo(Card other) {
		return this.num - other.num;
	}


	public boolean isRed() {
		return isRed;
	}



	public Rectangle getRectangle() {
		return rectangle;
	}

	public void dealADeck() {
		x += 50;
	}



	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
		rectangle.translate(dx, dy);
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		rectangle.setLocation(x, y);
	}
}
