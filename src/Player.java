
public class Player{

	private PlayingPile pile1, pile2, pile3, pile4, pile5, pile6, pile7;

	private FinishedPile pile8, pile9, pile10, pile11;

	private Deck deck;

	private DeckPile deckPile;

	public Player() {
		givePiles();
	}

	private void givePiles() {
		pile1 = new PlayingPile();
		pile2 = new PlayingPile();
		pile3 = new PlayingPile();
		pile4 = new PlayingPile();
		pile5 = new PlayingPile();
		pile6 = new PlayingPile();
		pile7 = new PlayingPile();

		pile8 = new FinishedPile();
		pile9 = new FinishedPile();
		pile10 = new FinishedPile();
		pile11 = new FinishedPile();

		deck = new Deck(100, 100);

		deckPile = new DeckPile();

		deck.shuffle();
	}




	public Deck getDeck() {
		return deck;
	}

	public DeckPile getDeckPile() {
		return deckPile;
	}

	public Card getCardInFinishedPile(FinishedPile pile, int i) {
		return pile.getCard(i);
	}

	public Card getCardInPlayingPile(PlayingPile pile, int i) {
		return pile.getCard(i);
	}

	public Card getACardInDeck(int i) {
		return deck.getACard(i);
	}
}
