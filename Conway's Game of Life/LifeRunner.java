import java.awt.*;
import javax.swing.*;




public class LifeRunner {

	private JFrame frame = new JFrame("Life, as we know it!");
	private JPanel panel;
	private int[][] grid;// to be constructed in the makeGrid method


	public static void main(String[] args) {
		new LifeRunner().start();
	}




	private static int width = 5;
	private int genCount = 0;
	private final double livesAppearPercentage = 5;



	//how to change label location




	private void start() {
		int w = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / width);
		int h = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / width);
		makeGrid(h, w);
		makeFrame();
		//printGrid();


		/*if(this.SHOW_GUI)
			makeFrame();

		printGrid();
		if(this.SHOW_GUI)
			showGrid();
		nextGen();
		printGrid();
		if(this.SHOW_GUI)
			showGrid();*/


	}




	private void makeFrame() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// code to draw on graphics

				for (int row = 0; row < grid.length; row++) {
					for (int col = 0; col < grid[row].length; col++) {
						if (grid[row][col] == 0) {
							g.setColor(Color.black);
						}
						else {
							g.setColor(Color.orange);
						}
						g.fillRect(width * col, width * row, width, width);
					}
				}
			}
		};


		frame.add(panel);


		JLabel fpsLabel = new JLabel();
		fpsLabel.setFont(new Font("Courier", Font.BOLD, 40));
		fpsLabel.setForeground(Color.white);


		JLabel genLabel = new JLabel();
		genLabel.setFont(new Font("Courier", Font.BOLD, 100));
		genLabel.setForeground(Color.white);


		JButton button1 = new JButton("Next");
		JButton button2 = new JButton("Auto: OFF");
		JSlider slider = new JSlider(1, 10) {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.gray);
				g.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight() / 2, getHeight() / 2);
				super.paintComponent(g);
			}
		};

		javax.swing.Timer timer = new javax.swing.Timer(0, event -> {
			nextGen();
			genLabel.setText(String.valueOf(genCount));
			panel.repaint();
		});

		button2.addActionListener(arg0 -> {
			if (timer.isRunning()) {
				button2.setText("Auto: OFF ");
				timer.stop();
			}
			else {
				button2.setText("Auto: ON ");
				timer.start();
			}
		});

		slider.addChangeListener(e -> {
			timer.setDelay(1000 / slider.getValue());
			fpsLabel.setText(String.format("%2d FPS", slider.getValue()));
		});

		slider.getChangeListeners()[0].stateChanged(null);

		button1.addActionListener(arg0 -> {
			nextGen();
			genLabel.setText(String.valueOf(genCount));
			panel.repaint();
		});




		panel.add(button1);
		panel.add(button2);
		panel.add(slider);
		panel.add(fpsLabel);
		panel.add(genLabel);
		panel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((dim.width / 2 - dim.getSize().width / 2), dim.height / 2 - dim.getSize().height / 2) ;
		frame.pack();

	}





















	/**
	 * create a grid with dimension of rows X cols with lives objects
	 * randomly placed into the grid.  One tricky part is to make sure you are 
	 * placing the correct number of objects in the grid.  If you randomly 
	 * come up with the same location, your code needs to account for that!
	 * 
	 * After making the grid, it is added to the List of grids
	 * 
	 * @param rows number of rows in the grid
	 * @param cols number of cols in the grid
	 * //@param lives number of lives to be added to the grid
	 */
	private void makeGrid(int rows, int cols) {
		grid = new int[rows][cols];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				grid[row][col] = (int) ((livesAppearPercentage * 0.01 + 1) * Math.random());
			}
		}
	}








	/**
	 * Prints the specified 2D array of int to the console.
	 */
	private void printGrid() {
		for (int[] aGrid : grid) {
			for (int anAGrid : aGrid) {
				System.out.print(anAGrid);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
















	/**
	 * This method advances grid from the previous generation to the next generation
	 * based on these two simple rules:
	 * 1.  If there are 3 neighboring objects around a cell, that cell will contain a 
	 *     life in the subsequent generation.
	 * 2.  If there are 3 neighboring objects around a cell that currently contains an 
	 *     object, then that object lives on into the next generation.
	 *     
	 * Be sure to make all the changes to a different grid.
	 * Finally, the newest grid is added to the list of generations
	 */
	private void nextGen() {

		genCount++;
		System.out.println("creating " + genCount);

		int neighbors;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				neighbors = countNeighbors(row, col);

				//rules of the game
				if (grid[row][col] == 1 && neighbors < 2) {
					grid[row][col] = 0;
				}
				else if (grid[row][col] == 1 && neighbors > 3) {
					grid[row][col] = 0;
				}
				else if (grid[row][col] == 0 && (neighbors == 3)) {
					grid[row][col] = 1;
				}
			}
		}
	}









	private int countNeighbors(int rows, int cols) {
		int count = 0;

		try {
			if (grid[rows - 1][cols - 1] == 1) {
				count++;
			}
			if (grid[rows - 1][cols] == 1) {
				count++;
			}
			if (grid[rows - 1][cols + 1] == 1) {
				count++;
			}

			if (grid[rows][cols - 1] == 1) {
				count++;
			}
			if (grid[rows][cols + 1] == 1) {
				count++;
			}

			if (grid[rows + 1][cols - 1] == 1) {
				count++;
			}
			if (grid[rows + 1][cols] == 1) {
				count++;
			}
			if (grid[rows + 1][cols + 1] == 1) {
				count++;
			}
		}
		catch (ArrayIndexOutOfBoundsException ignored) {
		}
		return count;
	}


}
