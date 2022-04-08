import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;


class Combo {

	private int combo = 0, x, y, count = 0, shakeCount = 0, xv = x;

	private final int SIZE = 70;


	private float size = SIZE;

	private String s = "";



	private AudioInputStream audioInputStream;
	private Clip clip;





	Combo(int x, int y) {
		this.x = x / 2;
		this.y = y / 2;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(
					"ComboReset.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	void paint(Graphics g, Font font, String ss) {


		s = ss;


		Graphics2D g2 = (Graphics2D) g;



		float t = (float) (combo * 0.01 + 0.7);
		if (t >= 1)
			t = (float) 1;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, t));
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		if (shakeCount > 0) {
			g.setColor(Color.red);
			shakeCount--;
			xv -= 10;
		} else {
			g.setColor(Color.orange);
			xv = x;
		}


		if (count > 3) {
			size += 10;
			count--;
		} else if (count != 0) {
			size -= 10;
			count--;
		}



		g.setFont(font.deriveFont(size));
		g.drawString(String.valueOf(combo), xv, y);


		if (!s.equals("")) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));

			switch (s) {
				case "Miss":
					g2.setColor(Color.red);
					break;
				case "Fair":
					g2.setColor(Color.cyan);
					break;
				case "Good":
					g2.setColor(Color.green);
					break;
				case "Excellent":
					g2.setColor(new Color(255, 150, 0));
					break;
				case "Marvelous":
					g2.setColor(Color.yellow);
					break;
			}


			g2.setFont(font.deriveFont((float) (size / 1.5)));
			if (s.equals("Excellent") || s.equals("Marvelous")) {
				g2.drawString(s, x - 90, y - 70);
			} else {
				g2.drawString(s, x - 30, y - 70);
			}
		}


		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

	}


	void increase() {
		combo++;
		if (count == 0)
			count = 6;

	}

	void reset() {
		if (shakeCount == 0)
			shakeCount = 5;
		if (count == 0)
			count = 6;
		combo = 0;
		size = SIZE;

		comboReset();

	}


	private void comboReset() {


		try {
			if (clip.getFramePosition() == 0 || clip.getFramePosition() ==
					clip.getFrameLength()) {
				clip.setFramePosition(0);
				clip.start();
			}
		} catch (Exception ignored) {
		}

	}










}