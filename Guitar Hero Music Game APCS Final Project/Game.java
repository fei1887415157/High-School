
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;





public class Game implements MouseListener {


	private JFrame frame = new JFrame("Guitar Hero");


	private String s = "";

	private char b1 = 'a', b2 = 's', b3 = ' ', b4 = 'k', b5 = 'l';

	private boolean play = false;

	private int frameX, frameY, noteHitX, noteHitY;


	private Font font;

	private final int D = 200;




	private Menu_Effect menuEffect = new Menu_Effect();
	private Background_Effect backgroundEffect = new Background_Effect();


	private double time = 0;



	private ArrayList<Double> listGreen;
	private ArrayList<Double> listRed;
	private ArrayList<Double> listYellow;
	private ArrayList<Double> listBlue;
	private ArrayList<Double> listOrange;



	private double i = 1, i2 = 1;

	private Menu menu = new Menu();


	private Score score;


	private Button button1 = new Button(0,0,1),
			button2 = new Button(0,0,1),
			button3 = new Button(0,0,1),
			button4 = new Button(0,0,1),
			button5 = new Button(0,0,1);


	private Note note1, note2, note3, note4, note5, note6, note7, note8, note9, note10,
			note11, note12, note13, note14, note15;

	private Combo combo;

	private Song song = new Song();






	private ArrayList<Integer> arrayList = new ArrayList<>();


	private void set() {
		for (int i = 0; i < 10; i++) {
			arrayList.add((int) (Math.random() * 10));
		}
	}

	private int Total(ArrayList<Integer> arr) {
		int num = 0;

		for (int i = 0; i < arrayList.size(); i++) {
			num += arrayList.get(i);
		}

		return num;
	}






	public static void main(String[] args) {
		new Game().start();

		//increase memory in jar

		String currentPath = null;
		try {
			currentPath = Game.class
					.getProtectionDomain()
					.getCodeSource().getLocation()
					.toURI().getPath()
					.replace('/', File.separator.charAt(0)).substring(1);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if(args.length==0) {
			try {
				Runtime.getRuntime().exec("java -jar -Xmx4000m "+currentPath+" restart");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
	}





	private void start() {



		Cursor c = null;
		try {

			c = Toolkit.getDefaultToolkit().createCustomCursor(ImageIO.read(getClass().getResourceAsStream(
					"Cursor.png")), new Point(frameX, frameY), "img");
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.setCursor(c);


		menuEffect.start();


		customFont();



		listGreen = song.getListGreen();
		listRed = song.getListRed();
		listYellow = song.getListYellow();
		listBlue = song.getListBlue();
		listOrange = song.getListOrange();

		song.start();

		makeFrame();



		backgroundEffect.start();
		button1.start();



		menu.start(frameX, frameY);



		timer.start();









	}


	private JPanel panel = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);



			animation(g);


			if (time >= song.getClipLength())
				play = false;



			if (song.getClipPosition() >= song.getClipLength() && !play) {
				song.replay();
			}



			if (note1.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(1);
			}
			if (note2.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(2);
			}
			if (note3.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(3);
			}
			if (note4.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(4);
			}
			if (note5.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(5);
			}
			if (note6.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(6);
			}
			if (note7.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(7);
			}
			if (note8.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(8);
			}
			if (note9.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(9);
			}
			if (note10.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(10);
			}
			if (note11.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(11);
			}
			if (note12.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(12);
			}
			if (note13.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(13);
			}
			if (note14.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(14);
			}
			if (note15.getY() > frameY + 50) {
				combo.reset();
				s = "Miss";
				noteReset(15);
			}






			if (play) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));

				int w = 60;
				g2.setColor(new Color(170, 50, 170));
				g2.fillRect((frameX / 4) - w / 2, 0, w, 10000);
				g2.fillRect((3 * frameX / 8) - w / 2, 0, w, 10000);
				g2.fillRect((frameX / 2) - w / 2, 0, w, 10000);
				g2.fillRect((5 * frameX / 8) - w / 2, 0, w, 10000);
				g2.fillRect((3 * frameX / 4) - w / 2, 0, w, 10000);
			}


			if (play) {
				combo.paint(g, font, s);


				button1.paint(g);
				button2.paint(g);
				button3.paint(g);
				button4.paint(g);
				button5.paint(g);
			}



