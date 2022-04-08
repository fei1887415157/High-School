import java.util.Scanner;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


import kareltherobot.*;
import kareltherobot.Directions.Direction;

import javax.swing.*;


public class CircleDrawer {


	private int[] prompt() {
		//array is fixed, get all the info then make it
		//array list is not

		 int x = 0;
		 int y = 0;
		 int r = 0;

		boolean exception = true;
		while (exception) {
			try {
				x = Integer.parseInt(JOptionPane.showInputDialog
						(null, "What's the x-axis?" + "\n" + "Choose a number between 20 and 30."));
				while (x > 30 || x < 20) {
					JOptionPane.showMessageDialog
							(null, "Choose a number between 20 and 30.", "ERROR", JOptionPane.ERROR_MESSAGE);
					x = Integer.parseInt(JOptionPane.showInputDialog
							(null, "What's the x-axis?" + "\n" + "Choose a number between 20 and 30."));
				}
				exception = false;
			} catch (NumberFormatException e) {
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
			} catch (NumberFormatException e) {
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
			} catch(NumberFormatException e){
				r = 0;
				JOptionPane.showMessageDialog
						(null, "Choose a number between 10 and 15.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

		return new int[]{x, y, r};
	}









	private static final int BEEPERS = 1000;

	public static void main(String[] args) {
		CircleDrawer cd = new CircleDrawer();
		cd.prompt();

		System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)) {
			@Override
			public void println(Object o) {
				if(!(o instanceof Robot)) {		// Karel gotta stfu
					super.println(o);
				}
			}
		});

		new CircleDrawer().start();
	}




	private void start() {
		initializeWorld();
		Robot karel = new Robot(x, y, Directions.South, BEEPERS);
		int[] coor = {12,12,10};
		makeCircle(karel, coor);
	}



	private static void initializeWorld() {
		kareltherobot.World.setSize(100, 100);
		kareltherobot.World.setDelay(0);
		kareltherobot.World.setVisible(true);
	}



	private void gotoXY(Robot karel, int x, int y){
		System.out.println("Currently at ("+karel.avenue()+","+karel.street()+")");
		System.out.println("Going to     ("+x+","+y+")");
		if((x == karel.avenue()) && (y == karel.street())) {
			System.out.println("Already there!");
			return;
		}

		int xOffset = x - karel.avenue();		// avenue and street were swapped
		int yOffset = y - karel.street();		// also, offset is one word, so the 's' SHOULD NOT BE CAPITALIZED YA DINGUS
		Direction xDirection = (xOffset > 0)?Directions.East:Directions.West;
		Direction yDirection   = (yOffset > 0)?Directions.North:Directions.South;


		//The following while loop is done how it is, rather than doing X first then Y or vice versa, to minimize unnecessary spinning
		boolean didX = (xOffset == 0);
		boolean didY = (yOffset == 0);
		while(!(didX && didY)) {
			if(karel.direction() == xDirection) {
				System.out.println("Moving "+xOffset+" spaces "+xDirection);
				for(int i = 0; i < Math.abs(xOffset); i++) {
					karel.move();
				}
				didX = true;
			}
			if(karel.direction() == yDirection) {
				System.out.println("Moving "+yOffset+" spaces "+yDirection);
				for(int i = 0; i < Math.abs(yOffset); i++) {
					karel.move();
				}
				didY = true;
			}
			if(!(didX && didY)) {
				karel.turnLeft();
			}
		}
	}




	private void makeCircle(Robot karel, int[] coordinates) {
		int x = coordinates[0];
		int y = coordinates[1];
		int r = coordinates[2];

		gotoXY(karel, x, y);

		// Was using degrees, Math.trig functions use radians. Used as var rather than converting because it seemed prettier
		for(double theta = 0; theta < 2*Math.PI; theta += 2*Math.PI / BEEPERS) {
			int X = (int)Math.round(r*Math.cos(theta) + x);		// You weren't adding the center, and were adding the robot's current
			int Y = (int)Math.round(r*Math.sin(theta) + y);		// position each time you moved. Also variables for clarity :p
			gotoXY(karel, X, Y);
			karel.putBeeper();
		}
	}
}
