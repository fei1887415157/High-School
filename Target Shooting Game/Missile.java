import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;









class Missile {



	private boolean gotHit = false;

	private Image target;

	private int strength, missileSize = 25;

	private double x = 225, y = 500, time;

	private Rectangle targetRec, missileRec;


	private javax.swing.Timer timer = new javax.swing.Timer(20, event -> {
		time += 0.02;
	});

	void start() {
		try {
			target = ImageIO.read(new File("res/Target.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}


		targetRec = new Rectangle(1000, 500, target.getWidth(null),
				target.getHeight(null));

		missileRec = new Rectangle((int) x, (int) y, missileSize, missileSize);


	}



	Missile(int strength) {
		this.strength = strength;
	}


	void setStrength(int strength) {
		this.strength = strength;
	}



	void setMissileSize(int size) {
		this.missileSize = size;
	}



	void paint(Graphics g, boolean flying) {
		g.drawImage(target, 1000, targetRec.y, null);
		if (flying)
			g.fillOval((int) x, (int) y, missileSize, missileSize);

	}




	void fire(double angle) {
		timer.start();
		x = 150 + strength * Math.cos(angle) * time;
		y = 464 + strength * Math.sin(angle) * time + (500 * time * time);











		missileRec.setLocation((int) x - missileRec.width/2, (int) y - missileRec.height/2);

		if (targetRec.intersects(missileRec)) {
			gotHit();
		}


		if (missileRec.getX() > new Game().getFrame().width)
			reset();

	}


	private void reset() {
		//???
	}



	private void gotHit() {
		gotHit = true;
	}

	boolean isHit() {
		return gotHit;
	}


	void targetHit() {
		targetRec.translate(0, 1);
	}
}