			if (time > note1.getTime())
				note1.setStart(true);
			if (time > note2.getTime())
				note2.setStart(true);
			if (time > note3.getTime())
				note3.setStart(true);
			if (time > note4.getTime())
				note4.setStart(true);
			if (time > note5.getTime())
				note5.setStart(true);
			if (time > note6.getTime())
				note6.setStart(true);
			if (time > note7.getTime())
				note7.setStart(true);
			if (time > note8.getTime())
				note8.setStart(true);
			if (time > note9.getTime())
				note9.setStart(true);
			if (time > note10.getTime())
				note10.setStart(true);
			if (time > note11.getTime())
				note11.setStart(true);
			if (time > note12.getTime())
				note12.setStart(true);
			if (time > note13.getTime())
				note13.setStart(true);
			if (time > note14.getTime())
				note14.setStart(true);
			if (time > note15.getTime())
				note15.setStart(true);

			if (play) {
				if (note1.isStart())
					note1.paint(g);
				if (note2.isStart())
					note2.paint(g);
				if (note3.isStart())
					note3.paint(g);
				if (note4.isStart())
					note4.paint(g);
				if (note5.isStart())
					note5.paint(g);
				if (note6.isStart())
					note6.paint(g);
				if (note7.isStart())
					note7.paint(g);
				if (note8.isStart())
					note8.paint(g);
				if (note9.isStart())
					note9.paint(g);
				if (note10.isStart())
					note10.paint(g);
				if (note11.isStart())
					note11.paint(g);
				if (note12.isStart())
					note12.paint(g);
				if (note13.isStart())
					note13.paint(g);
				if (note14.isStart())
					note14.paint(g);
				if (note15.isStart())
					note15.paint(g);
			}




			if (play)
				score.paint(g, font);


			menu.paint(g, font);

