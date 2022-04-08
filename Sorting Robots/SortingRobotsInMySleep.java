import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;

import java.util.ArrayList;

public class SortingRobotsInMySleep {

	public static void main(String[] args) {
		World.setVisible(true);
		World.setDelay(0);
		World.setSize(10, 10);



		SortableRobot[] robots = new SortableRobot[10];
		for (int i = 0; i < 10; i++) {
			robots [i] = new SortableRobot(1, i+1, (int)(Math.random()*50) );
		}

		//SortableRobot sr1 = robots[1];

		// make a list or array of Sortable Robots with random number of 
		// beepers in a line along the bottom of the world
		
		
	}

}
