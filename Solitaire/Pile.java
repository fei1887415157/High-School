package cards;
import java.awt.Graphics;

public interface Pile {

	public Card draw();
	
	public void add(Card c);
	
	public void paint(Graphics g);
	
}
