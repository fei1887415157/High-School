import kareltherobot.*;
import javax.swing.*;


public class Driver implements Directions {
	public static void main(String[] args) {
		Driver d = new Driver();
		d.prompt();
		d.getInfo();
		d.cleanRoom();
	}

	private int trash = 0;

	private void prompt() {
		trash = Integer.parseInt(JOptionPane.showInputDialog
				(null, "How many trash do you want to clean?"));

	}




	private void cleanRoom() {
		Robot roomba = new Robot(7, 6, North, 0);
		System.out.println(roomba);
		int piles = 21;
		int area = 10;
		System.out.println("Cleanness Percentage: " + (piles / area));    //Cleanness Percentage

		int trash1 = 0;
		int trash2 = 0;
		while (trash1 != trash || trash1 != 59) {
			while (roomba.nextToABeeper()) {
				if (trash1 != trash) {
					roomba.pickBeeper();
					trash1++;
				}
			}


			if (!(roomba.frontIsClear())) {
				roomba.turnLeft();
				roomba.turnLeft();
				while (roomba.frontIsClear()) {
					roomba.move();
				}
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}

			else {
				roomba.move();
			}

		}






		roomba.turnLeft();
		roomba.turnLeft();
		roomba.move();
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();

		while (true) {
			roomba.move();
			if (!roomba.frontIsClear()) {
				break;
			}
		}

		roomba.turnLeft();
		roomba.turnLeft();








		while (true) {
			while (roomba.nextToABeeper()) {
				roomba.pickBeeper();
				trash2++;
			}

			if (trash2 == 21) {
				break;
			}

			if (trash1 + trash2 == trash) {
				break;
			}

			if (!(roomba.frontIsClear())) {
				roomba.turnLeft();
				roomba.turnLeft();
				while (roomba.frontIsClear()) {
					roomba.move();
				}
				roomba.turnLeft();
				roomba.move();
				roomba.turnLeft();
			}

			else {
				roomba.move();
			}

		}

		System.out.println("Trash collected in room 1: " + trash1);
		System.out.println("Trash collected in room 2: " + trash2);
	}









	private void getInfo() {
		// this method acquires the starting street, avenue and direction
		// of the robot from the user.  Also it inputs the name of the world
		// file.  It then opens the world file and creates the robot
		String worldName1 = "Room1.wld";
		String worldName2 = "Room2.wld";
		
		//int beepers=0, piles =0;
		//piles++;
		//System.out.println("Beepers: "+beepers+"\nPiles: "+piles);
		
		JFileChooser jfc = new JFileChooser();
		//jfc.setVisible(true);
		//jfc.showOpenDialog(null);
	
		World.readWorld(worldName1);
		World.readWorld(worldName2);
		World.setVisible(true);
		World.setDelay(1);
		
	}

}
