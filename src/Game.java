import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//Klondike card game


public class Game extends JPanel {

	public static void main(String[] args) {
		new Game().start();
	}

	Player player1 = new Player();

	Card card;

	private int numOfClicks;


	private boolean repaint = false;

	private void start() {

		makeFrame();




		update();





	}



	public void update() {


		if (repaint)
			repaint();



		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//update();

	}





	@Override
	public void paintComponent(Graphics g) {


		super.paintComponent(g);


		int index = 0;
		for (int i = 0; i < 8; i++) {
			for (int k = i; k > 0; k--) {
				boolean isFaceUp = true;
				if (k != 1) {
					isFaceUp = false;
				}
				//player1.getACardInDeck(index).translate(50 + i * 100, 300 - k * 19);
				//player1.getACardInDeck(index).draw(g, isFaceUp);

				index++;
			}

		}


		player1.getDeck().paint(g);

		if (repaint) {
			card.dealADeck();
			card.draw(g,true);
		}


	}


	private void makeFrame() {

		JFrame frame = new JFrame("Card Game");



		frame.setPreferredSize(new Dimension(1000, 700));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);



		this.setBackground(new Color(100, 200, 100));
		this.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent e) {
				Point click = new Point(e.getX(), e.getY());

				if (player1.getDeck().getRectangle().contains(click)) {
					card = player1.getDeck().getACard(numOfClicks);
					player1.getDeckPile().add(card);
					numOfClicks++;
					repaint = true;
				}

			}


			@Override
			public void mousePressed(MouseEvent e) {
				Point press = new Point(e.getX() / 60, e.getY() / 60);

				for (int i = 0; i < player1.getDeck().getSize(); i++) {
					if (player1.getDeck().getACard(i).getRectangle().contains(press)) {
						//player1.getDeck().getCard(i).move();
						break;
					}
				}


				//repaint = true;


			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Point release = new Point(e.getX() / 60, e.getY() / 60);


				if (player1.getDeck().getACard(0).getRectangle().contains(release)) {

				}


				//repaint = false;
			}
		});

	}
















}
