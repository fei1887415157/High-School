import java.awt.*;

public interface Pile {

	Card update();

	void add(Card c);

	void paint(Graphics g);


	Rectangle getRectangle();






}
