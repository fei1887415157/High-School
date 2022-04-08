import java.awt.*;
import java.awt.image.BufferedImage;


public class Target {



	static BufferedImage[] explosionFrames = new BufferedImage[10];
	static {
		for (int i = 1; i <= 10; i++) {
			explosionFrames[i-1] = ImageHandler.getImage("Explosion/Explosion_"+i+".png");
		}
	}



	private int x, y;
	private boolean exploding;
	private long timeStart;

	public Target(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int frame = (int) (System.currentTimeMillis() - timeStart) / 100;

	public void paint(Graphics g) {
		if (exploding) {
			if (frame < 10) {
				System.out.println(frame);
				BufferedImage image = explosionFrames[frame];
				g.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2,
						null);
				frame++;
			}
		}
	}

	public void explode() {
		timeStart = System.currentTimeMillis();
		exploding = true;
	}

}
