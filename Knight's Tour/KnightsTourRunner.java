import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;









public final class KnightsTourRunner {

	private JFrame frame = new JFrame("Moving the knight");
	private JPanel panel;

	private int numSquares = 1;// keeps track of how many squares the knight has been to
	private int[][] board;// to be constructed in the makeGrid method

	private int Kr = 500;
	private int Kc = 500;


	public static void main(String[] args) {

		new KnightsTourRunner().start();
	}

	private void start() {
		makeBoard();// makes the chess board
		makeFrame();
		//printBoard();
	}




	private void printBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}






	private void makeFrame() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			int state = 0;
			
			@Override
			public void mousePressed(MouseEvent me) {
				if(state == 0) {
					putKnightOnBoard(me);
					state++;
				}
				else if(state == 1){
					moveKnight();
					/*if(knightTrapped(1, 1)) {
						showNotificationAndPromptRestart();
						state++;
					}	*/
				}
				else if(state == 2) {
					makeBoard();
					state = 0;
				}
				frame.repaint();
			}
		});
		frame.add(panel);
		panel.setPreferredSize(new Dimension(700, 700));
		frame.pack();
		frame.setVisible(true);

	}





	private void showNotificationAndPromptRestart() {
		// TODO Auto-generated method stub
		
	}


	private void drawPath(Graphics g, List<Point> path) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.setColor(Color.orange);
		for (int i = 0; i < path.size(); i++) {
			if (i < path.size() - 1) {
				drawString(g, "" + i, path.get(i));
			}
			else {
				drawString(g, "K", path.get(i));
			}
		}
	}



	private List<List<Point>> getMoves(List<Point> path) {

		Point current = path.get(path.size() - 1);
		List<Point> moves = Arrays.asList(
				new Point(current.x - 1, current.y - 2),
				new Point(current.x + 1, current.y - 2),
				new Point(current.x + 2, current.y - 1),
				new Point(current.x + 2, current.y + 1),
				new Point(current.x + 1, current.y + 2),
				new Point(current.x - 1, current.y + 2),
				new Point(current.x - 2, current.y + 1),
				new Point(current.x - 2, current.y - 1));

		for (int i = 0; i < 8; i++) {

			Point p = moves.get(i);

			if (p.x < 0 || p.x >= 8 || p.y < 0 || p.y >= 8) {
				moves.remove(i);
				i--;
			}

			if (path.contains(p)) {
				moves.remove(i);
				i--;
			}
		}

		return Arrays.asList(moves);





	}




	// figure out where the mouse event is on the board and put the knight there
	protected void putKnightOnBoard(MouseEvent me) {
		//System.out.println("Placing the knight " + me);
		Kr = me.getX();
		Kc = me.getY();

		Point start = new Point(me.getX() - 100 / 50, me.getY() - 100 / 50);

		List<Point> path = new ArrayList<Point>(16);
		path.add(start);

		explore(path);
	}




	private List<Point> explore(List<Point> path) {

		if (path.size() >= 64) {
			return path;
		}

		List<List<Point>> moves = getMoves(path);

		if (moves.size() == 0) {
			return null;
		}

		return null;
	}






	// draw the chessboard (alternating colors) and draw a "K" where the knight 
	// currently is and numbers where the knight has been
	protected void drawBoard(Graphics g, List<Point> path) {
		int width = 50;
		for (int row = 2; row < board.length - 2; row++) {
			for (int col = 2; col < board[row].length - 2; col++) {
				if ((row % 2 == 1 && col % 2 == 1) || (row % 2 == 0 && col % 2 == 0)) {
					g.setColor(Color.white);
				}
				else {
					g.setColor(Color.gray);
				}
				g.fillRect(width * col, width * row, width, width);
			}
		}











		int i = 0;
		for (int row = 2; row < board.length - 2; row++) {
			for (int col = 2; col < board[row].length - 2; col++) {
				if (board[row][col] != 0) {
					i++;
					g.setColor(Color.orange);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					g.drawString("" + board[row][col], row * 50, col * 50 + 50);
				}
			}
		}

		if (i == 65) {
			return;
		}
	}








	/**
	 * Make the chessboard
	 */
	private void makeBoard() {
		board = new int[12][12];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = 9;
			}
		}

		for (int row = 2; row < board.length - 2; row++) {
			for (int col = 2; col < board[row].length - 2; col++) {
				board[row][col] = 0;
			}
		}
	}




	/**
	 * Makes a move of the knight.  Find a random location on the board where the knight
	 * hasn't been (and that the knight can go to) and move there
	 */
	int count = 1;
	private void moveKnight() {
		int r = (int) (Math.random() * 8 + 2);
		int c = (int) (Math.random() * 8 + 2);
		while (true) {
			if (board[r][c] == 0) {
				board[r][c] = count;

				Kc = c * 50;
				Kr = r * 50 + 50;

				break;
			}
			else {
				r = (int) (Math.random() * 8 + 2);
				c = (int) (Math.random() * 8 + 2);
			}
		}


		count++;
		numSquares++;



	}












	private void drawString(Graphics g, String s, Point p) {
		int px = 125 + p.x * 50,
			py = 140 + p.y * 50;
		px -= g.getFontMetrics().stringWidth(s) / 2;

		g.drawString(s, px, py);
	}


}
