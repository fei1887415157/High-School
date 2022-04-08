import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MotionPanel extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.add(new MotionPanel());

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private MotionPanel() {
		this.setPreferredSize(new Dimension(640,480));
		this.setBackground(Color.BLACK);

		this.addKeyListener(new KeyAdapter() {			// KeyAdapters allow for implementing KeyListeners with an anonymous subclass
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					row -= 1;							// Change row, for use with jumping rapidly
					up = true;							// Set directional boolean for checking state of key in update()
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					row += 1;
					down = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					col -= 1;
					left = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					col += 1;
					right = true;
				}
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					up = false;						// Set directional boolean for checking state of key in update()
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = false;
				}
			}
		});

		this.setFocusable(true);

		Timer t = new Timer(1000/100, e->{		// This is a java swing timer, with a lambda method for the actionlistener
			this.update();
			this.repaint();
		});

		t.start();
	}

	private boolean up, down, left, right;

	private int x , y;
	private int row, col;

	private void update() {

//		if(x < col*50) {			// Move toward correct horizontal position, based on column
//			x += 10;
//		} else if(x > col*50) {
//			x -= 10;
//		}

		if(y < row*50) {
			y += 10;
		} else if(y > row*50) {
			y -= 10;
		}

//		if(up) {					// Smoothly move based on key being down or not
//			y -= 1;
//		}
//		if(down) {
//			y += 1;
//		}
		if(left) {
			x -= 5;
		}
		if(right) {
			x += 5;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);

		g.fillRect(x, y, 50, 50);
	}



}


