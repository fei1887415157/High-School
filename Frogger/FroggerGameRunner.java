import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class FroggerGameRunner {
	private JPanel panel;
	private FroggerGame game = new FroggerGame();
	private Timer timer;
	private int ticks;
	
	// Notice this intuitive method for finding the screen size 
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = (int) (screenSize.getWidth()*3/4),HEIGHT=(int) (screenSize.getHeight()*3/4);
	private static final int REFRESH_RATE = 50;

	public FroggerGameRunner() throws IOException {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					start();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
			}
		});
	}

	public static void main(String[] args) throws IOException {
		new FroggerGameRunner();
	}

	private void start() {
		JFrame frame = new JFrame("Frogger");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGame(g);
			}
		};
		// random color to the background
		panel.setBackground(new Color(20, 15, 120));
		
		// so that the frame isn't minimized
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		// so that the frame is placed a little way from top and left side
		frame.setLocation(WIDTH/10, HEIGHT/10);

		// map the keystrokes that the panel detects to the game
		mapKeyStrokesToActions(panel);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		// after setting visible to true, you can get focus.  You need focus to consume
		// the keystrokes hit by the user
		panel.requestFocusInWindow();
		
		// this timer controls the actions in the game and then repaints after each update to data
		timer = new Timer(REFRESH_RATE, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				panel.repaint();
			}
		});
		timer.start();
	}

	// this method is called every time the timer goes off (which right now is every 10 milliseconds = 100 times per second
	protected void updateGame() {
		ticks++;// keeps track of the number of times the timer has gone off
		for(GameObject go : game.gos){
			go.update();
		}
		for (GameObject go: game.gos) {
			if (game.frog.hit(go)) {
				game.frog.getRect().translate(go.getLogMovementSpeed(), 0);
			}
		}
//		int hertz = 1000/REFRESH_RATE;
//		if(ticks % hertz == 0) {
//
//			//System.out.println(ticks/hertz+" seconds");
//		}
	}

	private void mapKeyStrokesToActions(JPanel panel) {

		// A map is an Data storage interface which defines
		// an association of a key with a value
		// to "add" to a map you use the "put" method
		// to "get" from a map you use "get(key)" and the 
		// value associated with the key is returned (or null)
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();





		// code below associates pressing the up arrow with the command "up"
		// essentially creating the command "up" being broadcast any time the 
		// up key is hit
		inMap.put(KeyStroke.getKeyStroke("UP"), "up");
		inMap.put(KeyStroke.getKeyStroke("W"), "up");
		// code below associates the "up" action with anything in the 
		// actionPerformed method.  Right now, it just prints something
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");
			}
		});

		inMap.put(KeyStroke.getKeyStroke("DOWN"),"down");
		inMap.put(KeyStroke.getKeyStroke("S"),"down");
		map.put("down",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});

		inMap.put(KeyStroke.getKeyStroke("LEFT"),"left");
		inMap.put(KeyStroke.getKeyStroke("A"),"left");
		map.put("left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});

		inMap.put(KeyStroke.getKeyStroke("RIGHT"),"right");
		inMap.put(KeyStroke.getKeyStroke("D"),"right");
		map.put("right",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});

	}
	public void hit(String s) {
		game.keyHit(s);
		panel.repaint();
	}
	protected void drawGame(Graphics g) {
		game.draw(g);
	}

}
