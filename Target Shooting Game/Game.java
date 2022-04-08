import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;







public class Game {




	private Image grassImage;
	private BufferedImage cannonImage;

	private boolean flying = false;

	private double rotation;



	private Missile missile = new Missile(0);
	private Cannon cannon = new Cannon();
	private Target target;




	private JSlider strengthS, angleS, sizeS;






	public static void main(String[] args) {
		new Game().start();
	}

	private void start() {

		cannon.start();

		try {
			grassImage = ImageIO.read(new File("res/Grass.jpg"));
			cannonImage = cannon.getCannonImage();
		} catch (IOException e) {
			e.printStackTrace();
		}





		missile.start();
		makeFrame();


		update();



	}


	private JFrame frame = new JFrame("Game");
	private JPanel panel = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(grassImage, 0, 0, null);


			missile.paint(g, flying);
			if(target != null){
				target.paint(g);
			}

			rotation = Math.toRadians(angleS.getValue());
			AffineTransform tx = AffineTransform.getRotateInstance(rotation,
					100+cannonImage.getWidth()/2, 500+cannonImage.getHeight()/2);
//			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			Graphics2D g2 = (Graphics2D)g.create();
			g2.transform(tx);
			g2.drawImage(cannonImage, 100, 500, null);
//			g.drawImage(op.filter(cannonImage, null), 100, 500, null);

		}
	};



	private void makeFrame() {


//		strengthS.setPreferredSize(new Dimension(50, 10));
//		angleS.setPreferredSize(new Dimension(50, 10));
//		sizeS.setPreferredSize(new Dimension(50, 10));



		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);






		JLabel strengthL = new JLabel("strength");
		strengthL.setFont(new Font("Courier", Font.BOLD, 30));
		strengthL.setForeground(Color.white);


		JLabel angleL = new JLabel("angle");
		angleL.setFont(new Font("Courier", Font.BOLD, 30));
		angleL.setForeground(Color.white);

		JLabel sizeL = new JLabel("size");
		sizeL.setFont(new Font("Courier", Font.BOLD, 30));
		sizeL.setForeground(Color.white);


		JButton fire = new JButton("fire");
		fire.setFont(new Font("Courier", Font.BOLD, 30));
		fire.addActionListener(e -> {
			//disable button when not ready
			missile.setStrength(strengthS.getValue());
			missile.setMissileSize(sizeS.getValue());
			playSound();
			timer.start();
		});




		strengthS = new JSlider(500, 2000, 1250) {
			@Override
			public void paintComponent(Graphics g) {
				Game.this.update();
				g.setColor(Color.gray);
				g.fillRoundRect(0, 0, getWidth(), getHeight(),
						getHeight() / 2, getHeight() / 2);
				super.paintComponent(g);
			}
		};
		strengthS.setPreferredSize(new Dimension(100,
				(int) strengthS.getPreferredSize().getHeight()));

		angleS = new JSlider(-90, 0, -45) {
			@Override
			public void paintComponent(Graphics g) {
				Game.this.update();
				g.setColor(Color.gray);
				g.fillRoundRect(0, 0, getWidth(), getHeight(),
						getHeight() / 2, getHeight() / 2);
				super.paintComponent(g);
			}
		};
		angleS.setPreferredSize(new Dimension(100, (int) angleS.getPreferredSize().getHeight()));

		sizeS = new JSlider(10, 50, 25) {
			@Override
			public void paintComponent(Graphics g) {
				Game.this.update();
				g.setColor(Color.gray);
				g.fillRoundRect(0, 0, getWidth(), getHeight(),
						getHeight() / 2, getHeight() / 2);
				super.paintComponent(g);
			}
		};
		sizeS.setPreferredSize(new Dimension(100, (int) sizeS.getPreferredSize().getHeight()));




		panel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));





		panel.add(strengthL);
		panel.add(strengthS);
		panel.add(angleL);
		panel.add(angleS);
		panel.add(sizeL);
		panel.add(sizeS);
		panel.add(fire);



		frame.add(panel);
		frame.setVisible(true);
		frame.pack();






	}








	private void update() {
		panel.repaint();
		if (missile.isHit()) {
			missile.targetHit();
			target = new Target(1000, 500);
			target.explode();
		}

	}


	private javax.swing.Timer timer = new javax.swing.Timer(20, event -> {
		flying = true;
		missile.fire(rotation);
		update();
	});




	private void playSound() {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(
					Game.class.getResourceAsStream("Cannon+3.wav")));
			clip.setFramePosition(0);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}














	Dimension getFrame() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
}