			if (button1.needPaintEffects()) {
				noteEffect(g, noteHitX, noteHitY, button1);
			}
			if (button2.needPaintEffects()) {
				noteEffect(g, noteHitX, noteHitY, button2);
			}
			if (button3.needPaintEffects()) {
				noteEffect(g, noteHitX, noteHitY, button3);
			}
			if (button4.needPaintEffects()) {
				noteEffect(g, noteHitX, noteHitY, button4);
			}
			if (button5.needPaintEffects()) {
				noteEffect(g, noteHitX, noteHitY, button5);
			}









		}

	};


	private javax.swing.Timer timer = new javax.swing.Timer(20, event -> {
		if (play) {
			time += 0.02;
		}


		song.increaseTime();
		panel.repaint();
	});







	private void makeFrame() {


		frameX = new Dimension(Toolkit.getDefaultToolkit().getScreenSize()).width;
		frameY = new Dimension(Toolkit.getDefaultToolkit().getScreenSize()).height;


		button1 = new Button(frameX / 4, frameY, 1);
		button2 = new Button(3 * frameX / 8, frameY, 2);
		button3 = new Button(frameX / 2, frameY, 3);
		button4 = new Button( 5 * frameX / 8, frameY, 4);
		button5 = new Button(3 * frameX / 4, frameY, 5);



		noteReset(1);
		noteReset(2);
		noteReset(3);
		noteReset(4);
		noteReset(5);
		noteReset(6);
		noteReset(7);
		noteReset(8);
		noteReset(9);
		noteReset(10);
		noteReset(11);
		noteReset(12);
		noteReset(13);
		noteReset(14);
		noteReset(15);



		combo = new Combo(frameX, frameY);

		score = new Score(frameX - 100);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



		panel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		panel.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {

				if (!play) {
					if (e.getKeyChar() == 'g') {    //key to start the game
						time = 20;
						play = true;
						i = 1;
						menu.pressed();
						song.startPlaying();
					}
				}

				if (e.getKeyChar() == b1) {
					if (!button1.isWait()) {
						button1.keyPressed();
						button1.setWait(true);

						if (Math.abs(button1.getY() - note1.getY()) < D) {

							int d = Math.abs(button1.getY() - note1.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button1.getX();
							noteHitY = button1.getY();
							button1.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button1.getY() - note1.getY()));
							noteReset(1);
						} else if (Math.abs(button1.getY() - note6.getY()) < D) {

							int d = Math.abs(button1.getY() - note6.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button1.getX();
							noteHitY = button1.getY();
							button1.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button1.getY() - note6.getY()));
							noteReset(6);
						} else if (Math.abs(button1.getY() - note11.getY()) < D) {

							int d = Math.abs(button1.getY() - note11.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button1.getX();
							noteHitY = button1.getY();
							button1.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button1.getY() - note11.getY()));
							noteReset(11);
						} else {
							combo.reset();
							s = "Miss";
						}
					}
				} else if (e.getKeyChar() == b2) {
					if (!button2.isWait()) {
						button2.keyPressed();
						button2.setWait(true);
						if (Math.abs(button2.getY() - note2.getY()) < D) {

							int d = Math.abs(button2.getY() - note2.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button2.getX();
							noteHitY = button2.getY();
							button2.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button2.getY() - note2.getY()));
							noteReset(2);
						} else if (Math.abs(button2.getY() - note7.getY()) < D) {

							int d = Math.abs(button2.getY() - note7.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button2.getX();
							noteHitY = button2.getY();
							button2.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button2.getY() - note7.getY()));
							noteReset(7);
						} else if (Math.abs(button2.getY() - note12.getY()) < D) {

							int d = Math.abs(button2.getY() - note12.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button2.getX();
							noteHitY = button2.getY();
							button2.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button2.getY() - note12.getY()));
							noteReset(12);
						} else {
							combo.reset();
							s = "Miss";
						}
					}
				} else if (e.getKeyChar() == b3) {
					if (!button3.isWait()) {
						button3.keyPressed();
						button3.setWait(true);
						if (Math.abs(button3.getY() - note3.getY()) < D) {

							int d = Math.abs(button3.getY() - note3.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button3.getX();
							noteHitY = button3.getY();
							button3.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button3.getY() - note3.getY()));
							noteReset(3);
						} else if (Math.abs(button3.getY() - note8.getY()) < D) {

							int d = Math.abs(button3.getY() - note8.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button3.getX();
							noteHitY = button3.getY();
							button3.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button3.getY() - note8.getY()));
							noteReset(8);
						} else if (Math.abs(button3.getY() - note13.getY()) < D) {

							int d = Math.abs(button3.getY() - note13.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button3.getX();
							noteHitY = button3.getY();
							button3.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button3.getY() - note13.getY()));
							noteReset(13);
						} else {
							combo.reset();
							s = "Miss";
						}
					}
				} else if (e.getKeyChar() == b4) {
					if (!button4.isWait()) {
						button4.keyPressed();
						button4.setWait(true);
						if (Math.abs(button4.getY() - note4.getY()) < D) {

							int d = Math.abs(button4.getY() - note4.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button4.getX();
							noteHitY = button4.getY();
							button4.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button4.getY() - note4.getY()));
							noteReset(4);
						} else if (Math.abs(button4.getY() - note9.getY()) < D) {

							int d = Math.abs(button4.getY() - note9.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button4.getX();
							noteHitY = button4.getY();
							button4.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button4.getY() - note9.getY()));
							noteReset(9);
						} else if (Math.abs(button4.getY() - note14.getY()) < D) {

							int d = Math.abs(button4.getY() - note14.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button4.getX();
							noteHitY = button4.getY();
							button4.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button4.getY() - note14.getY()));
							noteReset(14);
						} else {
							combo.reset();
							s = "Miss";
						}
					}
				} else if (e.getKeyChar() == b5) {
					if (!button5.isWait()) {
						button5.keyPressed();
						button5.setWait(true);
						if (Math.abs(button5.getY() - note5.getY()) < D) {

							int d = Math.abs(button5.getY() - note5.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button5.getX();
							noteHitY = button5.getY();
							button5.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button5.getY() - note5.getY()));
							noteReset(5);
						} else if (Math.abs(button5.getY() - note10.getY()) < D) {

							int d = Math.abs(button5.getY() - note10.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button5.getX();
							noteHitY = button5.getY();
							button5.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button5.getY() - note10.getY()));
							noteReset(10);
						} else if (Math.abs(button5.getY() - note15.getY()) < D) {

							int d = Math.abs(button5.getY() - note15.getY());

							if (d > D / 2)
								s = "Fair";
							else if (d > D / 3)
								s = "Good";
							else if (d > D / 4)
								s = "Excellent";
							else
								s = "Marvelous";

							noteHitX = button5.getX();
							noteHitY = button5.getY();
							button5.setPaintEffects(true);
							combo.increase();
							score.increase(Math.abs(button5.getY() - note15.getY()));
							noteReset(15);
						} else {
							combo.reset();
							s = "Miss";
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});



		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		panel.addMouseListener(this);
		frame.pack();

		panel.requestFocusInWindow();



	}







	private void noteReset(int a) {



		switch (a) {
			case 1:
				if (listGreen.size() > 0) {
					note1 = new Note(button1.getX() + 5, 1, listGreen.get(0));
					removeFirstItemInList(1);
					break;
				}
			case 2:
				if (listRed.size() > 0) {
					note2 = new Note(button2.getX() + 5, 2, listRed.get(0));
					removeFirstItemInList(2);
					break;
				}
			case 3:
				if (listYellow.size() > 0) {
					note3 = new Note(button3.getX() + 5, 3, listYellow.get(0));
					removeFirstItemInList(3);
					break;
				}
			case 4:
				if (listBlue.size() > 0) {
					note4 = new Note(button4.getX() + 5, 4, listBlue.get(0));
					removeFirstItemInList(4);
					break;
				}
			case 5:
				if (listOrange.size() > 0) {
					note5 = new Note(button5.getX() + 5, 5, listOrange.get(0));
					removeFirstItemInList(5);
					break;
				}
			case 6:
				if (listGreen.size() > 0) {
					note6 = new Note(button1.getX() + 5, 1, listGreen.get(0));
					removeFirstItemInList(1);
					break;
				}
			case 7:
				if (listRed.size() > 0) {
					note7 = new Note(button2.getX() + 5, 2, listRed.get(0));
					removeFirstItemInList(2);
					break;
				}
			case 8:
				if (listYellow.size() > 0) {
					note8 = new Note(button3.getX() + 5, 3, listYellow.get(0));
					removeFirstItemInList(3);
					break;
				}
			case 9:
				if (listBlue.size() > 0) {
					note9 = new Note(button4.getX() + 5, 4, listBlue.get(0));
					removeFirstItemInList(4);
					break;
				}
			case 10:
				if (listOrange.size() > 0) {
					note10 = new Note(button5.getX() + 5, 5, listOrange.get(0));
					removeFirstItemInList(5);
					break;
				}
			case 11:
				if (listGreen.size() > 0) {
					note11 = new Note(button1.getX() + 5, 1, listGreen.get(0));
					removeFirstItemInList(1);
					break;
				}
			case 12:
				if (listRed.size() > 0) {
					note12 = new Note(button2.getX() + 5, 2, listRed.get(0));
					removeFirstItemInList(2);
					break;
				}
			case 13:
				if (listYellow.size() > 0) {
					note13 = new Note(button3.getX() + 5, 3, listYellow.get(0));
					removeFirstItemInList(3);
					break;
				}
			case 14:
				if (listBlue.size() > 0) {
					note14 = new Note(button4.getX() + 5, 4, listBlue.get(0));
					removeFirstItemInList(4);
					break;
				}
			case 15:
				if (listOrange.size() > 0) {
					note15 = new Note(button5.getX() + 5, 5, listOrange.get(0));
					removeFirstItemInList(5);
					break;
				}
		}
	}







	private void customFont() {
		try {
			//create the font to use. Specify the size!
			this.font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(
					"java.ttf")).deriveFont(50f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			//register the font
			ge.registerFont(this.font);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void removeFirstItemInList(int a) {
		switch (a) {
			case 1: listGreen.remove(0);
				break;
			case 2:	listRed.remove(0);
				break;
			case 3: listYellow.remove(0);
				break;
			case 4: listBlue.remove(0);
				break;
			case 5: listOrange.remove(0);
				break;
		}
	}




	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}




	private void animation(Graphics g2) {
		try {
			if (!play) {
				if (i > 151)
					i = 1;

				g2.drawImage(menuEffect.get((int) i), 0, 0, frameX, frameY, null);
				i += 0.5;
			} else {
				if (menuEffect.size() != 0)
					menuEffect.clear();
				if (i > 601)
					i = 1;

				g2.drawImage(backgroundEffect.get((int) i), 0, 0, frameX, frameY, null);

				i += 0.5;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void noteEffect(Graphics g, int x, int y, Button b) {
		b.paintEffects(g, x, y, (int) i2);
		i2++;
		if (i2 > 9) {
			i2 = 1;
			b.setPaintEffects(false);
		}
	}
}




