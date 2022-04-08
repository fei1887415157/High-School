import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Button {



	private int x, y, rA = 60, rb = 50, yCount = 6, color;

	private boolean wait = false, paint = false;






	Button(int x, int y, int color) {
		this.x = x - (rA / 2);
		this.y = y - (rA / 2) - 100;
		this.color = color;
	}
// Colors: 1 = green, 2 = red, 3 = yellow, 4 = blue, 5 = orange

	void paint(Graphics graphics) {

		Graphics2D g = (Graphics2D) graphics;


		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


		if (yCount > 3) {
			rA -= 4;
			rb -= 4;
			x += 2;
			y += 2;
			yCount--;
		} else if (yCount > 0) {
			rA += 4;
			rb += 4;
			x -= 2;
			y -= 2;
			yCount--;
		}
		if (yCount == 0) {
			wait = false;
		}



		Color color;
		switch (this.color) {
			case 1: color = Color.green;
				break;
			case 2: color = Color.red;
				break;
			case 3: color = Color.yellow;
				break;
			case 4: color = Color.blue;
				break;
			case 5: color = Color.orange;
				break;

			default: color = Color.white;
		}

		g.setColor(color);
		g.fillOval(x,y,rA,rA);
		g.setColor(Color.black);
		g.fillOval(x + (rA-rb) / 2, y + (rA-rb) / 2, rb, rb);


	}




	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}






	public void keyPressed() {
		yCount = 6;
	}


	public boolean isWait() {
		return wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}









	private static ArrayList<BufferedImage> list = new ArrayList<>();

	void start() {
		for (int i = 1; i < 11; i++) {
			try {

				list.add(ImageIO.read(getClass().getResourceAsStream(
						"Note_Effect.png" + File.separator + "Explosion_" + i + ".png")));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	BufferedImage get(int i) {
		return list.get(i - 1);
	}

	public void clear() {
		list.clear();
	}

	public int size() {
		return list.size();
	}


	public void paintEffects(Graphics g, int x, int y, int i2) {
		g.drawImage(get(i2), x, y, null);
	}

	public boolean needPaintEffects() {
		return paint;
	}

	public void setPaintEffects(boolean b) {
		paint = b;
	}

}