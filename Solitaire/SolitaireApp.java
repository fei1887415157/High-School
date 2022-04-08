package cards;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SolitaireApp extends JPanel {
	
	Deck deck = new Deck();
	FinishPile[] finishPiles = new FinishPile[4];
	BottomPile[] bottomPiles = new BottomPile[7];

	public static void main(String[] args) {
		new SolitaireApp().start();
	}

	private void start() {
		Deck test = new Deck();
		
		for(int i = 0; i < bottomPiles.length; i++) {
			for(int j = 0; j <= i; j++) {
				bottomPiles[i].add(deck.draw());
			}
			bottomPiles[i].revealTop();
		}
	}
	
	
	
}
