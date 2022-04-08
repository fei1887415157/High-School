import java.util.List;

public class SeatingChart {
	
	Student[][] students;

	public SeatingChart(List<Student> studentList, int rows, int cols) {
		students = new Student[cols][rows];
		for(int i = 0; i < studentList.size(); i++) {
			students[i%cols][i/cols] = studentList.get(i);
		}
	}
	
	public int removeAbstentStudents(int numAbsences) {
		int numRemoved = 0;
		for(int x = 0; x < students.length; x++) {			// for every column
			for(int y = 0; y < students[x].length; y++) {	// for every member in the column
				Student current = students[x][y];			// retrieve member
				if(current != null && current.absences > numAbsences) {	// check if it exists, and if so, if it has too many absences
					students[x][y] = null;
					numRemoved++;
				}
			}
		}
		return numRemoved;
	}
	
	@Override
	public String toString() {
		String out = "";
		for(int y = 0; y < students[0].length; y++) {
			for(int x = 0; x < students.length; x++) {
				Student toPrint = students[x][y];
				if(toPrint != null) {
					out += String.format("%10s %d", toPrint.name, toPrint.absences);
				} else {
					out += "     null   ";
				}
				
			}
			out += "\n";
		}
		return out;
	}
}
