import java.util.Scanner;

import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


public class MakeADiamond  implements Directions{
	Robot bobbie = new Robot(600,600,South,10000);
	String upOrDown;


	public static void main(String[] args) {
		MakeADiamond temp = new MakeADiamond();
		temp.makeADiamondWith5BeepsOnEachSide();
	}


	private boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}


	private void makeADiamondWith5BeepsOnEachSide() {
		//make the robot fill the blank inside the diamond
		System.out.println("Enter a whole number 1 to 5.");
		Scanner keyboard  = new Scanner(System.in);
		String testString = keyboard.next();

		while(!isInteger(testString)){
			System.out.println("Please enter a whole number");
			testString = keyboard.next();
		}
		int beepersOnSide = Integer.parseInt(testString);

		/*if (beepersOnSide == 1 || beepersOnSide == 2 || beepersOnSide == 3 || beepersOnSide == 4 || beepersOnSide == 5) {
		}
		else {
			System.out.println("Invalid number.");
			System.exit(0);
		}*/

		World.setVisible(true);
		World.setDelay(0);
		World.setSize(1000,1000);


		for (int i = 0; i < beepersOnSide + 1; i += 1) {
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();

		}
















		bobbie.putBeeper();
		for (int i = 0; i < beepersOnSide - 1; i += 1) {
			bobbie.move();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.putBeeper();
		}

		bobbie.move();
		for (int i = 0; i < beepersOnSide - 1; i += 1) {
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.move();
		}

		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();
		for (int i = 0; i < beepersOnSide - 1; i += 1) {
			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
		}

		for (int i = 0; i < beepersOnSide - 1; i += 1) {
			bobbie.move();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
		}
		bobbie.pickBeeper();
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();
		bobbie.putBeeper();

		for (int i = 0; i < beepersOnSide - 2; i += 1) {
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
		}

		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();

		for (int i = 0; i < beepersOnSide - 2; i += 1) {
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
		}

		bobbie.pickBeeper();
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.turnLeft();
		bobbie.move();
		bobbie.putBeeper();

		for (int i = 0; i < beepersOnSide - 2; i += 1) {
			bobbie.putBeeper();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.move();
			bobbie.turnLeft();
			bobbie.move();

		}


		bobbie.turnLeft();
		bobbie.turnLeft();

		for (int i = 0; i < beepersOnSide - 2; i += 1) {
			bobbie.move();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.putBeeper();
			bobbie.turnLeft();
			bobbie.turnLeft();
			bobbie.turnLeft();

		}
	}


}