import java.util.Arrays;
import java.util.List;

public class Seating {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("Karen",3),new Student("Liz",1),new Student("Paul",4),new Student("Lester",1),new Student("Henry",5),
				new Student("Renee",9),new Student("Glen",2),new Student("Fran",6),new Student("David",1),new Student("Danny",3));
		
		SeatingChart chart = new SeatingChart(students,3,4);
		System.out.println(chart.toString());
		
		chart.removeAbstentStudents(4);
		System.out.println(chart);

	}

}
