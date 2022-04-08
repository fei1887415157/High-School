import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;



class Menu {


	private int frameX, frameY, x, y, count = 0;



	private boolean play = false;




	private AudioInputStream audioInputStream;
	private Clip clip;






	void start(int x, int y) {



		this.frameX = x;
		this.frameY = y;



		this.x = (int) (frameX / 3.3);
		this.y = frameY / 3;


	}


	void paint(Graphics g, Font font) {



		if (!play) {
			g.setColor(Color.orange);
			g.setFont(font.deriveFont((float) 20));
			g.drawString("Key: q w e o p", frameX - 200, 50);

			if (count >= 0 && count < 30) {
			} else if (count >= 30 && count < 60) {
				g.setColor(Color.white);
				g.setFont(font.deriveFont((float) 50));
				g.drawString("PRESS G TO START", x, y);
			} else {
				count = 0;
			}
			count++;
		}



	}







	void pressed() {

		play = true;

		try {
			audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(
					"HandClap.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.setFramePosition(0);
			clip.start();
		} catch(Exception ignored) {
		}

	}




}

