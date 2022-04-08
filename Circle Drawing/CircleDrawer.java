import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;

import javax.swing.JOptionPane;

public class CircleDrawer implements Directions {

	public static void main(String[] args) {
		CircleDrawer cd = new CircleDrawer();
		int numCircles = 1;
		while (numCircles > 0) {
			numCircles--;
			int[] deets = cd.prompt();
			World.setVisible(true);
			World.setDelay(0);
			cd.makeCircle(deets);
		}
	}

	/**
	 * Ask the user for the circle size and center
	 * The returned array has the following info
	 * index 0 - has the Street
	 * index 1 - has the Avenue
	 * index 2 - has the Radius
	 */
	private int[] prompt() {
		//array is fixed, get all the info then make it
		//array list is not
		int x = 0;
		int y = 0;
		int r = 0;

		boolean exception1 = true;
		while (exception1) {
			try {
				x = Integer.parseInt(JOptionPane.showInputDialog
						(null, "What's the x-axis?" + "\n" + "Choose a number between 20 and 30."));
				while (x > 30 || x < 20) {
					JOptionPane.showMessageDialog
							(null, "Choose a number between 20 and 30.", "ERROR", JOptionPane.ERROR_MESSAGE);
					x = Integer.parseInt(JOptionPane.showInputDialog
							(null, "What's the x-axis?" + "\n" + "Choose a number between 20 and 30."));
				}
				exception1 = false;
			}
			catch (NumberFormatException e) {
				x = 0;
				JOptionPane.showMessageDialog
						(null, "Choose a number between 20 and 30.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}


		boolean exception2 = true;
		while (exception2) {
			try {
				y = Integer.parseInt(JOptionPane.showInputDialog
						(null, "What's the y-axis?" + "\n" + "Choose a number between 20 and 30."));
				while (y > 30 || y < 20) {
					JOptionPane.showMessageDialog
							(null, "Choose a number between 20 and 30.", "ERROR", JOptionPane.ERROR_MESSAGE);
					y = Integer.parseInt(JOptionPane.showInputDialog
							(null, "What's the y-axis?" + "\n" + "Choose a number between 20 and 30."));
				}
				exception2 = false;
			}
			catch (NumberFormatException e) {
				y = 0;
				JOptionPane.showMessageDialog
						(null, "Choose a number between 25 and 75.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}


		boolean exception3 = true;
		while (exception3) {
			try {
				r = Integer.parseInt(JOptionPane.showInputDialog
						(null, "What's the radius?" + "\n" + "Choose a number between 10 and 15."));
				while (r > 15 || r < 10) {
					JOptionPane.showMessageDialog
							(null, "Choose a number between 10 and 15.", "ERROR", JOptionPane.ERROR_MESSAGE);
					r = Integer.parseInt(JOptionPane.showInputDialog
							(null, "What's the radius?" + "\n" + "Choose a number between 10 and 15."));
				}
			exception3 = false;
			}
			catch(NumberFormatException e){
				r = 0;
				JOptionPane.showMessageDialog
						(null, "Choose a number between 10 and 15.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

		return new int[]{x, y, r};
	}



	/**
	 * Makes a circle with the conditions provided by the specified array
	 * The specified array has the following info
	 * index 0 - has the Street
	 * index 1 - has the Avenue
	 * assume street and avenue are large enough so that the circle is possible
	 * index 2 - has the Radius
	 */

	private void makeCircle(int[] details) {
		int x = details[0];
		int y = details[1];
		int r = details[2];
		World.setSize(50, 50);
		Robot bobbie = new Robot(x, y, South, 100);


		for (int a = 0; a < 4; a++) {
			for (int i = 0; i < r; i++) {
				bobbie.move();
			}
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r*2; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 2; a++) {
			for (int i = 0; i < r-1; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < (r*2)-2; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-1; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 2; a++) {
			for (int i = 0; i < r-2; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < (r*2)-4; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-2; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-3; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < (r*2)-6; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-3; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-4; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();

			for (int i = 0; i < (r*2)-10; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-4; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-6; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();

			for (int i = 0; i < (r*2)-14; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-6; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-8; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();

			for (int i = 0; i < (r*2)-18; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-8; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < 2; i++) {
				bobbie.move();
				bobbie.putBeeper();
			}

			bobbie.turnLeft();
			bobbie.turnLeft();
			for (int i = 0; i < 4; i++) {
				bobbie.move();
				bobbie.putBeeper();
			}
		}

		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();
		bobbie.turnLeft();


		for (int i = 0; i < (x/2); i++) {
			bobbie.move();
		}

		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();

































		for (int a = 0; a < 4; a++) {
			for (int i = 0; i < r; i++) {
				bobbie.move();
			}
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r*2; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 2; a++) {
			for (int i = 0; i < r-1; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < (r*2)-2; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-1; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 2; a++) {
			for (int i = 0; i < r-2; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < (r*2)-4; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-2; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-3; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < (r*2)-6; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-3; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-4; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();

			for (int i = 0; i < (r*2)-10; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-4; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-6; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();

			for (int i = 0; i < (r*2)-14; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-6; i++) {
				bobbie.move();
			}

			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < r-8; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();

			for (int i = 0; i < (r*2)-18; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();

			for (int i = 0; i < r-8; i++) {
				bobbie.move();
			}

			bobbie.putBeeper();
		}


		for (int a = 0; a < 1; a++) {
			for (int i = 0; i < 2; i++) {
				bobbie.move();
				bobbie.putBeeper();
			}

			bobbie.turnLeft();
			bobbie.turnLeft();
			for (int i = 0; i < 4; i++) {
				bobbie.move();
				bobbie.putBeeper();
			}
		}

		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();
		bobbie.turnLeft();


		for (int i = 0; i < (x/2)+1; i++) {
			bobbie.move();
		}

		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();
	}
}