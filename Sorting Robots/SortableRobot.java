import kareltherobot.Directions;
import kareltherobot.Robot;

public class SortableRobot extends Robot implements Comparable<SortableRobot> {

	public SortableRobot(int st, int av,  int beeps) {
		super(st, av,North, beeps);
	}


	public void turnTo(Directions direction) {
		while(!direction().equals(direction)) {
			turnLeft();
		}
	}


	public void moveTO() {

	}

	@Override
	public int compareTo(SortableRobot other) {
//		if(this.beepers() < other.beepers())
//			return -9993;
//		if(this.beepers() > other.beepers())
//			return 6;
		return this.beepers() - other.beepers();
	}
	public void showAllBeeps() {
		
	}
	
	
}
