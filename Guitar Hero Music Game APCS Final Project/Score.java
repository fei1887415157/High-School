import java.awt.*;

public class Score {


	private int score = 0, x;

	private final int SIZE = 20;


	Score(int x) {
		this.x = x;
	}

	void paint(Graphics g1, Font font) {

		Graphics2D g = (Graphics2D) g1;

		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g.setFont(font.deriveFont((float)SIZE));
		g.setColor(Color.white);
		if (score < 0)
			score = 0;
		g.drawString(String.valueOf(score), x, 50);
	}



	void increase(int i) {

		if (i > 150)
			return;
		else if (i > 100)
			score += 1;
		else if (i > 50)
			score += 2;
		else
			score += 3;
	}


}
